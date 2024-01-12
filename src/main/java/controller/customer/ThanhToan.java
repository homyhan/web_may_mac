package controller.customer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.IVoucherDaO;
import DAO.impl.VoucherDaO;
import controller.OrderFeeController;
import helper.Contants;
import model.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import response.ProductCartResponse;
import service.*;
import ultilities.Log4j;
import ultilities.Message;

@WebServlet(name = "ThanhToan", value = "/thanh-toan/*")
public class ThanhToan extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") == null) {
			response.sendRedirect("/cart");
			return;
		}
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		if (session.getAttribute("addressDefault") == null) {
			System.out.println("chưa có địa chỉ mặc định");
			request.getRequestDispatcher("/tai-khoan/update-address").forward(request, response);
			return;
		}
		//trước khi mua hàng lấy lại thông tin địa chỉ mặc định
		User info = (User)session.getAttribute("userLogin");
		//lấy thông tin địa chỉ mặc đinh mới nhất
		Address addressDefaut = AddressService.getAddressDefaultByIdUser(info.getIduser());//cập nhật lại địa chỉ để sử dụng khi mua hàng
		session.setAttribute("addressDefault", addressDefaut);// thông tin địa chỉ mặc định

		IVoucherDaO iVoucherDaO = new VoucherDaO();
		List<Voucher> vouchers = iVoucherDaO.findAll(info.getIduser());
		request.setAttribute("vouchers", vouchers);
		request.getRequestDispatcher("template/thanh-toan.jsp").forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {

			case "/checkout":
				try {
					checkout(request, response);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				break;
			case "/leakPrivateKey":
				try {
					leakPrivateKey(request, response);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				break;

			default:
				System.out.println(action);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/template/gio-hang2.jsp");
				requestDispatcher.forward(request, response);
				break;
		}
		return;
	}

//	START CMT
	private  void leakPrivateKey(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		HttpSession session = request.getSession(true);
		User info = (User) session.getAttribute("userLogin");
		// biến dùng để cập nhập trạng thái đơn hàng từ ngày
		String startAt = request.getParameter("startAt");
		// cập nhập lại các hóa đơn = 0 sau lúc lộ key
		InvoiceService.updateInvoiceStatusBeforeStartAt(info.getIduser(), startAt);

		// tạo  public-key, private-key mới
		RSA rsa = new RSA();
		rsa.genKey();
		String newPublicKey = Base64.getEncoder().encodeToString(rsa.getPublicKey().getEncoded());
		String newPrivateKey = Base64.getEncoder().encodeToString(rsa.getPrivateKey().getEncoded());
		// cập nhập lại thông tin user
		Boolean isUpdate = UserService.updatePublicKeyById(info.getIduser(),newPublicKey);
		System.out.println(isUpdate);
		session.setAttribute("userLogin", info);
		// cập nhập các đơn hàng cũ
		List<Order> listOrder = OrderService.getOrdersByUserIdBeforeStartAt(info.getIduser(), startAt);
		PrivateKey privateKeyConverted = new RSA().getPrivateKeyFromString(newPrivateKey);
		for (Order order : listOrder) {
			Order orderGetFromDB = new Order(order.getIduser(), order.getIdaddress(), order.getSubtotal(), order.getItemdiscount(), order.getShipping(), order.getIdcoupons(), order.getGrandtotal(), order.getStatus(), order.getContent());
			byte[] byteOrder = toByteArray(orderGetFromDB);

			int idOrder = order.getIdorder();
			List<OrderDetail> orDetailList = OrderDetailService.getProductCategory(idOrder);


			byte[] rsArrOrderDetail = new byte[0];
			List<OrderDetail> odDetailListNew = new ArrayList<>();
			for (OrderDetail od : orDetailList) {
				OrderDetail odD = new OrderDetail(idOrder, od.getIdproduct(), od.getQuantity(), od.getSize(), od.getPrice(), od.getDiscount(), od.getIsmeasure(), od.getWeight(), od.getHeight(), od.getRound1(), od.getRound2(), od.getRound3(), od.getContent());
				odDetailListNew.add(odD);
			}

			for (OrderDetail o: odDetailListNew){
				byte[] odToArrayByte = toByteArray(o);
				// Tạo mảng mới có kích thước là tổng kích thước của mảng cũ và mảng mới
				byte[] newArray = new byte[rsArrOrderDetail.length + odToArrayByte.length];

				// Sao chép dữ liệu từ mảng cũ và mảng mới vào mảng mới
				System.arraycopy(rsArrOrderDetail, 0, newArray, 0, rsArrOrderDetail.length);
				System.arraycopy(odToArrayByte, 0, newArray, rsArrOrderDetail.length, odToArrayByte.length);

				// Gán mảng mới cho mảng lớn
				rsArrOrderDetail = newArray;

			}

			List<Invoice> invoiceListA = InvoiceService.getDataInvoiceByIdOrder(idOrder);

			Invoice invoiceOne = invoiceListA.get(0);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String formattedDate = dateFormat.format(invoiceOne.getCreateAt());

			Invoice invoiceObj = new Invoice(info.getIduser(), idOrder, invoiceOne.getMode(), formattedDate, invoiceOne.getContent());
			byte[] invoiceByte = toByteArray(invoiceObj);

			byte[] rsConcate = concatenateByteArrays(byteOrder, rsArrOrderDetail, invoiceByte);
			byte[] hashConcate = hashData(rsConcate);
			byte[] signature = signHashOrder(hashConcate, privateKeyConverted);
			byte[] okSignature = Arrays.copyOfRange(signature, 0, 256);

			int updatedOrder = OrderService.updateSignatureForOrder(idOrder, Base64.getEncoder().encodeToString(okSignature));

		}
		// lưu lại giá trị private-key mới
		savePrivateKeyToFile(newPrivateKey);

		System.out.println(info);
		// Gửi giá trị voucherPrice về phản hồi
		response.setContentType("text/plain");
		response.getWriter().write(String.valueOf(newPrivateKey));
	}

	private void savePrivateKeyToFile(String privateKey) throws IOException {
		// Lấy ngày và giờ hiện tại
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Định dạng chuỗi
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
		String formattedDateTime = currentDateTime.format(formatter);

		// Thực hiện lưu file vào thư mục hoặc nơi khác
		// Ví dụ: Lưu file vào thư mục "private_keys"
		String fileName = formattedDateTime+"_privatekey.txt";
		String directoryPath = "D:\\HAN\\AT";

		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdirs(); // Tạo thư mục nếu nó chưa tồn tại
		}

		File file = new File(directory, fileName);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(privateKey);
		}
	}

	private void checkout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("check out");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") == null) {
			response.sendRedirect("/cart");
			return;
		}
		HashMap<Integer, ProductCartResponse> cartList = (HashMap<Integer, ProductCartResponse>) session.getAttribute("productCartList");
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		if (session.getAttribute("addressDefault") == null) {
			System.out.println("chưa có địa chỉ mặc định!!!");
			response.sendRedirect("/tai-khoan/update-address");
			return;
		}

		// login thành công đã có user
		User info = (User) session.getAttribute("userLogin");
		Address address = (Address) session.getAttribute("addressDefault");

		// lấy thông tin tên, địa chỉ, sdt
		// session cart

		// address > get session để lấy addressid = 3

		// insert order > orderid
		// for cart > insert order detail
		float subtotal = 0;// tổng giá tiền = sô lượng từng sản phẩm * đơn giá
		float itemdiscount = 0;// tổng giá tiền giảm = số lượng * giấ giảm của từng sản phẩm
		for (Map.Entry<Integer, ProductCartResponse> entry : cartList.entrySet()) {
			subtotal += entry.getValue().getQuantity() * entry.getValue().product.getPrice();
			itemdiscount += entry.getValue().getQuantity() * entry.getValue().product.getDiscount();
		}

		Coupons coupons = null;
		if (session.getAttribute("coupon") != null) {
			coupons = (Coupons) session.getAttribute("coupon");
		}

		float shipping = (float)0.01 * itemdiscount;
		System.out.println(shipping);
		float grandtotal = itemdiscount + shipping;// tổng giá tiền cuối cùng
		if (coupons != null) {
			grandtotal = grandtotal -coupons.getPrice();
		}

		int iduser = info.getIduser();
		int idaddress = address.getIdaddress();

		int idcoupons = 1;
		if (coupons != null) {
			idcoupons = coupons.getIdcoupons();
		}

//		// TẠO CHỮ KÝ SỐ
		String privateKey = request.getParameter("privateKey");
		String publicKey = (String) session.getAttribute("publicKeySession");
		PrivateKey privateKeyConverted;
		PublicKey publicKeyConverted;
		System.out.println(publicKey);
		System.out.println(privateKey);

		try {
			PublicKey pbKey = convertStringToPublicKey(publicKey);
			PrivateKey prKey = convertStringToPrivateKey(privateKey);
			if(!checkKeyPair(pbKey, prKey)){
				System.out.println("Khong phai la 1 cap key");
			}else {
				System.out.println("La mot cap key");

			}

		} catch (Exception e) {
//                throw new RuntimeException(e);
			System.out.println("Khong phai la cap key - duoc xu ly trong try catch");
			request.getSession().setAttribute("errorPrivateKey", "Private Key không trùng khớp");
			response.sendRedirect("/thanh-toan?errorPrivateKey=0");

			return;
		}


		if(privateKey.trim().isEmpty() || privateKey==null){
			System.out.println("Nhap privatekey");
			request.setAttribute("errorPrivateKey", "Private Key cannot be empty.");
			return;
		}
		else{
			RSA rsa = new RSA();
			privateKeyConverted = rsa.getPrivateKeyFromString(privateKey);
			publicKeyConverted = rsa.getPublicKeyFromString(publicKey);

		}

		Order order = new Order(iduser, idaddress, subtotal, itemdiscount, shipping, idcoupons, grandtotal, 0, "");
		Order orderKhac = new Order(40, 11111, 100.0f, itemdiscount, shipping, idcoupons, grandtotal, 0, "");
		byte[] data = toByteArray(order);
		String hash1 = hashData2412(data);
		System.out.println("Obj thanh toan: "+order);
		System.out.println("Hash 1: " + hash1);


//		TEST START 2812

		byte[] byteOrder = toByteArray(order);

		List<OrderDetail> dsOrderDetail = new ArrayList<>();

		byte[] rsArrOrderDetail = new byte[0];

		OrderDetail orDetail;

		int idorder = OrderService.insertOrder(order);
		for (Map.Entry<Integer, ProductCartResponse> productCart : cartList.entrySet()) {
			OrderDetail orderDetail = new OrderDetail(idorder, productCart.getValue().getProduct().getIdproduct(),
					productCart.getValue().quantity, productCart.getValue().getDetail().getSize(),
					productCart.getValue().getProduct().getPrice(), productCart.getValue().getProduct().getDiscount(),
					productCart.getValue().getDetail().getIsmeasure(), productCart.getValue().getDetail().getWeight(),
					productCart.getValue().getDetail().getHeight(), productCart.getValue().getDetail().getRound1(),
					productCart.getValue().getDetail().getRound2(), productCart.getValue().getDetail().getRound3(),
					productCart.getValue().getDetail().getContent());
			boolean isInsert = OrderDetailService.insertOrderDetail(orderDetail);
			orDetail=new OrderDetail(idorder, productCart.getValue().getProduct().getIdproduct(),
					productCart.getValue().quantity, productCart.getValue().getDetail().getSize(),
					productCart.getValue().getProduct().getPrice(), productCart.getValue().getProduct().getDiscount(),
					productCart.getValue().getDetail().getIsmeasure(), productCart.getValue().getDetail().getWeight(),
					productCart.getValue().getDetail().getHeight(), productCart.getValue().getDetail().getRound1(),
					productCart.getValue().getDetail().getRound2(), productCart.getValue().getDetail().getRound3(),
					productCart.getValue().getDetail().getContent());

			dsOrderDetail.add(orderDetail);
		}

		for (OrderDetail o: dsOrderDetail){
			byte[] odToArrayByte = toByteArray(o);
			// Tạo mảng mới có kích thước là tổng kích thước của mảng cũ và mảng mới
			byte[] newArray = new byte[rsArrOrderDetail.length + odToArrayByte.length];

			// Sao chép dữ liệu từ mảng cũ và mảng mới vào mảng mới
			System.arraycopy(rsArrOrderDetail, 0, newArray, 0, rsArrOrderDetail.length);
			System.arraycopy(odToArrayByte, 0, newArray, rsArrOrderDetail.length, odToArrayByte.length);

			// Gán mảng mới cho mảng lớn
			rsArrOrderDetail = newArray;

		}

		Invoice invoice = new Invoice(iduser, idorder, Contants.INVOIE_STATUS_WAITING_APPROVE, Contants.INVOICE_MODE_TRUCTIEP,
				new Timestamp(System.currentTimeMillis()), address.getContent());
		boolean isInsert = InvoiceService.insertInvoice(invoice);

//		Invoice invoiceSign = new Invoice(iduser, idorder, Contants.INVOICE_MODE_TRUCTIEP,new Timestamp(System.currentTimeMillis()), address.getContent());

		Invoice invoiceGetFromDB = InvoiceService.getInvoiceByIdorder(idorder);
		Invoice invoiceSign = new Invoice(iduser, idorder, Contants.INVOICE_MODE_TRUCTIEP, invoiceGetFromDB.getCreateAt(), address.getContent());
		byte[] byteInvoice = toByteArray(invoiceSign);
		System.out.println("????????In invoiceSign?????????");
		System.out.println(invoiceSign);

		// gộp
		byte[] rsConcate = concatenateByteArrays(byteOrder, rsArrOrderDetail, byteInvoice);
		byte[] hashConcate = hashData(rsConcate);
		byte[] signature = signHashOrder(hashConcate, privateKeyConverted);
		byte[] okSignature = Arrays.copyOfRange(signature, 0, 256);


		System.out.println("--------- Start Signature : ");
		System.out.println(Base64.getEncoder().encodeToString(okSignature));
		System.out.println("-------- End Signature ");
		System.out.println("order: "+order);
		System.out.println("Invoice: "+invoice);
		System.out.println(" co lenh update order");

		int updatedOrder = OrderService.updateSignatureForOrder(idorder, Base64.getEncoder().encodeToString(okSignature));
		System.out.println(updatedOrder);

		System.out.println("In thanh toan");
		System.out.println(order);
		System.out.println(dsOrderDetail);
		System.out.println(invoice);
		System.out.println("In mang byte order: ");
		System.out.println(hashData2412(byteOrder));

		System.out.println("In mang byte order detail: ");
		System.out.println(hashData2412(rsArrOrderDetail));

		System.out.println("In mang byte invoice: ");
		System.out.println(hashData2412(byteInvoice));

		System.out.println("In mang byte da gop 3 mang: ");
		System.out.println(hashData2412(rsConcate));

		System.out.println("In mang chua Hash mang to: ");
		System.out.println(hashData2412(hashConcate));


		session.removeAttribute("productCartList");
		response.sendRedirect("/cart/checkout-success");

//		END TEST 2812

//
//		byte[] orderBytes = toByteArray2(order);
//
//		byte[] hashResult = hashData(orderBytes);
//
//		byte[] signature = signHashOrder(hashResult, privateKeyConverted);
//
//		byte[] fixedSizeSignature = Arrays.copyOfRange(signature, 0, 256);
//
//		Order orderSigned = new Order(iduser, idaddress, subtotal, itemdiscount, shipping, idcoupons, grandtotal, 0, "", Base64.getEncoder().encodeToString(fixedSizeSignature));


		//THEM VAO DB OK K XÓA

		// END OK K XÓA
	}


	//END CMT



	private static byte[] signHashOrder(byte[] hashedData, PrivateKey privateKey) throws Exception {

		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		signature.update(hashedData);

		return signature.sign();
	}


	private static byte[] hashData(byte[] data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(data);
	}

	private static boolean checkKeyPair(PublicKey publicKey, PrivateKey privateKey) {
		try {
			// Tạo một đối tượng Signature với thuật toán SHA256withRSA
			Signature signature = Signature.getInstance("SHA256withRSA");

			// Ký một mảng byte bằng private key
			signature.initSign(privateKey);
			byte[] message = "Hello, World!".getBytes();
			signature.update(message);
			byte[] signedData = signature.sign();

			// Xác minh chữ ký bằng public key
			signature.initVerify(publicKey);
			signature.update(message);

			// Nếu xác minh thành công, chứng tỏ public key và private key là một cặp hợp lệ
			return signature.verify(signedData);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static PublicKey convertStringToPublicKey(String str) throws Exception {
		RSA rsa = new RSA();
		PublicKey pbKey = rsa.getPublicKeyFromString(str);
		return pbKey;
	}
	private static PrivateKey convertStringToPrivateKey(String str) throws Exception {
		RSA rsa = new RSA();
		PrivateKey privateKey = rsa.getPrivateKeyFromString(str);
		return privateKey;
	}

	public static byte[] toByteArray(Order or) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(or);
			oos.close();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public static byte[] toByteArray2(Order order) {
		try {
			// Sắp xếp các thuộc tính của đối tượng trước khi serialization
//			Arrays.sort(order.getProperties()); // Giả sử bạn có một phương thức getProperties trả về mảng chứa các thuộc tính cần sắp xếp

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(order);
			oos.close();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] toByteArray(Object object) {
		try {
			// Sắp xếp các thuộc tính của đối tượng trước khi serialization
//			Arrays.sort(order.getProperties()); // Giả sử bạn có một phương thức getProperties trả về mảng chứa các thuộc tính cần sắp xếp

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			oos.close();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




	private static String hashData2412(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data);
			return bytesToHex2412(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String bytesToHex2412(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append(String.format("%02X", b));
		}
		return result.toString();
	}


	public static byte[] concatenateByteArrays(byte[] order, byte[] orderdetail, byte[] invoice) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			baos.write(order);
			baos.write(orderdetail);
			baos.write(invoice);

			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
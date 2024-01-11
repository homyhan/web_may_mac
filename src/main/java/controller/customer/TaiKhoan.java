package controller.customer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.IVoucherDaO;
import DAO.impl.VoucherDaO;
import model.*;
import model.Address;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import response.InvoiceResponse;
import service.*;

import javax.servlet.annotation.*;
import java.io.*;
import java.security.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "TaiKhoan", value = "/tai-khoan/*")
public class TaiKhoan extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		String action = request.getPathInfo();// lấy được đường dẫn phía sau chữ cart /
		if (action == null) {
			action = "/";
		}
		switch (action) {
			case "/update-address":
				if (session.getAttribute("addressDefault") == null) {
					response.sendRedirect("thong-tin-khach-hang/dia-chi.jsp");
					return;
				}
				break;
			case "/don-hang":
				try {
					showInvoice(request, response);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return;
			case "/dia-chi":
				showAddress(request, response);
				return;
			case "/reset-password":
				resetPassword(request, response);
				return;
			case "/voucher":
				showListVoucher(request, response);
				return;


			default:
				break;
		}
		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
		return;
	}

	private void showListVoucher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("show list voucher");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		IVoucherDaO iVoucherDaO = new VoucherDaO();
		User info = (User) session.getAttribute("userLogin");
		request.setAttribute("listMyVoucher", iVoucherDaO.findAll(info.getIduser()));
		request.getRequestDispatcher("/thong-tin-khach-hang/voucher.jsp").forward(request, response);
		return;

	}

	private void showInvoice(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("show invoice");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
		User info = (User) session.getAttribute("userLogin");
		List<InvoiceResponse> invoiceList = InvoiceService.getListInvoiceByUserId(info.getIduser());

//		String publicKey = (String) session.getAttribute("publicKeySession");
		String publicKey  = UserService.getUserById(info.getIduser()).getPublicKey();
		String emailCustomer = (String) session.getAttribute("emailCustomer");
		System.out.println("pbKey: "+publicKey);
//		PublicKey pbKeyConverted = convertStringToPublicKey(publicKey);
		PublicKey publicKeyConverted;
		RSA rsa = new RSA();
		publicKeyConverted = rsa.getPublicKeyFromString(publicKey);
		List<Order> listOrder = OrderService.getListOrderByUserId(info.getIduser());
		System.out.println("In danh sach don hang");
		System.out.println(listOrder.toString());
		ArrayList<Order> listOrderChanged = new ArrayList<>();

		int count=0;
//		Order orderGetFromDB = new Order();
		for (Order order : listOrder) {
			Order orderGetFromDB = new Order(order.getIduser(), order.getIdaddress(), order.getSubtotal(), order.getItemdiscount(), order.getShipping(), order.getIdcoupons(), order.getGrandtotal(), order.getStatus(), order.getContent());
			System.out.println();
			System.out.println("Obj: " + orderGetFromDB);
			System.out.println(order.getSignature());


			//START TEST 2812
			int idOrder = order.getIdorder();
			List<OrderDetail> orDetailList = OrderDetailService.getProductCategory(idOrder);

			List<OrderDetail> odDetailListNew = new ArrayList<>();
			for (OrderDetail od : orDetailList) {
				OrderDetail odD = new OrderDetail(idOrder, od.getIdproduct(), od.getQuantity(), od.getSize(), od.getPrice(), od.getDiscount(), od.getIsmeasure(), od.getWeight(), od.getHeight(), od.getRound1(), od.getRound2(), od.getRound3(), od.getContent());
				odDetailListNew.add(odD);
			}

			System.out.println("Ds odDetail");
			System.out.println(odDetailListNew);

			List<Invoice> invoiceListA = InvoiceService.getDataInvoiceByIdOrder(idOrder);
			System.out.println(idOrder);
			System.out.println("Log invoice List A");
			System.out.println(invoiceListA);
			Invoice invoiceOne = invoiceListA.get(0);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String formattedDate = dateFormat.format(invoiceOne.getCreateAt());

			Invoice invoiceObj = new Invoice(info.getIduser(), idOrder, invoiceOne.getMode(), formattedDate, invoiceOne.getContent());
			System.out.println("??????????????In invoice obj");
			System.out.println(invoiceObj);
			boolean checkTest = verifySignature3Obj(orderGetFromDB, odDetailListNew, invoiceObj, Base64.getDecoder().decode(order.getSignature()), publicKeyConverted);
			System.out.print("In checktest: ");
			System.out.println(checkTest);


			if(!checkTest){

				System.out.println("Da gui email thanh cong");
				listOrderChanged.add(order);

			}
			for (Order or : listOrderChanged){
				List<Invoice> invoicesL = getListInvoiceByIdOrder(or.getIdorder());
				Invoice invoice = invoicesL.get(0);
				updateInvoiceStatus(invoice.getIdinvoice(), 0);
				if(invoice.getStatus()!=0){
					count++;
				}
//				if(listOrderChanged.size()>0 && invoice.getStatus()!=0){
//					System.out.println("So luong don hang bi thay doi la: ");
//					System.out.println(listOrderChanged.size());
//					System.out.println(listOrderChanged);
//					updateInvoiceStatus(invoice.getIdinvoice(), 0);
//					sendEmail(emailCustomer,  listOrderChanged);
//					System.out.println("Da gui email thanh cong");
//				}
			}

			System.out.println("In tai khoan");
			System.out.println(orderGetFromDB);
			System.out.println(odDetailListNew);
			System.out.println(invoiceObj);

			byte[] b1 = toByteArray(orderGetFromDB);
			byte[] b3 = toByteArray(invoiceObj);

			byte[] rsArrOrderDetail = new byte[0];

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

			byte[] rsConcate = concatenateByteArrays(b1, rsArrOrderDetail, b3);
			System.out.println("In mang byte order tai khoan: ");
			System.out.println(hashData2412(b1));

			System.out.println("In mang byte order detail tai khoan: ");
			System.out.println(hashData2412(rsArrOrderDetail));

			System.out.println("In mang byte invoice tai khoan: ");
			System.out.println(hashData2412(b3));

			System.out.println("In mang byte da gop 3 mang tai khoan: ");
			System.out.println(hashData2412(rsConcate));



		}
		if(listOrderChanged.size()>0 && count==listOrderChanged.size()){
			System.out.println("So luong don hang bi thay doi la: ");
			System.out.println(listOrderChanged.size());
			System.out.println(listOrderChanged);

			sendEmail(emailCustomer,  listOrderChanged);
			System.out.println("Da gui email thanh cong");
		}
		request.setAttribute("invoiceList", invoiceList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		request.getRequestDispatcher("/thong-tin-khach-hang/don-hang.jsp").forward(request, response);
	}

	private void showAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
		User info = (User) session.getAttribute("userLogin");
		List<Address> addressList = AddressService.getListAddressByIdUser(info.getIduser());
		request.setAttribute("addressList", addressList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		request.getRequestDispatcher("/thong-tin-khach-hang/dia-chi.jsp").forward(request, response);
		System.out.println("show address");
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();// lấy được đường dẫn phía sau chữ cart /
		if (action == null) {
			action = "/";
		}
		switch (action) {
			case "/them-dia-chi":
				addAddress(request, response);
				return;
			case "/cap-nhat-tai-khoan":
				updateUser(request, response);
				return;
			case "/quen-mat-khau":
				quenMatKhau(request, response);
				return;
			case "/thay-doi-mat-khau":
				thayDoiMatKhau(request, response);
				return;
			case "/reset-password":
				resetPasswordPost(request, response);
				return;
			case "/voucher":
				showListVoucher(request, response);
				return;
			case "/quen-key":
				try {
					quenKey(request, response);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return;
			default:
				break;
		}
		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
		return;
	}

	protected void addAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("add address");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		User info = (User) session.getAttribute("userLogin");
		int iduser = info.getIduser();
		System.out.println(iduser);
		String name = request.getParameter("name");// input bình thường
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		System.out.println(address);
		String content = request.getParameter("content");
		int isdefault = 0;
		String[] selected = request.getParameterValues("isdefault");// input checkbox
		// https://stackoverflow.com/questions/12396828/how-to-get-checked-checkboxes-in-jsp
		if (selected != null) {
			isdefault = Integer.parseInt(selected[0]);
		}
		Address addressNew = new Address(iduser, name, phone, address, isdefault, 1, content);
		int isInsert = AddressService.insertAddress(addressNew);
		System.out.println(isInsert);

		Address addressDefaut = AddressService.getAddressDefaultByIdUser(info.getIduser());// cập nhật lại địa chỉ để sử
		// dụng khi mua hàng
		session.setAttribute("addressDefault", addressDefaut);// thông tin địa chỉ mặc định

		response.sendRedirect("/tai-khoan/dia-chi");
		return;
	}

	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("update user info");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		User info = (User) session.getAttribute("userLogin");// mai
		System.out.println(info);
		String lastname = request.getParameter("lastname");// maimai
		String firstname = request.getParameter("firstname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		if (!username.equals(info.getUsername())) {
			// kiểm tra username mới này có gắn với tk nào không
			if (UserService.checkUserNameExist(username)) {
				System.out.println("check user name");
				request.setAttribute("error", "Username này đã có người sử dụng. Vui lòng đổi username khác");
				request.getRequestDispatcher("/thong-tin-khach-hang/quan-ly-tai-khoan.jsp").forward(request, response);
				return;
			}
			info.setUsername(username);// nếu chưa ai sử dụng thì có quyền đổi
		}

		info.setLastname(lastname);// maimai
		info.setFirstname(firstname);
		info.setEmail(email);
		info.setPhone(phone);
		System.out.println(info);
		boolean isUpdate = UserService.updateUserByIdUser(info.getIduser(), info);// cập nhật thông tin vào db
		System.out.println(isUpdate);

		session.setAttribute("userLogin", info);// cập nhật thông tin trên secction //maimai

		response.sendRedirect("/thong-tin-khach-hang/quan-ly-tai-khoan.jsp");// method get
		return;
	}

	private void thayDoiMatKhau(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		User info = (User) session.getAttribute("userLogin");

		String newPassword1 = request.getParameter("repassword1");
		String newPassword2 = request.getParameter("repassword2");
		System.out.println(newPassword1);

		String password = request.getParameter("password");
		String passwordHash = UserService.hashPassword(password);
		if (info.getPassword().equals(passwordHash)) {

			if (!newPassword1.equals(newPassword2)) {
				request.setAttribute("error", "Mật khẩu không giống nhau. Vui lòng thử lại");
				request.getRequestDispatcher("/thong-tin-khach-hang/thay-doi-mat-khau.jsp").forward(request, response);
				return;
			}
		}

		String newPasswordHash = UserService.hashPassword(newPassword2);
		System.out.println(newPasswordHash);
		info.setPassword(newPasswordHash);
		boolean isUpdate = UserService.updatePassByIdUser(info.getIduser(), info);// cập nhật thông tin vào db
		System.out.println("update password");
		System.out.println(isUpdate);

		session.setAttribute("userLogin", info);// cập nhật thông tin trên secction

		response.sendRedirect("/products");// method get
		return;
	}

	protected void quenMatKhau(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		User info = UserService.getUserByEmail(email);
		if (info != null) {
			// sendmail
			boolean isSendMail = UserService.getInstance().passwordRecovery(email);
			if (isSendMail) {
				request.setAttribute("message", "Vui lòng truy cập mail để lấy mật khẩu");
			} else {
				request.setAttribute("error", "Lỗi gửi mail. Vui lòng thử lại");
			}
			request.getRequestDispatcher("/template/quen-mat-khau.jsp").forward(request, response);
			return;
		}
		request.setAttribute("error", "Email không tồn tại. Vui lòng nhập lại");
		request.getRequestDispatcher("/template/quen-mat-khau.jsp").forward(request, response);
		return;
	}

	protected void resetPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwordHash = request.getParameter("token");
		User info = UserService.getUserByUserNameAndPassword(username, passwordHash);
		if (info != null) {
			request.setAttribute("username", username);
			request.setAttribute("token", passwordHash);
			request.getRequestDispatcher("/thong-tin-khach-hang/reset-password.jsp").forward(request, response);
			return;
		}
		request.setAttribute("error", "Tài khoản không tồn tại. Vui lòng nhập lại");
		request.getRequestDispatcher("/template/quen-mat-khau.jsp").forward(request, response);
		return;
	}

	private void resetPasswordPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
//		if (session.getAttribute("userLogin") == null) {
//			response.sendRedirect("/sign-in");
//			return;
//		}
//		User info = (User) session.getAttribute("userLogin");

		String newPassword1 = request.getParameter("repassword1");
		String newPassword2 = request.getParameter("repassword2");
		System.out.println(newPassword1);
		System.out.println(newPassword2);
//		String password = request.getParameter("password");
//		String passwordHash = UserService.hashPassword(password);
		String username = request.getParameter("username");
		String passwordHash = request.getParameter("token");
		System.out.println("--------u---------"+username);
		System.out.println("--------p---------"+passwordHash);
		User info = UserService.getUserByUserNameAndPassword(username, passwordHash);
		if (info == null) {
			request.setAttribute("error", "Tài khoản không tồn tại. Vui lòng nhập lại");
			request.getRequestDispatcher("/template/quen-mat-khau.jsp").forward(request, response);
			return;
		}
		if (info.getPassword().equals(passwordHash)) {

			if (!newPassword1.equals(newPassword2)) {
				request.setAttribute("error", "Mật khẩu không giống nhau. Vui lòng thử lại");
				request.getRequestDispatcher("/thong-tin-khach-hang/thay-doi-mat-khau.jsp").forward(request, response);
				return;
			}
		}

		String newPasswordHash = UserService.hashPassword(newPassword2);
		System.out.println(newPasswordHash);
		info.setPassword(newPasswordHash);
		boolean isUpdate = UserService.updatePassByIdUser(info.getIduser(), info);// cập nhật thông tin vào db
		System.out.println("update password");
		System.out.println(isUpdate);

		session.setAttribute("userLogin", info);// cập nhật thông tin trên secction

		response.sendRedirect("/products");// method get
		return;
	}



	private static PublicKey convertStringToPublicKey(String str) throws Exception {
		RSA rsa = new RSA();
		PublicKey pbKey = rsa.getPublicKeyFromString(str);
		return pbKey;
	}
	public static byte[] convertStringToByteArray(String input) {
		// Kiểm tra xem chuỗi đầu vào có null hay không
		if (input == null) {
			return null;
		}

		// Chuyển chuỗi thành mảng byte
		return input.getBytes();
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

	public static byte[] toByteArray(Object obj) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static byte[] hashData(byte[] data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(data);
	}


	public static byte[] toByteArray2(Order or) {
		try {
//			Arrays.sort(or.getProperties());

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

	private static String printIdOrder(ArrayList<Integer> idInvoicesList){
		String idOrderString = "";
		for(Integer idInvoice : idInvoicesList){
			idOrderString+=idInvoice+", ";
		}
		return idOrderString;
	}

	public static List<Integer> getOrderIds(List<Order> orderList) {
		List<Integer> idList = new ArrayList<>();

		for (Order order : orderList) {
			idList.add(order.getIdorder());
		}

		return idList;
	}

	private void sendEmail(String toEmail, ArrayList<Order> orderList) {

		int count = orderList.size();

		List<Integer> idList = getOrderIds(orderList);

		ArrayList<Integer> idInvoice = new ArrayList<>();

		ArrayList<Product> prodList = new ArrayList<>();

		ArrayList<Invoice> invoicesListCheckoutOnl = new ArrayList<>();

		String contentTd = "";
		String idInvoiceCheckoutOnlStr ="";

		final String fromEmail = "thienan21215@gmail.com"; // Email của bạn
		final String password = "wqubwaintvcbufnn"; // Mật khẩu email của bạn

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

//		int maHoaDon = Integer.parseInt(printIdOrder(orderList));


		for (Order order : orderList){
			System.out.println("Hoa don ma don hang bi thay doi: ");

			Order orderObj = OrderService.getDetailByOrderId(order.getIdorder());

			System.out.println(getListInvoiceByIdOrder(order.getIdorder()).toString());
			Product prod = ProductService.getProductByIdOrder(order.getIdorder()).get(0);
//			prodList
			Invoice inv = getListInvoiceByIdOrder(order.getIdorder()).get(0);
			idInvoice.add(inv.getIdinvoice());
			if(orderObj.getStatus()==1){
				invoicesListCheckoutOnl.add(inv);
			}
			for (Invoice invoice : invoicesListCheckoutOnl){
				idInvoiceCheckoutOnlStr+=invoice.getIdinvoice()+", ";
			}
			System.out.println("ID hoa don: ");
			System.out.println(inv.getIdinvoice());
//			updateInvoiceStatus(inv.getIdinvoice(), 0);
			System.out.println("Da cap nhat trang thai");
			prodList.add(prod);

		}

		for (Product p: prodList){
			contentTd+="<p style=\"text-indent: 40px;\">"+p.getTitle()+" - "+p.getPrice()+"</p>";
		}


		try {
			String content = "<!DOCTYPE html>\n" +
					"<html lang=\"en\">\n" +
					"<head>\n" +
					"    <meta charset=\"UTF-8\">\n" +
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
					"    <title>Document</title>\n" +

					"</head>\n" +
					"<body>\n" +
					"    <h3>Công ty May Mặc G15 gửi đến quý khách <span style=\"color: red;\"><b>CẢNH BÁO</b></span></h3>\n" +
					"    <p>Chúng tôi vừa nhận thấy thông tin "+count+" đơn hàng của quý khách đã bị chỉnh sửa thông tin</p>\n"  +
					"    <p>Mã đơn hàng bị thay đổi là: "+printIdOrder(idInvoice)+" \n"  +
					"	<p>Thông tin sản phẩm: </p>"+
					contentTd+
					"	<p>Trong đó các hóa đơn bạn đã thanh toán là: </p>"+idInvoiceCheckoutOnlStr+" \n"  +
					"    <p>Để bảo vệ tài khoản của quý khách được an toàn chúng tôi sẽ tiến hành hủy đơn hàng. Đối với các đơn hàng đã thanh toán G15 sẽ hoàn trả lại số tiền cho quý khách</p>\n" +
					"    <p>Chúng tôi chân thành xin lỗi vì sự bất tiện này</p>\n" +
					"    <p>Cảm ơn quý khách đã tin chọn G15</p>\n" +
					"    <p>Mọi thắc mắc xin vui lòng liên hệ:</p>\n" +
					"    <p>Số điện thoại: 0270399999</p>\n" +
					"    <p>Email: thienan21215@gmail.com</p>\n" +
					"</body>\n" +
					"</html>";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("[CẢNH BÁO] CTY MAY MẶC G15 - ĐƠN HÀNG");
//            message.setText(content);
			message.setContent(content, "text/html; charset=utf-8");
			Transport.send(message);
			System.out.println("Email sent successfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
			// Xử lý lỗi gửi email
		}
	}


	private static List<Invoice> getListInvoiceByIdOrder(int idOrder){
//		ArrayList<Invoice> listInvoice = new ArrayList<>();
		return InvoiceService.getDataInvoiceByIdOrder(idOrder);
	}



	private void updateInvoiceStatus(Integer idInvoice, int status){

		boolean isUpdate = InvoiceService.updateInvoiceStatus(idInvoice, status);
		System.out.println(isUpdate);


		System.out.println("redirect don-hang");
		return;
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



	private static boolean verifySignature3Obj(Order order, List<OrderDetail> orDetailL, Invoice invoice, byte[] digitalSignature, PublicKey publicKey) throws Exception {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ObjectOutputStream oos = new ObjectOutputStream(baos);
//		oos.writeObject(order);
//		oos.close();
		byte[] rsArrOrderDetail = new byte[0];
		for (OrderDetail od: orDetailL){
			byte[] odToArrayByte = toByteArray(od);
			// Tạo mảng mới có kích thước là tổng kích thước của mảng cũ và mảng mới
			byte[] newArray = new byte[rsArrOrderDetail.length + odToArrayByte.length];

			// Sao chép dữ liệu từ mảng cũ và mảng mới vào mảng mới
			System.arraycopy(rsArrOrderDetail, 0, newArray, 0, rsArrOrderDetail.length);
			System.arraycopy(odToArrayByte, 0, newArray, rsArrOrderDetail.length, odToArrayByte.length);

			// Gán mảng mới cho mảng lớn
			rsArrOrderDetail = newArray;
		}

		byte[] orderBytes = toByteArray(order);
//		byte[] orDetailByte = toByteArray(orDetai);
		byte[] invoiceByte = toByteArray(invoice);

		byte[] rsConcate = concatenateByteArrays(orderBytes, rsArrOrderDetail, invoiceByte);


		byte[] hashResult = hashData(rsConcate);

		System.out.println("In mang chua Hash mang to: ");
		System.out.println(hashData2412(hashResult));


		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(publicKey);
		signature.update(hashResult);

		return signature.verify(digitalSignature);
	}

	private static byte[] signHashOrder(byte[] hashedData, PrivateKey privateKey) throws Exception {

		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		signature.update(hashedData);

		return signature.sign();
	}

	protected void quenKey(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		User info = (User) session.getAttribute("userLogin");
		System.out.println(info.getUsername());

		if (info != null) {

			String privateKey = request.getParameter("privateKeyReq");
			String publicKey = request.getParameter("publicKeyReq");
			if(UserService.checkKeyExist(publicKey)){
				request.setAttribute("error", "Key đã tồn tại. Vui lòng nhập key khác");
				request.getRequestDispatcher("/template/quen-key.jsp").forward(request, response);
				return;
			}
			if(publicKey.trim().length()==0 || publicKey.length()==0 ||privateKey.trim().length()==0||privateKey.length()==0){
				request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
				request.getRequestDispatcher("/template/quen-key.jsp").forward(request, response);
				return;
			}
			savePrivateKeyToFile(privateKey);
			int updatedPublicKey  = UserService.updatePublicKeyForUser(info.getIduser(), publicKey);
			PrivateKey privateKeyConverted = new RSA().getPrivateKeyFromString(privateKey);

			System.out.println("In cap key");
			System.out.println(privateKey);
			System.out.println(publicKey);
			List<Order> listOrder = OrderService.getListOrderByUserId(info.getIduser());
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
			System.out.println("Cap nhat thanh cong");
			request.getRequestDispatcher("/template/gio-hang2.jsp").forward(request, response);
			return;
		}else{
			request.getRequestDispatcher("/template/dang-nhap.jsp").forward(request, response);
			return;

		}



	}

	private void savePrivateKeyToFile(String privateKey) throws IOException {
		// Lấy ngày và giờ hiện tại
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Định dạng chuỗi
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
		String formattedDateTime = currentDateTime.format(formatter);

		// Thực hiện lưu file vào thư mục hoặc nơi khác
		// Ví dụ: Lưu file vào thư mục "private_keys"
		String fileName = formattedDateTime+"_changed"+"_privatekey.txt";
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

}

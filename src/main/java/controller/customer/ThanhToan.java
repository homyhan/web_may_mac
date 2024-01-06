package controller.customer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.*;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Order order = new Order(iduser, idaddress, subtotal, itemdiscount, shipping, idcoupons, grandtotal, 0, "");
		Order orderKhac = new Order(40, 11111, 100.0f, itemdiscount, shipping, idcoupons, grandtotal, 0, "");
		// TẠO CHỮ KÝ SỐ
		String privateKey = request.getParameter("privateKey");
		PrivateKey privateKeyConverted;
		PublicKey publicKeyConverted;
		if(privateKey.length()==0){
			System.out.println("Nhap privatekey");
			return;
		}else{
			RSA rsa = new RSA();
			privateKeyConverted = rsa.getPrivateKeyFromString(privateKey);
			publicKeyConverted = rsa.getPublicKeyFromString("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA13b0LspgrkM8ikj9X1dNBH7/9sNLF+egHTIMt/Y9TqAkH4hVihbCPkJL5ILOSEfupIhAhgb1HQQ9/563uKrOTeldMfRqBDq5Kr4S1vSfB0yltO1KzUi+JrC/8j6S9Jh5tIiNMp0ubIe1Fr413Sf2ydMD1oB9Mpq3y3Fs0FvC0OQ+xU6jzs4HB1Z82vnc92/7tbR0+2kDLMPE1NSI37vpZTV85Vg52Q36PJY4En7jqrLTakkb3AEK8Ts5qK/FNyojvkkjne6aRNSJCL9rKuj/KUMN8nGBNp6AxDgVNZlBeX0PYQe0bN6dny7k6HYW8C92UnNFCCkxybBxJAgafCn+zQIDAQAB");
			byte[] signature = signObject(order, privateKeyConverted);
//			System.out.println("-------- da ky va chu ky la-----------");
//			System.out.println(Base64.getEncoder().encodeToString(signature));

			boolean isSignatureValid = verifySignature(orderKhac, signature, publicKeyConverted);
			System.out.println("so sanh chu ky dien tu");
			System.out.println(isSignatureValid);
		}

//		int idorder = OrderService.insertOrder(order);
//		int idorder =0;
//		System.out.println("insert order success");
//		System.out.println(idorder);
//		if (idorder <= 0) {
//			System.out.println("error insert order");
//		}
//
//		System.out.println("insert order");
//
//		for (Map.Entry<Integer, ProductCartResponse> productCart : cartList.entrySet()) {
//			OrderDetail orderDetail = new OrderDetail(idorder, productCart.getValue().getProduct().getIdproduct(),
//					productCart.getValue().quantity, productCart.getValue().getDetail().getSize(),
//					productCart.getValue().getProduct().getPrice(), productCart.getValue().getProduct().getDiscount(),
//					productCart.getValue().getDetail().getIsmeasure(), productCart.getValue().getDetail().getWeight(),
//					productCart.getValue().getDetail().getHeight(), productCart.getValue().getDetail().getRound1(),
//					productCart.getValue().getDetail().getRound2(), productCart.getValue().getDetail().getRound3(),
//					productCart.getValue().getDetail().getContent());
//			boolean isInsert = OrderDetailService.insertOrderDetail(orderDetail);
//			System.out.println(isInsert);
//		}
//		System.out.println("insert order detail success");
//
//		System.out.println("insert invoice");
//		Invoice invoice = new Invoice(iduser, idorder, Contants.INVOIE_STATUS_WAITING_APPROVE, Contants.INVOICE_MODE_TRUCTIEP,
//				new Timestamp(System.currentTimeMillis()), address.getContent());
//		//trong đó new Timestamp(System.currentTimeMillis() là lấy thời gian lúc mua hàng
//		boolean isInsert = InvoiceService.insertInvoice(invoice);
//		System.out.println(isInsert);
//
//		System.out.println("checkout success");
//		session.removeAttribute("productCartList");
//		response.sendRedirect("/cart/checkout-success");
		return;
	}

	private  void leakPrivateKey(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		HttpSession session = request.getSession(true);
		User info = (User) session.getAttribute("userLogin");

		String startAt = request.getParameter("startAt");
		// handle delete order before startAt
		InvoiceService.deleteInvoiceBeforeStartAt(info.getIduser(), startAt);

		// handle create new public-key, private-key
		RSA rsa = new RSA();
		rsa.genKey();
		info.setPublicKey(Base64.getEncoder().encodeToString(rsa.getPublicKey().getEncoded()));

		String newPrivateKey = Base64.getEncoder().encodeToString(rsa.getPrivateKey().getEncoded());
		info.setPrivateKey(newPrivateKey);
		// update info user
		Boolean isUpdate = UserService.updatePublicKeyById(info.getIduser(),info);
		System.out.println(isUpdate);
		session.setAttribute("userLogin", info);

		System.out.println(info);
		// Gửi giá trị voucherPrice về phản hồi
		response.setContentType("text/plain");
		response.getWriter().write(String.valueOf(newPrivateKey));
	}
	private static byte[] signObject(Order order, PrivateKey privateKey) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(order);
		oos.close();

		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		signature.update(baos.toByteArray());

		return signature.sign();
	}
	private static boolean verifySignature(Order order, byte[] digitalSignature, PublicKey publicKey) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(order);
		oos.close();

		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(publicKey);
		signature.update(baos.toByteArray());

		return signature.verify(digitalSignature);
	}

	private static byte[] hashData(byte[] data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(data);
	}
}
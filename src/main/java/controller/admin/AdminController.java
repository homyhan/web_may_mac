//package controller.admin;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//import model.Invoice;
//import model.Order;
//import model.OrderDetail;
//import model.Permission;
//import model.Role;
//import model.RolePermission;
//import model.User;
//import response.InvoiceResponse;
//import response.OrderOrderdetailResponse;
//import service.InvoiceService;
//import service.OrderDetailService;
//import service.OrderService;
//import service.PemisionService;
//import service.RoleSevice;
//import service.UserService;
//
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.List;
//
//@WebServlet(name = "AdminController", value = "/admin/*")
//public class AdminController extends HttpServlet {
//	@Override
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String action = request.getPathInfo();// lấy được đường dẫn phía sau chữ cart /
//		if (action == null) {
//			action = "/";
//		}
//		switch (action) {
//		case "/don-hang":
//			showAdminInvoice(request, response);
//			return;
//		case "/tai-khoan":
//			showAdminAccount(request, response);
//			return;
//		case "/chi-tiet-tai-khoan":
//			detailAccount(request, response);
//			return;
//
//		case "/chi-tiet-don-hang":
//			detailOrder(request, response);
//			return;
//
//
//		default:
//			break;
//		}
//		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
//		return;
//	}
//
//	private void detailAccount(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		int iduser = Integer.parseInt(request.getParameter("iduser"));
//		System.out.println(iduser);
//		User data = UserService.getInstance().getDetailUserByIdUser(iduser);
//		System.out.println(data);
//		request.setAttribute("accounttdetail", data);
//		request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
//		return;
//	}
//
//	private void detailOrder(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int idOrder = Integer.parseInt(request.getParameter("idOrder"));
//		System.out.println(idOrder);
//
////		List<Invoice> data = OrderService.getDetailOrderByIdOrder1(idinvoice);
//		List<Order> data = OrderService.getDetailOrderByIdOrder1(idOrder);
//
//		request.setAttribute("idOrder", idOrder);
//
//		request.setAttribute("showOrderdetailTemp", data);
//		request.getRequestDispatcher("/quan-tri-admin/don-hang/chi-tiet-don-hang.jsp").forward(request, response);
//		return;
//	}
//
//
//
//
//
//
//	// hiển thị thông tin tài khoản admin
//	private void showAdminAccount(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession(true);
//		if (session.getAttribute("userLogin") == null) {
//			response.sendRedirect("/sign-in");
//			return;
//		}
//		// login thành công đã có user
//		List<User> userAdminList = UserService.getData();
//		request.setAttribute("userAdminList", userAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
//		request.getRequestDispatcher("/quan-tri-admin/khach-hang/khach-hang.jsp").forward(request, response);
//		System.out.println("redirect Admin user");
//		return;
//
//	}
//
//	// hiển thị Invoice
//	private void showAdminInvoice(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession(true);
//		if (session.getAttribute("userLogin") == null) {
//			response.sendRedirect("/sign-in");
//			return;
//		}
//		// login thành công đã có user
////		User info = (User) session.getAttribute("userLogin");
//		List<InvoiceResponse> invoiceAdminList = InvoiceService.getListInvoice4Admin();
//		request.setAttribute("invoiceAdminList", invoiceAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển
//																	// thị
//		request.getRequestDispatcher("/quan-tri-admin/don-hang/ql-don.jsp").forward(request, response);
//		System.out.println("chuyển đến trang đơn hàng");
//		return;
//
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String action = request.getPathInfo();
//		if (action == null) {
//			action = "/";
//		}
//		switch (action) {
//		case "/don-hang/updade-status":
//			updateInvoiceStatus(request, response);
//			return;
//		case "/remove-don-hang":
////			removeInvoice(request, response);
//			break;
//
//		case "/cap-nhat-tai-khoan":
//			updateUser(request, response);
//			return;
//
//		case "/remove-khach-hang":
//			removeAccount(request, response);
//			break;
//		default:
//			break;
//		}
//		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
//		return;
//	}
//
//
//	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
//		response.setCharacterEncoding("utf8");
//		response.setContentType("text/html; charset=UTF-8");
//		System.out.println("update user info");
//		HttpSession session = request.getSession(true);
//		if (session.getAttribute("userLogin") == null) {
//			response.sendRedirect("/sign-in");
//			return;
//		}
//		int iduser = Integer.parseInt(request.getParameter("iduser"));
//		System.out.println(iduser);
//		User info = UserService.getInstance().getDetailUserByIdUser(iduser);
//		String lastname = request.getParameter("lastname");// maimai
//		String firstname = request.getParameter("firstname");
//		String username = request.getParameter("username");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//
//		if (!username.equals(info.getUsername())) {
//			// kiểm tra username mới này có gắn với tk nào không
//			if (UserService.checkUserNameExist(username)) {
//				System.out.println("check user name");
//				request.setAttribute("error", "Username này đã có người sử dụng. Vui lòng đổi username khác");
//				request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
//				return;
//			}
//			info.setUsername(username);// nếu chưa ai sử dụng thì có quyền đổi
//		}
//
//		int role = info.getRole();
//		String[] selected = request.getParameterValues("isdefault");// input checkbox
//		// https://stackoverflow.com/questions/12396828/how-to-get-checked-checkboxes-in-jsp
//		System.out.println(selected);
//		if (selected != null) {
//			role = Integer.parseInt(selected[0]);
//		}
//		System.out.println(role);
//		info.setRole(role);
//
//		info.setLastname(lastname);// maimai
//		info.setFirstname(firstname);
//		info.setEmail(email);
//		info.setPhone(phone);
//		System.out.println(info);
//		boolean isUpdate = UserService.updateUserByIdUser(info.getIduser(), info);// cập nhật thông tin vào db
//		System.out.println(isUpdate);
//		if (isUpdate) {
//			request.setAttribute("message", "Cập nhật thành công");// hiển thị thông báo
//			request.setAttribute("accounttdetail", info);// hiển thị lại thông tin sau khi cập nhật
//			request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
//			return;
//		}
//		request.setAttribute("accounttdetail", info);
//		request.setAttribute("error", "Cập nhật không thành công. Vui lòng thử lại");
//		request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
//		return;
//	}
//
//	private void removeAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		String delete = request.getParameter("delete");
//        if (delete != null) {
//            String id = request.getParameter("id");
////            new UserService().deleteUser(id);
//        }
//        request.getRequestDispatcher("/quan-tri-admin/khach-hang/khach-hang.jsp").forward(request, response);
//		return;
//	}
//
//	private void updateInvoiceStatus(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
//		response.setCharacterEncoding("utf8");
//		response.setContentType("text/html; charset=UTF-8");
//		HttpSession session = request.getSession(true);
//		if (session.getAttribute("userLogin") == null) {
//			response.sendRedirect("/sign-in");
//			return;
//		}
//
//		int idinvoice = Integer.parseInt(request.getParameter("idinvoice"));
//		System.out.println(idinvoice);
//		System.out.println("Run update status invoice");
//		int invoice_status = Integer.parseInt(request.getParameter("invoice_status"));
//		System.out.println(invoice_status);
//
//		boolean isUpdate = InvoiceService.updateInvoiceStatus(idinvoice, invoice_status);
//		System.out.println(isUpdate);
//
//		response.sendRedirect("/admin/don-hang");
//		System.out.println("redirect don-hang");
//		return;
//	}
//}



package controller.admin;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import response.InvoiceResponse;
import response.OrderOrderdetailResponse;
import service.*;

import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "AdminController", value = "/admin/*")
public class AdminController extends HttpServlet {
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();// lấy được đường dẫn phía sau chữ cart /
		if (action == null) {
			action = "/";
		}
		switch (action) {
			case "/don-hang":
				try {
					showAdminInvoice(request, response);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return;
			case "/tai-khoan":
				showAdminAccount(request, response);
				return;
			case "/chi-tiet-tai-khoan":
				detailAccount(request, response);
				return;

			case "/chi-tiet-don-hang":
				detailOrder(request, response);
				return;


			default:
				break;
		}
		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
		return;
	}

	private void detailAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int iduser = Integer.parseInt(request.getParameter("iduser"));
		System.out.println(iduser);
		User data = UserService.getInstance().getDetailUserByIdUser(iduser);
		System.out.println(data);
		request.setAttribute("accounttdetail", data);
		request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
		return;
	}

	private void detailOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		User user = (User) session.getAttribute("userLogin");
		if(user.getRole()!=2){
			response.sendRedirect("/sign-in");
			return;
		}

		int idOrder = Integer.parseInt(request.getParameter("idOrder"));
		System.out.println(idOrder);

//		List<Invoice> data = OrderService.getDetailOrderByIdOrder1(idinvoice);
		List<Order> data = OrderService.getDetailOrderByIdOrder1(idOrder);

		request.setAttribute("idOrder", idOrder);

		request.setAttribute("showOrderdetailTemp", data);
		request.getRequestDispatcher("/quan-tri-admin/don-hang/chi-tiet-don-hang.jsp").forward(request, response);
		return;
	}






	// hiển thị thông tin tài khoản admin
	private void showAdminAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		User user = (User) session.getAttribute("userLogin");
		if(user.getRole()!=2){
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
		List<User> userAdminList = UserService.getData();
		request.setAttribute("userAdminList", userAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		request.getRequestDispatcher("/quan-tri-admin/khach-hang/khach-hang.jsp").forward(request, response);
		System.out.println("redirect Admin user");
		return;

	}

	// hiển thị Invoice
	private void showAdminInvoice(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("userLogin");
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}

		if(user.getRole()!=2){
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
//		User info = (User) session.getAttribute("userLogin");
		List<InvoiceResponse> invoiceAdminList = InvoiceService.getListInvoice4Admin();
		request.setAttribute("invoiceAdminList", invoiceAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển
		System.out.println(invoiceAdminList);											// thị
//		request.getRequestDispatcher("/quan-tri-admin/don-hang/ql-don.jsp").forward(request, response);
//		System.out.println("chuyển đến trang đơn hàng");

//		return;

//		START TEST 4-1
		List<Integer> cancelledInvoices = new ArrayList<>();
		for(InvoiceResponse invoiceRs : invoiceAdminList){
			ArrayList<Order> listOrderChanged = new ArrayList<>();

			Order orderGetFromDB = new Order(invoiceRs.getOrder().getIduser(), invoiceRs.getOrder().getIdaddress(), invoiceRs.getOrder().getSubtotal(), invoiceRs.getOrder().getItemdiscount(), invoiceRs.getOrder().getShipping(), invoiceRs.getOrder().getIdcoupons(), invoiceRs.getOrder().getGrandtotal(), invoiceRs.getOrder().getStatus(), invoiceRs.getOrder().getContent());
			int idOrder = invoiceRs.getOrder().getIdorder();
			List<OrderDetail> orDetailList = OrderDetailService.getProductCategory(idOrder);
			List<OrderDetail> odDetailListNew = new ArrayList<>();
			for (OrderDetail od : orDetailList) {
				OrderDetail odD = new OrderDetail(idOrder, od.getIdproduct(), od.getQuantity(), od.getSize(), od.getPrice(), od.getDiscount(), od.getIsmeasure(), od.getWeight(), od.getHeight(), od.getRound1(), od.getRound2(), od.getRound3(), od.getContent());
				odDetailListNew.add(odD);
			}
			System.out.println("----------- invoice trong admin----------");
			System.out.println(invoiceRs.getInvoice());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String formattedDate = dateFormat.format(invoiceRs.getInvoice().getCreateAt());
			Invoice invoiceObj = new Invoice(invoiceRs.getOrder().getIduser(), idOrder, invoiceRs.getInvoice().getMode(), formattedDate, invoiceRs.getInvoice().getContent());

			String publicKeyString = UserService.getUserById(invoiceRs.getOrder().getIduser()).getPublicKey();
			RSA rsa = new RSA();
			PublicKey publicKeyConverted = rsa.getPublicKeyFromString(publicKeyString);

			boolean checkTest = verifySignature3Obj(orderGetFromDB, odDetailListNew, invoiceObj, Base64.getDecoder().decode(invoiceRs.getOrder().getSignature()), publicKeyConverted);
			System.out.println("Ket qua Test Signature:");
			System.out.println(checkTest);

			if (!checkTest) {
				listOrderChanged.add(invoiceRs.getOrder());
				cancelledInvoices.add(invoiceRs.getInvoice().getIdinvoice());
			}
			if(listOrderChanged.size()>0 && invoiceRs.getInvoice().getStatus()!=0){

				updateInvoiceStatus(invoiceRs.getInvoice().getIdinvoice(), 0);
				sendEmail(UserService.getUserById(invoiceRs.getOrder().getIduser()).getEmail(),  listOrderChanged);
//				request.setAttribute("changedOrder", invoiceRs.getInvoice().getIdinvoice());
				System.out.println("Da gui email thanh cong");
			}

		}
		request.setAttribute("cancelledInvoices", cancelledInvoices);
		request.getRequestDispatcher("/quan-tri-admin/don-hang/ql-don.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		if (action == null) {
			action = "/";
		}
		switch (action) {
			case "/don-hang/updade-status":
				updateInvoiceStatus(request, response);
				return;
			case "/remove-don-hang":
//			removeInvoice(request, response);
				break;

			case "/cap-nhat-tai-khoan":
				updateUser(request, response);
				return;

			case "/remove-khach-hang":
				removeAccount(request, response);
				break;
			default:
				break;
		}
		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
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
		int iduser = Integer.parseInt(request.getParameter("iduser"));
		System.out.println(iduser);
		User info = UserService.getInstance().getDetailUserByIdUser(iduser);
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
				request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
				return;
			}
			info.setUsername(username);// nếu chưa ai sử dụng thì có quyền đổi
		}

		int role = info.getRole();
		String[] selected = request.getParameterValues("isdefault");// input checkbox
		// https://stackoverflow.com/questions/12396828/how-to-get-checked-checkboxes-in-jsp
		System.out.println(selected);
		if (selected != null) {
			role = Integer.parseInt(selected[0]);
		}
		System.out.println(role);
		info.setRole(role);

		info.setLastname(lastname);// maimai
		info.setFirstname(firstname);
		info.setEmail(email);
		info.setPhone(phone);
		System.out.println(info);
		boolean isUpdate = UserService.updateUserByIdUser(info.getIduser(), info);// cập nhật thông tin vào db
		System.out.println(isUpdate);
		if (isUpdate) {
			request.setAttribute("message", "Cập nhật thành công");// hiển thị thông báo
			request.setAttribute("accounttdetail", info);// hiển thị lại thông tin sau khi cập nhật
			request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
			return;
		}
		request.setAttribute("accounttdetail", info);
		request.setAttribute("error", "Cập nhật không thành công. Vui lòng thử lại");
		request.getRequestDispatcher("/quan-tri-admin/khach-hang/edit-customer.jsp").forward(request, response);
		return;
	}

	private void removeAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String delete = request.getParameter("delete");
		if (delete != null) {
			String id = request.getParameter("id");
//            new UserService().deleteUser(id);
		}
		request.getRequestDispatcher("/quan-tri-admin/khach-hang/khach-hang.jsp").forward(request, response);
		return;
	}

	private void updateInvoiceStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}

		int idinvoice = Integer.parseInt(request.getParameter("idinvoice"));
		System.out.println(idinvoice);
		System.out.println("Run update status invoice");
		int invoice_status = Integer.parseInt(request.getParameter("invoice_status"));
		System.out.println(invoice_status);

		boolean isUpdate = InvoiceService.updateInvoiceStatus(idinvoice, invoice_status);
		System.out.println(isUpdate);

		response.sendRedirect("/admin/don-hang");
		System.out.println("redirect don-hang");
		return;
	}

	private void updateInvoiceStatus(Integer idInvoice, int status){

		boolean isUpdate = InvoiceService.updateInvoiceStatus(idInvoice, status);
		System.out.println(isUpdate);

		System.out.println("redirect don-hang");
		return;
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

		ArrayList<Invoice> invoicesList = new ArrayList<>();

		String contentTd = "";

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


		for (Integer id : idList){
			System.out.println("Hoa don ma don hang bi thay doi: ");

//			System.out.println(getListInvoiceByIdOrder(id).toString());
			Product prod = ProductService.getProductByIdOrder(id).get(0);
//			prodList
//			Invoice inv = getListInvoiceByIdOrder(id).get(0);
//			idInvoice.add(inv.getIdinvoice());
//			System.out.println("ID hoa don: ");
//			System.out.println(inv.getIdinvoice());
//			updateInvoiceStatus(inv.getIdinvoice(), 0);
			System.out.println("Da cap nhat trang thai");
			prodList.add(prod);

		}

//		System.out.println("In san pham trong don hang bi thay doi");
//		System.out.println(prodList);

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
}





package controller.admin;

import javax.servlet.*;
import javax.servlet.http.*;

import model.Order;
import model.User;
import response.InvoiceResponse;
import service.InvoiceService;
import service.OrderService;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
			showAdminInvoice(request, response);
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
		// login thành công đã có user
		List<User> userAdminList = UserService.getData();
		request.setAttribute("userAdminList", userAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		request.getRequestDispatcher("/quan-tri-admin/khach-hang/khach-hang.jsp").forward(request, response);
		System.out.println("redirect Admin user");
		return;

	}

	// hiển thị Invoice
	private void showAdminInvoice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
//		User info = (User) session.getAttribute("userLogin");
		List<InvoiceResponse> invoiceAdminList = InvoiceService.getListInvoice4Admin();
		request.setAttribute("invoiceAdminList", invoiceAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển
																	// thị
		request.getRequestDispatcher("/quan-tri-admin/don-hang/ql-don.jsp").forward(request, response);
		System.out.println("chuyển đến trang đơn hàng");
		return;

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
}

package controller.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.IVoucherDaO;
import DAO.impl.VoucherDaO;
import model.Address;
import model.User;
import model.Voucher;
import response.InvoiceResponse;
import service.AddressService;
import service.InvoiceService;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
			showInvoice(request, response);
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
			throws ServletException, IOException {
		System.out.println("show invoice");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
		User info = (User) session.getAttribute("userLogin");
		List<InvoiceResponse> invoiceList = InvoiceService.getListInvoiceByUserId(info.getIduser());
		request.setAttribute("invoiceList", invoiceList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		request.getRequestDispatcher("/thong-tin-khach-hang/don-hang.jsp").forward(request, response);
		return;
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
}

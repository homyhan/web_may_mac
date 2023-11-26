package controller.admin;

import javax.servlet.*;
import javax.servlet.http.*;

import model.User;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileController", value = "/admin/profile/*")
public class ProfileController extends HttpServlet {
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		if (action == null) {
			action = "/";
		}
		switch (action) {
		case "/cap-nhat-tai-khoan":
			updateUser(request, response);
			return;
		case "/thay-doi-mat-khau":
			thayDoiMatKhau(request, response);
			return;

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
				request.getRequestDispatcher("/quan-tri-admin/profile.jsp").forward(request, response);
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

		response.sendRedirect("/quan-tri-admin/profile.jsp");// method get
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
				request.setAttribute("error-pass", "Mật khẩu không giống nhau. Vui lòng thử lại");
				request.getRequestDispatcher("/quan-tri-admin/profile.jsp").forward(request, response);
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

		response.sendRedirect("/quan-tri-admin/profile.jsp");// method get
		return;
	}

}

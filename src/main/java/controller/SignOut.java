package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignOut", value = "/sign-out")
public class SignOut extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// https://stackoverflow.com/questions/31555909/the-session-not-getting-cleared-in-logout
		System.out.println("Logout");
		try {
			HttpSession session = request.getSession(false);//set lại session false và xóa tất cả các attribute đang được lưu
			session.removeAttribute("userLogin");
			session.removeAttribute("addressDefault");
			session.removeAttribute("productCartList");
			session.removeAttribute("cartInfo");
			session.invalidate();//chuyển hết hạn
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		response.sendRedirect("/products");
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

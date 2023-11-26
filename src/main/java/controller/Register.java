package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import helper.Contants;
import model.User;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register ", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
        String lastname = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String phone = request.getParameter("phone");
        if (!password.equals(repassword)) {
        	request.setAttribute("error", "Mật khẩu không giống nhau. Vui lòng thử lại");
            request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
            return;
        } else {
            if (UserService.checkUserNameExist(userName)) {
                request.setAttribute("error", "Bạn đã có tài khoản. Vui lòng đăng nhập");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }
            
            //Nếu là admin
            int role = Contants.ROLE_CUSTOMER;
    		String[] selected = request.getParameterValues("isdefault");
    		System.out.println(selected);
    		if (selected != null) {
    			role = Integer.parseInt(selected[0]);//nếu có tham số này thì là insert từ trang quản trị là Admin
    		}
    		System.out.println(role);
    		
            User user = new User(lastname, firstName, email, userName, phone, password, 1, role);
            int isInsert = UserService.addRegister(user);
            if (isInsert <= 0) {
                request.setAttribute("error", "Đăng ký bị lỗi. Vui lòng thử lại.");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }
            System.out.println(isInsert);
        }
        response.sendRedirect("/sign-in");
        return;
    }
}

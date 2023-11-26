package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helper.Contants;
import model.Address;
import model.Log;
import model.User;
import response.RolePermissionResponse;
import service.AddressService;
import service.LogService;
import service.PemisionService;
import service.UserService;
import ultilities.Log4j;
import ultilities.Message;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;


@WebServlet(name = "SignIn", value = "/sign-in")
public class SignIn extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(SignIn.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("template/dang-nhap.jsp").forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	try {
//		logger.debug("This is a debug message");
//		logger.info("This is an info message");
//		logger.warn("This is a warn message");
//		logger.error("This is an error message");
//		logger.fatal("This is a fatal message");

//5.Hệ thống lấy dữ liệu và kiểm tra dữ liệu nhập		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		User user = UserService.dangNhap(username, password);

//		7.1 Hiển thị thông báo tên đăng nhập và password không hợp lệ
		if (user == null) {
			request.setAttribute("error", "Username or password is incorrect");// truyền kèm theo biến
			// .forward(request, response) khi muốn truyền tất cả input truyền sang trang kế
			// tiếp

			Log4j.error(Message.error());
			
			request.getRequestDispatcher("/template/dang-nhap.jsp").forward(request, response);
		} else {
			System.out.println(user.getRole());
			HttpSession session = request.getSession(true);
			session.setAttribute("userLogin", user);// lưu thông tin của user vào trường auth trên session
			if (user.getRole() == Contants.ROLE_CUSTOMER) {
				Address info = AddressService.getAddressDefaultByIdUser(user.getIduser());
				System.out.println("addressDefault");
				System.out.println(info);
				session.setAttribute("addressDefault", info);// thông tin địa chỉ mặc định lưa trên session để sử dụng
				 // khi mua hàng
				
//				Đăng nhập thành công lưu xuống log
				Log4j.info(Message.infoCustomer());
				
//				User info = (User) session.getAttribute("userLogin");
				String ip = request.getRemoteAddr();
				System.out.println("client ip address: "+ip);
				int iduser=user.getIduser();
				Log log = new Log(iduser,username,ip,new Timestamp(System.currentTimeMillis()));
				boolean isInsert = LogService.insertLog(log);
//				----------------
				
				
				response.sendRedirect("/products");// goi api lấy danh sách sản phẩm
			} else if (user.getRole() == Contants.ROLE_ADMIN) {
				// khi là admin thì cần lấy danh sách quyền trả về client
				List<RolePermissionResponse> data = PemisionService.getInstance().getData(user.getIdrole());
				// luu trữ dữ liệu lên section cho cả phiên làm viêc
				session.setAttribute("permissions", data);

				Log4j.info(Message.infoAdmin());

				response.sendRedirect("/quan-tri-admin/indexAdmin.jsp");
			}
			// truoc khi response thi luu log
			// insert log_system (ip, username, link api, datarequest, data reponse, status,
			// level)
			// { "username": "mainguyen", "password": "abc123"} > datarequest
			// { "userLogin": "..............", "addressDefault": "....."} > datarespone
			// status = 1 >
			// status = 0 >
			return;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return;
	}
	}
}

package controller.facebook;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.restfb.types.User;

import common.RestFB;
import helper.Contants;
import model.Address;
import model.Facebook;
import service.AddressService;
import service.FacebookService;
import service.LogService;
import service.UserService;
import ultilities.Log4j;
import ultilities.Message;

@WebServlet("/login-facebook")
public class LoginFacebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFacebookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");// queryparam lấy token từ facebook gửi về để sử dụng lấy thông tin
		System.out.println(code);
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("/template/dang-nhap.jsp");
			dis.forward(request, response);
		} else {
			// muốn lấy được accesstoken thì gọi API gettoken lên facebook để trả về
			String accessToken = RestFB.getToken(code);
			// dựa vào mã accessToken để lấy thông tin user: email, name, image, v.v
			User userInfo = RestFB.getUserInfo(accessToken);
			request.setAttribute("id", userInfo.getId());
			request.setAttribute("name", userInfo.getName());

			String myJSONString = userInfo.toString();
			System.out.println(myJSONString);

//			kiểm tra tài khoản có trong bảng facebook chưa
			// có rồi nên vào trang index
			if (FacebookService.checkIdFacebookExist(userInfo.getId())) {
				model.User user = FacebookService.dangNhapByIdFacebook(userInfo.getId());
				if (user == null) {
					Log4j.error(Message.error());
					request.getRequestDispatcher("/template/dang-nhap.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession(true);
					session.setAttribute("userLogin", user);// lưu thông tin của user vào trường auth trên session
					if (user.getRole() == Contants.ROLE_CUSTOMER) {
						Address info = AddressService.getAddressDefaultByIdUser(user.getIduser());
						session.setAttribute("addressDefault", info);// thông tin địa chỉ mặc định lưa trên session để
																		// sử dụng khi mua hàng
						
						Log4j.info(Message.infoCustomer());
						RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
						dis.forward(request, response);
					} else if (user.getRole() == Contants.ROLE_ADMIN) {
						
					}
				}
			} else {
				Facebook facebook = new Facebook(userInfo.getId(), userInfo.getName());
				boolean isInsert = FacebookService.insertFacebook(facebook);
				int role = Contants.ROLE_CUSTOMER;
				model.User user = new model.User(userInfo.getId(), 1, role);
				boolean isUser = FacebookService.insertUserFacebook(user);
//				RequestDispatcher dis = request.getRequestDispatcher("/facebook/index.jsp");
				RequestDispatcher dis = request.getRequestDispatcher("/products");
				dis.forward(request, response);
			}
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

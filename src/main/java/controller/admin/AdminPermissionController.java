package controller.admin;

import javax.servlet.*;
import javax.servlet.http.*;

import model.Permission;
import model.Role;
import model.RolePermission;
import model.User;
import service.PemisionService;
import service.RoleSevice;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "AdminPermissionController", value = "/admin/permision/*")
public class AdminPermissionController extends HttpServlet {
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();// lấy được đường dẫn phía sau chữ cart /
		if (action == null) {
			action = "/";
		}
		switch (action) {

		case "/phan-quyen-user":
			showAdminPession(request, response);
			return;

		case "/phan-quyen-role":
			showRolePession(request, response);
			return;

		case "/show-permission":
			showDetailPermission(request, response);
			return;

		default:
			break;
		}
		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
		return;
	}

//-- Phaan quyen	
	// hiển thị thông tin tài khoản AdminPession
	private void showAdminPession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
		List<User> userAdminPessionList = UserService.getData();
		request.setAttribute("userAdminPessionList", userAdminPessionList);
		System.out.println("userAdminPessionList" + userAdminPessionList);
		
		List<Role> roleList = RoleSevice.getData();
		request.setAttribute("roleList", roleList);
		
		request.getRequestDispatcher("/quan-tri-admin/phan-quyen/phan-quyen-user.jsp").forward(request, response);
		System.out.println("redirect Admin user");
		return;

	}

	// hiển thị thông tin role

	private void showRolePession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}
		// login thành công đã có user
		List<Role> roleList = RoleSevice.getData();
		request.setAttribute("roleList", roleList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		request.getRequestDispatcher("/quan-tri-admin/phan-quyen/phan-quyen-role.jsp").forward(request, response);
		System.out.println("redirect Admin user");
		return;

	}

//	

	private void showDetailPermission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idrole = Integer.parseInt(request.getParameter("idrole"));
		System.out.println("idrole: " + idrole);

		// lấy tất cả các permision của hệ thống
		// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		List<Permission> showPemision = PemisionService.getPermisson();

		// lấy tất cả các permision của role đó
		// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
		List<RolePermission> roleListDetail = PemisionService.getDetailPermissonByIdRole(idrole);

		List<Permission> showPemisionTemp = showPemision;
		for (int i = 0; i < showPemision.size(); i++) {
			showPemision.get(i).setStatus(0);// config giá trị mặc định
			for (RolePermission rp : roleListDetail) {
				if (showPemision.get(i).getIdpermission() == rp.getIdpermission()) {
					showPemision.get(i).setStatus(1);// tận dụng trường status để bật tắt quyền của role đó
					break;
				}
			}

			// gán dữ liệu vào ds mới
			showPemisionTemp.set(i, showPemision.get(i));
		}
		System.out.println(showPemisionTemp);

		request.setAttribute("idRoleOfPermision", idrole);
		request.setAttribute("showAllPemision", showPemisionTemp);
		request.getRequestDispatcher("/quan-tri-admin/phan-quyen/edit-permission.jsp").forward(request, response);
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

		case "/phan-quyen-user/updade-idrole":
			updateIdRole4User(request, response);
			return;

		case "/upsert-permission":
			upsertPermission(request, response);
			break;
		default:
			break;
		}
		// request.getRequestDispatcher("template/dang-nhap.jsp").forward(request,response);
		return;
	}

	private void updateIdRole4User(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLogin") == null) {
			response.sendRedirect("/sign-in");
			return;
		}

		int iduser = Integer.parseInt(request.getParameter("iduser"));
		System.out.println(iduser);
		System.out.println("Run update status iduser");
		int idrole = Integer.parseInt(request.getParameter("idrole"));
		System.out.println(idrole);

		boolean isUpdate = PemisionService.updateIdRole4User(iduser, idrole);
		System.out.println(isUpdate);

		response.sendRedirect("/admin/permision/phan-quyen-user");
		System.out.println("redirect phan-quyen");
		return;
	}

	private void upsertPermission(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("upsert Permission");
		// HttpSession session = request.getSession(true);
		// if (session.getAttribute("userLogin") == null) {
		// response.sendRedirect("/sign-in");
		// return;
		// }

		int idrole = Integer.parseInt(request.getParameter("idRole"));
		int idPermission = Integer.parseInt(request.getParameter("idPermission"));
		Timestamp currentTime = PemisionService.getCurrentTimeStamp();

		int isCheckPermission = 0;
		String[] selected = request.getParameterValues("isCheckPermission");// input checkbox
		System.out.println("check permision " + selected);
		if (selected != null) {
			isCheckPermission = Integer.parseInt(selected[0]);//nếu có check thì mới có giá trị để lấy
			System.out.println("valuse check permision " + isCheckPermission);
		}
		boolean isCheckInsert = false;
		RolePermission infoRolePermision = PemisionService.getInstance()
				.getDetailRolePermissonByIdroleAndIdPermision(idrole, idPermission);
		// query kiểm tra xem cặp idrole_idpermision có tồn tại hay không, không không
		// kiểm tra trường status có thì insert, ngược lại là update
		if (infoRolePermision == null) {
			isCheckInsert = true;// không tồn tại thì insert
		}
		if (isCheckInsert) {
			RolePermission rp = new RolePermission(idrole, idPermission, isCheckPermission, currentTime, currentTime);
			boolean isInsert = PemisionService.insertPermission(rp);
			System.out.println(isInsert);
		} else {
			RolePermission rp = new RolePermission(idrole, idPermission, isCheckPermission, currentTime, currentTime);
			boolean isUpdate = PemisionService.updatePermission(rp);
			System.out.println(isUpdate);
		}

		response.sendRedirect("/admin/permision/show-permission?idrole=" + idrole);
		return;
	}
}

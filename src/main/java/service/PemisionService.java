package service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import db.JDBIConnector;
import model.Permission;
import model.Role;
import model.RolePermission;
import response.RolePermissionResponse;

public class PemisionService {
	private static PemisionService instance;

	private PemisionService() {
	}

	public static PemisionService getInstance() {
		if (instance == null) {
			instance = new PemisionService();
		}
		return instance;
	}

	public static List<RolePermissionResponse> getData(int idrole) {
		return JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(
					"select rp.idrole, r.rolename, r.action as actionrole, rp.idpermission,  p.permissionname, p.action as actionpermission from role_permission rp join role r on rp.idrole = r.idrole join permission p on rp.idpermission = p.idpermission where rp.idrole = ?")
					.bind(0, idrole).mapToBean(RolePermissionResponse.class).stream().collect(Collectors.toList());
		});
	}

	public static List<RolePermissionResponse> getData1() {
		return JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(
					"select rp.idrole, r.rolename, r.action as actionrole, rp.idpermission,  p.permissionname, p.action as actionpermission from role_permission rp join role r on rp.idrole = r.idrole join permission p on rp.idpermission = p.idpermission ")

					.mapToBean(RolePermissionResponse.class).stream().collect(Collectors.toList());
		});
	}

	public static boolean updateIdRole4User(int iduser, int idrole) {
		// query > insert
		String query = "update user set idrole = ? where iduser = ?";
		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, idrole).bind(1, iduser).execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}

	public Role getDetailPermissonByIdrole(int idrole) {
		System.out.println(idrole);
		String query = "select * FROM role where idrole=?";
		List<Role> datas = JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(query).bind(0, idrole).mapToBean(Role.class).stream()
					.collect(Collectors.toList());
		});
		if (datas.size() > 0) {
			return datas.get(0);// lấy duy nhất 1 sản phẩm
		}
		return null;
	}

	public static List<RolePermission> getDetailPermissonByIdRole(int idrole) {
		return JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(
					"select rp.* from  role_permission rp join permission p on rp.idpermission = p.idpermission where rp.status = 1 and p.status = 1 and  rp.idrole = ?")
					.bind(0, idrole).mapToBean(RolePermission.class).stream().collect(Collectors.toList());
		});
	}

	public static List<Permission> getPermisson() {
		return JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery("select * from permission where status = 1").mapToBean(Permission.class).stream()
					.collect(Collectors.toList());
		});
	}

	public RolePermission getDetailRolePermissonByIdroleAndIdPermision(int idrole, int idPermision) {
		System.out.println(idrole);
		String query = "select * FROM role_permission where idrole=? and idpermission = ?";
		List<RolePermission> datas = JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(query).bind(0, idrole).bind(1, idPermision).mapToBean(RolePermission.class)
					.stream().collect(Collectors.toList());
		});
		if (datas.size() > 0) {
			return datas.get(0);// lấy duy nhất 1 sản phẩm
		}
		return null;
	}

	public static Timestamp getCurrentTimeStamp() {
		String query = "SELECT CURRENT_TIMESTAMP()";
		Optional<Timestamp> result = JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(query).mapTo(Timestamp.class).findFirst();
		});
		return result.get();
	}

	public static boolean insertPermission(RolePermission input) {
		// query > insert
		String query = "INSERT INTO `role_permission`(`idrole`,`idpermission`,`status`,`createAt`,`updateAt`)VALUES (?,?,?,?,?)";
		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, input.getIdrole()).bind(1, input.getIdpermission())
					.bind(2, input.getStatus()).bind(3, input.getCreateAt()).bind(4, input.getUpdateAt())
					.execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}

	public static boolean updatePermission(RolePermission input) {
		// query > insert
		String query = "UPDATE role_permission SET status = ? and updateAt = now() WHERE  idrole = ? and idpermission = ?;";
		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, input.getStatus()).bind(1, input.getIdrole())
					.bind(2, input.getIdpermission()).execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		List<RolePermission> data = PemisionService.getInstance().getDetailPermissonByIdRole(3);
		for (RolePermission item : data) {
			System.out.println(item.toString());
		}

		List<Permission> dataP = PemisionService.getInstance().getPermisson();
		for (Permission item : dataP) {
			System.out.println(item.toString());
		}
	}

}

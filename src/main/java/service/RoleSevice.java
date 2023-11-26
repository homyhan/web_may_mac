package service;

import java.util.List;
import java.util.stream.Collectors;

import db.JDBIConnector;
import model.Role;
import model.User;

public class RoleSevice {

	private static RoleSevice instance;

	private RoleSevice() {
	}

	public static RoleSevice getInstance() {
		if (instance == null) {
			instance = new RoleSevice();
		}
		return instance;
	}


	
	public static List<Role> getData() {
		return JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery("select * from role where status = 1").mapToBean(Role.class).stream().collect(Collectors.toList());
		});
	}
	
	

	public static void main(String[] args) {
		System.out.println(getData());
//		List<RolePermissionResponse> data = PemisionService.getInstance().getData(3);
//		for (RolePermissionResponse item : data) {
//			System.out.println(item.toString());
//		}
	}
}
package service;

import java.util.List;
import java.util.stream.Collectors;

import db.JDBIConnector;
import model.Facebook;
import model.User;

public class FacebookService {
	private static FacebookService instance;

	private FacebookService() {
	}

	public static FacebookService getInstance() {
		if (instance == null) {
			instance = new FacebookService();
		}
		return instance;
	}

	public static boolean insertFacebook(Facebook input) {

		// query > insert
		String query = "INSERT INTO facebook(`idfacebook`,`name`)VALUES(?,?)";

		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, input.getIdfacebook()).bind(1, input.getName())

					.execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}

	public static boolean insertUserFacebook(User input) {

		// query > insert
		String query = "INSERT INTO user(`status`,`role`,`idfacebook`) VALUES (?,?,?)";
		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, input.getStatus()).bind(1, input.getRole())
					.bind(2, input.getIdfacebook())

					.execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}

	public static boolean checkIdFacebookExist(String idfacebook) {
		List<Facebook> facebook = JDBIConnector.get()
				.withHandle(h -> h.createQuery("select * from facebook where idfacebook = ? ").bind(0, idfacebook)
						.mapToBean(Facebook.class).stream().collect(Collectors.toList()));
		if (facebook.size() == 0)
			return false;
		return true;
	}

	public static User dangNhapByIdFacebook(String idfacebook) {
		List<User> users = JDBIConnector.get().withHandle(h -> h.createQuery(
				"select u.iduser, u.role , f.name as username , u.idfacebook from user u join facebook f on u.idfacebook= f.idfacebook where u.idfacebook=? and u.status = 1")
				.bind(0, idfacebook).mapToBean(User.class).stream().collect(Collectors.toList()));
		if (users.size() == 0)
			return null;
		User user = users.get(0);
		return user;
	}

}

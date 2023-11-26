package model;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iduser;
	private String lastname;
	private String firstname;
	private String email;
	private String username;
	private String phone;
	private String password;
	private int status;
	private int role;
	private int idrole;
	private String idfacebook;

	// required default constructor
	public User() {
		super();
	}

	@ConstructorProperties({ "iduser", "lastname", "firstname", "email", "username", "phone", "password", "status",
			"role", "idrole" })
	public User(int iduser, String lastname, String firstname, String email, String username, String phone,
			String password, int status, int role, int idrole) {
		super();
		this.iduser = iduser;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.role = role;
		this.idrole = idrole;
	}

	public User(String lastname, String firstname, String email, String username, String phone, String password,
			int status, int role) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public User(String idfacebook, int role, int status) {
		super();
		this.status = status;
		this.role = role;
		this.idfacebook = idfacebook;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getIdrole() {
		return idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getIdfacebook() {
		return idfacebook;
	}

	public void setIdfacebook(String idfacebook) {
		this.idfacebook = idfacebook;
	}

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
				+ ", username=" + username + ", phone=" + phone + ", password=" + password + ", status=" + status
				+ ", role=" + role + ", idrole=" + idrole + ", idfacebook=" + idfacebook + "]";
	}

}

package response;

import model.Role;
import model.User;

public class UserRole {
	private static final long serialVersionUID = 1L;
	private User user;
	private Role role;
	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRole [user=" + user + ", role=" + role + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
	

}

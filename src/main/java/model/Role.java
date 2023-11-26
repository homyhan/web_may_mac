package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idrole;
	private String rolename;
	private int status;
	private Timestamp createAt;
	private Timestamp updateAt;
	private String action;

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", rolename=" + rolename + ", status=" + status + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + ", action=" + action + "]";
	}

	public int getIdrole() {
		return idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

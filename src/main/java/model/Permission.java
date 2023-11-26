package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idpermission;
	private String permissionname;
	private int status;
	private Timestamp createAt;
	private Timestamp updateAt;
	private String action;
		
	public Permission() {
		
	}
	
	@Override
	public String toString() {
		return "Permission [idpermission=" + idpermission + ", permissionname=" + permissionname + ", status=" + status
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + ", action=" + action + "]";
	}

	public int getIdpermission() {
		return idpermission;
	}

	public void setIdpermission(int idpermission) {
		this.idpermission = idpermission;
	}

	public String getPermissionname() {
		return permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
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

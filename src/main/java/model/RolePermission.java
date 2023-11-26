package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RolePermission implements Serializable  {
    private static final long serialVersionUID = 1L;
  
	private int idrole;
    private int idpermission;
    private int status;
    private Timestamp createAt;
    private Timestamp updateAt;
    
    public RolePermission() {
    }
    
	public RolePermission(int idrole, int idpermission, int status, Timestamp createAt, Timestamp updateAt) {
		super();
		this.idrole = idrole;
		this.idpermission = idpermission;
		this.status = status;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	@Override
	public String toString() {
		return "RolePermission [idrole=" + idrole + ", idpermission=" + idpermission + ", status=" + status
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	public int getIdpermission() {
		return idpermission;
	}
	public void setIdpermission(int idpermission) {
		this.idpermission = idpermission;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}

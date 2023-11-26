package response;


public class RolePermissionResponse {
	private static final long serialVersionUID = 1L;
	private int idrole;
	private String rolename;
	private String actionrole;

	private int idpermission;
	private String permissionname;
	private String actionpermission;



	@Override
	public String toString() {
		return "RolePermissionResponse [idrole=" + idrole + ", rolename=" + rolename + ", actionrole=" + actionrole
				+ ", idpermission=" + idpermission + ", permissionname=" + permissionname + ", actionpermission="
				+ actionpermission + "]";
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

	public String getActionrole() {
		return actionrole;
	}

	public void setActionrole(String actionrole) {
		this.actionrole = actionrole;
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

	public String getActionpermission() {
		return actionpermission;
	}

	public void setActionpermission(String actionpermission) {
		this.actionpermission = actionpermission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}

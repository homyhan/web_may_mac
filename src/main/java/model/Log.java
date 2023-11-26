package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private int idlog;
    private int iduser;
    private String username;
    private String ip;
    private Timestamp createAt;
    
    public Log() {
    }
    
	public Log( int iduser, String username, String ip, Timestamp createAt) {
		super();
	
		this.iduser = iduser;
		this.username = username;
		this.ip = ip;
		this.createAt = createAt;
	}

	public int getIdlog() {
		return idlog;
	}

	public void setIdlog(int idlog) {
		this.idlog = idlog;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Log [idlog=" + idlog + ", iduser=" + iduser + ", username=" + username + ", ip=" + ip + ", createAt="
				+ createAt + "]";
	}
    
	
    
    

}

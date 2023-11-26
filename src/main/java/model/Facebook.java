package model;

import java.io.Serializable;

public class Facebook implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idfacebook;
    private String name;
    
	public Facebook() {
		super();
	}

	public Facebook(String idfacebook, String name) {
		super();
		this.idfacebook = idfacebook;
		this.name = name;
	}

	public String getIdfacebook() {
		return idfacebook;
	}

	public void setIdfacebook(String idfacebook) {
		this.idfacebook = idfacebook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Facebook [idfacebook=" + idfacebook + ", name=" + name + "]";
	}

	
}

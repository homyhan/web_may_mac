package model;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;


    private int idaddress ;
    private int iduser ;
    private String name ;
    private String phone ;
    private String address ;
    private int isdefault ;
    private int  status ;
    private String content ;


    public Address() {
    }

    public Address( int iduser, String name, String phone, String address, int isdefault, int status, String content) {

        this.iduser = iduser;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.isdefault = isdefault;
        this.status = status;
        this.content = content;
    }

    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(int isdefault) {
        this.isdefault = isdefault;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idaddress=" + idaddress +
                ", iduser=" + iduser +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", isdefault=" + isdefault +
                ", status=" + status +
                ", content='" + content + '\'' +
                '}';
    }
}

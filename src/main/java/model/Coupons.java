package model;

import java.io.Serializable;

public class Coupons implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idcoupons;
    private int iduser;
    private String code;
    private String title;
    private float price;
    private int status;
    private int actice;
    private String content;

    public Coupons() {
    }

    public Coupons(int iduser, String code, String title, float price, int status, int actice, String content) {
		super();
		this.iduser = iduser;
		this.code = code;
		this.title = title;
		this.price = price;
		this.status = status;
		this.actice = actice;
		this.content = content;
	}

	public Coupons(int idcoupons, int iduser, String code, String title, float price, int status, int actice,
            String content) {
        this.idcoupons = idcoupons;
        this.iduser = iduser;
        this.code = code;
        this.title = title;
        this.price = price;
        this.status = status;
        this.actice = actice;
        this.content = content;
    }

    public int getIdcoupons() {
        return idcoupons;
    }

    public void setIdcoupons(int idcoupons) {
        this.idcoupons = idcoupons;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getActice() {
        return actice;
    }

    public void setActice(int actice) {
        this.actice = actice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "idcoupons=" + idcoupons +
                ", iduser=" + iduser +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", actice=" + actice +
                ", content='" + content + '\'' +
                '}';
    }
}

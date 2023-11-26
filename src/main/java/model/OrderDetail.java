package model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idorderdetail;
    private int idorder;
    private int idproduct;
    private int quantity;
    private String size;
    private float price;
    private float discount;
    private int ismeasure;
    private float weight;
    private float height;
    private float round1;
    private float round2;
    private float round3;
    private String content;

    public OrderDetail() {
    	this.size= "";
    	this.content = "";
    }

    public OrderDetail(int idorder, int idproduct, int quantity, String size, float price, float discount,
			int ismeasure, float weight, float height, float round1, float round2, float round3, String content) {
		super();
		this.idorder = idorder;
		this.idproduct = idproduct;
		this.quantity = quantity;
		this.size = size;
		this.price = price;
		this.discount = discount;
		this.ismeasure = ismeasure;
		this.weight = weight;
		this.height = height;
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
		this.content = content;
	}

	public OrderDetail(int idorderdetail, int idorder, int idproduct, int quantity, String size, float price,
            float discount, int ismeasure, float weight, float height, float round1, float round2, float round3,
            String content) {
        this.idorderdetail = idorderdetail;
        this.idorder = idorder;
        this.idproduct = idproduct;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.discount = discount;
        this.ismeasure = ismeasure;
        this.weight = weight;
        this.height = height;
        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
        this.content = content;
    }


	public int getIdorderdetail() {
        return idorderdetail;
    }

    public void setIdorderdetail(int idorderdetail) {
        this.idorderdetail = idorderdetail;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getIsmeasure() {
        return ismeasure;
    }

    public void setIsmeasure(int ismeasure) {
        this.ismeasure = ismeasure;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRound1() {
        return round1;
    }

    public void setRound1(float round1) {
        this.round1 = round1;
    }

    public float getRound2() {
        return round2;
    }

    public void setRound2(float round2) {
        this.round2 = round2;
    }

    public float getRound3() {
        return round3;
    }

    public void setRound3(float round3) {
        this.round3 = round3;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "idorderdetail=" + idorderdetail +
                ", idorder=" + idorder +
                ", idproduct=" + idproduct +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", ismeasure=" + ismeasure +
                ", weight=" + weight +
                ", height=" + height +
                ", round1=" + round1 +
                ", round2=" + round2 +
                ", round3=" + round3 +
                ", content='" + content + '\'' +
                '}';
    }
}

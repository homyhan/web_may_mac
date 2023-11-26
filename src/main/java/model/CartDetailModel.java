package model;

public class CartDetailModel {
    private int id;
    private String nameproduct;
    private String img;
    private double totalPrice;

    public CartDetailModel(int id, String nameproduct, String img, double totalPrice) {
        this.id = id;
        this.nameproduct = nameproduct;
        this.img = img;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartDetailModel() {
    }
}

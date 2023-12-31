package model;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idorder;
    private int iduser;
    private int idaddress;
    private float subtotal;
    private float itemdiscount;
    private float shipping;
    private float grandtotal;
    private int idcoupons;
    private int status;
    private String content;

    private String signature;

    public Order() {

    }

    public Order(int idorder, int iduser, int idaddress, float subtotal, float itemdiscount, float shipping,    int idcoupons, float grandtotal
            , int status, String content) {
//        super();
        this.idorder = idorder;
        this.iduser = iduser;
        this.idaddress = idaddress;
        this.subtotal = subtotal;
        this.itemdiscount = itemdiscount;
        this.shipping = shipping;
        this.idcoupons = idcoupons;
        this.grandtotal = grandtotal;
        this.status = status;
        this.content = content;
//        this.signature = signature;
    }

    public Order(int iduser, int idaddress, float subtotal, float itemdiscount, float shipping,    int idcoupons, float grandtotal
            , int status, String content) {

        this.iduser = iduser;
        this.idaddress = idaddress;
        this.subtotal = subtotal;
        this.itemdiscount = itemdiscount;
        this.shipping = shipping;
        this.idcoupons = idcoupons;
        this.grandtotal = grandtotal;
        this.status = status;
        this.content = content;
    }

    public Order(int iduser, int idaddress, float subtotal, float itemdiscount, float shipping,    int idcoupons, float grandtotal
            , int status, String content, String signature) {

        this.iduser = iduser;
        this.idaddress = idaddress;
        this.subtotal = subtotal;
        this.itemdiscount = itemdiscount;
        this.shipping = shipping;
        this.idcoupons = idcoupons;
        this.grandtotal = grandtotal;
        this.status = status;
        this.content = content;
        this.signature = signature;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }

    public int getIdcoupons() {
        return idcoupons;
    }

    public void setIdcoupons(int idcoupons) {
        this.idcoupons = idcoupons;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getItemdiscount() {
        return itemdiscount;
    }

    public void setItemdiscount(float itemdiscount) {
        this.itemdiscount = itemdiscount;
    }

    public float getShipping() {
        return shipping;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public float getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(float grandtotal) {
        this.grandtotal = grandtotal;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
//    public String toString() {
//        return "Order{" +
//                "idorder=" + idorder +
//                ", iduser=" + iduser +
//                ", idaddress=" + idaddress +
//                ", subtotal=" + subtotal +
//                ", itemdiscount=" + itemdiscount +
//                ", shipping=" + shipping +
//                ", grandtotal=" + grandtotal +
//                ", idcoupons=" + idcoupons +
//                ", status=" + status +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public String toString() {
        return "Order{" +
                "idorder=" + idorder +
                ", iduser=" + iduser +
                ", idaddress=" + idaddress +
                ", subtotal=" + subtotal +
                ", itemdiscount=" + itemdiscount +
                ", shipping=" + shipping +
                ", grandtotal=" + grandtotal +
                ", idcoupons=" + idcoupons +
                ", status=" + status +
                ", content='" + content +
                ", signature='" + signature + '\'' +
                '}';
    }

    public void put(Product product){

    }

    public void remove(int id) {

    }
    public void update(int id, int quantity) {

    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}

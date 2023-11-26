package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    public int idproduct;
    public int idcategory;
    public int idmaterial;
    public int idcolor;
    public String sku;
    public String title;
    public String image;
    public float price;
    public float discount;
    public int quantity;
    public int status;
    public int mode;
    public Timestamp startAt;
    public String content;

    public Product() {
    }

    public Product(int idproduct, int idcategory, int idmaterial, int idcolor, String sku, String title, String image, float price, float discount, int quantity, int status, int mode, Timestamp startAt, String content) {
        this.idproduct = idproduct;
        this.idcategory = idcategory;
        this.idmaterial = idmaterial;
        this.idcolor = idcolor;
        this.sku = sku;
        this.title = title;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.status = status;
        this.mode = mode;
        this.startAt = startAt;
        this.content = content;
    }

    public Product(int idcategory, int idmaterial, int idcolor, String sku, String title, String image, float price, float discount, int quantity, int status, int mode, Timestamp startAt, String content) {
        this.idcategory = idcategory;
        this.idmaterial = idmaterial;
        this.idcolor = idcolor;
        this.sku = sku;
        this.title = title;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.status = status;
        this.mode = mode;
        this.startAt = startAt;
        this.content = content;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "\nProduct{" +
                "idproduct=" + idproduct +
                ", idcategory=" + idcategory +
                ", idmaterial=" + idmaterial +
                ", idcolor=" + idcolor +
                ", sku='" + sku + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", status=" + status +
                ", mode=" + mode +
                ", startAt=" + startAt +
                ", content='" + content + '\'' +
                '}';
    }
}

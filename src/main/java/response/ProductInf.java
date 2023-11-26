package response;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductInf implements Serializable {
    private int idproduct;
    private String codecate;
    private int idmaterial;
    private String codecolor;
    private String sku;
    private String title;
    private String image;
    private float price;
    private float discount;
    private int quantity;
    private int status;
    private int mode;
    private Timestamp startAt;
    private String content;

    public ProductInf() {
    }

    public ProductInf(int idproduct, String codecate, int idmaterial, String codecolor, String sku, String title, String image, float price, float discount, int quantity, int status, int mode, Timestamp startAt, String content) {
        this.idproduct = idproduct;
        this.codecate = codecate;
        this.idmaterial = idmaterial;
        this.codecolor = codecolor;
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

    public String getCodecate() {
        return codecate;
    }

    public void setCodecate(String codecate) {
        this.codecate = codecate;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getCodecolor() {
        return codecolor;
    }

    public void setCodecolor(String codecolor) {
        this.codecolor = codecolor;
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
        return "\nProductInf{" +
                "idproduct=" + idproduct +
                ", codecate='" + codecate + '\'' +
                ", idmaterial=" + idmaterial +
                ", codecolor='" + codecolor + '\'' +
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

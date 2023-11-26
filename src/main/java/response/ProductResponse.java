package response;

import java.sql.Timestamp;

import model.Product;

public class ProductResponse extends Product {
	private static final long serialVersionUID = 1L;

	private String namematerial;

	public ProductResponse(int idproduct, int idcategory, int idmaterial, String sku, String title, String image,
			float price, float discount, int quantity, int status, int mode, Timestamp startAt, String content,
			String namematerial) {
		this.idproduct = idproduct;
		this.idcategory = idcategory;
		this.idmaterial = idmaterial;
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
		this.namematerial = namematerial;// thêm biến tên chất liệu
	}

	public String getNamematerial() {
		return namematerial;
	}

	public void setNamematerial(String namematerial) {
		this.namematerial = namematerial;
	}

	@Override
	public String toString() {
		return "ProductResponse [namematerial=" + namematerial + ", idproduct=" + idproduct + ", idcategory="
				+ idcategory + ", idmaterial=" + idmaterial + ", sku=" + sku + ", title=" + title + ", image=" + image
				+ ", price=" + price + ", discount=" + discount + ", quantity=" + quantity + ", status=" + status
				+ ", mode=" + mode + ", startAt=" + startAt + ", content=" + content + "]";
	}

}

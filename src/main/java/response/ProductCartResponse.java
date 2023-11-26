package response;

import model.OrderDetail;

//lớp custom chứa thông tin số lượng chọn mua và thông tin sản phẩm
public class ProductCartResponse {
	
	public int quantity;
//	public Product product;
	public ProductInf product;

	//size
	//height
	//round, ... tất cả thông tin này đều giống ở class orderdetail nên tận dụng
	public OrderDetail detail;

	public ProductCartResponse(int quantity, ProductInf product, OrderDetail detail) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.detail = detail;
	}

	public void incrementQuantity() {
		this.quantity++;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductInf getProduct() {
		return product;
	}

	public void setProduct(ProductInf product) {
		this.product = product;
	}

	public OrderDetail getDetail() {
		return detail;
	}

	public void setDetail(OrderDetail detail) {
		this.detail = detail;
	}

	public void setQuantity4Detail(int quantity) {
		if (this.detail != null) {
			this.detail.setQuantity(quantity);
		}
	}
}

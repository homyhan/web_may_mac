package response;

import java.util.HashMap;

//lớp custom chứa đầy đủ thông tin để sử dụng ở frondend file jsp
public class CartResponse {
	public float subtotal;// tổng giá tiền = sô lượng từng sản phẩm * đơn giá
	public float itemdiscount;// tổng giá tiền giảm = số lượng * giấ giảm của từng sản phẩm
	public float shipping;

	public float vouchePrice;
	public float grandtotal;
	// v.v
	public HashMap<Integer, ProductCartResponse> productCartList;

	public CartResponse(HashMap<Integer, ProductCartResponse> productCartList, float subtotal, float vouchePrice, float itemdiscount, float shipping, float grandtotal) {
		super();
		this.subtotal = subtotal;
		this.itemdiscount = itemdiscount;
		this.shipping = shipping;
		this.grandtotal = grandtotal;
		this.productCartList = productCartList;
		this.vouchePrice = vouchePrice;
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
	
	public float getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(float grandtotal) {
		this.grandtotal = grandtotal;
	}
	
	public float getShipping() {
		return shipping;
	}
	
	public void setShipping(float shipping) {
		this.shipping = shipping;
	}
	public HashMap<Integer, ProductCartResponse> getProductCartList() {
		return productCartList;
	}

	public void setProductCartList(HashMap<Integer, ProductCartResponse> productCartList) {
		this.productCartList = productCartList;
	}

	public float getVouchePrice() {
		return vouchePrice;
	}

	public void setVouchePrice(float vouchePrice) {
		this.vouchePrice = vouchePrice;
	}

	@Override
	public String toString() {
		return "CartResponse{" +
				"subtotal=" + subtotal +
				", itemdiscount=" + itemdiscount +
				", shipping=" + shipping +
				", vouchePrice=" + vouchePrice +
				", grandtotal=" + grandtotal +
				", productCartList=" + productCartList +
				'}';
	}
}
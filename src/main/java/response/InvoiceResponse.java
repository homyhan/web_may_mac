package response;

import java.io.Serializable;

import model.Invoice;
import model.Order;

//lớp custom chứa thông tin chi tiết của đơn hàng
public class InvoiceResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Invoice invoice;
	private Order order;
	private String statusValue;

	public InvoiceResponse(Invoice invoice, Order order, String statusValue) {
		super();
		this.statusValue = statusValue;
		this.invoice = invoice;
		this.order = order;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	
	@Override
	public String toString() {
		return "InvoiceResponse [statusValue=" + statusValue + ", invoice=" + invoice + ", order=" + order + "]";
	}
}

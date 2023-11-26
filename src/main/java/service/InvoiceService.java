package service;

import db.JDBIConnector;
import helper.Contants;
import model.Invoice;
import model.Order;
import response.InvoiceResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
	public static List<Invoice> getData() {
		
		return JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery("select * from invoice").mapToBean(Invoice.class).stream()
					.collect(Collectors.toList());
		});
	}

	// thêm thanh toan
	// -- status = 0 hủy, 1 thành công(đã giao hàng), 2 chờ xác nhận từ admin, 3 xác
	// nhận từ admin, 4 đang giao hàng,
	// -- hình thức 1: thanh toán khi nhận hàng, 2: thanh toán băng thẻ ngân hàng

	public static boolean insertInvoice(Invoice input) {
		// query > insert
		String query = "INSERT INTO invoice( `idusers`, `idorder`, `status`, `mode`,`createAt`,`content`) VALUES ( ?, ?, ?, ?, ?, ?)";
		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, input.getIduser()).bind(1, input.getIdorder())
					.bind(2, input.getStatus()).bind(3, input.getMode()).bind(4, input.getCreateAt())
					.bind(5, input.getContent()).execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	public static boolean updateInvoiceStatus(int invoiceId, int status) {
		// query > insert
		String query = "update invoice set status = ? where idinvoice = ?";
		int result = JDBIConnector.get().withHandle(handle -> {
			int count = handle.createUpdate(query).bind(0, status).bind(1, invoiceId).execute();
			return count;
		});
		if (result == 1) {
			return true;
		}
		return false;
	}

	public static List<InvoiceResponse> getListInvoiceByUserId(int iduser) {
		String query = "SELECT * FROM invoice where idusers = ? order by createAt desc";
		List<Invoice> datas = JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(query).bind(0, iduser).mapToBean(Invoice.class).stream()
					.collect(Collectors.toList());
		});
		return getListInvoiceResp(datas);
	}
	
	public static List<InvoiceResponse> getListInvoice4Admin() {
		String query = "select * from invoice order by createAt desc";
		List<Invoice> datas = JDBIConnector.get().withHandle(handle -> {
			return handle.createQuery(query).mapToBean(Invoice.class).stream()
					.collect(Collectors.toList());
		});
		return getListInvoiceResp(datas);
	}
	
	public static List<InvoiceResponse> getListInvoiceResp(List<Invoice> datas) {
		List<InvoiceResponse> result = new ArrayList<InvoiceResponse>();
		for (Invoice invoice : datas) {
			Order order = OrderService.getDetailByOrderId(invoice.getIdorder());
			String status = "Không xác định";
			switch (invoice.getStatus()) {
			case Contants.INVOIE_STATUS_APPROVE:
				status = "Đã xác nhận";
				break;
			case Contants.INVOIE_STATUS_CANCEL:
				status = "Đã hủy";
				break;
			case Contants.INVOIE_STATUS_DELIVERY:
				status = "Đang giao hàng";
				break;
			case Contants.INVOIE_STATUS_SUCCESS:
				status = "Hoàn thành";
				break;
			case Contants.INVOIE_STATUS_WAITING_APPROVE:
				status = "Chờ xác nhận";
				break;
			default:
				break;
			}
			result.add(new InvoiceResponse(invoice, order, status));// tạo lớp chứa thông tin invoice và order
		}
		return result;
	}

	public static void main(String[] args) {

//		List<Invoice> data = getData();
//		System.out.println(data);
//
//		Invoice input = new Invoice(2, 3, Contants.INVOIE_STATUS_WAITING_APPROVE, Contants.INVOICE_MODE_TRUCTIEP, new Timestamp(System.currentTimeMillis()), "abc");
//		boolean isInsert = insertInvoice(input);
//		System.out.println(isInsert);

		List<InvoiceResponse> result = getListInvoiceByUserId(2);
		for (InvoiceResponse item : result) {
			System.out.println(item.toString());

		}

	}
}

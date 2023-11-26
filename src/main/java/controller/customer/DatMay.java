package controller.customer;

import service.ProductInfService;

import javax.servlet.*;
import javax.servlet.http.*;

import helper.Contants;
import model.OrderDetail;
import response.ProductCartResponse;
import response.ProductInf;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DatMay", value = "/datmay")
public class DatMay extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idproduct = Integer.parseInt(request.getParameter("idproduct"));
		ProductCartResponse info = null;
		
		HashMap<Integer, ProductCartResponse> cartList = new HashMap<Integer, ProductCartResponse>();// khởi tạo mảng rổng
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") != null) {// kiểm tra
			cartList = (HashMap<Integer, ProductCartResponse>) session.getAttribute("productCartList");// ép kiểu dữ liệu
		}
		for (Map.Entry<Integer, ProductCartResponse> entry : cartList.entrySet()) {
			//nếu sản phẩm tồn tại trong giỏ hàng và là đặt may
			if (entry.getValue().getProduct().getIdproduct() == idproduct
					&& entry.getValue().getDetail().getIsmeasure() == Contants.ORDER_MEASURE) {
				//nếu đã có trong giỏ hàng lấy ra
				info = entry.getValue();
			}
		}
		if (info == null) {
			//nếu chưa có trong giỏ hàng thì khởi tạo
			ProductInf product = ProductInfService.getInstance().getDetailProductByidproduct(idproduct);
			
			OrderDetail detail = new OrderDetail();
			detail.setIsmeasure(1);
			detail.setHeight(160);
			detail.setWeight(45);
			detail.setRound1(90);
			detail.setRound2(60);
			detail.setRound3(90);
			info = new ProductCartResponse(idproduct, product, detail);
			info.setQuantity(1);
		}
		System.out.println("show dat may");
		request.setAttribute("cartdatmay", info);
		request.getRequestDispatcher("/template/dat-may-theo-yeu-cau.jsp").forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

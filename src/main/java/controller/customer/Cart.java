package controller.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.impl.VoucherDaO;
import controller.OrderFeeController;
import controller.customer.GetVoucherPriceServlet;
import helper.Contants;
import model.OrderDetail;
import model.Voucher;
import model.VoucherUser;
import response.CartResponse;
import response.ProductCartResponse;
import response.ProductInf;
import service.ProductInfService;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Cart", value = "/cart/*") // endpoint * có nhiều route đường dẫn phía sau và xử lí từng trường hợp method get, post
public class Cart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();// lấy được đường dẫn phía sau chữ cart /
		if (action == null) {
			action = "/";
		}
		switch (action) {
		case "/":
			showCart(request, response);
			// chuyển đến màn hình hiển thị giỏ hàng
			break;
		case "/checkout-success":
			showCheckout(request, response);//sau khi mua hàng thành công
			break;
		default:
			break;
		}
		return;
	}
	public void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<Integer, ProductCartResponse> cartList = new HashMap<Integer, ProductCartResponse>();//khai báo danh sách giỏ hàng rổng
		//nếu chưa mua gì thì vẫn hiển thị giỏ hàng rổng
		HttpSession session = request.getSession(true);//khai báo session
		if (session.getAttribute("productCartList") != null) {//phải kiểm tra null ở session trước khi ép kiểu dữ liệu
			//chứa thông tin sản phẩm và số lượng mua được chọn trong phiên làm việc
			cartList = (HashMap<Integer, ProductCartResponse>) session.getAttribute("productCartList");
		}

		float voucherPrice = 0;
//			voucherPrice = (float) session.getAttribute("voucherPrice");


		float subtotal = 0;// tổng giá tiền = sô lượng từng sản phẩm * đơn giá
		float itemdiscount = 0;// tổng giá tiền giảm = số lượng * giấ giảm của từng sản phẩm
		for (Map.Entry<Integer, ProductCartResponse> entry : cartList.entrySet()) {
			subtotal += entry.getValue().getQuantity() * entry.getValue().product.getPrice();
			itemdiscount += entry.getValue().getQuantity() * entry.getValue().product.getDiscount();
		}

		float shipping = (float) (0.01*itemdiscount);
		System.out.println(shipping);
		float grandtotal = itemdiscount + shipping - (float) voucherPrice;// tổng giá tiền cuối cùng
		CartResponse cartInfo = new CartResponse(cartList, subtotal, voucherPrice, itemdiscount, shipping, grandtotal);
		System.out.println(cartInfo);
		session.setAttribute("cartInfo", cartInfo);//session để lưu thông tin tiền và cả sản phẩm
		System.out.println("show cart");
		// gán thông tin danh sách giỏ hàng vào trong request
		response.sendRedirect("/template/gio-hang2.jsp");
		return;
	}

	public void showCheckout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/template/dat-hang-thanh-cong.jsp");
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/add-to-cart":
			addToCart(request, response);
			break;
		case "/update-quantity":
			updateQuantity(request, response);
			break;
		case "/remove-product":
			removeProduct(request, response);
			break;
		case "/remove-all":
			removeAll(request, response);
			break;
		default:
			break;
		}
		return;
	}

	private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") == null) {
			response.sendRedirect("/cart");
			return;
		}
		HashMap<Integer, ProductCartResponse> cartList = (HashMap<Integer, ProductCartResponse>) session
				.getAttribute("productCartList");

		int id = Integer.parseInt(request.getParameter("id"));
		cartList.remove(id);
		session.setAttribute("productCartList", cartList);// lưu lại vào trong session thông tin
		System.out.println("remove item product");
		response.sendRedirect("/cart");
		return;
	}

	private void removeAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") == null) {
			response.sendRedirect("/products");
			return;
		}
		HashMap<Integer, ProductCartResponse> cartList = new HashMap<Integer, ProductCartResponse>();
		session.setAttribute("productCartList", cartList);// lưu lại vào trong session thông tin
		System.out.println("remove all");
		response.sendRedirect("/cart");
		return;
	}

	private void updateQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") == null) {
			response.sendRedirect("/cart");
			return;
		}
		HashMap<Integer, ProductCartResponse> cartList = (HashMap<Integer, ProductCartResponse>) session
				.getAttribute("productCartList");

		int idproduct = Integer.parseInt(request.getParameter("id"));
		System.out.println(idproduct);
		System.out.println("Run update to cart");
		int quantity = Integer.parseInt(request.getParameter("get_quantity_order"));
		System.out.println(quantity);
		ProductInf product = ProductInfService.getInstance().getDetailProductByidproduct(idproduct);// lấy dữ liệu database dựa vào id

		int ismeasure = Integer.parseInt(request.getParameter("ismeasure"));
		OrderDetail detail = new OrderDetail();// dữ liệu thêm của người dùng gồm số lượng, size, height, v.v
		detail.setIsmeasure(ismeasure);
		if (ismeasure == 0) {
			detail.setSize(request.getParameter("get_size_order"));
			System.out.println(detail.getSize());
		} else if (ismeasure == 1) {
			detail.setHeight(Float.parseFloat(request.getParameter("height")));
			detail.setWeight(Float.parseFloat(request.getParameter("weight")));
			detail.setRound1(Float.parseFloat(request.getParameter("round1")));
			detail.setRound2(Float.parseFloat(request.getParameter("round2")));
			detail.setRound3(Float.parseFloat(request.getParameter("round3")));
			detail.setContent(request.getParameter("validationNote"));
			//
		}
		ProductCartResponse productCart;
		// lấy thông tin giỏ hàng hiện có > xử lí thêm xóa chỉnh sửa số lượng, sản phẩm
		if (cartList.containsKey(idproduct)) {
			if (quantity == 0) {
				cartList.remove(idproduct);//số lượng = 0 thì xóa
			} else {
				productCart = cartList.get(idproduct);
				productCart.setQuantity(quantity);// cập nhật lại số lượng
				productCart.setDetail(detail);// cập nhật lại thông tin detail
				// https://stackoverflow.com/questions/10120063/how-to-set-default-value-for-drop-down-select-in-jsp
			}
		} else {
			productCart = new ProductCartResponse(quantity, product, detail);
			cartList.put(idproduct, productCart);
		}

		session.setAttribute("productCartList", cartList);// lưu lại vào trong session thông tin
		for (Map.Entry<Integer, ProductCartResponse> entry : cartList.entrySet()) {
			System.out.println(entry.getValue().product.getIdproduct() + " So luong = " + entry.getValue().quantity);
		}
		System.out.println("update to cart");
		response.sendRedirect("/cart");// gọi đến method get /cart là gọi đến showcard
		return;
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		int idproduct = Integer.parseInt(request.getParameter("id"));//input lấy từ name="" đầu vào idproduct
		System.out.println(idproduct);
		System.out.println("Run add to cart");
		int quantity = Integer.parseInt(request.getParameter("get_quantity_order"));//input số lượng
		System.out.println(quantity);
		ProductInf product = ProductInfService.getInstance().getDetailProductByidproduct(idproduct);// lấy dữ liệu database dựa vào id
		
		int ismeasure = Integer.parseInt(request.getParameter("ismeasure"));
		OrderDetail detail = new OrderDetail();// dữ liệu thêm của người dùng gồm số lượng, size, height, v.v
		detail.setIsmeasure(ismeasure);//xác định là mua hàng có sẵn hay đặt may
		if (ismeasure == Contants.ORDER_NOT_MEASURE) {
			detail.setSize(request.getParameter("get_size_order"));//chỉ có size, số lượng
			System.out.println(detail.getSize());
		} else if (ismeasure == Contants.ORDER_MEASURE) {
			detail.setHeight(Float.parseFloat(request.getParameter("height")));
			detail.setWeight(Float.parseFloat(request.getParameter("weight")));
			detail.setRound1(Float.parseFloat(request.getParameter("round1")));
			detail.setRound2(Float.parseFloat(request.getParameter("round2")));
			detail.setRound3(Float.parseFloat(request.getParameter("round3")));
			detail.setContent(request.getParameter("validationNote"));
			//
		}
		
		ProductCartResponse productCart;

		HashMap<Integer, ProductCartResponse> cartList = new HashMap<Integer, ProductCartResponse>();;//khai báo chưa có giỏ hàng mảng rỗng
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productCartList") != null) {
			cartList = (HashMap<Integer, ProductCartResponse>) session.getAttribute("productCartList");//nếu giỏ hàng có sản phẩm
		}

		// lấy thông tin giỏ hàng hiện có > xử lí thêm xóa chỉnh sửa số lượng, sản phẩm
		if (cartList.size()==0) {
			//nếu giỏ hàng chưa có sản phẩm nào thì thêm vào
			//dùng hashmap để set key value , trong đó key là idproduct, value là thông tin chi tiết của sản phẩm và số lượng mua
			productCart = new ProductCartResponse(quantity, product, detail);//khởi tạo sản phẩm
			cartList.put(idproduct, productCart);//thêm sản phẩm được chọn vào giỏ hàng

		} else {
			if (cartList.containsKey(idproduct)) {//kiểm tra key tồn tại trong hashmap
				productCart = cartList.get(idproduct);
				productCart.setQuantity(quantity);// cập nhật lại số lượng
				productCart.setDetail(detail);// cập nhật lại thông tin detail
				// https://stackoverflow.com/questions/10120063/how-to-set-default-value-for-drop-down-select-in-jsp
			} else {
				productCart = new ProductCartResponse(quantity, product, detail);
				cartList.put(idproduct, productCart);
			}
		}
		session.setAttribute("productCartList", cartList);// lưu lại vào trong session thông tin
		System.out.println("add to cart");
		response.sendRedirect("/cart");// gọi đến method get /cart là gọi đến showcard
		return;
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto- method stub
		super.doDelete(req, resp);
		//xóa - form
	}
	
	// get - link - không bảo mật
	// post - form
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
		//cập nhật - form
	}
}

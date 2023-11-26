package controller.admin.product;

import model.*;
import response.ProductInf;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "AdminUpdateProductControl", urlPatterns = "/edit-product")
public class AdminUpdateProductControl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		
		//nếu sử dung multipart/form-data thì dùng getParameter đang không lấy dữ liệu
		String name = request.getParameter("name");
		if (name == null) {
			name = "";
		}

		String sku = request.getParameter("sku");
		if (sku == null) {
			sku = "";
		}

		String qty = request.getParameter("qty");
		if (qty == null) {
			qty = "5";
		}
		int iQty = Integer.parseInt(qty);

		String cate = request.getParameter("cate");
		System.out.println(cate);
		if (cate == null) {
			cate = "1";
		}
		int idcate = Integer.parseInt(cate);

		String material = request.getParameter("material");
		if (material == null) {
			cate = "1";
		}
		System.out.println(material);
		int idmaterial = Integer.parseInt(material);

		String color = request.getParameter("color");
		if (color == null) {
			cate = "1";
		}
		int idcolor = Integer.parseInt(color);

		String price = request.getParameter("price");
		if (price == null) {
			price = "0";
		}
		price = price.replaceAll(",", "");
		// do ở giao diên dùng fmt để chuyển price về string nên cần cắt chuỗi trả về số
		float fprice = Float.parseFloat(price);

		String discount = request.getParameter("discount");
		if (discount == null) {
			discount = "0";
		}
		discount = discount.replaceAll(",", "");
		float fdiscount = Float.parseFloat(discount);

		String content = request.getParameter("content");
		if (content == null) {
			content = "";
		}

		String mode = request.getParameter("mode");
		if (mode == null) {
			mode = "0";
		}
		int imode = Integer.parseInt(mode);

		String status = request.getParameter("status");
		if (status == null) {
			status = "1";
		}
		int istatus = Integer.parseInt(status);

		Timestamp currentTimeNow = new Timestamp(System.currentTimeMillis());// cách lấy giờ ở code java
		Timestamp currentTime = ProductService.getCurrentTimeStamp();

		String codecate = CategoryService.getInstance().getCodeById(idcate);

		String idProduct = request.getParameter("idproduct");
		if (idProduct == null) {
			idProduct = "";
		}
		int idproduct = Integer.parseInt(idProduct);
		try {
			//chưa xử lí được hình ảnh nên đóng lại do chưa có multipart/form-data 
			/*
			Part part = request.getPart("imgProduct");
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			String realPath = request.getServletContext().getRealPath("/images/products/" + codecate);
			System.out.print(filename + "-");
			part.write(realPath + "/" + filename);
			*/
			ProductInf product = ProductInfService.getInstance().getDetailProductByidproduct(idproduct);
			String filename = product.getImage();

			Product p = new Product(idcate, idmaterial, idcolor, sku, name, filename, fprice, fdiscount, iQty, istatus,
					imode, currentTime, content);
			boolean isUpdate = ProductService.updatePByIdProduct(idproduct, p);
			if (isUpdate == false) {
				request.setAttribute("msg", "thất bại");
				request.getRequestDispatcher("/quan-tri-admin/edit/edit-san-pham.jsp").forward(request, response);
				return;
			} else {
				System.out.println(isUpdate);
				request.setAttribute("msg", "thành công");
				request.getRequestDispatcher("/quan-tri-admin/edit/edit-san-pham.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/quan-tri-admin/edit/edit-san-pham.jsp").forward(request, response);
			return;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//        get id
		String idProduct = request.getParameter("idproduct");
		if (idProduct == null) {
			idProduct = "";
		}
		int idproduct = Integer.parseInt(idProduct);
		ProductInf product = ProductInfService.getInstance().getDetailProductByidproduct(idproduct);

		int idcate = ProductService.getIdCateByIdP(idproduct);
		String nameCate = CategoryService.getInstance().getNameCateById(idcate);
		request.setAttribute("idCate", idcate);
		request.setAttribute("nameCate", nameCate);

		int idM = ProductService.getIdMByIdP(idproduct);
		String nameM = MaterialService.getInstance().getNameCateById(idM);
		request.setAttribute("idM", idM);
		request.setAttribute("nameM", nameM);

		int idColor = ProductService.getIdColorByIdP(idproduct);
		String nameColor = ColorService.getInstance().getNameCateById(idColor);
		request.setAttribute("idColor", idColor);
		request.setAttribute("nameColor", nameColor);

		List listProduct = ProductInfService.getInstance().showListProductByID(idproduct);
		List<Category> listCate = CategoryService.getInstance().showListCate();
		List<Color> listColor = ColorService.getInstance().showListColorProduct();
		List<Material> listMaterial = MaterialService.getInstance().showListMaterial();

		request.setAttribute("listCate", listCate);
		request.setAttribute("listColor", listColor);
		request.setAttribute("listMaterial", listMaterial);
		request.setAttribute("listProduct", listProduct);
		request.getRequestDispatcher("/quan-tri-admin/edit/edit-san-pham.jsp").forward(request, response);
	}
}

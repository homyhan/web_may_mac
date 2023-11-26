package controller.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import response.ProductInf;
import service.ProductInfService;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductDetail", value = "/detail")
public class ProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idproduct = Integer.parseInt(request.getParameter("idproduct"));
        ProductInf data = ProductInfService.getInstance().getDetailProductByidproduct(idproduct);
        System.out.println(data);
        //gán dữ liệu danh sách sản phẩm vào biến list > gọi tới giao diên .jsp để hiển thị
        request.setAttribute("productdetail", data);
        request.getRequestDispatcher("/template/chi-tiet-san-pham.jsp").forward(request, response);//gọi đến giao diện sản phẩm
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
    //API có các phuong thức get post delete put
    //get lấy danh sách
    // + param //getdetail?a=xxxxx&b=
    //post khi muốn insert vào database ->
    //put khi muốn update vào database -> post
    //delete khi muốn xóa database -> post
}

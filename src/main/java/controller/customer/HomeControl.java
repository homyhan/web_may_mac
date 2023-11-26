package controller.customer;

import service.CategoryService;
import service.ProductInfService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControl", urlPatterns = {"/home", ""})
public class HomeControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        Show Top 8 san pham noi bat
        List listProduct = ProductInfService.getInstance().showTop8FeaturedProducts();
        request.setAttribute("listProduct", listProduct);

        List listCate = CategoryService.getInstance().showListCate();
        request.setAttribute("listCate", listCate);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

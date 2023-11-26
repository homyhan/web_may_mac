package controller.customer;

import service.CategoryService;
import service.ColorService;
import service.MaterialService;
import service.ProductInfService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Color;
import model.Material;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchControl", urlPatterns = "/search")
public class SearchControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String txtSearch = request.getParameter("txtSearch");
        int count = ProductInfService.getInstance().countProductByKeyWord(txtSearch);
        int total = ProductInfService.getInstance().getTotalProduct(); //119
        String page = request.getParameter("page");
        if(page==null){
            page="1";
        }
        int indexPage = Integer.parseInt(page);
        int pageSize = 12;
        int endPage = count / pageSize;
        if (count % pageSize != 0){
            endPage++;
        }
        List listProduct = ProductInfService.getInstance().searchByNamePaging(txtSearch, indexPage);

        //      -- get list category
        List<Category> listCate= CategoryService.getInstance().showListCate();
        List<Color> listColor= ColorService.getInstance().showListColorProduct();
        List<Material> listMaterial = MaterialService.getInstance().showListMaterial();

        request.setAttribute("listCate", listCate);
        request.setAttribute("listColor", listColor);
        request.setAttribute("listMaterial", listMaterial);

        request.setAttribute("count", count);
        request.setAttribute("total", total);
        request.setAttribute("endP", endPage);
        request.setAttribute("tag", indexPage);

        request.setAttribute("listProduct", listProduct);
        request.setAttribute("urlPattern", "search");
        request.setAttribute("contentPara", "&txtSearch=" + txtSearch);
        request.setAttribute("isProductPage", 0);
        request.setAttribute("mainTitle", "Tìm sản phẩm cho \"" + txtSearch + "\"");
        request.getRequestDispatcher("/views-product/products.jsp").forward(request, response);
    }
}

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductControl", urlPatterns = "/products")
public class ProductControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String sort = request.getParameter("sort");
        if (sort==null){
            sort="";
        }

//      --  pagination
        String page = request.getParameter("page");
        if(page==null){
            page = "1";
        }
        int indexPage = Integer.parseInt(page);

        int count = 0;
        int total = ProductInfService.getInstance().getTotalProduct(); //119

        List listProduct = new ArrayList();

        if(sort.equals("")){
        	count=total;
            listProduct = ProductInfService.getInstance().showListProduct(indexPage);
            request.setAttribute("mainTitle", "Sản phẩm");
            request.setAttribute("newChecked", 0);
            request.setAttribute("hotChecked", 0);
        }else{
            if(sort.equals("new")){
                count = total;
                listProduct = ProductInfService.getInstance().showListProductNewest(indexPage);
                request.setAttribute("contentPara", "&sort=" + sort);
                request.setAttribute("mainTitle", "Sản phẩm mới nhất");
                request.setAttribute("newChecked", 1);
                request.setAttribute("hotChecked", 0);
            }
            if(sort.equals("hot")){
                count = ProductInfService.getInstance().getTotalProductFeatured();
                listProduct = ProductInfService.getInstance().showListProductFeatured(indexPage);
                request.setAttribute("contentPara", "&sort=" + sort);
                request.setAttribute("mainTitle", "Sản phẩm nổi bật");
                request.setAttribute("hotChecked", 1);
                request.setAttribute("newChecked", 0);
            }
            if(sort.equals("asc")){
                count = total;
                listProduct = ProductInfService.getInstance().sortByPriceASC(indexPage);
                request.setAttribute("contentPara", "&sort=" + sort);
                request.setAttribute("mainTitle", "Sản phẩm");
                request.setAttribute("sortName", ": Giá thấp đến cao");
                request.setAttribute("newChecked", 0);
                request.setAttribute("hotChecked", 0);
            }
            if(sort.equals("desc")){
                count = total;
                listProduct = ProductInfService.getInstance().sortByPriceDESC(indexPage);
                request.setAttribute("contentPara", "&sort=" + sort);
                request.setAttribute("mainTitle", "Sản phẩm");
                request.setAttribute("sortName", ": Giá thấp đến cao");
                request.setAttribute("newChecked", 0);
                request.setAttribute("hotChecked", 0);
            }
        }

        int pageSize = 12;
        int endPage = count / pageSize;
        if(count % pageSize != 0){
            endPage++;
        }

        request.setAttribute("count", count);
        request.setAttribute("total", total);
        request.setAttribute("endP", endPage);
        request.setAttribute("tag", indexPage);
        request.setAttribute("isProductPage", 1);

//      -- get list category
        List<Category> listCate= CategoryService.getInstance().showListCate();
        List<Color> listColor= ColorService.getInstance().showListColorProduct();
        List<Material> listMaterial = MaterialService.getInstance().showListMaterial();

        request.setAttribute("listCate", listCate);
        request.setAttribute("listColor", listColor);
        request.setAttribute("listMaterial", listMaterial);

        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("/views-product/products.jsp").forward(request, response);

    }
}

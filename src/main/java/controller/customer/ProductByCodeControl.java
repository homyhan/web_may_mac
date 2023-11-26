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

import model.Material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductByCodeControl", urlPatterns = "/productsByCode")
public class ProductByCodeControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String page = request.getParameter("page");
        if (page==null){
            page="1";
        }
        int indexPage = Integer.parseInt(page);
//        get para discount
        String paraDiscount = request.getParameter("discount");
        if(paraDiscount==null){
            paraDiscount="";
        }
//        get para sort
        String paraSort = request.getParameter("sort");
        if(paraSort==null){
            paraSort="";
        }

//        count
        int total = ProductInfService.getInstance().getTotalProduct();
        int countPByCate = CategoryService.getInstance().countProductByCode(code);
        int countPByColor = ColorService.getInstance().countProductByCode(code);
        int countByMaterial = MaterialService.getInstance().countProductByCode(code);
        int countDByCate = CategoryService.getInstance().countProductDiscountByCode(code);
        int countHByCate = CategoryService.getInstance().countProductHotByCode(code);
        int countHDByCate = CategoryService.getInstance().countProductDiscountHotByCode(code);
        int countHByColor = ColorService.getInstance().countProductHotByCode(code);
        int countHByMaterial = MaterialService.getInstance().countProductHotByCode(code);

        int count = 0;
        String title = "";

        List listProduct = new ArrayList();

//        part: filter by code
//        Category
        if(countPByCate > 0){
            title = CategoryService.getInstance().getNameCateByCode(code);
            //        part: sort
            if(paraSort.equals("")){
                count = countPByCate;
                listProduct = CategoryService.getInstance().getProductByCode(code, indexPage);
                request.setAttribute("hotChecked", 0);
                request.setAttribute("newChecked", 0);
                request.setAttribute("contentPara", "&code=" + code);
            }else{
                request.setAttribute("contentPara", "&sort=" + paraSort + "&code=" + code);
                if(paraSort.equals("new")){
                    count = countPByCate;
                    listProduct = CategoryService.getInstance().showListProductNewestByCode(code, indexPage);
                    title += " mới nhất";
                    request.setAttribute("newChecked", 1);
                    request.setAttribute("hotChecked", 0);
                }
                if(paraSort.equals("hot")){
                    count = countHByCate;
                    listProduct = CategoryService.getInstance().showListProductFeaturedByCode(code, indexPage);
                    title += " nổi bật";
                    request.setAttribute("hotChecked", 1);
                    request.setAttribute("newChecked", 0);
                }
                if(paraSort.equals("asc")){
                    count = countPByCate;
                    listProduct = CategoryService.getInstance().sortByPriceASCByCode(code, indexPage);
                    title += " - Giá thấp đến cao";
                    request.setAttribute("sortName", ": Giá thấp đến cao");
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("hotChecked", 0);
                }
                if(paraSort.equals("desc")){
                    count = countPByCate;
                    listProduct = CategoryService.getInstance().sortByPriceDESCByCode(code, indexPage);
                    title += " - Giá cao đến thấp";
                    request.setAttribute("sortName", ": Giá cao đến thấp");
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("hotChecked", 0);
                }
            }
        }
//        Color
        if(countPByColor > 0){
            title = ColorService.getInstance().getNameByCode(code);
            if(paraSort.equals("")){
                count = countPByColor;
                listProduct = ColorService.getInstance().getProductByCode(code, indexPage);
                request.setAttribute("hotChecked", 0);
                request.setAttribute("newChecked", 0);
                request.setAttribute("contentPara", "&code=" + code);
            }else{
                request.setAttribute("contentPara", "&sort=" + paraSort + "&code=" + code);
                if(paraSort.equals("new")){
                    count = countPByColor;
                    listProduct = ColorService.getInstance().showListProductNewestByCode(code, indexPage);
                    title += " mới nhất";
                    request.setAttribute("newChecked", 1);
                    request.setAttribute("hotChecked", 0);
                }
                if(paraSort.equals("hot")){
                    count = countHByColor;
                    listProduct = ColorService.getInstance().showListProductFeaturedByCode(code, indexPage);
                    title += " nổi bật";
                    request.setAttribute("hotChecked", 1);
                    request.setAttribute("newChecked", 0);
                }
                if(paraSort.equals("asc")){
                    count = countPByCate;
                    listProduct = ColorService.getInstance().sortByPriceASCByCode(code, indexPage);
                    title += " - Giá thấp đến cao";
                    request.setAttribute("sortName", ": Giá thấp đến cao");
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("hotChecked", 0);
                }
                if(paraSort.equals("desc")){
                    count = countPByCate;
                    listProduct = ColorService.getInstance().sortByPriceDESCByCode(code, indexPage);
                    title += " - Giá cao đến thấp";
                    request.setAttribute("sortName", ": Giá cao đến thấp");
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("hotChecked", 0);
                }
            }
        }
//        Material
        if(countByMaterial > 0){
            title = MaterialService.getInstance().getNameByCode(code);
            if(paraSort.equals("")){
                count = countByMaterial;
                listProduct = MaterialService.getInstance().getProductByCode(code, indexPage);
                request.setAttribute("hotChecked", 0);
                request.setAttribute("newChecked", 0);
                request.setAttribute("contentPara", "&code=" + code);
            }else{
                request.setAttribute("contentPara", "&sort=" + paraSort + "&code=" + code);
                if(paraSort.equals("new")){
                    count = countByMaterial;
                    listProduct = MaterialService.getInstance().showListProductNewestByCode(code, indexPage);
                    title += " mới nhất";
                    request.setAttribute("newChecked", 1);
                    request.setAttribute("hotChecked", 0);
                }
                if(paraSort.equals("hot")){
                    count = countHByMaterial;
                    listProduct = MaterialService.getInstance().showListProductFeaturedByCode(code, indexPage);
                    title += " nổi bật";
                    request.setAttribute("hotChecked", 1);
                    request.setAttribute("newChecked", 0);
                }
                if(paraSort.equals("asc")){
                    count = countByMaterial;
                    listProduct = MaterialService.getInstance().sortByPriceASCByCode(code, indexPage);
                    title += " - Giá thấp đến cao";
                    request.setAttribute("sortName", ": Giá thấp đến cao");
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("hotChecked", 0);
                }
                if(paraSort.equals("desc")){
                    count = countByMaterial;
                    listProduct = MaterialService.getInstance().sortByPriceDESCByCode(code, indexPage);
                    title += " - Giá cao đến thấp";
                    request.setAttribute("sortName", ": Giá cao đến thấp");
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("hotChecked", 0);
                }
            }
        }

//        part: discount
        if(paraDiscount.equals("true")){
            if(code.equals("big-deal")){
                count = ProductInfService.getInstance().countTotalProductDiscount();
                listProduct = ProductInfService.getInstance().showListProductDiscount(indexPage);
                title = "Siêu Khuyến Mãi";
            }
            if(countDByCate>0){
                title = CategoryService.getInstance().getNameCateByCode(code) + " khuyến mãi";
                if(paraSort.equals("")){
                    count = countDByCate;
                    listProduct = CategoryService.getInstance().getListProductDiscountByCode(code, indexPage);
                    request.setAttribute("hotChecked", 0);
                    request.setAttribute("newChecked", 0);
                    request.setAttribute("contentPara", "&code=" + code);
                }else{
                    request.setAttribute("contentPara", "&sort=" + paraSort + "&code=" + code);
                    if(paraSort.equals("new")){
                        count = countDByCate;
                        listProduct = CategoryService.getInstance().showListProductDiscountNewestByCode(code, indexPage);
                        title += " mới nhất";
                        request.setAttribute("newChecked", 1);
                        request.setAttribute("hotChecked", 0);
                    }
                    if(paraSort.equals("hot")){
                        count = countHDByCate;
                        listProduct = CategoryService.getInstance().showListProductDiscountFeaturedByCode(code, indexPage);
                        title += " nổi bật";
                        request.setAttribute("hotChecked", 1);
                        request.setAttribute("newChecked", 0);
                    }
                    if(paraSort.equals("asc")){
                        count = countDByCate;
                        listProduct = CategoryService.getInstance().sortDiscountByPriceASCByCode(code, indexPage);
                        title += " - Giá thấp đến cao";
                        request.setAttribute("sortName", ": Giá thấp đến cao");
                        request.setAttribute("newChecked", 0);
                        request.setAttribute("hotChecked", 0);
                    }
                    if(paraSort.equals("desc")){
                        count = countDByCate;
                        listProduct = CategoryService.getInstance().sortDiscountByPriceDESCByCode(code, indexPage);
                        title += " - Giá cao đến thấp";
                        request.setAttribute("sortName", ": Giá cao đến thấp");
                        request.setAttribute("newChecked", 0);
                        request.setAttribute("hotChecked", 0);
                    }
                }
            }
        }

        int pageSize = 12;
        int endPage = count/pageSize;
        if(count%pageSize!=0){
            endPage++;
        }

        List listCate = CategoryService.getInstance().showListCate();
        List listColor= ColorService.getInstance().showListColorProduct();
        List<Material> listMaterial = MaterialService.getInstance().showListMaterial();

        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listCate", listCate);
        request.setAttribute("listColor", listColor);
        request.setAttribute("listMaterial", listMaterial);

        request.setAttribute("count", count);
        request.setAttribute("total", total);

        request.setAttribute("endP", endPage);
        request.setAttribute("tag", indexPage);

        request.setAttribute("urlPattern", "productsByCode");

        if(paraDiscount.equals("true")){
            request.setAttribute("contentPara", "&code="+ code + "&discount=true");
        }
        request.setAttribute("mainTitle", title);
        request.setAttribute("isProductPage", 0);

        request.getRequestDispatcher("/views-product/products.jsp").forward(request, response);
    }
}

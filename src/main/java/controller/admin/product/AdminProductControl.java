package controller.admin.product;

import model.Category;
import model.Color;
import model.Material;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminProductControl", urlPatterns = "/admin-products")
public class AdminProductControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int total = ProductInfService.getInstance().getTotalProduct();
        int count = 0;
        String contentPara = "";

        String code = request.getParameter("code");
        if(code==null){
            code="";
        }
        String nameCode = "Dòng sản phẩm";

        String sort = request.getParameter("sort");
        if(sort==null){
            sort="";
        }
        String nameSort = "Sắp xếp theo";

        //      --  pagination
        String page = request.getParameter("page");
        if(page==null){
            page = "1";
        }
        int indexPage = Integer.parseInt(page);

        String maxRow = request.getParameter("views");
        if(maxRow==null){
            maxRow="30";
        }
        int pageSize = Integer.parseInt(maxRow);

        List listProduct = new ArrayList();

        if(code.equals("") && sort.equals("")){
            count = total;
            listProduct = ProductInfService.getInstance().showListProductByPageSize(indexPage, pageSize);
        }else{
            if(!code.equals("")){
                count = CategoryService.getInstance().countProductByCode(code);
                pageSize = 15;
                listProduct = CategoryService.getInstance().getProductByCode(code, indexPage);
                contentPara += "&code=" + code;
                nameCode = CategoryService.getInstance().getNameCateByCode(code);
            }
            if(!sort.equals("")){
                count = total;
                pageSize = 15;
                contentPara += "&sort=" + sort;
                if(sort.equals("asc")){
                    listProduct = ProductInfService.getInstance().sortByPriceASC(indexPage);
                    nameSort = "Giá thấp đến cao";
                }
                if(sort.equals("desc")){
                    listProduct = ProductInfService.getInstance().sortByPriceDESC(indexPage);
                    nameSort = "Giá cao đến thấp";
                }
                if(sort.equals("discount")){
                    listProduct = ProductInfService.getInstance().showListProductDiscount(indexPage);
                    nameSort = "Giá khuyễn mãi";
                }
            }
        }

        int endPage = count / pageSize;
        if(count % pageSize != 0){
            endPage++;
        }

        //        xoa
        String paraIDProduct = request.getParameter("delIdproduct");
        if(paraIDProduct==null){
            paraIDProduct="";
        }
        if(!paraIDProduct.equals("")){
            int idproduct = Integer.parseInt(paraIDProduct);
            String namePDel = ProductService.getNameById(idproduct);
            boolean delP = ProductService.getDeleteOne(idproduct);
            if(delP==false){
                request.setAttribute("delnameProduct", "Không thể xóa: \"" + namePDel + "\" khỏi danh sách sản phẩm!");
            }else{
                request.setAttribute("delnameProduct", "Đã xóa: \"" + namePDel + "\" khỏi danh sách sản phẩm!");
                System.out.println(delP);
            }
            request.setAttribute("ipm", 1);
        }

        List<Category> listCate= CategoryService.getInstance().showListCate();
        if(!maxRow.equals("30") || !maxRow.equals("")){
            contentPara += "&views=" + pageSize;
        }

        request.setAttribute("count", count);
        request.setAttribute("total", total);
        request.setAttribute("endP", endPage);
        request.setAttribute("tag", indexPage);
        request.setAttribute("views", pageSize);
        request.setAttribute("nameCode", nameCode);
        request.setAttribute("contentPara", contentPara);
        request.setAttribute("nameSort", nameSort);

        request.setAttribute("listCate", listCate);
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("/quan-tri-admin/san-pham.jsp").forward(request, response);
    }
}

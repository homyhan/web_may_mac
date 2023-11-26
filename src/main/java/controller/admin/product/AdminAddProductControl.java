package controller.admin.product;

import model.Category;
import model.Color;
import model.Material;
import model.Product;
import service.CategoryService;
import service.ColorService;
import service.MaterialService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@MultipartConfig
@WebServlet(name = "AdminAddProductControl", urlPatterns = "/add-product")
public class AdminAddProductControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name==null){
            name="";
        }
        String sku = request.getParameter("sku");
        if(sku==null){
            sku="";
        }
        String qty = request.getParameter("qty");
        if(qty==null){
            qty="5";
        }
        int iQty = Integer.parseInt(qty);
        String cate = request.getParameter("cate");
        if(cate==null){
            cate="1";
        }
        int idcate = Integer.parseInt(cate);
        String material = request.getParameter("material");
        if(material==null){
            cate="1";
        }
        int idmaterial = Integer.parseInt(material);
        String color = request.getParameter("color");
        if(color==null){
            cate="1";
        }
        int idcolor = Integer.parseInt(color);
        String price = request.getParameter("price");
        if(price==null){
            price="0";
        }
        float fprice = Float.parseFloat(price);
        String discount = request.getParameter("discount");
        if(discount==null){
            discount="0";
        }
        float fdiscount = Float.parseFloat(discount);
        String content = request.getParameter("content");
        if(content==null){
            content="";
        }
        String mode = request.getParameter("mode");
        if(mode==null){
            mode="0";
        }
        int imode= Integer.parseInt(cate);
        String status = request.getParameter("status");
        if(status==null){
            status="1";
        }
        int istatus = Integer.parseInt(cate);

        Timestamp currentTime = ProductService.getCurrentTimeStamp();

        String codecate = CategoryService.getInstance().getCodeById(idcate);

        if(name.equals("") || sku.equals("")){
            request.setAttribute("error", "Không thể để trống phần này");
            response.sendRedirect("/quan-tri-admin/add/add-san-pham.jsp");
        }
        try{
            Part part = request.getPart("imgProduct");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            String realPath = request.getServletContext().getRealPath("/images/products/" + codecate);
            System.out.print(filename+ "-");
            part.write(realPath + "/" + filename);

            Product p = new Product(idcate, idmaterial, idcolor, sku, name, filename, fprice, fdiscount, iQty, istatus, imode, currentTime ,content);
            boolean isAdd = ProductService.inserProduct(p);
            if(isAdd == false){
                request.setAttribute("msg", "thất bại");
                request.getRequestDispatcher("/quan-tri-admin/add/add-san-pham.jsp").forward(request, response);
            }else{
                System.out.println(isAdd);
                request.setAttribute("msg", "thành công");
                request.getRequestDispatcher("/quan-tri-admin/add/add-san-pham.jsp").forward(request, response);
            }
        }catch (Exception e){}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCate= CategoryService.getInstance().showListCate();
        List<Color> listColor= ColorService.getInstance().showListColorProduct();
        List<Material> listMaterial = MaterialService.getInstance().showListMaterial();

        request.setAttribute("listCate", listCate);
        request.setAttribute("listColor", listColor);
        request.setAttribute("listMaterial", listMaterial);

        request.getRequestDispatcher("/quan-tri-admin/add/add-san-pham.jsp").forward(request, response);
    }
}

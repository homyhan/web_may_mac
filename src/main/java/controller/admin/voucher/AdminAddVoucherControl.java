//package controller.admin.voucher;
//
//import DAO.impl.VoucherDaO;
//import model.*;
//import service.CategoryService;
//import service.ColorService;
//import service.MaterialService;
//import service.ProductService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.List;
//
//@MultipartConfig
//@WebServlet(name = "AdminAddProductControl", urlPatterns = "/add-voucher")
//public class AdminAddVoucherControl extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("nameVoucher");
//        if(name==null){
//            name="";
//        }
//        String diktat = request.getParameter("diktat");
//        if(diktat==null){
//            diktat="";
//        }
//        String qty = request.getParameter("quantity");
//        if(qty==null){
//            qty="100";
//        }
//        int iQty = Integer.parseInt(qty);
//
//        String value = request.getParameter("value");
//        if(value==null){
//            value="0";
//        }
//        int vValue = Integer.parseInt(value);
//
//        String status = request.getParameter("status");
//        if(status==null){
//            status="1";
//        }
//        int istatus = Integer.parseInt(status);
//        Date startAt = VoucherDaO.getStartAtTime();
//        Timestamp
//        if(name.equals("") || diktat.equals("")){
//            request.setAttribute("error", "Không thể để trống phần này");
//            response.sendRedirect("/quan-tri-admin/add/add-voucher.jsp");
//        }
//        try{
//            Voucher p = new Voucher(name, iQty, diktat, vValue, name, filename, fprice, fdiscount, iQty, istatus, imode, currentTime ,content);
//            boolean isAdd = ProductService.inserProduct(p);
//            if(isAdd == false){
//                request.setAttribute("msg", "thất bại");
//                request.getRequestDispatcher("/quan-tri-admin/add/add-san-pham.jsp").forward(request, response);
//            }else{
//                System.out.println(isAdd);
//                request.setAttribute("msg", "thành công");
//                request.getRequestDispatcher("/quan-tri-admin/add/add-san-pham.jsp").forward(request, response);
//            }
//        }catch (Exception e){}
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Category> listCate= CategoryService.getInstance().showListCate();
//        List<Color> listColor= ColorService.getInstance().showListColorProduct();
//        List<Material> listMaterial = MaterialService.getInstance().showListMaterial();
//
//        request.setAttribute("listCate", listCate);
//        request.setAttribute("listColor", listColor);
//        request.setAttribute("listMaterial", listMaterial);
//
//        request.getRequestDispatcher("/quan-tri-admin/add/add-san-pham.jsp").forward(request, response);
//    }
//}

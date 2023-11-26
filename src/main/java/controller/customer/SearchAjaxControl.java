package controller.customer;


import service.ProductInfService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import response.ProductInf;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "SearchAjaxControl", urlPatterns = "/search-ajax" +
        "")
public class SearchAjaxControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.CHINA);

        String txtSearch = request.getParameter("txtS");
        List<ProductInf> listSearch = ProductInfService.getInstance().searchByName(txtSearch);
        PrintWriter out = response.getWriter();

        if(txtSearch.equals("") || txtSearch==null){
            out.println("<h2 class=\"p-3\">Không tìm thấy sản phẩm phù hợp (@_@) ! Hãy thử lại</h2>");
        }else{
            for (ProductInf p : listSearch) {
                out.println("<li class=\"item\">\n" +
                        "       <a href=\"detail?idproduct=" + p.getIdproduct() + "\" class=\"d-flex align-items-center p-2\">\n" +
                        "          <img src=\"images\\products\\" + p.getCodecate() + "\\" + p.getImage() + "\" alt=\"\">\n" +
                        "          <p class=\"card-title text-start\">"+p.getTitle()+"</p>\n" +
                        "     </a>\n" +
                        " </li>");
            }
        }
    }
}

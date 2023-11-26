package controller.admin.product;

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

@WebServlet(name = "SearchAjaxAdminProduct", urlPatterns = "/search-p-ajax")
public class SearchAjaxAdminProduct extends HttpServlet {
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
                out.println("<tr>");
                out.println("<td data-label=\"Id\">"+ p.getIdproduct() +"</td>");
                out.println("<td data-label=\"Ma\">"+ p.getSku() +"</td>");
                out.println("<td data-label=\"Name\">"+ p.getTitle() +"</td>");

                out.println("<td data-label=\"Image\">");
                out.println("<img src=\"images\\products\\" + p.getCodecate() + "\\" + p.getImage() + "\" width=\"100\" >");
                out.println("</td>");

                out.println("<td data-label=\"Status\">"+ p.getStartAt() +"</td>");

                out.println("<td data-label=\"Price\">");
                out.println("<span class=\"price\">");
                if(p.getDiscount()>0){
                    out.println("<del>" + p.getPrice() + " VND</del>");
                }
                if(p.getDiscount()==0){
                    out.println("<strong>" + p.getPrice() + " VND</strong>");
                }
                out.println("</span>");

                out.println("</td>");
                out.println("<td data-label=\"Discount\">");
                out.println("<span class=\"price-sale\">");
                if(p.getDiscount()>0){
                    out.println("<strong>" + p.getDiscount() + " VND</strong>");
                }
                if(p.getDiscount()==0){
                    out.println("<span>0 VND</span>");
                }
                out.println("</span>");
                out.println("</td>");

                out.println("<td class=\"actions-cell\">");
                out.println("<div class=\"buttons right nowrap\">");
                out.println("<a href=\"edit?idproduct=" + p.getIdproduct() + "\" ");
                out.println("<button  class=\"button small green \"  type=\"button\">\n" +
                        "                      <span class=\"icon\"><i class=\"mdi mdi-eye\"></i></span>\n" +
                        "                    </button>");
                out.println("</a>");
                out.println("<button class=\"button small red --jb-modal\" data-target=\"sample-modal\" type=\"button\">\n" +
                        "                      <span class=\"icon\"><i class=\"mdi mdi-trash-can\"></i></span>\n" +
                        "                    </button>");
                out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
            }
        }
    }
}

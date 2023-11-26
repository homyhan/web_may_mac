package controller.customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewControll extends HttpServlet {
    @WebServlet(name = "NewControll", value = "/NewControll")
    public class AboutUsControll extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        AboutUs aboutus = AboutUsService.getId(id);
//        request.setAttribute("aboutus", aboutus);
//        request.getRequestDispatcher("ve-chung-toi.jsp").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }
}

package controller.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AboutUsController", value = "/AboutUsController")
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

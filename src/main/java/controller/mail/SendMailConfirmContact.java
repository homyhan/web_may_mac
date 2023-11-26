package controller.mail;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendMailConfirmContact", urlPatterns = "/lien-he")
public class SendMailConfirmContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String msg = request.getParameter("message");
        String tripStart = request.getParameter("trip-start");

//        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;

        if(name==null){
            name="";
        }
        if(email==null){
            email="";
        }
        if(phone==null){
            phone="";
        }
        if(msg==null){
            msg="";
        }
        if(tripStart==null){
            tripStart="";
        }

        if(name.equals("") || email.equals("") || phone.equals("") || msg.equals("")){
            if(name.equals("")){
                request.setAttribute("errorName", "G15 muốn biết tên của bạn!");
            }
            if(email.equals("")){
                request.setAttribute("errorEmail", "G15 muốn biết email để liên hệ!");
            }
            if(phone.equals("")){
                request.setAttribute("errorPhone", "G15 muốn biết số điện thoại liên lạc!");
            }
            if(msg.equals("")){
                request.setAttribute("errorMsg", "G15 cần biết yêu cầu của bạn là gì!");
            }
            request.setAttribute("status", 0);
            response.sendRedirect("template/lien-he.jsp");
        }else{
//            try {
//                date = in.parse(tripStart);
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//            // output format
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

            UserService.getInstance().getMailContact(name, email, phone, tripStart , msg);
            request.setAttribute("status", 1);
            request.getRequestDispatcher("template/lien-he.jsp").forward(request, response);
        }
        System.out.println(name);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(tripStart);
        System.out.println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("template/lien-he.jsp").forward(request, response);
    }
}

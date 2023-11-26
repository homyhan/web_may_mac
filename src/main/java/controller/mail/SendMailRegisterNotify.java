package controller.mail;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendMailRegisterNotify", urlPatterns = "/registerNotify")
public class SendMailRegisterNotify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String emailTo = request.getParameter("emailTo");
        if(emailTo==null){
            emailTo="";
        }
        if(!emailTo.equals("")){
            UserService.getInstance().getMailNotify(emailTo);
            System.out.println("Đăng ký nhận thông báo thành công!");
            request.setAttribute("msgRegisterNotify", "Đăng ký nhận thông báo thành công!");
        }else{
            System.out.println("Đăng ký nhận thông báo thất bại");
            request.setAttribute("msgRegisterNotify", "Đã có vấn đề xãy ra! Hãy kiểm tra lại email đăng ký");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        something like that
    }
}

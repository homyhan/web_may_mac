package controller.admin.orders;

import model.*;
import response.ProductInf;
import service.*;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@WebServlet(name = "AdminUpdateOrderControl", urlPatterns = "/admin/edit-don-hang")
public class AdminUpdateOrderControl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            int idAddress = Integer.parseInt(request.getParameter("idAddress"));
            float subtotal = Float.parseFloat(request.getParameter("subtotal"));
            float itemDiscount = Float.parseFloat(request.getParameter("itemDiscount"));
            float shipping = Float.parseFloat(request.getParameter("shipping"));
            float grandtotal = Float.parseFloat(request.getParameter("grandtotal"));

            boolean isUpdated = OrderService.updateOrder(idOrder, idAddress, subtotal, itemDiscount, shipping, grandtotal);
            if(isUpdated){
                System.out.println("Updated Order");
                User userOrder = OrderService.getUserById(idUser);
                System.out.println(userOrder.getEmail());
                sendEmail(userOrder.getEmail());
//            OrderService orderFix = new OrderService();
//            orderFix.updateOrderAndSendEmail(idOrder, idAddress, subtotal, itemDiscount, shipping, grandtotal);
                response.sendRedirect("/admin/don-hang");
            }else{
                System.out.println("ERROR");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/quan-tri-admin/edit/edit-san-pham.jsp").forward(request, response);
            return;
        }
    }

    private void sendEmail(String toEmail) {
        final String fromEmail = "thienan21215@gmail.com";
        final String password = "wqubwaintvcbufnn";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            String content = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h3>Công ty May Mặc G15 gửi đến quý khách <span style=\"color: red;\"><b>CẢNH BÁO</b></span></h3>\n" +
                    "    <p>Chúng tôi vừa nhận thấy thông tin đơn hàng của quý khách đã bị chỉnh sửa thông tin</p>\n"  +
                    "    <p>Để bảo vệ tài khoản của quý khách được an toàn chúng tôi sẽ tiến hành hủy đơn hàng. Đối với các đơn hàng đã thanh toán G15 sẽ hoàn trả lại số tiền cho quý khách</p>\n" +
                    "    <p>Chúng tôi chân thành xin lỗi vì sự bất tiện này</p>\n" +
                    "    <p>Cảm ơn quý khách đã tin chọn G15</p>\n" +
                    "    <p>Mọi thắc mắc xin vui lòng liên hệ:</p>\n" +
                    "    <p>Số điện thoại: 0270399999</p>\n" +
                    "    <p>Email: thienan21215@gmail.com</p>\n" +
                    "</body>\n" +
                    "</html>";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("[CẢNH BÁO] CTY MAY MẶC G15 - ĐƠN HÀNG");
//            message.setText(content);
            message.setContent(content, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            // Xử lý lỗi gửi email
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        System.out.println(idOrder);

        List<Order> data = OrderService.getDetailOrderByIdOrder2(idOrder);

        request.setAttribute("idOrderToEdit", idOrder);

        request.setAttribute("showOrderdetailTempToEdit", data);
        request.getRequestDispatcher("/quan-tri-admin/edit/edit-don-hang.jsp").forward(request, response);
    }
}


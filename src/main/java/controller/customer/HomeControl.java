package controller.customer;

import model.Order;
import model.User;
import service.CategoryService;
import service.InvoiceService;
import service.ProductInfService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "HomeControl", urlPatterns = {"/home", ""})
public class HomeControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        Show Top 8 san pham noi bat
        List listProduct = ProductInfService.getInstance().showTop8FeaturedProducts();
        request.setAttribute("listProduct", listProduct);

        List listCate = CategoryService.getInstance().showListCate();
        request.setAttribute("listCate", listCate);

        HttpSession session = request.getSession(true);
        User info = (User) session.getAttribute("userLogin");
        if(info!=null){
//        if(info!=null){
            System.out.println(info.getIduser());
//            List<Order> orderHistoryList = InvoiceService.getDataOrderHistory(info.getIduser());
//        request.setAttribute("userAdminList", userAdminList);// lưu thông tin đơn hàng chuyển qua giao diện hiển thị
//        request.getRequestDispatcher("/quan-tri-admin/khach-hang/khach-hang.jsp").forward(request, response);
//            System.out.println("Order history");
//            System.out.println(orderHistoryList);
//            if (orderHistoryList.size()!=0){
//                System.out.println("Canh bao");
//                sendEmail(info.getEmail());
////                session.setAttribute("emailSent", true);
//                return;
//            }else{
//                System.out.println("Khong canh bao");
//            }

        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    private void sendEmail(String toEmail) {
        final String fromEmail = "thienan21215@gmail.com"; // Email của bạn
        final String password = "wqubwaintvcbufnn"; // Mật khẩu email của bạn

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

}

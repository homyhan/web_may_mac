package controller.customer;

import db.JDBIConnector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "GetVoucherPriceServlet", value = "/thanh-toan/get-voucher-price")
public class GetVoucherPriceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int voucherId = Integer.parseInt(request.getParameter("id"));
        // Lấy giá trị voucher từ CSDL hoặc bất kỳ nguồn dữ liệu nào khác
        float voucherPrice = (float) getVoucherPrice(voucherId);
        HttpSession session = request.getSession(true);
        session.setAttribute("voucherPrice", voucherPrice);
        // Gửi giá trị voucherPrice về phản hồi
        response.setContentType("text/plain");
        response.getWriter().write(String.valueOf(voucherPrice));
        return;
    }

    private static int getVoucherPrice(int voucherId) {
        String sql = "SELECT `value`\n" +
                "FROM vouchers\n" +
                "WHERE idvouchers =?";
        Optional<Integer> result = JDBIConnector.get().withHandle(handle -> handle.createQuery(sql).bind(0, voucherId).mapTo(Integer.class).findFirst());
        return result.get();
    }

    public static void main(String[] args) {
       System.out.println(getVoucherPrice(1 ));
    }
}

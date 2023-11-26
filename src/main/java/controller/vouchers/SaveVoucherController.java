package controller.vouchers;
import DAO.IVoucherDaO;
import DAO.impl.VoucherDaO;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "saveVoucher", value = "/saveVoucher")
public class SaveVoucherController extends HttpServlet {
    IVoucherDaO iVoucherDaO =  new VoucherDaO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        HttpSession session = req.getSession(true);
        if (session.getAttribute("userLogin") == null) {
            resp.sendRedirect("/sign-in");
            return;
        }
        User user = (User) session.getAttribute("userLogin");
        if (String.valueOf(id) != null) {
            int idInt = id;
            iVoucherDaO.saveVoucherUser(idInt, user.getIduser());
            iVoucherDaO.updateVoucher(idInt);
        }
        resp.sendRedirect("/tai-khoan/voucher");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

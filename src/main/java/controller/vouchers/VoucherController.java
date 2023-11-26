package controller.vouchers;

import DAO.IVoucherDaO;
import DAO.impl.VoucherDaO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "voucher", value = "/voucher")
public class VoucherController extends HttpServlet {
    IVoucherDaO iVoucherDaO = new VoucherDaO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = (User) SessionUtil.getInstance().getValue(req, "USERMODEL");
        HttpSession session = req.getSession(true);
        if (session.getAttribute("userLogin") == null) {
            resp.sendRedirect("/sign-in");
            return;
        }
        User user = (User) session.getAttribute("userLogin");
        List listVoucher = iVoucherDaO.findAllVoucherById(user.getIduser());
        req.setAttribute("listVoucher", listVoucher);
        req.getRequestDispatcher("/template/voucher.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

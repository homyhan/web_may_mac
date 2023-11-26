package controller;

import model.Order;
import ultilities.FeeGHNUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.StringTokenizer;

@WebServlet(name = "OrderFeeController", value = "/thanh-toan/fee")
public class OrderFeeController extends HttpServlet {
    public static float feeDeliver(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        String nameDistrict = request.getParameter("exits");
        StringTokenizer tokenizer = new StringTokenizer(nameDistrict, "/");
        String district = tokenizer.nextToken().trim();
        String ward = tokenizer.nextToken().trim();
        float result =0;
//        ArrayList<Cart> p = new ArrayList<>();
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("cartInfo");
        double cost = FeeGHNUtils.getFeeShip(3695, 90737, "Huyện Cái Bè", "Xã An Hữu");
        order.setShipping((float) cost);
        result = (float) cost;
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(feeDeliver(req, resp));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order cartModel = (Order) session.getAttribute("cartInfo");
        feeDeliver(req, resp);
        PrintWriter out = resp.getWriter();
        out.println(cartModel.getShipping());
    }
}

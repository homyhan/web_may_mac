package service;

import db.JDBIConnector;
import model.Invoice;
import model.Order;
import model.OrderDetail;
import model.Permission;
import model.RolePermission;
import model.User;
import response.InvoiceResponse;
import response.OrderOrderdetailResponse;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    //	laay danh sach
    public static List<Order> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from orders").mapToBean(Order.class)
                    .stream().collect(Collectors.toList());
        });
    }

    // them order
    public static int addOrder(Order input) {
        input.setStatus(1);
        return insertOrder(input);
    }

    public static int insertOrder(Order input) {
        System.out.println("----insert order-----");
        System.out.println(input.toString());
        // query > insert
        String query = "INSERT INTO orders(`iduser`,`idaddress`,`subtotal`,`itemdiscount`,`shipping`,`idcoupons`,`grandtotal`,`status`,`content`, `signature`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate(query)
                    .bind(0, input.getIduser())
                    .bind(1, input.getIdaddress())
                    .bind(2, input.getSubtotal())
                    .bind(3, input.getItemdiscount())
                    .bind(4, input.getShipping())
                    .bind(5, input.getIdcoupons())
                    .bind(6, input.getGrandtotal())
                    .bind(7, input.getStatus())
                    .bind(8, input.getContent())
                    .bind(9, input.getSignature())
                    .executeAndReturnGeneratedKeys()
                    .mapTo(Integer.class)
                    .findOnly();
        });
    }


    //UPDATE LẠI CHỮ KÝ ĐIỆN TỬ:
    public static int updateSignatureForOrder(int orderId, String signature) {
        // query > update
        String updateQuery = "UPDATE orders SET signature = ? WHERE idorder = ?";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate(updateQuery)
                    .bind(0, signature)
                    .bind(1, orderId)
                    .execute();
        });
    }

    //    CHỈNH SỬA ĐƠN HÀNG
    public static boolean updateOrder(int idOrder, int idaddress, float subtotal, float itemDiscount, float shipping, float grandtotal) {
        JDBIConnector.get().useHandle(handle -> {
            handle.createUpdate("UPDATE orders SET idaddress=?, subtotal = ?, itemdiscount = ?, shipping = ?, grandtotal=? WHERE idorders = ?")
                    .bind(0, idaddress)
                    .bind(1, subtotal)
                    .bind(2, itemDiscount)
                    .bind(3, shipping)
                    .bind(4, grandtotal)
                    .bind(5, idOrder)
                    .execute();

        });
        return true;
    }


    public static List<Order> getListOrderByUserId(int iduser) {
        String query = "SELECT * FROM orders where iduser = ? ";
        List<Order> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query).bind(0, iduser).mapToBean(Order.class).stream()
                    .collect(Collectors.toList());
        });
        return datas;
    }

    public  static  List<Order> getOrdersByUserIdBeforeStartAt(int idUser, String startAt){
        String query = "SELECT orders.* from orders join invoice on invoice.idorder = orders.idorder WHERE createAt < ? AND orders.iduser = ?";
        List<Order> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query).bind(0, startAt).bind(1, idUser).mapToBean(Order.class).stream()
                    .collect(Collectors.toList());
        });
        return datas;
    }


//    public static void updateOrderAndSendEmail(int idOrder, int idaddress, float subtotal, float itemDiscount, float shipping, float grandtotal) {
//        JDBIConnector.get().useHandle(handle -> {
//            handle.createUpdate("{call update_order_and_send_email(?, ?, ?, ?, ?, ?)}")
//                    .bind(0, idOrder)
//                    .bind(1, idaddress)
//                    .bind(2, subtotal)
//                    .bind(3, itemDiscount)
//                    .bind(4, shipping)
//                    .bind(5, grandtotal)
//                    .execute();
//
//        });
//    }

    // cập nhật lại mã code trong orders

    public static Order updateCodeUser(int idcoupons, int idorders) {

        String query = "UPDATE orders SET idcoupons = ? WHERE idorder = ?";
        // String query = " SELECT code FROM coupons where
        // idcoupons = 1";

        // return JDBIConnector.get().withHandle(handle -> {
        // return handle.createQuery(query)
        // .bind(0, idcoupons)
        // .bind(1, iduser)
        // .mapToBean(Order.class).stream().collect(Collectors.toList());
        // });

        List<Order> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idcoupons)
                    .bind(1, idorders)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
        });
        return datas.get(0);

    }

    // cập nhật số lượng

    public static Order updateQuantity(int idorders) {

        String query = "UPDATE orders SET quantity = ? WHERE idorder = ?";

        List<Order> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)

                    .bind(0, idorders)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
        });
        return datas.get(0);

    }

    // xoa 1 san phamr
    public static Order getDeleteOne(int idorders) {

        String query = "delete from orders where idorder = ?";
        List<Order> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idorders)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
        });
        return datas.get(0);
    }

    // lấy chi tiết 1 theo id cuar san pham
    public static Order getDetailByOrderId(int idorder) {
        String query = "SELECT * FROM orders where idorder = ?";
        List<Order> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idorder).mapToBean(Order.class).stream().collect(Collectors.toList());
        });
        if (datas.size() > 0) {
            if (datas.size() != 1)
                return null;
            return datas.get(0);// lấy duy nhất 1 sản phẩm
        }
        return null;
    }

    //    LẤY RA USER ĐỂ TRÍCH SUẤT EMAIL
    public static User getUserById(int iduser) {
        String query = "SELECT * FROM user where iduser = ?";
        List<User> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, iduser).mapToBean(User.class).stream().collect(Collectors.toList());
        });
        if (datas.size() > 0) {
            if (datas.size() != 1)
                return null;
            return datas.get(0);// lấy duy nhất 1 sản phẩm
        }
        return null;
    }



    //	public static List<OrderOrderdetailResponse> getDetailOrderByIdOrder(int idinvoice) {
//		return JDBIConnector.get().withHandle(handle -> {
//			return handle.createQuery(
//					"select o.idorders as idorder , o.iduser, d.idproduct, d.content, i.idinvoice from  invoice i  join orders o on o.idorders=i.idorder join orderdetail d on o.idorders=d.idorders where i.idinvoice=?")
//					.bind(0, idinvoice).mapToBean(OrderOrderdetailResponse.class).stream().collect(Collectors.toList());
//		});
//	}
//
    public static List<Order> getDetailOrderByIdOrder1(int idorder) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(
                            "select * from orders where idorder=?")
                    .bind(0, idorder).mapToBean(Order.class).stream().collect(Collectors.toList());
        });
    }

    public static List<Order> getDetailOrderByIdOrder2(int idorder) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(
                            "select * from orders where idorder=?")
                    .bind(0, idorder).mapToBean(Order.class).stream().collect(Collectors.toList());
        });
    }




    public static void main(String[] args) {

//        List<Order> data = getData();
//        System.out.println(data);
//
////        Order order = new Order(2, 3, 100000, 20000, 5000, 1, 120000, 1, "");
//        Order order = new Order(4, 3, 4000000, 20000, 0, 1, 20000, 1, "");
//        int insertId= insertOrder(order);
//        System.out.println(insertId);

        User us = getUserById(2);
        System.out.println(us.getFirstname());

    }
}

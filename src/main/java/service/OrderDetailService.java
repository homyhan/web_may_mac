package service;

import db.JDBIConnector;
import model.OrderDetail;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailService {
    public static List<OrderDetail> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from orderdetail").mapToBean(OrderDetail.class)
                    .stream().collect(Collectors.toList());
        });
    }

    // lấy ra danh sách orderdetail có idorder =?
    public static List<OrderDetail> getProductCategory(int idorder) {

        String query = "select * from orderdetail where idorders = ?";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idorder)
                    .mapToBean(OrderDetail.class).stream().collect(Collectors.toList());
        });
    }
    // delete from oderdetail where id = 2;
    // xóa tất cả orderdetail của orderid đó

    public static List<OrderDetail> getDeleteAll(int idorder) {

        String query = "delete from oderdetail where idorders = ?";

        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idorder)
                    .mapToBean(OrderDetail.class).stream().collect(Collectors.toList());
        });
    }
    
    public static boolean insertOrderDetail(OrderDetail input) {
    	System.out.println("--------insert order detail-----------");
    	System.out.println(input);
        // query > insert
        String query = "INSERT INTO orderdetail(`idorders`,`idproduct`,`quantity`,`size`,`price`,`discount`,`ismeasure`,`weight`,`height`,`round1`,`round2`,`round3`,`content`) "
        		+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(query)
                    .bind(0, input.getIdorder())
                    .bind(1, input.getIdproduct())
                    .bind(2, input.getQuantity())
                    .bind(3, input.getSize())
                    .bind(4, input.getPrice())
                    .bind(5, input.getDiscount())
                    .bind(6, input.getIsmeasure())
                    .bind(7, input.getWeight())
                    .bind(8, input.getHeight())
                    .bind(9, input.getRound1())
                    .bind(10, input.getRound2())
                    .bind(11, input.getRound3())
                    .bind(12, input.getContent())
		            .execute();
            return count;
        });
        if (result == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        List<OrderDetail> data = getData();
        System.out.println(data);
        OrderDetail item = new OrderDetail(8, 3, 9, "M", 100000, 50000, 1, 1, 1, 1, 1, 1, "Giao giờ hành chính");
        System.out.println(insertOrderDetail(item));

    }
}

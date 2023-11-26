package service;

import db.JDBIConnector;
import model.Coupons;

import java.util.List;
import java.util.stream.Collectors;

public class CouponsService {

    public static List<Coupons> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from coupons").mapToBean(Coupons.class).stream().collect(Collectors.toList());
        });
    }

    // lấy mã code theo iduser
    public static List<Coupons> codeUser(String code, int iduser) {

        String query = "select * from coupons where code='ABC' and status=1 and iduser=2";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
//                    .bind(0, code)
//                    .bind(1, iduser)
                    .mapToBean(Coupons.class).stream().collect(Collectors.toList());
        });

    }
    public static int insertCoupons(Coupons input) {
        // query > insert
        String query = "INSERT INTO coupons(`iduser`,`code`,`title`,`price`,`status`,`actice`,`content`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        int result = JDBIConnector.get().withHandle(handle -> {
            int id = handle.createUpdate(query)
                    .bind(0, input.getIduser())
                    .bind(1, input.getCode())
                    .bind(2, input.getTitle())
                    .bind(3, input.getPrice())
                    .bind(4, input.getStatus())
                    .bind(5, input.getActice())
                    .bind(6, input.getContent())
                    .executeAndReturnGeneratedKeys()
		            .mapTo(Integer.class)
		            .one();
            return id;
        });
        return result;
    }

    public static void main(String[] args) {

//        List<Coupons> data = getData();
//        System.out.println(data);
        List<Coupons> code = codeUser("ABC", 2);
        System.out.println(code);

    }
}

package DAO.impl;

import DAO.IVoucherDaO;
import db.JDBIConnector;
import model.Product;
import model.Voucher;
import model.VoucherUser;
import org.jdbi.v3.core.Jdbi;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VoucherDaO implements IVoucherDaO{
    @Override
    public List<Voucher> findAll(int idUser) {
        String sql = "SELECT vouchers.idvouchers, vouchers.nameVoucher, vouchers.startAt, vouchers.finishAt, vouchers.diktat, vouchers.`value`\n" +
                "FROM vouchers INNER JOIN voucher_users ON vouchers.idvouchers = voucher_users.idvouchers WHERE vouchers.finishAt > CURRENT_DATE()";
        List<Voucher> listMyVoucher = JDBIConnector.get().withHandle(handle -> handle.createQuery(sql)
                .bind(0, idUser)
                .mapToBean(Voucher.class).stream().collect(Collectors.toList()));
        return listMyVoucher;
    }

    @Override

    public  List<Voucher> findAllVoucherById(int idUser) {
        String sql = "select vouchers.idvouchers, vouchers.nameVoucher, vouchers.diktat, vouchers.startAt, vouchers.finishAt \n" +
                "FROM vouchers WHERE vouchers.finishAt > CURRENT_DATE() AND vouchers.status =1 AND vouchers.idvouchers  NOT IN (SELECT voucher_users.idvouchers FROM voucher_users WHERE voucher_users.iduser =?);";
        List<Voucher> voucherList = JDBIConnector.get().withHandle(handle -> handle.createQuery(sql)
                .bind(0, idUser)
                .mapToBean(Voucher.class).stream().collect(Collectors.toList()));
        return voucherList;
    }
    @Override
    public int getValueVoucher(int idVoucher) {
        String queryGetValueVoucher = "SELECT `value` FROM vouchers where idvouchers =?";
        Optional<Integer> values = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetValueVoucher).bind(0, idVoucher).mapTo(Integer.class).findFirst();
        });
        return values.get();
    }
    @Override
    public  boolean saveVoucherUser(int idVoucher, int idUser) {
        String sql = "INSERT into voucher_users VALUES (?,?,1,1)";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(sql).bind(0, idVoucher).bind(1, idUser).execute();
            return count;
        });
        if (result == 1) {
            return true;
        }
        return false;
    }
    @Override
    public void updateVoucher(int idVoucher) {
        String sql = "UPDATE vouchers SET quantity = quantity-1 WHERE idvouchers = ?";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(sql).bind(0, idVoucher).execute();
            return count;
        });
    }
    public static List<Voucher> findAllVoucher (int iduser) {
        String sql = "select * FROM vouchers \n" +
                "WHERE vouchers.status =1 \n" +
                "AND (vouchers.idvouchers NOT IN (SELECT voucher_users.idvouchers FROM voucher_users WHERE voucher_users.iduser =?))";
        List<Voucher> listVoucher = JDBIConnector.get().withHandle(handle -> handle
                .createQuery(sql).bind(0, iduser)
                .mapToBean(Voucher.class).stream().collect(Collectors.toList()));
        return listVoucher;
    }
//        String sql = "select vouchers.idvouchers, vouchers.nameVoucher, vouchers.diktat, vouchers.startAt, vouchers.finishAt \n" +
//                "FROM vouchers WHERE vouchers.finishAt > CURRENT_DATE() AND vouchers.status =1 AND vouchers.idvouchers  NOT IN (SELECT voucher_users.idvouchers FROM voucher_users WHERE voucher_users.iduser =?);";
//         return JDBIConnector.get().withHandle(handle -> handle.createQuery(sql)
//                .bind(0, idUser)
//                .mapToBean(Voucher.class).stream().collect(Collectors.toList()));


    public static void main(String[] args) {
        System.out.println(findAllVoucher(2));
    }
}

package DAO.impl;

import DAO.IVoucherUser;
import db.JDBIConnector;
import model.Voucher;
import model.VoucherUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VoucherUserDao implements IVoucherUser {
    @Override
    public List<VoucherUser> listVoucherUser(int iduser, float subtotal) {
        String sql = "SELECT vc.idvouchers, vc.iduser, v.nameVoucher, v.`value`, v.diktat\n" +
                "FROM voucher_users vc JOIN vouchers v ON vc.idvouchers = v.idvouchers\n" +
                "where vc.iduser =? and v.`value` < ?";
        List<VoucherUser> result = JDBIConnector.get().withHandle(handle -> handle.createQuery(sql).bind(0, iduser).bind(1, subtotal).mapToBean(VoucherUser.class).stream().collect(Collectors.toList()));
        return result;
    }

    @Override
    public boolean checkIdVoucherInUser(int idvouchers, int iduser) {
        String sql = "SELECT idvouchers " +
                "FROM voucher_users " +
                "WHERE idvouchers = ? AND iduser = ?";

        List<Integer> result = JDBIConnector.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind(0, idvouchers)
                        .bind(1, iduser)
                        .mapTo(Integer.class)
                        .list()
        );

        return result.size() == 1;
    }

    @Override
    public List<Voucher> findVoucherById(int iduser, int idvouchers) {
        String sql = "SELECT vouchers.idvouchers, vouchers.nameVoucher, vouchers.startAt, vouchers.finishAt, vouchers.diktat, vouchers.`value` " +
                "FROM vouchers " +
                "INNER JOIN voucher_users ON vouchers.idvouchers = voucher_users.idvouchers " +
                "WHERE vouchers.finishAt > CURRENT_DATE() " +
                "AND voucher_users.iduser = ? " +  // Thêm điều kiện voucher_users.iduser = ?
                "AND vouchers.idvouchers = ?";     // Thêm điều kiện vouchers.idvouchers = ?

        List<Voucher> listMyVoucher = JDBIConnector.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind(0, iduser)         // Sử dụng chỉ số 0 cho iduser
                        .bind(1, idvouchers)     // Sử dụng chỉ số 1 cho idvouchers
                        .mapToBean(Voucher.class)
                        .list()
        );
        return listMyVoucher;
    }

    public static boolean checkIdVoucherInUser1(int idvouchers, int iduser) {
        String sql = "SELECT idvouchers " +
                "FROM voucher_users " +
                "WHERE idvouchers = ? AND iduser = ?";

        List<Integer> result = JDBIConnector.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind(0, idvouchers)
                        .bind(1, iduser)
                        .mapTo(Integer.class)
                        .list()
        );

        return result.size() == 1;
    }

    public static List<Voucher> findVoucherById1(int iduser, int idvouchers) {
        String sql = "SELECT vouchers.idvouchers, vouchers.nameVoucher, vouchers.startAt, vouchers.finishAt, vouchers.diktat, vouchers.`value` " +
                "FROM vouchers " +
                "INNER JOIN voucher_users ON vouchers.idvouchers = voucher_users.idvouchers " +
                "WHERE vouchers.finishAt > CURRENT_DATE() " +
                "AND voucher_users.iduser = ? " +  // Thêm điều kiện voucher_users.iduser = ?
                "AND vouchers.idvouchers = ?";     // Thêm điều kiện vouchers.idvouchers = ?

        List<Voucher> listMyVoucher = JDBIConnector.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind(0, iduser)         // Sử dụng chỉ số 0 cho iduser
                        .bind(1, idvouchers)     // Sử dụng chỉ số 1 cho idvouchers
                        .mapToBean(Voucher.class)
                        .list()
        );
        return listMyVoucher;
    }
    public static void main(String[] args) {
       System.out.println(checkIdVoucherInUser1(1, 2));
//        System.out.println(findVoucherById1(2,1));
    }
}
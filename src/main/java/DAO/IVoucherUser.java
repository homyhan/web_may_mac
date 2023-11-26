package DAO;

import model.Coupons;
import model.Voucher;
import model.VoucherUser;

import java.util.List;

public interface IVoucherUser {
    public List<VoucherUser> listVoucherUser(int iduser, float subtotal);
    boolean checkIdVoucherInUser(int idvouchers, int iduser);
    List<Voucher> findVoucherById(int iduser, int idvouchers);
}

package DAO;

import model.Voucher;
import model.VoucherUser;

import java.util.List;

public interface IVoucherDaO {
    List<Voucher> findAll(int idUser);
    List<Voucher> findAllVoucherById(int idUser);
    int getValueVoucher(int idVoucher);
    boolean saveVoucherUser(int idVoucher, int idUser);
    void updateVoucher(int idVoucher);
}

package model;

import java.io.Serializable;

public class VoucherUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idvouchers;
    private int iduser;
    private int quantity;
    private int isActive;

    public VoucherUser(int idvouchers, int iduser, int quantity, int isActive) {
        this.idvouchers = idvouchers;
        this.iduser = iduser;
        this.quantity = quantity;
        this.isActive = isActive;
    }

    public VoucherUser() {
    }

    public int getIdvouchers() {
        return idvouchers;
    }

    public void setIdvouchers(int idvouchers) {
        this.idvouchers = idvouchers;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "VoucherUser{" +
                "idvouchers=" + idvouchers +
                ", iduser=" + iduser +
                ", quantity=" + quantity +
                ", isActive=" + isActive +
                '}';
    }
}

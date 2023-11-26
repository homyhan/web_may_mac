package model;

import java.io.Serializable;
import java.util.Date;

public class Voucher implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idvouchers;
    private String nameVoucher;
    private String diktat;
    private int quantity;
    private Date startAt;
    private Date finishAt;
    private int value;
    private int status;
    private String content;

    public Voucher() {
    }
    public Voucher(int idvouchers, String nameVoucher, String diktat, int quantity, Date startAt, Date finishAt, int value, int status, String content) {
        this.idvouchers = idvouchers;
        this.nameVoucher = nameVoucher;
        this.diktat = diktat;
        this.quantity = quantity;
        this.startAt = startAt;
        this.finishAt = finishAt;
        this.value = value;
        this.status = status;
        this.content = content;
    }
    public int getIdvouchers() {
        return idvouchers;
    }
    public void setIdvouchers(int idvouchers) {
        this.idvouchers = idvouchers;
    }
    public String getNameVoucher() {
        return nameVoucher;
    }
    public void setNameVoucher(String nameVoucher) {
        this.nameVoucher = nameVoucher;
    }
    public String getDiktat() {
        return diktat;
    }

    public void setDiktat(String diktat) {
        this.diktat = diktat;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "idVoucher=" + idvouchers +
                ", nameVoucher='" + nameVoucher + '\'' +
                ", diktat='" + diktat + '\'' +
                ", quatity=" + quantity +
                ", startAt=" + startAt +
                ", finishAt=" + finishAt +
                ", value=" + value +
                ", status=" + status +
                ", content='" + content + '\'' +
                '}';
    }
}

package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idinvoice;
    private int iduser;
    private int idorder;
    private int status;
    private int mode;
    private Timestamp createAt;
    private String content;

    public Invoice() {
    }

    public Invoice(int iduser, int idorder, int status, int mode,
            Timestamp createAt,
            String content) {
        this.iduser = iduser;
        this.idorder = idorder;
        this.status = status;
        this.mode = mode;
        this.createAt = createAt;
        this.content = content;
    }

    public int getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(int idinvoice) {
        this.idinvoice = idinvoice;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idinvoice=" + idinvoice +
                ", iduser=" + iduser +
                ", idorder=" + idorder +
                ", status=" + status +
                ", mode=" + mode +
                ", createAt=" + createAt +
                ", content='" + content + '\'' +
                '}';
    }
}

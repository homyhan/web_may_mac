package model;

import java.io.Serializable;

public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idfeedback;
    private int iduser;
    private int idproduct;
    private String comment;

    public Feedback() {
    }

    public Feedback(int idfeedback, int iduser, int idproduct, String comment) {
        this.idfeedback = idfeedback;
        this.iduser = iduser;
        this.idproduct = idproduct;
        this.comment = comment;
    }

    public int getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(int idfeedback) {
        this.idfeedback = idfeedback;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "idfeedback=" + idfeedback +
                ", iduser=" + iduser +
                ", idproduct=" + idproduct +
                ", comment='" + comment + '\'' +
                '}';
    }
}

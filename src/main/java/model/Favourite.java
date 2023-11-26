package model;

import java.io.Serializable;

public class Favourite implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idfavourite;
    private int iduser;
    private int idproduct;
    private boolean islike;

    public Favourite() {
    }

    public Favourite(int idfavourite, int iduser, int idproduct, boolean islike) {
        this.idfavourite = idfavourite;
        this.iduser = iduser;
        this.idproduct = idproduct;
        this.islike = islike;
    }

    public int getIdfavourite() {
        return idfavourite;
    }

    public void setIdfavourite(int idfavourite) {
        this.idfavourite = idfavourite;
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

    public boolean getIslike() {
        return islike;
    }

    public void setIslike(boolean islike) {
        this.islike = islike;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "idfavourite=" + idfavourite +
                ", iduser=" + iduser +
                ", idproduct=" + idproduct +
                ", islike=" + islike +
                '}';
    }
}

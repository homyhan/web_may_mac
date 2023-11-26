package model;

import java.io.Serializable;

public class Color implements Serializable {
    private int idcolor;
    private String title;
    private String codecolor;

    public Color() {
    }

    public Color(int idcolor, String title, String codecolor) {
        this.idcolor = idcolor;
        this.title = title;
        this.codecolor = codecolor;
    }

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCodecolor() {
        return codecolor;
    }

    public void setCodecolor(String codecolor) {
        this.codecolor = codecolor;
    }

    @Override
    public String toString() {
        return "\nColor{" +
                "idcolor=" + idcolor +
                ", title='" + title + '\'' +
                ", codecolor='" + codecolor + '\'' +
                '}';
    }
}

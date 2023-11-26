package model;

import java.io.Serializable;

public class Material implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idmaterial;
    private String title;
    private String content;
    private String codematerial;

    public Material() {

    }

    public Material(int idmaterial, String title, String content) {
        this.idmaterial = idmaterial;
        this.title = title;
        this.content = content;
    }

    public Material(int idmaterial, String title, String content, String codematerial) {
        this.idmaterial = idmaterial;
        this.title = title;
        this.content = content;
        this.codematerial = codematerial;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCodematerial() {
        return codematerial;
    }

    public void setCodematerial(String codematerial) {
        this.codematerial = codematerial;
    }

    @Override
    public String toString() {
        return "Material{" +
                "idmaterial=" + idmaterial +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", codematerial='" + codematerial + '\'' +
                '}';
    }
}

package model;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idcategory;
    private String title;
    private String content;
    private String codecate;

    public Category() {
    }

    public Category(int idcategory, String title, String content) {
        this.idcategory = idcategory;
        this.title = title;
        this.content = content;
    }

    public Category(int idcategory, String title, String content, String codecate) {
        this.idcategory = idcategory;
        this.title = title;
        this.content = content;
        this.codecate = codecate;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
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

    public String getCodecate() {
        return codecate;
    }

    public void setCodecate(String codecate) {
        this.codecate = codecate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idcategory=" + idcategory +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", codecate='" + codecate + '\'' +
                '}';
    }
}

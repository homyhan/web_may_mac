package model;

public class NewsDetail {
    int id;
    String title1;
    String title2;
    String  content;
    String image;
    String name;
    String nd1;
    String nd2;
    String nd3;
    String nd4;
    String nd5;
    public NewsDetail(){

 }

    public NewsDetail(int id, String title1, String title2, String content, String image, String name, String nd1, String nd2, String nd3, String nd4, String nd5) {
        this.id = id;
        this.title1 = title1;
        this.title2 = title2;
        this.content = content;
        this.image = image;
        this.name = name;
        this.nd1 = nd1;
        this.nd2 = nd2;
        this.nd3 = nd3;
        this.nd4 = nd4;
        this.nd5 = nd5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNd1() {
        return nd1;
    }

    public void setNd1(String nd1) {
        this.nd1 = nd1;
    }

    public String getNd2() {
        return nd2;
    }

    public void setNd2(String nd2) {
        this.nd2 = nd2;
    }

    public String getNd3() {
        return nd3;
    }

    public void setNd3(String nd3) {
        this.nd3 = nd3;
    }

    public String getNd4() {
        return nd4;
    }

    public void setNd4(String nd4) {
        this.nd4 = nd4;
    }

    public String getNd5() {
        return nd5;
    }

    public void setNd5(String nd5) {
        this.nd5 = nd5;
    }
}

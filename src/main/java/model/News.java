package model;

public class News {
    int id;
    String title1;
    String title2;
    String title3;
    String title4;
    String content1;
    String content2;
    String image1;
    String image2;
    String image3;
    String image4;
    String docthem;

    public News() {

    }

    public News(int id, String title1, String title2, String title3, String title4, String content1, String content2, String image1, String image2, String image3, String image4, String docthem) {
        this.id = id;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
        this.content1 = content1;
        this.content2 = content2;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.docthem = docthem;
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

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getDocthem() {
        return docthem;
    }

    public void setDocthem(String docthem) {
        this.docthem = docthem;
    }
}

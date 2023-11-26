package service;

import db.JDBIConnector;
import model.AboutUs;
import model.NewsDetail;

import java.util.List;
import java.util.stream.Collectors;

public class NewsDetailService {
    public static List<NewsDetail> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from newsdetail")
                    .mapToBean(NewsDetail.class).stream().collect(Collectors.toList());
        });
    }


    public static void main(String[] args) {
        System.out.println(getData());

    }
}

package service;

import db.JDBIConnector;
import model.News;
import model.NewsDetail;

import java.util.List;
import java.util.stream.Collectors;

public class NewsService {
    public static List<News> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from news")
                    .mapToBean(News.class).stream().collect(Collectors.toList());
        });
    }


    public static void main(String[] args) {
        System.out.println(getData());

    }
}

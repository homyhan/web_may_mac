package service;

import db.JDBIConnector;
import model.AboutUs;


import java.util.List;
import java.util.stream.Collectors;

public class AboutUsService {
    public static List<AboutUs> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from aboutus")
                    .mapToBean(AboutUs.class).stream().collect(Collectors.toList());
        });
    }


    public static void main(String[] args) {
      System.out.println(getData());

    }
}

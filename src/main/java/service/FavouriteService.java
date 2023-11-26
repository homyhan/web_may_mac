package service;

import db.JDBIConnector;
import model.Favourite;

import java.util.List;
import java.util.stream.Collectors;

public class FavouriteService {

    public static List<Favourite> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from favourite").mapToBean(Favourite.class)
                    .stream().collect(Collectors.toList());
        });
    }

    public static void main(String[] args) {

        List<Favourite> data = getData();
        System.out.println(data);

    }
}

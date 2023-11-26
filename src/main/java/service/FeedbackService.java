package service;

import db.JDBIConnector;
import model.Feedback;

import java.util.List;
import java.util.stream.Collectors;

public class FeedbackService {
    public static List<Feedback> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM feedback").mapToBean(Feedback.class)
                    .stream().collect(Collectors.toList());
        });
    }

    public static void main(String[] args) {

        List<Feedback> data = getData();
        System.out.println(data);

    }
}

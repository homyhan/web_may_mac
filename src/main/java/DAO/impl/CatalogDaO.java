package DAO.impl;

import DAO.ICatalogDaO;
import db.JDBIConnector;
import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogDaO implements ICatalogDaO {
    @Override
    public List<Category> findAll() {
        List<Category> results = new ArrayList<>();
        String sql = "SELECT * FROM category";
        results = JDBIConnector.get().withHandle(handle -> handle.createQuery(sql).mapToBean(Category.class).stream().collect(Collectors.toList()));
        return results;
    }

    @Override
    public List<Category> findAllSort(int limit, int offset, String name, String type) {
        return null;
    }

    @Override
    public List<Category> findAllTest(int limit, int offset) {
        return null;
    }

    @Override
    public Long save(Category category) {
        return null;
    }
}

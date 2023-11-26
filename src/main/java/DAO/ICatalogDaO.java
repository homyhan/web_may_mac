package DAO;

import model.Category;

import java.util.List;

public interface ICatalogDaO {
    List<Category> findAll();
    List<Category> findAllSort(int limit, int offset, String name, String type);
    List<Category> findAllTest(int limit, int offset);
    Long save(Category category);
}

package Bbashyan.dao.category;

import Bbashyan.model.category.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao {
  private static final Map<Integer, Category> categoryRepository = new HashMap<>();

  public CategoryDao() {
    int categoryId = 1;
    categoryRepository.put(categoryId, Category.builder().id(categoryId++).name("한식").build());
    categoryRepository.put(categoryId, Category.builder().id(categoryId++).name("중식").build());
    categoryRepository.put(categoryId, Category.builder().id(categoryId++).name("양식").build());
    categoryRepository.put(categoryId, Category.builder().id(categoryId).name("일식").build());
  }
  public List<Category> findAll() {
    return new ArrayList<>(categoryRepository.values());
  }

}

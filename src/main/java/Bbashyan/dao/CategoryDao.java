package Bbashyan.dao;

import Bbashyan.model.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao {
  private static final Map<Integer, Category> map = new HashMap<>();

  public CategoryDao() {
    int i = 1;
    map.put(i, Category.builder().id(i++).name("한식").build());
    map.put(i, Category.builder().id(i++).name("중식").build());
    map.put(i, Category.builder().id(i++).name("양식").build());
    map.put(i, Category.builder().id(i++).name("일식").build());
  }
  public List<Category> findAll() {

    return new ArrayList<>(map.values());
  }

}

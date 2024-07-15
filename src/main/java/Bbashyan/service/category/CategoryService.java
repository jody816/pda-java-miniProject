package Bbashyan.service.category;

import Bbashyan.dao.category.CategoryDao;
import Bbashyan.model.category.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao = new CategoryDao();

    public List<Category> getCategories() {
        return categoryDao.findAll();
    }
}

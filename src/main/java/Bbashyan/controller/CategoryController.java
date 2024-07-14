package Bbashyan.controller;

import Bbashyan.dao.CategoryDao;
import Bbashyan.model.Category;
import Bbashyan.view.CategoryView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CategoryController {
    private CategoryDao categoryDao=new CategoryDao();
    private CategoryView view=new CategoryView(this);

    public void displayCategories() throws IOException{
       List<Category> categories = categoryDao.findAll();
       view.displayCategories(categories);
    }
    public void selectCategories(int categoryIndex) throws IOException{

    }
}

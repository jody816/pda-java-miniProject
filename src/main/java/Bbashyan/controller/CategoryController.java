package Bbashyan.controller;

import Bbashyan.dao.CategoryDao;
import Bbashyan.model.Category;
import Bbashyan.view.CategoryView;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
@Getter
@Setter
public class CategoryController {

    private CategoryDao categoryDao=new CategoryDao();
    private CategoryView view=new CategoryView(this);

    private RestaurantController restaurantController = new RestaurantController();

    public void displayCategories() throws IOException{
       List<Category> categories = categoryDao.findAll();
       view.displayCategories(categories);
    }

}

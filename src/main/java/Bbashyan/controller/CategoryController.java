package Bbashyan.controller;

import Bbashyan.dao.CategoryDao;
import Bbashyan.model.Category;
import Bbashyan.view.CategoryView;

import java.io.IOException;
import java.util.List;

public class CategoryController {
    private CategoryDao categoryDao=new CategoryDao();
    private CategoryView view=new CategoryView(this);

    private RestaurantController restaurantController = new RestaurantController();

    public void setRestaurantController(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }
    public void displayCategories() throws IOException{
       List<Category> categories = categoryDao.findAll();
       view.displayCategories(categories);
    }


    public RestaurantController getRestaurantController() { return restaurantController;}
}

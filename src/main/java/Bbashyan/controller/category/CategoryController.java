package Bbashyan.controller.category;

import Bbashyan.controller.restaurant.RestaurantController;
import Bbashyan.service.category.CategoryService;
import Bbashyan.view.category.CategoryView;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class CategoryController {

    private final CategoryView categoryView = new CategoryView(this);
    private final CategoryService categoryService = new CategoryService();
    @Getter
    @Setter
    private RestaurantController restaurantController = new RestaurantController();

    public void displayCategories() throws IOException {
        categoryView.displayCategories(categoryService.getCategories());
    }
}

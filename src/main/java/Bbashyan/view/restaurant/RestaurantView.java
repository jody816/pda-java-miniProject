package Bbashyan.view.restaurant;

import Bbashyan.controller.restaurant.RestaurantController;
import Bbashyan.model.restaurant.Restaurant;

import java.io.IOException;
import java.util.List;

import static Bbashyan.utils.InputUtil.input;

public class RestaurantView {
    private final RestaurantController restaurantController;

    public RestaurantView(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }

    public void displayCategoriesByCategoryId(List<Restaurant> restaurants) throws IOException {
        System.out.println("***** 가게 선택 *****");
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            System.out.println((i + 1) + ". " + restaurant.getName());
        }
        int categoryId = restaurants.get(1).getCategoryId();
        int restaurantSelect = Integer.parseInt(input());
        restaurantController.displayRestaurantDetailById(categoryId, restaurantSelect);
    }
}

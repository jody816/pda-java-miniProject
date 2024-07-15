package Bbashyan.controller.restaurant;

import Bbashyan.model.restaurant.Restaurant;
import Bbashyan.service.restaurant.RestaurantService;
import Bbashyan.view.restaurant.RestaurantDetailView;
import Bbashyan.view.restaurant.RestaurantView;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

@Setter
public class RestaurantController {

    private RestaurantView restaurantView;
    private RestaurantService restaurantService = new RestaurantService();
    private RestaurantDetailView restaurantDetailView;

    public void displayRestaurantByCategoryId(int categoryId) throws IOException {
        List<Restaurant> restaurants = restaurantService.getRestaurants(categoryId);
        restaurantView.displayCategoriesByCategoryId(restaurants);
    }

    public void displayRestaurantDetailById(int categoryId, int restaurantId) throws IOException {
        Restaurant restaurant = restaurantService.getRestaurant(categoryId, restaurantId);
        restaurantDetailView.displayRestaurantDetail(restaurant);
    }
}

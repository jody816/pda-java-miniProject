package Bbashyan.controller;

import Bbashyan.dao.RestaurantDao;
import Bbashyan.model.Restaurant;
import Bbashyan.view.RestaurantDetailView;
import Bbashyan.view.RestaurantView;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

@Setter
public class RestaurantController {

    private RestaurantDao restaurantDao = new RestaurantDao();
    private RestaurantView restaurantView;
    private RestaurantDetailView restaurantDetailView = new RestaurantDetailView();

    //TODO:service로 빠져야함
    public void displayRestaurantByCategoryId(int categoryId) throws IOException {
        List<Restaurant> restaurants = restaurantDao.findByCategoryId(categoryId);
        restaurantView.displayCategoriesByCategoryId(restaurants);
    }

    //TODO:service로 빠져야함
    public void displayRestaurantDetailById(int categoryId, int restaurantId) throws IOException {
        Restaurant restaurant = restaurantDao.findOneByRestaurantId(categoryId, restaurantId);
        restaurantDetailView.displayRestaurantDetail(restaurant);
    }
}

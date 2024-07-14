package Bbashyan.controller;

import Bbashyan.dao.RestaurantDao;
import Bbashyan.model.Restaurant;
import Bbashyan.view.RestaurantDetailView;
import Bbashyan.view.RestaurantView;

import java.io.IOException;
import java.util.List;

public class RestaurantController {

    private RestaurantDao restaurantDao = new RestaurantDao();
    private RestaurantView restaurantView;
    private RestaurantDetailView restaurantDetailView = new RestaurantDetailView();

    public RestaurantController() {
        // 기본 생성자
    }

    public void setRestaurantView(RestaurantView restaurantView) {
        this.restaurantView = restaurantView;
    }

    public void displayRestaurantByCategoryId(int categoryId) throws IOException {
        List<Restaurant> restaurants = restaurantDao.findByCategoryId(categoryId);
        restaurantView.displayCategoriesByCategoryId(restaurants);
    }

    public void displayRestaurantDetailById(int categoryId, int restaurantId) throws IOException {
        Restaurant restaurant = restaurantDao.findOneByRestaurantId(categoryId, restaurantId);
        restaurantDetailView.displayRestaurantDetail(restaurant);
    }
}

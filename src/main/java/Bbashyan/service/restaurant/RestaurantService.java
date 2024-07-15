package Bbashyan.service.restaurant;

import Bbashyan.dao.restaurant.RestaurantDao;
import Bbashyan.model.restaurant.Restaurant;

import java.util.List;

public class RestaurantService {

    private final RestaurantDao restaurantDao = new RestaurantDao();

    public List<Restaurant> getRestaurants(int categoryId) {
        return restaurantDao.findByCategoryId(categoryId);
    }

    public Restaurant getRestaurant(int categoryId, int restaurantId) {
        return restaurantDao.findOneByRestaurantId(categoryId, restaurantId);
    }

}

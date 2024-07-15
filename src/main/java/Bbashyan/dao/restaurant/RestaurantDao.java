package Bbashyan.dao.restaurant;

import Bbashyan.model.restaurant.Restaurant;

import java.util.*;

public class RestaurantDao {

    private static final Map<String, Restaurant> restaurantRepository = new LinkedHashMap<>();

    public RestaurantDao() {
        for (RestaurantDummyData restaurantDummyData : RestaurantDummyData.values()) {
            restaurantRepository.put(restaurantDummyData.getId(), restaurantDummyData.getRestaurant());
        }
    }

    public List<Restaurant> findByCategoryId(int categoryId) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurantRepository.values()) {
            if (restaurant.getCategoryId() == categoryId) {
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }

    public Restaurant findOneByRestaurantId(int categoryId, int restaurantId) {
        for (Restaurant restaurant : restaurantRepository.values()) {
            if (restaurant.getCategoryId() == categoryId && restaurant.getId() == restaurantId) {
                return restaurant;
            }
        }
        return null;
    }

}

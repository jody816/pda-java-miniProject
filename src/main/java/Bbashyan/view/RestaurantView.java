package Bbashyan.view;

import Bbashyan.controller.RestaurantController;
import Bbashyan.model.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RestaurantView {

    private RestaurantController restaurantController;

    public RestaurantView(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void displayCategoriesByCategoryId(List<Restaurant> restaurants) throws IOException{
        System.out.println("***** 가게 선택 *****");
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            System.out.println((i + 1) + ". " + restaurant.getName());
        }
        int categoryId = restaurants.get(1).getCategoryId();
        int restaurantSelect = Integer.parseInt(input());
        restaurantController.displayRestaurantDetailById(categoryId,restaurantSelect);

    }




    private String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }

}

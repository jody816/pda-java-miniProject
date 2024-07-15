package Bbashyan.controller;

import Bbashyan.controller.bucket.BucketController;
import Bbashyan.controller.category.CategoryController;
import Bbashyan.controller.restaurant.RestaurantController;
import Bbashyan.controller.user.UserController;
import Bbashyan.view.MainView;
import Bbashyan.view.restaurant.RestaurantDetailView;
import Bbashyan.view.restaurant.RestaurantView;
import lombok.Getter;

import java.io.IOException;

@Getter
public class MainController {

    private static MainController mainController;

    private final UserController userController;
    private final CategoryController categoryController;
    private final RestaurantController restaurantController;
    private final BucketController bucketController;

    private final MainView mainView;

    private MainController() {
        userController = new UserController();
        bucketController = new BucketController();

        restaurantController = new RestaurantController();

        RestaurantView restaurantView = new RestaurantView(restaurantController);
        restaurantController.setRestaurantView(restaurantView);

        categoryController = new CategoryController();
        categoryController.setRestaurantController(restaurantController);

        mainView = new MainView(this);

    }

    public static MainController getMainController() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    public void displayMainMenu() throws IOException {
        mainView.displayMainMenu();
    }

}

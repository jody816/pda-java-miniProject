package Bbashyan.controller;

import Bbashyan.model.User;
import Bbashyan.view.MainView;
import Bbashyan.view.RestaurantView;

import java.io.IOException;

public class MainController {
    private static MainController instance;
    private MainView mainView;
    private UserController userController;
    private CategoryController categoryController;
    private RestaurantController restaurantController;
    private BucketController bucketController;

    private MainController() {
        userController = new UserController();
        bucketController = new BucketController();
        mainView = new MainView(this);

        initializeControllers();
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    private void initializeControllers() {
        restaurantController = new RestaurantController();
        RestaurantView restaurantView = new RestaurantView(restaurantController);
        restaurantController.setRestaurantView(restaurantView);

        categoryController = new CategoryController();
        categoryController.setRestaurantController(restaurantController);
    }

    public void start() throws IOException {
        mainView.displayMainMenu();
    }

    public void displayMainMenu() throws IOException {
        mainView.displayMainMenu();
    }

    public UserController getUserController() {
        return userController;
    }

    public CategoryController getCategoryController() {
        return categoryController;
    }

    public BucketController getBucketController() {
        return bucketController;
    }


}

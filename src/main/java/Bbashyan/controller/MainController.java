package Bbashyan.controller;

import Bbashyan.model.User;
import Bbashyan.view.MainView;
import java.io.IOException;

public class MainController {
    private static MainController instance;
    private MainView mainView;
    private UserController userController;
    private CategoryController categoryController;
    private BucketController bucketController;

    private MainController() {
        userController = new UserController();
        categoryController = new CategoryController();
        bucketController = new BucketController();
        mainView = new MainView(this);
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
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

    public User getCurrentUser() {
        return userController.getCurrentUser();
    }
}

package Bbashyan.view.restaurant;

import Bbashyan.controller.bucket.BucketController;
import Bbashyan.model.menu.Menu;
import Bbashyan.model.restaurant.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static Bbashyan.utils.InputUtil.inputMenu;


public class RestaurantDetailView {

    private final BucketController bucketController;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public RestaurantDetailView(BucketController bucketController) {
        this.bucketController = bucketController;
    }

    public void displayRestaurantDetail(Restaurant restaurant) throws IOException {
        System.out.println();
        System.out.println("    ____||____");
        System.out.println("   ///////////\\");
        System.out.println("  ///////////  \\");
        System.out.println(" /////////     \\");
        System.out.println("/////////       \\");
        System.out.println("===================");
        System.out.println("   " + restaurant.getName());
        System.out.println("주소: " + restaurant.getAddress());
        System.out.println("설명: " + restaurant.getDescription());
        System.out.println("메뉴:");
        for (Menu menu : restaurant.getMenuList()) {
            System.out.println(" - " + menu.getName() + ": " + menu.getPrice() + "원");
        }
        System.out.println("===================");
        Map<Menu, Integer> menuOrderMap = inputMenu(restaurant.getMenuList());
        bucketController.addBucket(menuOrderMap);
        System.out.println("장바구니에 담겼습니다");
    }
}

package Bbashyan.view.restaurant;

import Bbashyan.model.menu.Menu;
import Bbashyan.model.restaurant.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Bbashyan.utils.InputUtil.inputMenu;


public class RestaurantDetailView {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        System.out.println("선택 완료");
    }
}

package Bbashyan.view;

import Bbashyan.model.Menu;
import Bbashyan.model.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RestaurantDetailView {


    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void displayRestaurantDetail(Restaurant restaurant) throws IOException {
        System.out.println("");
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
        int RestaurantSelect = Integer.parseInt(input());
    }


    private String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }


}

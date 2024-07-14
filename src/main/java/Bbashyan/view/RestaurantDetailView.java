package Bbashyan.view;

import Bbashyan.model.Menu;
import Bbashyan.model.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RestaurantDetailView {


    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        Map<Menu, Integer> menuOrderMap = input(restaurant.getMenuList());
        System.out.println("선택 완료");
    }


    private Map<Menu, Integer> input(List<Menu> menuList) throws IOException {
        System.out.print("메뉴와 수량을 공백으로 구분하여 입력해주세요: ");
        String[] input = br.readLine().split(" ");

        String menuName = input[0];
        int quantity = Integer.parseInt(input[1]);

        Menu selectedMenu = null;
        for (Menu menu : menuList) {
            if (menu.getName().equals(menuName)) {
                selectedMenu = menu;
                break;
            }
        }

        if (selectedMenu == null) {
            throw new IllegalArgumentException("해당 메뉴가 존재하지 않습니다.");
        }

        Map<Menu, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(selectedMenu, quantity);

        return menuOrderMap;
    }


}

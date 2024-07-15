package Bbashyan.view.restaurant;

import Bbashyan.model.menu.Menu;
import Bbashyan.model.restaurant.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        Map<Menu, Integer> menuOrderMap = input(restaurant.getMenuList());
        System.out.println("선택 완료");
    }


    private Map<Menu, Integer> input(List<Menu> menuList) throws IOException {
        System.out.print("메뉴와 수량을 엔터키로 구분하여 입력해주세요 : ");
        String menuName = br.readLine();
        int quantity = Integer.parseInt(br.readLine());

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

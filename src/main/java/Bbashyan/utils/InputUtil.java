package Bbashyan.utils;

import Bbashyan.model.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputUtil {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }

    public static Map<Menu, Integer> inputMenu(List<Menu> menuList) throws IOException {
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

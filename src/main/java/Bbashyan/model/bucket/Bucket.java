package Bbashyan.model.bucket;

import java.util.HashMap;
import java.util.Map;

import Bbashyan.model.menu.Menu;
import lombok.Getter;

@Getter
public class Bucket {
    private String restaurant;
    private final Map<Menu, Integer> orderMenus;
    private int totalPrice;


    public Bucket() {
        this.restaurant = "";
        this.orderMenus = new HashMap<>();
        this.totalPrice = 0;
    }

    public void addMenuItem(Menu menu, int quantity, int price) {
        int orderMenuQuantity = orderMenus.getOrDefault(menu, 0);
        orderMenus.put(menu, orderMenuQuantity + quantity);
        totalPrice += quantity * price;
    }

    public void removeMenuItem(Menu menu, int quantity, int price) {
        int orderMenuQuantity = orderMenus.getOrDefault(menu, 0);
        if (orderMenuQuantity <= quantity) {
            orderMenus.remove(menu);
            totalPrice -= orderMenuQuantity * price;
        } else {
            orderMenus.put(menu, orderMenuQuantity - quantity);
            totalPrice -= quantity * price;
        }
    }

    public void clearBucket() {
        orderMenus.clear();
        totalPrice = 0;
    }

}

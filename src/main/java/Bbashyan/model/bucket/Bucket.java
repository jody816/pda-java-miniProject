package Bbashyan.model.bucket;

import java.util.HashMap;
import java.util.Map;

import Bbashyan.model.menu.Menu;
import lombok.Getter;

@Getter
public class Bucket {
  private String restaurant;
  private final Map<Menu, Integer> orderMenus;
  private double totalPrice;


  public Bucket() {
    this.restaurant = "";
    this.orderMenus = new HashMap<>();
    this.totalPrice = 0;
  }

  public void addMenuItem(Map<Menu, Integer> orderedMenu) {
    Menu menu = orderedMenu.keySet().iterator().next();
    int quantity = orderedMenu.get(menu);
    double price = menu.getPrice();

    int orderMenuQuantity = orderMenus.getOrDefault(menu, 0);
    orderMenus.put(menu, orderMenuQuantity + quantity);
    totalPrice += quantity * price;
  }

  public void removeMenuItem(Menu menu, int quantity, int price) {
    if (orderMenus.containsKey(menu)) {
      int currentQuantity = orderMenus.get(menu);
      if (currentQuantity <= quantity) {
        orderMenus.remove(menu);
        totalPrice -= currentQuantity * price;
      } else {
        orderMenus.put(menu, currentQuantity - quantity);
        totalPrice -= quantity * price;
      }
    }
  }

  public void clearBucket() {
    orderMenus.clear();
    totalPrice = 0;
  }

}

package Bbashyan.model.bucket;

import java.util.HashMap;
import java.util.Map;

import Bbashyan.model.menu.Menu;
import lombok.Getter;

@Getter
public class Bucket {
  private String restaurant;
  private final Map<Menu, Integer> orderMenu;
  private int totalPrice;


  public Bucket() {
    this.restaurant = "";
    this.orderMenu = new HashMap<>();
    this.totalPrice = 0;
  }

    public void addMenuItem(Menu menu, int quantity, int price) {
    if (orderMenu.containsKey(menu) ){
      orderMenu.put(menu, orderMenu.get(menu) + quantity);
    } else {
      orderMenu.put(menu, quantity);
    }
    totalPrice += quantity * price;
  }

  public void removeMenuItem(Menu menu, int quantity, int price) {
    if (orderMenu.containsKey(menu)) {
      int currentQuantity = orderMenu.get(menu);
      if (currentQuantity <= quantity) {
        orderMenu.remove(menu);
        totalPrice -= currentQuantity * price;
      } else {
        orderMenu.put(menu, currentQuantity - quantity);
        totalPrice -= quantity * price;
      }
    }
  }

  public void clearBucket() {
    orderMenu.clear();
    totalPrice = 0;
  }

}

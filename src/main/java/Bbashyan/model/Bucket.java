package Bbashyan.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Bucket {
  private String restaurant;
  private Map<Menu, Integer> orderMenu;
  private int totalPrice;


  public Bucket() {
    this.orderMenu = new HashMap<>();
    this.totalPrice = 0;
  }
  public String getRestaurant() {
    return restaurant;
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

  public void setRestaurant(String restaurant) {
    this.restaurant = restaurant;
  }

  public Map<Menu, Integer> getOrderMenu() {
    return orderMenu;
  }

  public void setOrderMenu(Map<Menu, Integer> orderMenu) {
    this.orderMenu = orderMenu;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }
}

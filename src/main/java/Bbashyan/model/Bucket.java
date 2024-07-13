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

//  public Bucket() {
//    this.orderMenu = new HashMap<>();
//    this.totalPrice = 0;
//    for(int price : orderMenu.values()) {
//
//    }
//    totalPrice =
//  }
}

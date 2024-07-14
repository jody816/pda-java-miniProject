package Bbashyan.view;

import Bbashyan.controller.BucketController;
import Bbashyan.model.Bucket;
import Bbashyan.model.Menu;

import java.util.Map;

public class BucketView {
    private BucketController controller;

    public BucketView(BucketController controller) {
        this.controller = controller;
    }

    public void displayBucket(Bucket bucket) {
        System.out.println("***** 장바구니 페이지 *****");
        Map<Menu, Integer> orderMenu = bucket.getOrderMenu();

        for (Map.Entry<Menu, Integer> entry : orderMenu.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(menu.getName() + " - " + quantity + "개");
        }
    }
}
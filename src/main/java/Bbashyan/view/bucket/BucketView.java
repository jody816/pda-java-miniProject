package Bbashyan.view.bucket;

import Bbashyan.controller.bucket.BucketController;
import Bbashyan.model.bucket.Bucket;
import Bbashyan.model.menu.Menu;

import java.util.Map;

public class BucketView {

    public BucketView(BucketController bucketController) {
    }

    public void displayBucket(Bucket bucket) {
        System.out.println("***** 장바구니 페이지 *****");
        Map<Menu, Integer> orderMenu = bucket.getOrderMenu();

        for (Map.Entry<Menu, Integer> entry : orderMenu.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(menu.getName() + " - " + quantity+"개");
        }
    }
}
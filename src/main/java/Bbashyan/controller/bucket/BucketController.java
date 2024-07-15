package Bbashyan.controller.bucket;

import Bbashyan.model.menu.Menu;
import Bbashyan.service.bucket.BucketService;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class BucketController {

    private static final BucketService bucketService = new BucketService();
    public void addBucket(Map<Menu,Integer> orderedMenu){
        bucketService.addBucket(orderedMenu);
    }
}

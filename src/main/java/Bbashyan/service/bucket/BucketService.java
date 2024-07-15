package Bbashyan.service.bucket;

import Bbashyan.model.bucket.Bucket;
import Bbashyan.model.menu.Menu;
import Bbashyan.utils.Session;

import java.util.Map;

public class BucketService {
    public void addBucket(Map<Menu,Integer> orderedMenu) {
        Bucket bucket = Session.getCurrentUser().getBucket();
        bucket.addMenuItem(orderedMenu);
    }
}

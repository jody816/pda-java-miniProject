package Bbashyan.controller;

import Bbashyan.model.Bucket;
import Bbashyan.view.BucketView;

public class BucketController {

    private BucketView view = new BucketView(this);

    public void displayBucket(Bucket bucket) {
        view.displayBucket(bucket);
    }

}

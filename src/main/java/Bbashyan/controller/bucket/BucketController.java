package Bbashyan.controller.bucket;

import Bbashyan.model.bucket.Bucket;
import Bbashyan.view.bucket.BucketView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BucketController {

    private final BucketView bucketView = new BucketView();

    public void displayBucket(Bucket bucket) {
        bucketView.displayBucket(bucket);
    }
}

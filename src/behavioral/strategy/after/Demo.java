package behavioral.strategy.after;

import java.util.Random;

public class Demo {
    private static Bucket getItemsFromDB() {
        Bucket bucket = new Bucket();
        bucket.add(new Item(10));
        bucket.add(new Item(15));
        bucket.add(new Item(12));
        return bucket;
    }
    private static Merchant getMerchantFromDB() {
        if (new Random().nextInt(100) < 10) {
            return new Merchant(new CreditCardPaymentOption());
        } else {
            return new Merchant(new PayPalPaymentOptionMethod());
        }
    }

    public static void main(String[] args) {
        Bucket bucketFromDB = getItemsFromDB();
        Merchant paymentOption = getMerchantFromDB();
        payForItems(bucketFromDB, paymentOption);
    }

    public static void payForItems(Bucket bucket, Merchant merchant) {
        merchant.getPaymentOption().pay(bucket.getTotal());
    }
}

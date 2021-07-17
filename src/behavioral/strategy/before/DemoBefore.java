package behavioral.strategy.before;

import java.util.Random;

public class DemoBefore {
    private static Bucket getItemsFromDB() {
        Bucket bucket = new Bucket();
        bucket.add(new Item(10));
        bucket.add(new Item(15));
        bucket.add(new Item(12));
        return bucket;
    }

    private static Merchant getMerchantFromDB() {
        if (new Random().nextInt(100) < 10) {
            return new Merchant("CreditCard");
        } else {
            return new Merchant("PayPal");
        }
    }

    public static void main(String[] args) {
        Bucket bucketFromDB = getItemsFromDB();
        Merchant merchant = getMerchantFromDB();

        if (merchant.getPaymentOption().equals("CreditCart")) {
            System.out.println(bucketFromDB.getTotal() + " paid with credit/debit card");
        } else if (merchant.getPaymentOption().equals("PayPal")) {
            System.out.println(bucketFromDB.getTotal() + " paid using PayPal");
        }
    }
}

package behavioral.strategy.after;

public class PayPalPaymentOptionMethod implements PaymentOption {

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal");
    }
}

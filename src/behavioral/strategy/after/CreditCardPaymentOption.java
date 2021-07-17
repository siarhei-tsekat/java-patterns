package behavioral.strategy.after;

public class CreditCardPaymentOption implements PaymentOption {

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }
}

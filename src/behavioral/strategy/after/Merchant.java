package behavioral.strategy.after;

public class Merchant {
    private PaymentOption paymentOption;

    public Merchant(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }
}

package behavioral.strategy.before;

public class Merchant {
    private String paymentOption;

    public Merchant(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getPaymentOption() {
        return paymentOption;
    }
}

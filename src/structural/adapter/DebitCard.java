package structural.adapter;

public class DebitCard {
    private Money money;

    public DebitCard(String val) {
        money = new Money(val);
    }

    public Money getMoney() {
        return money;
    }
}

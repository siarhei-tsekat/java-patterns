package adapter;

public class OnlineShop {
    public void payWithMoney(Money money) {
        System.out.println("adapter.Money taken: " + money.amount());
    }
}


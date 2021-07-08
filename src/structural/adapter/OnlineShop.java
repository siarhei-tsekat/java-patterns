package structural.adapter;

public class OnlineShop {
    public void payWithMoney(Money money) {
        System.out.println("structural.adapter.Money taken: " + money.amount());
    }
}


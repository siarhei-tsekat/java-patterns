package structural.adapter;

public class App {
    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        Money money = new Money("10");

        DebitCard debitCard = new DebitCard("10");
        shop.payWithMoney(money);

//        shop.payWithMoney(debitCard);

        shop.payWithMoney(new DebitCardToMoneyAdapter(debitCard));

    }
}

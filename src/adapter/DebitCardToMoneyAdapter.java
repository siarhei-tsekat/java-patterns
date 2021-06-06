package adapter;

public class DebitCardToMoneyAdapter extends Money {

    private DebitCard debitCard;

    public DebitCardToMoneyAdapter(DebitCard debitCard) {
        super(debitCard.getMoney().amount());
        this.debitCard = debitCard;
    }

    @Override
    public String amount() {
        return debitCard.getMoney().amount();
    }
}

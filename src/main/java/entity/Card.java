package entity;

public class Card {
    CardType cardType;

    public Card(CardType cardType){
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCard(CardType cardType){
        this.cardType = cardType;
    }
}
package entity;

public class Card {
    CardType cardType;

    private Country countryToWhichCardBelong;


    public Card(CardType cardType){
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCard(CardType cardType){
        this.cardType = cardType;
    }

    public Country getCountryToWhichCardBelong() {
        return countryToWhichCardBelong;
    }


    public void setCountryToWhichCardBelong(Country countryToWhichCardBelong) {
        this.countryToWhichCardBelong = countryToWhichCardBelong;
    }

    public String toString() {
        return "Card [cardType = " + cardType + ", CountryofCard = " + countryToWhichCardBelong + "]";
    }
}
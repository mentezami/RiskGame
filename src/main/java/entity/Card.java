package entity;

/**
 * This is the main class for the card.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class Card {

    CardType cardType;
    private Country countryToWhichCardBelong;

    /**
     * Parameterized Constructor for Card
     *
     * @param cardType reference to get cardType enum
     */
    public Card(CardType cardType){
        this.cardType = cardType;
    }

    /**
     * This method gets Card Type.
     *
     * @return the type of the card
     */
    public CardType getCardType() {
        return cardType;
    }

    /**
     * This method sets Card Type.
     *
     * @param cardType sets the Type of card
     */
    public void setCard(CardType cardType){
        this.cardType = cardType;
    }

    /**
     * This method gets Country names which belong the card.
     *
     * @return countryToWhichCardBelong
     */
    public Country getCountryToWhichCardBelong() {
        return countryToWhichCardBelong;
    }

    /**
     * This method sets Country names which belong the card.
     *
     * @param countryToWhichCardBelong country name which belongs the card
     */
    public void setCountryToWhichCardBelong(Country countryToWhichCardBelong) {
        this.countryToWhichCardBelong = countryToWhichCardBelong;
    }

    /*(non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Card [cardType = " + cardType + ", CountryOfCard = " + countryToWhichCardBelong + "]";
    }
}
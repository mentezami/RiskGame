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
     * This method gets Card Kind.
     *
     * @return the type of the card
     */
    public CardType getCardType() {
        return cardType;
    }

    /**
     * This method sets Cad Type.
     *
     * @param cardType sets the kind of card
     */
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    /**
     * This method gets Country names which card belongs.
     *
     * @return countryToWhichCardBelong
     */
    public Country getCountryToWhichCardBelong() {
        return countryToWhichCardBelong;
    }

    /**
     * This method sets Country names which card belongs.
     *
     * @param countryToWhichCardBelong country name which card belongs
     */
    public void setCountryToWhichCardBelong(Country countryToWhichCardBelong) {
        this.countryToWhichCardBelong = countryToWhichCardBelong;
    }

    /*(non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[cardType = " + cardType + ", CountryOfCard = " + countryToWhichCardBelong + "], ";
    }
}
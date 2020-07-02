package entity;

import java.util.List;
import java.util.ArrayList;

/**
 * This class defines Player with
 * its properties like id, name, armies
 * and number of countries won by player.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class Player {

    private int id;
    private String name;
    private int armies;
    private int numberOfCardsExchanged;
    private List<Country> assignedCountry;
    private List<Card> cardList;

    /**
     * Player parameterized constructor.
     *
     * @param id of Player
     * @param name of Player
     */
    public Player(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.assignedCountry = new ArrayList<>();
        this.cardList = new ArrayList<>();
        this.numberOfCardsExchanged = 0;
    }

    /**
     * get cards of player
     *
     * @return the cardList
     */
    public List<Card> getCardList() {
        return cardList;
    }

    /**
     * set cards of the player
     *
     * @param cardList is the list of card objects.
     */
    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    /**
     * Getter method for the player ID.
     *
     * @return id of Player
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for the player ID.
     *
     * @param id of Player
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for the player name.
     *
     * @return name of Player
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the player name.
     *
     * @param name of Player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the player armies.
     *
     * @return armies of Player
     */
    public int getArmies() {
        return armies;
    }

    /**
     * Setter method for the player armies.
     *
     * @param armies of Player
     */
    public void setArmies(int armies) {
        this.armies = armies;
    }

    /**
     * Getter method for the assigned country of the player.
     *
     * @return assignedCountry
     */
    public List<Country> getAssignedCountry() {
        return assignedCountry;
    }

    /**
     * Setter method to assign country to the player.
     *
     * @param assignedCountry is a country object to assign to a player.
     */
    public void setAssignedCountry(Country assignedCountry) {
        this.assignedCountry.add(assignedCountry);
    }

    /**
     * Getter method for the number of times the cards is exchanged.
     *
     * @return numberOfCardsExchanged
     */
    public int getNumberOfTimeCardsExchanged() {
        return numberOfCardsExchanged;
    }

    /**
     * Setter method for the cards exchanged.
     *
     * @param numberOfCardsExchanged is a number of exchanged cards.
     */
    public void setNumberOfTimesCardsExchanged(int numberOfCardsExchanged) {
        this.numberOfCardsExchanged = numberOfCardsExchanged;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object input_obj) {

        if (input_obj == this)
            return true;

        if (!(input_obj instanceof Player))
            return false;

        Player player = (Player) input_obj;

        return player.getName().equalsIgnoreCase(name);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Player [name = " + name + "]";
    }
}


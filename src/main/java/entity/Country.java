package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines properties of country like its coordinates,
 * the continent to which country belongs, its adjacent countries,
 * and whether it's been assigned to any player or not.
 *
 * @see Continent
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class Country {

    private String name;
    private int xCoordinate;
    private int yCoordinate;
    private Player player;
    private Continent belongToContinent;
    private List <String> neighborCountries;
    private List <Country> adjacentCountries;
    private int army;
    private boolean isVisited;

    /**
     * Default constructor for the country.
     *
     */
    public Country() {
        neighborCountries = new ArrayList<String>();
        adjacentCountries = new ArrayList<Country>();
    }

    /**
     * Parameterized constructor for the country.
     *
     * @param neighborCountries name of adjacent countries
     * @param adjacentCountries object of adjacent countries
     */
    public Country(List <String> neighborCountries, List <Country> adjacentCountries) {
        this.neighborCountries = neighborCountries;
        this.adjacentCountries = adjacentCountries;
    }

    /**
     * Getter method for the player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter method for the player.
     *
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Getter method for the country armies.
     *
     * @return army
     */
    public int getArmy() {
        return army;
    }

    /**
     * Setter method for the country armies count.
     *
     * @param army
     */
    public void setArmy(int army) {
        if (army > 5000) {
            this.army = 5000;
            return;
        }
        this.army = Math.abs(army);
    }

    /**
     * Getter method for the country name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the country name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the X coordinate of the country.
     *
     * @return xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }


    /**
     * Setter method for the X coordinate of the country.
     *
     * @param xCoordinate
     */
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Getter method for the y coordinate of the country.
     *
     * @return yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Setter method for the y coordinate of the country.
     *
     * @param yCoordinate set yCoordinate
     */
    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Getter method to returns continent which belongs to the country.
     *
     * @return belongToContinent
     */
    public Continent getBelongToContinent() {
        return belongToContinent;
    }

    /**
     * Setter method to set the continent for the country.
     *
     * @param belongToContinent
     */
    public void setBelongToContinent(Continent belongToContinent) {
        this.belongToContinent = belongToContinent;
    }

    /**
     * Getter method to return the adjacent countries of country.
     *
     * @return neighborCountries
     */
    public List<String> getNeighborCountries() {
        return neighborCountries;
    }

    /**
     * Setter method for the adjacent countries to the country.
     *
     * @param neighborCountries
     */
    public void setNeighborCountries(List <String> neighborCountries) {
        this.neighborCountries = neighborCountries;
    }

    /**
     * Getter method to return the adjacent countries to the countries.
     *
     * @return adjacentCountries
     */
    public List<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    /**
     * Setter method for the adjacent countries to the countries.
     *
     * @param adjacentCountries
     */
    public void setAdjacentCountries(List <Country> adjacentCountries) {
        this.adjacentCountries = adjacentCountries;
    }

    /**
     * Checks whether the country is processed or not.
     *
     * @return boolean value whether a country is processed or not
     */
    public boolean isVisited() {
        return isVisited;
    }

    /**
     * Setter method for the country as processed.
     *
     * @param isProcessed
     */
    public void setVisited(boolean isProcessed) {
        this.isVisited = isProcessed;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object input_obj) {

        if (!(input_obj instanceof Country)) {
            return false;
        }
        if (input_obj == this) {
            return true;
        }
        Country t = (Country) input_obj;
        return t.getName().equalsIgnoreCase(name);
    }
}


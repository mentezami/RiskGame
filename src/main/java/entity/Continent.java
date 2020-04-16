package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class defines properties for a continent like name of continent,
 * controls values and list of the countries.
 *
 * @see Country
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class Continent {

    private String name;
    private int value;
    private String color;
    private HashMap <String, Country> countryMap;
    private List <Country> countriesList;
    private boolean isVisited = false;

    /**
     * Default constructor of Continent class
     */
    public Continent() {
        this.countriesList = new ArrayList<Country>();
        this.countryMap = new HashMap<String, Country>();
    }

    /**
     * Constructor of Continent class
     *
     * @param name used for name of the continent
     * @param value used for controlling value of the continent
     */
    public Continent(String name, int value) {
        super();
        this.name = name;
        this.value = value;
        this.countryMap = new HashMap<String, Country>();
        this.countriesList = new ArrayList<Country>();
    }

    /**
     * Getter method for the continent name.
     *
     * @return continent name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the continent name.
     *
     * @param name continent name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the continent color.
     *
     * @return color of the continent
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for the continent color.
     *
     * @param color of the continent
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter method for the continent countries.
     *
     * @return countries list
     */
    public List <Country> getCountries() {
        return countriesList;
    }

    /**
     * Setter method for the continent countries.
     *
     * @param countries set the countries
     */
    public void setCountries(List <Country> countries) {
        countriesList = countries;
    }

    /**
     * Getter method for the continent control value.
     *
     * @return continent control value
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter method for the continent control value.
     *
     * @param value set continent control value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Getter method for the continent countryMap.
     *
     * @return continent countryMap
     */
    public HashMap <String, Country> getCountryMap() {
        return countryMap;
    }

    /**
     * Setter method for the continent countries.
     *
     * @param countryMap map of the country
     */
    public void setCountryMap(HashMap <String, Country> countryMap) {
        this.countryMap = countryMap;
    }

    /**
     * This method checks whether the continent is visited or not.
     *
     * @return isVisited
     */
    public boolean isVisited() {
        return isVisited;
    }

    /**
     * This sets the continent to have been visited.
     *
     * @param isVisited boolean value
     */
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Continent [name = " + name + ", value = " + value + ", countries = " + countriesList + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object input_obj) {

        if (!(input_obj instanceof Continent)) {
            return false;
        }
        if (input_obj == this) {
            return true;
        }
        Continent continent = (Continent) input_obj;

        return continent.getName().equalsIgnoreCase(name);
    }
}
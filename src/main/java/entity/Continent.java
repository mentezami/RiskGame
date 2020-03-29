package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Continent {

    private String name;
    private int value;
    private String color;
    private HashMap <String, Country> countryMap;
    private List <Country> countriesList;
    private boolean isVisited = false;

    public Continent() {
        this.countriesList = new ArrayList<Country>();
        this.countryMap = new HashMap<String, Country>();
    }

    public Continent(String name, int value) {
        super();
        this.name = name;
        this.value = value;
        this.countryMap = new HashMap<String, Country>();
        this.countriesList = new ArrayList<Country>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List <Country> getCountries() {
        return countriesList;
    }

    public void setCountries(List <Country> countries) {
        this.countriesList = countries;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashMap <String, Country> getCountryMap() {
        return countryMap;
    }

    public void setCountryMap(HashMap <String, Country> countryMap) {
        this.countryMap = countryMap;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    @Override
    public String toString() {
        return "Continent [name = " + name + ", value = " + value + ", countries = " + countriesList + "]";
    }

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
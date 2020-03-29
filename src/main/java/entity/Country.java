package entity;

import java.util.ArrayList;
import java.util.List;

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

    public Country() {
        neighborCountries = new ArrayList<String>();
        adjacentCountries = new ArrayList<Country>();
    }

    public Country(List <String> adjCountries, List <Country> adjacentCountries) {
        this.neighborCountries = adjCountries;
        this.adjacentCountries = adjacentCountries;
    }

    public int getArmy() {
        return army;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setArmy(int army) {
        if (army > 5000) {
            this.army = 5000;
            return;
        }
        this.army = Math.abs(army);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Continent getBelongToContinent() {
        return belongToContinent;
    }

    public void setBelongToContinent(Continent belongToContinent) {
        this.belongToContinent = belongToContinent;
    }

    public List<String> getNeighborCountries() {
        return neighborCountries;
    }

    public void setNeighborCountries(List <String> adjCountries) {
        this.neighborCountries = adjCountries;
    }

    public List<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    public void setAdjacentCountries(List <Country> adjacentCountries) {
        this.adjacentCountries = adjacentCountries;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isProcessed) {
        this.isVisited = isProcessed;
    }

    @Override
    public String toString() {
        return name;
    }

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


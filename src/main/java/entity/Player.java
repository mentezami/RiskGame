package entity;

import java.util.List;

public class Player {

    private int id;
    private String name;
    private int armies;
    private int numberOfCardsExchanged;
    private List <Card> cardList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmies() {
        return armies;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }

    public List <Card> getCardList() {
        return cardList;
    }

    public void setCardList(List <Card> cardList) {
        this.cardList = cardList;
    }
}
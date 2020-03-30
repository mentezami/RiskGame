package entity;

import java.util.List;

import java.util.ArrayList;


public class Player {


        private int id;
        private String name;

        private int armies;
        private int numberOfCardsExchanged;

        private List<Country> assignedCountry;
        private List<Card> cardList;

        public List<Card> getCardList() {
            return cardList;
        }

        public void setCardList(List<Card> cardList) {
            this.cardList = cardList;
        }


        public Player(int id, String name) {
            super();
            this.id = id;
            this.name = name;
            this.assignedCountry = new ArrayList<Country>();
            this.cardList = new ArrayList<Card>();
            this.numberOfCardsExchanged = 0;
        }

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

        public List<Country> getAssignedCountry() {
            return assignedCountry;
        }

        public void setAssignedCountry(Country assignedCountry) {
            this.assignedCountry.add(assignedCountry);
        }

        public int getNumeberOfTimeCardsExchanged() {
            return numberOfCardsExchanged;
        }

        public void setNumeberOfTimesCardsExchanged(int numeberOfCardsExchanged) {
            this.numberOfCardsExchanged = numeberOfCardsExchanged;
        }

        @Override
        public boolean equals(Object input_obj) {

            if (input_obj == this)
                return true;

            if (!(input_obj instanceof Player))
                return false;

            Player player = (Player) input_obj;

            return player.getName().equalsIgnoreCase(name);
        }

        @Override
        public String toString() {
            return "Player [name = " + name + "]";
        }
    }


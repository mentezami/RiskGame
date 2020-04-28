package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import entity.CardType;
import config.Commands;
import entity.Card;
import entity.Country;
import entity.Hmap;
import entity.Player;
import entity.Continent;
import commandparser.CommandParser;






public class CardModel {



        private List<Card> cardForExchange;
        public void setNumberOfTimesCardExchanged() {
            cardExchanged += 5;
        }
        public int getCardExchanged() {
            return cardExchanged;
        }
        private static int cardExchanged = 5;
        /**
         * Gets the cards to be exchanged.
         *
         * @return the cardsToBeExchange
         */
        public List<Card> getCardsToBeExchange() {
            return cardForExchange;
        }

        /**
         * Sets the cards to be exchanged.
         *
         * @param cardsToBeExchange the cardsToBeExchange to set
         */
        public void setCardsToBeExchange(List<Card> cardsToBeExchange) {
            this.cardForExchange = cardsToBeExchange;
        }

        /**
         * Allocate cards to country
         * @param map current Hashmap object
         * @param stackOfCards stack of cards
         *
         */


        /**
         * exchange of cards between players
         * @param cardlist list of cards
         * @param player current Player object
         *
         * @param cardStack current stack of cards
         *
         */
        public void exchangeCards(Player player, List<Card> cardlist, Stack<Card> cardStack) {

            Boolean isCardArmiesAssigned = false;

            for (Country c : player.getAssignedCountry()) {
                for (Card cardChosen: cardlist) {
                    if (c.getName().equalsIgnoreCase(cardChosen.getCountryToWhichCardBelong().getName())) {
                        player.setArmies(player.getArmies() + 2);
                        isCardArmiesAssigned = true;
                        break;
                    }
                }

                if (isCardArmiesAssigned)
                    break;
            }

            player.setArmies(player.getArmies() + getCardExchanged());
            setNumberOfTimesCardExchanged();

            for (Card card : cardlist) {
                // Removing the exchanged cards from players hand
                player.getCardList().remove(card);
                // Adding cards back to deck
                cardStack.push(card);
            }
        }

        /**
         * validates card for exchange
         * @param cardlist list of cards
         * @return true if cards are valid for exchange, false otherwise
         *
         */
        public boolean areCardsvalidForExchange(List<Card> cardlist) {

            if (cardlist.size() == 3) {
                int infantry = 0, cavalry = 0, artillery = 0;

                for (Card card : cardlist) {
                    if (card.getCardType().toString().equals(CardType.CAVALRY.toString())) {
                        infantry++;
                    } else if (card.getCardType().toString().equals(CardType.INFANTRY.toString())) {
                        cavalry++;
                    } else if (card.getCardType().toString().equals(CardType.ARTILLERY.toString())) {
                        artillery++;
                    }
                }

                // if all are of different kind or all are of same
                // kind then only, player can exchange cards for army.
                if ((infantry == 1 && cavalry == 1 && artillery == 1)
                        || infantry == 3 || cavalry == 3 || artillery == 3) {
                    return true;
                }
            }

            return false;
        }
    }


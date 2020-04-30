package models;

import entity.Country;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DiceModel {

    public int numberOfDiceUsedByAttacker;
    public int numberOfDiceUsedByDefender;

    public Country attackingCountry;
    public Country defendingCountry;

    public List<Integer> attackerDiceValues;
    public List<Integer> defenderDiceValues;

    public DiceModel(Country attackingCountry, Country defendingCountry, int numberOfDiceUsedByAttacker,
                     int numberOfDiceUsedByDefender) {

        this.attackingCountry = attackingCountry;
        this.defendingCountry = defendingCountry;
        this.attackerDiceValues = new ArrayList<Integer>();
        this.defenderDiceValues = new ArrayList<Integer>();
        this.numberOfDiceUsedByAttacker = numberOfDiceUsedByAttacker;
        this.numberOfDiceUsedByDefender = numberOfDiceUsedByDefender;
    }

    /**
     * This roll the Dices of attacker and defender
     */
    public void rolldice() {

        this.attackerDiceValues= new ArrayList<>();
        this.defenderDiceValues = new ArrayList<>();

        for (int i = 0; i < numberOfDiceUsedByAttacker; i++) {

            int value = new Random().nextInt(6)+1;
            attackerDiceValues.add(value);
        }
        for (int i = 0; i < numberOfDiceUsedByDefender; i++) {

            int value= new Random().nextInt(6)+1;
            defenderDiceValues.add(value);
        }
    }

    /**
     * This gets the dice values of attacker and defender after roll.
     *
     */
    public void getResultAfterRoll() {

        Collections.sort(attackerDiceValues, Collections.reverseOrder());
        Collections.sort(defenderDiceValues, Collections.reverseOrder());

        System.out.println("Attacker dice = " + attackerDiceValues);
        System.out.println("Defender dice = " + defenderDiceValues);

        for (Integer defenderDiceValue : defenderDiceValues) {

            for (Integer attackerDiceValue : attackerDiceValues) {

                if (attackerDiceValue.compareTo(defenderDiceValue) == 0) {

                    System.out.println("1 army lost by Attacker");
                    if (attackingCountry.getArmy() > 1) {
                        attackingCountry.setArmy(attackingCountry.getArmy() - 1);
                    }
                } else if (attackerDiceValue.compareTo(defenderDiceValue) > 0) {

                    System.out.println("1 army lost by Defender");

                    if (defendingCountry.getArmy() > 0) {
                        defendingCountry.setArmy(defendingCountry.getArmy() - 1);
                    }
                } else {
                    System.out.println("1 army lost by Attacker");
                    if (attackingCountry.getArmy() > 1) {
                        attackingCountry.setArmy(attackingCountry.getArmy() - 1);
                    }
                }
                break;
            }
            if (attackerDiceValues.size() >= 1) {
                attackerDiceValues.remove(0);
            }
        }
    }
}


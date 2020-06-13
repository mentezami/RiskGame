package models;

import entity.Country;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in the DiceModel class.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class DiceModelTest {

    Country attackingCountry;
    Country defendingCountry;
    DiceModel diceModel;

    /**
     * This method runs before all test methods.
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("The test methods are started. \n");
    }

    /**
     * This method runs before each test method to initialize the objects.
     *
     */
    @Before
    public void beforeEachTest() {
        attackingCountry = new Country();
        defendingCountry = new Country();
        diceModel = new DiceModel(attackingCountry, defendingCountry,
                3, 2);
    }

    /**
     * This method runs after all methods.
     *
     */
    @AfterClass
    public static void afterAllTesting() {
        System.out.println("The tests are done.");
    }

    /**
     * This method tests rollDice method for DiceModel class.
     *
     */
    @Test
    public void rollDiceTest() {
        //first run this to check whether the returning list is empty.
        assertTrue(diceModel.attackerDiceValues.isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "the list of attackerDiceValues is empty. \n");

        diceModel.rollDice();

        assertFalse(diceModel.attackerDiceValues.isEmpty());
        System.out.println("\"assertFalse\" is passed to test whether " +
                "the list of attackerDiceValues is updated by rollDice method. \n");
    }

    /**
     * This method tests getResultAfterRoll method for DiceModel class.
     *
     */
    @Test
    public void getResultAfterRollTest() {
        //first, declare diceModel object.
        int numberOfDiceUsedByAttacker = 4;
        diceModel = new DiceModel(attackingCountry, defendingCountry,
                numberOfDiceUsedByAttacker, 2);

        //run this to build and roll a dice.
        diceModel.rollDice();

        assertEquals(numberOfDiceUsedByAttacker, diceModel.attackerDiceValues.size());
        System.out.println("\"assertEquals\" is passed to check whether" +
                " the list of attackerDiceValues is built by rollDice method. \n");

        //run this for updating the list of attackerDiceValues.
        diceModel.getResultAfterRoll();

        assertNotEquals(numberOfDiceUsedByAttacker, diceModel.attackerDiceValues.size());
        System.out.println("\n \"assertNotEquals\" is passed to test whether" +
                " the list of attackerDiceValues is updated by getResultAfterRoll method. \n");
    }
}

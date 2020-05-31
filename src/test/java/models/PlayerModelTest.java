package models;

import entity.Continent;
import org.junit.*;
import entity.Country;
import entity.Player;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in the PlayerModel class.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class PlayerModelTest {

    Player playerOne;
    Player playerTwo;
    PlayerModel playerModel;
    ArrayList<Player> playerList;

    /**
     * This method runs before all test methods.
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("The test methods are started \n");
    }

    /**
     * This method runs before each test method to initialize the objects.
     *
     */
    @Before
    public void beforeEachTest() {
        playerOne = new Player(1, "Player One");
        playerTwo = new Player(2, "Player Two");
        playerModel = new PlayerModel();
        playerList = new ArrayList<>();
    }

    /**
     * This method runs after all methods.
     *
     */
    @AfterClass
    public static void afterAllTesting() {
        System.out.println("The tests are done");
    }

    /**
     * This method tests getPlayersList method for PlayerModel class.
     *
     */
    @Test
    public void getPlayersListTest() {
        //run this to make sure playerList is empty.
        assertTrue(playerModel.getPlayersList().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether playerList is empty. \n");

        //store players to the playerList
        playerList.add(playerOne);
        playerList.add(playerTwo);

        //run this to set playerList
        playerModel.setPlayersList(playerList);

        assertFalse(playerModel.getPlayersList().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getPlayersList method" +
                " and whether playerList is still empty. \n");
    }

    /**
     * This method tests removePlayer method for PlayerModel class.
     *
     */
    @Test
    public void removePlayerTest() {
        //run this to make sure playerList is empty.
        assertTrue(playerList.isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether playerList is empty. \n");

        //store players to the playerList
        playerList.add(playerOne);
        playerList.add(playerTwo);

        //set playerList
        playerModel.setPlayersList(playerList);

        /*run this to make sure playerList is not empty,
        its size should be equal or greater than 2.
         */
        assertEquals(playerList.size(), 2);
        System.out.println("\"assertEquals\" is passed to test size of playerList for removePlayer" +
                " which should be equal or greater than 2 to run removePlayer method. \n");

        //run this to remove a player
        playerModel.removePlayer("Player Two");

        //check the playerList size is decreased
        assertEquals(playerList.size(), 1);
        System.out.println("\"assertEquals\" is passed to test size of playerList for removePlayer" +
                " which should be decreased after running the removePlayer method. \n");
    }

    /**
     * This method tests 3 reinforce armies.
     *
     */
    @Test
    public void testThreeReinforceArmiesForPLayer() {

        for (int idx = 0; idx < 8; idx++) {
            Country c1 = new Country();
            Continent con1 = new Continent();
            c1.setBelongToContinent(con1);
            playerOne.getAssignedCountry().add(c1);
        }

        int armies = playerModel.countReinforcementArmies(playerOne);

        assertEquals(3, armies);
    }

    /**
     * This method tests more than 3 reinforce armies.
     *
     */
    @Test
    public void testReinforceArmiesCountForPLayer() {

        for (int idx = 0; idx < 25; idx++) {
            Country c1 = new Country();
            Continent con1 = new Continent();
            c1.setBelongToContinent(con1);
            playerOne.getAssignedCountry().add(c1);
        }

        int armies = playerModel.countReinforcementArmies(playerOne);
        assertEquals(8, armies);
    }
}
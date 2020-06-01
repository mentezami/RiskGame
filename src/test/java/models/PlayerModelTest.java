package models;

import entity.Continent;
import org.junit.*;
import entity.Country;
import entity.Player;
import java.util.ArrayList;
import java.util.Random;
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
        System.out.println("The test methods are started. \n");
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
        System.out.println("The tests are done.");
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

        //store players to the playerList.
        playerList.add(playerOne);
        playerList.add(playerTwo);

        //run this to set playerList.
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

        //store players to the playerList.
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

        //run this to remove a player.
        playerModel.removePlayer("Player Two");

        //check the playerList size is decreased.
        assertEquals(playerList.size(), 1);
        System.out.println("\"assertEquals\" is passed to test size of playerList for removePlayer" +
                " which should be decreased after running the removePlayer method. \n");
    }

    /**
     * This method tests createPlayer method for PlayerModel class.
     *
     */
    @Test
    public void createPlayerTest() {
        //run this to make sure playerList is empty.
        assertTrue(playerModel.getPlayersList().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether playerList is empty. \n");

        //run this to create a player.
        playerModel.createPlayer("Player Test");

        //check whether size of playerList is updated.
        assertEquals(playerModel.getPlayersList().size(), 1);
        System.out.println("\"assertEquals\" is passed to test whether the size of playerList" +
                " is updated by createPlayer method. \n");
    }

    /**
     * This method tests assignArmiesToAllPlayers method for PlayerModel class.
     *
     */
    @Test
    public void assignArmiesToAllPlayersTest() {
        //run this to add players to the playerList.
        playerList.add(playerOne);
        playerList.add(playerTwo);

        //set playerList.
        playerModel.setPlayersList(playerList);

        //run this to make sure number of armies for each player is 0.
        assertEquals(playerOne.getArmies(), 0);
        assertEquals(playerTwo.getArmies(), 0);
        System.out.println("\"assertEquals\" is passed to test whether number of armies for each player is 0. \n");

        //run this to assign armies to the players.
        playerModel.assignArmiesToAllPlayers();

        //run this to make sure number of armies for each player is still 0.
        assertNotEquals(playerOne.getArmies(), 0);
        assertNotEquals(playerTwo.getArmies(), 0);
        System.out.println("\"assertNotEquals\" is passed to test whether the number of armies" +
                " for each player is updated by assignArmiesToAllPlayers method. \n");
    }

    /**
     * This method tests placeAll method for PlayerModel class.
     *
     */
    @Test
    public void placeAllTest() {
        //create a country and assign to a player
        Country country = new Country();
        country.setName("Canada");
        playerOne.setAssignedCountry(country);

        //set armies to the player
        playerOne.setArmies(20);

        //run this to add players to the playerList.
        playerList.add(playerOne);

        //set playerList.
        playerModel.setPlayersList(playerList);

        assertEquals(country.getArmy(), 0);
        System.out.println("\"assertEquals\" is passed to test whether the number of armies" +
                " for each country is 0. \n");

        assertEquals(playerOne.getArmies(), 20);
        System.out.println("\"assertEquals\" is passed to test whether the number of armies" +
                " for each player is set. \n");

        //run this to place all armies from each player to its correspondence country
        playerModel.placeAll();

        assertEquals(country.getArmy(), 20);
        System.out.println("\"assertEquals\" is passed to test whether the number of armies" +
                " for each player's country is updated by placeAll method. \n");

        assertEquals(playerOne.getArmies(), 0);
        System.out.println("\"assertEquals\" is passed to test whether the number of armies" +
                " for each player is updated to 0 by placeAll method. \n");
    }

    /**
     * This method tests getRandomNumber method for PlayerModel class.
     *
     */
    @Test
    public void getRandomNumberTest() {
        //declare a positive random number for passing to the method.
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(Integer.MAX_VALUE);

        assertNotNull(playerModel.getRandomNumber(number));
        System.out.println("\"assertNotNull\" is passed to test getRandomNumber method. \n");
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
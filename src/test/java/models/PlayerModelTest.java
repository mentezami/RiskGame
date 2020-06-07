package models;

import entity.Continent;
import entity.Hmap;
import org.junit.*;
import entity.Country;
import entity.Player;

import java.util.*;

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
    Hmap hmap;
    Country firstCountry;
    Country secondCountry;
    ArrayList<Country> countryList;
    Continent continent;
    List<Continent> continentList;
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
        hmap = new Hmap();
        firstCountry = new Country();
        secondCountry = new Country();
        countryList = new ArrayList<>();
        continent = new Continent();
        continentList = new ArrayList<>();
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

        assertNotEquals(playerModel.getPlayersList().size(), playerModel.getPlayersList().isEmpty());
        System.out.println("\"assertNotEquals\" is passed to test getPlayersList method" +
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

    ////
    @Test
    public void createPlayerTest() {
        //run this to make sure playerList is empty.
        assertTrue(playerModel.getPlayersList().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether playerList is empty. \n");

        //run this to create a player.
        playerModel.createPlayer("Player Test");

        //check whether size of playerList is updated.
        assertNotEquals(playerModel.getPlayersList().size(), playerModel.getPlayersList().isEmpty());
        System.out.println("\"assertNotEquals\" is passed to test whether the playerList" +
                " is still empty or updated by createPlayer method. \n");
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
        firstCountry.setName("Canada");
        playerOne.setAssignedCountry(firstCountry);

        //set armies to the player
        playerOne.setArmies(20);

        //run this to add players to the playerList.
        playerList.add(playerOne);

        //set playerList.
        playerModel.setPlayersList(playerList);

        assertEquals(firstCountry.getArmy(), 0);
        System.out.println("\"assertEquals\" is passed to test whether the number of armies" +
                " for each country is 0. \n");

        assertEquals(playerOne.getArmies(), 20);
        System.out.println("\"assertEquals\" is passed to test whether the number of armies" +
                " for each player is set. \n");

        //run this to place all armies from each player to its correspondence country
        playerModel.placeAll();

        assertEquals(firstCountry.getArmy(), 20);
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

        assertNotEquals(PlayerModel.getRandomNumber(number), 0);
        System.out.println("\"assertNotEquals\" is passed to test getRandomNumber method. \n");
    }

    /**
     * This method tests placeArmy method for PlayerModel class.
     *
     */
    @Test
    public void placeArmyTest() {
        //first add a country to the map.
        firstCountry.setName("Canada");
        Map<String,Country> countryMap = new HashMap<>();
        countryMap.put("Canada",firstCountry);
        hmap.setCountryMap(countryMap);

        //assign the added country to a player.
        playerOne.setAssignedCountry(firstCountry);

        //assign the player to the added country.
        firstCountry.setPlayer(playerOne);

        //run this to check whether there is no army for the player.
        assertFalse(playerModel.placeArmy(hmap, playerOne, "Canada"));
        System.out.println("\"assertFalse\" is passed to test whether there is any player's army" +
                " for assigning to the country. \n");

        //run this to check whether there is no army for the country.
        assertEquals(firstCountry.getArmy(), 0);
        System.out.println("\"assertEquals\" is passed to test there is no army for the country. \n");

        //add some armies to the player
        playerOne.setArmies(20);

        //run this to check whether the player assigns its armies to the country
        assertTrue(playerModel.placeArmy(hmap,playerOne,"Canada"));
        System.out.println("\"assertTrue\" is passed to test placeArmy method. \n");

        //run this to check whether the player's armies are assigned to the country.
        assertNotEquals(firstCountry.getArmy(), 0);
        System.out.println("\"assertNotEquals\" is passed to test whether placeArmy method" +
                " assigns player's armies to the country. \n");
    }

    /**
     * This method tests isAllPlayersArmiesExhausted method for PlayerModel class.
     *
     */
    @Test
    public void isAllPlayersArmiesExhaustedTest() {
        //run this to check there are no armies for the player.
        assertTrue(playerModel.isAllPlayersArmiesExhausted());
        System.out.println("\"assertTrue\" is passed to test whether there are" +
                " no armies for the player. \n");

        //add some armies to the player.
        playerOne.setArmies(50);
        playerList.add(playerOne);
        playerModel.setPlayersList(playerList);

        //run this to check whether the number of player's armies are still zero or exhausted.
        assertFalse(playerModel.isAllPlayersArmiesExhausted());
        System.out.println("\"assertFalse\" is passed to test isAllPlayersArmiesExhausted method and " +
                "whether the number of armies for each player is exhausted. \n");
    }

    /**
     * This method tests populateCountries method for PlayerModel class.
     *
     */
    @Test
    public void populateCountriesTest() {
        //first create a player list and add some players ot it.
        playerList.add(playerOne);
        playerList.add(playerTwo);

        //set the player list.
        playerModel.setPlayersList(playerList);

        //add some countries and a continent for creating a map.
        firstCountry.setName("Canada");
        secondCountry.setName("USA");

        countryList.add(firstCountry);
        countryList.add(secondCountry);

        continent = new Continent("North America",1);
        continent.setCountries(countryList);

        continentList.add(continent);

        hmap.setContinents(continentList);

        //run this to make sure there are no countries assigned to the players.
        assertTrue(playerOne.getAssignedCountry().isEmpty());
        assertTrue(playerTwo.getAssignedCountry().isEmpty());
        System.out.println("\"assertTrue\" is passed to test the no countries" +
                " assigned to the players. \n");

        //run this to assign the countries to the players.
        playerModel.populateCountries(hmap);

        assertNotEquals(playerOne.getAssignedCountry().size(), playerOne.getAssignedCountry().isEmpty());
        assertNotEquals(playerTwo.getAssignedCountry().size(), playerTwo.getAssignedCountry().isEmpty());
        System.out.println("\"assertNotEquals\" is passed to test the countries" +
                " assigned to players by populateCountries method. \n");
    }

    /**
     * This method tests getCountryListFromMap method for PlayerModel class.
     *
     */
    @Test
    public void getCountryListFromMapTest() {
        /*
        first, create a list to test for comparison of return value of getCountryListFromMap method
        and the created list to make sure both are empty.
         */
        ArrayList<Country> countryListTest = new ArrayList<>();

        //run this to check whether the return value of getCountryListFromMap method equals an empty list.
        assertEquals(playerModel.getCountryListFromMap(hmap), countryListTest);
        System.out.println("\"assertEquals\" is passed to test whether getCountryListFromMap" +
                " is returning empty list by comparing with an empty created list. \n");

        //add countries and continent to the map.
        firstCountry.setName("Canada");
        secondCountry.setName("USA");

        countryList.add(firstCountry);
        countryList.add(secondCountry);

        continent = new Continent("North America",1);
        continent.setCountries(countryList);

        continentList.add(continent);

        hmap.setContinents(continentList);

        assertNotEquals(playerModel.getCountryListFromMap(hmap),countryListTest);
        System.out.println("\"assertNotEquals\" is passed to test whether getCountryListFromMap" +
                " is still returning empty value list by comparing with an empty created list. \n");
    }

    /**
     * This method tests countReinforcementArmies method for PlayerModel class.
     *
     */
    @Test
    public void countReinforcementArmiesTest() {
        //run this to make sure the number of player's armies equals zero.
        assertEquals(0, playerOne.getArmies());
        System.out.println("\"assertEquals\" is passed to test whether the number of player's" +
                " armies equals zero. \n");

        //run this to make sure the number of assigned countries to the player is zero.
        assertEquals(0, playerOne.getAssignedCountry().size());
        System.out.println("\"assertEquals\" is passed to test whether the number of assigned" +
                " countries to player is zero. \n");

        //add some armies to the player.
        playerOne.setArmies(20);

        //create and set a country and continent to the map for assigning to the player.
        firstCountry.setName("Canada");

        countryList.add(firstCountry);

        continent = new Continent("North America",1);

        firstCountry.setBelongToContinent(continent);

        continent.setCountries(countryList);

        //assign both the player to the country and the country to the player.
        firstCountry.setPlayer(playerOne);
        playerOne.setAssignedCountry(firstCountry);

        //run this to compare Reinforced Armies with the added armies to the player
        assertNotEquals(playerOne.getArmies(), playerModel.countReinforcementArmies(playerOne));
        System.out.println("\"assertNotEquals\" is passed to test countReinforcementArmies method. \n");
    }

    /**
     * This method tests initializeArmiesForAllCountries method for PlayerModel class.
     *
     */
    @Test
    public void initializeArmiesForAllCountriesTest() {
        //first create the map by adding a country and continent, then set a player for the country.
        firstCountry.setName("Canada");
        firstCountry.setPlayer(playerOne);
        countryList.add(firstCountry);
        continent = new Continent("North America",1);
        firstCountry.setBelongToContinent(continent);
        continent.setCountries(countryList);
        continentList.add(continent);
        hmap.setContinents(continentList);

        //add some armies to the player and country.
        firstCountry.setArmy(1);
        playerOne.setArmies(11);

        //run this to add army to the country by decreasing from player's army.
        playerModel.initializeArmiesForAllCountries(hmap);

        assertEquals(2, firstCountry.getArmy());
        System.out.println("\"assertEquals\" is passed to test whether the number of country's armies" +
                " is increased and updated by initializeArmiesForAllCountries method. \n");

        assertEquals(10, firstCountry.getPlayer().getArmies());
        System.out.println("\"assertEquals\" is passed to test whether the number of player's armies" +
                " is decreased by initializeArmiesForAllCountries method. \n");
    }

    /**
     * This method tests reinforceArmiesForCurrentPlayer method for PlayerModel class.
     *
     */
    @Test
    public void reinforceArmiesForCurrentPlayerTest() {
        //first declare a country
        firstCountry.setName("Canada");

        //add some armies and assign the country to the player
        playerOne.setArmies(10);
        playerOne.setAssignedCountry(firstCountry);

        assertTrue(playerModel.reinforceArmiesForCurrentPlayer(playerOne, "Canada", 10));
        System.out.println("\"assertTrue\" is passed to test reinforceArmiesForCurrentPlayer method. \n");
    }

    /**
     * This method tests assignReinforceArmiesToPlayers method for PlayerModel class.
     *
     */
    @Test
    public void assignReinforceArmiesToPlayersTest() {
        //first run this to check whether the number of player's armies is zero.
        assertEquals(0, playerOne.getArmies());
        System.out.println("\"assertEquals\" is passed to test whether the number of player's" +
                " armies equals zero. \n");

        //add the player to the player list and set the player list.
        playerList.add(playerOne);
        playerModel.setPlayersList(playerList);

        //run this to assign armies to the player, the default value to assign is 3 by this method.
        playerModel.assignReinforceArmiesToPlayers();

        assertEquals(3, playerOne.getArmies());
        System.out.println("\"assertEquals\" is passed to test whether the number of player's" +
                " armies is updated by assignReinforceArmiesToPlayers method. \n");
    }
}
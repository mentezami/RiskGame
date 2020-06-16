package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in the Country class.
 *
 * @author Mahmoudreza
 * @version 0.0.3
 */
public class CountryTest {

    Country country;
    Player player;
    Continent continent;
    List<String> neighborCountries = new ArrayList<>();
    List<Country> adjacentCountries = new ArrayList<>();

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
        country = new Country();
        player = new Player(1, "Player");
        continent = new Continent("North America", 1);
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
     * This method tests getPlayer method for Country class.
     *
     */
    @Test
    public void getPlayerTest() {
        //first run this to check whether no player is set to the country.
        assertNull(country.getPlayer());
        System.out.println("\"assertNull\" is passed to test whether " +
                "no any player is set to the country. \n");

        //set a player to the country
        country.setPlayer(player);

        assertNotNull(country.getPlayer());
        System.out.println("\"assertNotNull\" is passed to test getPlayer method. \n");
    }

    /**
     * This method tests getArmy method for Country class.
     *
     */
    @Test
    public void getArmyTest() {
        //first run this to check the getArmy method returns default value which is 0;
        assertEquals(0, country.getArmy());
        System.out.println("\"assertEquals\" is passed to test whether " +
                "getArmy method returns the default value. \n");
        /*
        The number of army should be between 0 and 5000.
        If it is more than 5000, it will be set to 5000,
        and if it is less than 0, it will be set as an absolute positive number.
         */
        int numberOfArmy = 3192;
        country.setArmy(numberOfArmy);

        assertEquals(numberOfArmy, country.getArmy());
        System.out.println("\"assertEquals\" is passed to test getArmy method. \n");

        numberOfArmy = 5300;
        country.setArmy(numberOfArmy);

        assertEquals(5000, country.getArmy());
        System.out.println("\"assertEquals\" is passed to test whether " +
                "if the number of army will be more than 5000, it will " +
                "be set to 5000 by getArmy method. \n");

        numberOfArmy = -30;
        country.setArmy(numberOfArmy);

        assertEquals(30, country.getArmy());
        System.out.println("\"assertEquals\" is passed to test whether " +
                "if the number of army will be less than 0, it will be set" +
                " as an absolute positive number by getArmy method. \n");
    }

    /**
     * This method tests getName method for Country class.
     *
     */
    @Test
    public void getNameTest() {
        //first runt this to check whether name of the country is not set.
        assertNull(country.getName());
        System.out.println("\"assertNull\" is passed to test whether " +
                "name of the country is not set. \n");

        //set a name to the country.
        String nameOfCountry = "Canada";
        country.setName(nameOfCountry);

        assertNotNull(country.getName());
        System.out.println("\"assertNotNull\" is passed to test getName method. \n");
    }

    /**
     * This method tests getxCoordinate method for Country class.
     *
     */
    @Test
    public void getxCoordinateTest() {
        //first run this to check the getxCoordinate method returns default value which is 0;
        assertEquals(0, country.getxCoordinate());
        System.out.println("\"assertEquals\" is passed to test whether " +
                "getxCoordinate method returns the default value. \n");

        //set a value for xCoordinate.
        int xCoordinate = 2;
        country.setxCoordinate(xCoordinate);

        assertEquals(xCoordinate, country.getxCoordinate());
        System.out.println("\"assertEquals\" is passed to test getxCoordinate method. \n");
    }

    /**
     * This method tests getyCoordinate method for Country class.
     *
     */
    @Test
    public void getyCoordinateTest() {
        //first run this to check the getyCoordinate method returns default value which is 0;
        assertEquals(0, country.getyCoordinate());
        System.out.println("\"assertEquals\" is passed to test whether " +
                "getyCoordinate method returns the default value. \n");

        //set a value for yCoordinate.
        int yCoordinate = 5;
        country.setyCoordinate(yCoordinate);

        assertEquals(yCoordinate, country.getyCoordinate());
        System.out.println("\"assertEquals\" is passed to test getyCoordinate method. \n");
    }
}
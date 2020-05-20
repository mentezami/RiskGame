package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in  the Country class.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class CountryTest {

    Country country;
    Player player;
    int playerId = 1;
    String playerName = "Mahmoudreza";


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
        country = new Country();
        player = new Player(playerId, playerName);
    }

    /**
     * This method runs after all methods.
     *
     */
    @AfterClass
    public static void afterAllTesting() {
        System.out.println("The test is done");
    }

    /**
     * This method tests getArmy method for country.
     *
     */
    @Test
    public void getArmyTest() {
        int numberOfArmy = 3192;
        country.setArmy(numberOfArmy);
        assertNotEquals(2300, country.getArmy());
        System.out.println("\"assertNotEquals\" to test getArmy method is passed");

        assertTrue(country.getArmy() == numberOfArmy);
        System.out.println("\"assertTrue\" to test getArmy method is passed");

        assertEquals(numberOfArmy, country.getArmy());
        System.out.println("\"assertEquals\" to test getArmy method is passed");
    }

    /**
     * This method tests getPlayer method for country.
     *
     */
    @Test
    public void getPlayerTest() {
        country.setPlayer(player);
        assertNotNull(country.getPlayer());
        System.out.println("\"assertNull\" to test getPlayer method is passed");

        assertEquals(player, country.getPlayer());
        System.out.println("\"assertNotEqual\" to test getPlayer method is passed");
    }

    /**
     * This method tests getxCoordinate method for country.
     *
     */
    @Test
    public void getxCoordinateTest() {
        int xCoordinate = 2;
        country.setxCoordinate(xCoordinate);
        assertEquals(country.getxCoordinate(), xCoordinate);
        System.out.println("\"assertEqual\" to test getxCoordinate method is passed");
    }
}
package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in  the Continent class.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class ContinentTest {

    static Continent continent;

    String firstColor = "Red";
    String secondColor = "Blue";

    String firstContinent = "South Pole";
    String secondContinent = "North Pole";

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
        continent = new Continent();
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
     * This method tests getColor method for continent.
     *
     */
    @Test
    public void getColorTest() {
        continent.setColor(firstColor);
        assertNotNull(continent.getColor());
        System.out.println("\"assertNotNull\" to test getColor method is passed");

        continent.setColor(secondColor);
        assertNotEquals(firstColor, continent.getColor());
        System.out.println("\"assertNotEqual\" to test getColor method is passed \n");
    }

    /**
     * This method tests getName method for continent.
     *
     */
    @Test
    public void getNameTest() {
        continent.setName(firstContinent);
        assertNotNull(continent.getName());
        System.out.println("\"assertNotNull\" to test getName method is passed");

        continent.setName(secondContinent);
        assertNotEquals(continent.getName(), firstContinent);
        System.out.println("\"assertNotEqual\" to test getName method is passed \n");
    }
}



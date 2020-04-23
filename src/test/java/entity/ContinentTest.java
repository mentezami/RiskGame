package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a Test Class for testing card
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class ContinentTest {

    Continent continent = null;

    /**
     * This method runs before all test methods only one times
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("This is before testing");
    }

    /**
     * This Method runs before test methods
     *
     */
    @Before
    public void beforeTest() {
        continent = new Continent();
    }

    /**
     * This method run after all test methods only one time.
     *
     */
    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("The test is done");
    }

    /**
     * This method test get color continent.
     *
     */
    @Test
    public void testGetColor() {
        assertNull(continent.getColor());
        System.out.println("'assertNull' test for getColor method is passed");
        assertNotEquals("Red", continent.getColor());
        System.out.println("'assertNotEqual' test for getColor method is passed");
    }

    /**
     * This method test get name continent.
     *
     */
    @Test
    public void testGetName() {
        assertNull(continent.getName());
        System.out.println("'assertNull' test for getName method is passed");
        assertNotEquals("Advance Programming", continent.getName());
        System.out.println("'assertNotEqual' test for getName method is passed");
    }

}



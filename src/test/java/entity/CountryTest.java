package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountryTest {

    Country country;

    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("This is for testing Country Class");
    }

    @Before
    public void beforeTest() {
        country = new Country();
    }

    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("The test is done");
    }

    @Test
    public void testGetArmy() {
        assertEquals(0, country.getArmy());
        System.out.println("'assertEquals' test for getArmy method is passed");

        assertTrue(country.getArmy() == 0);
        System.out.println("'assertTrue' test for getArmy method is passed");

        assertNotEquals(6000, country.getArmy());
        System.out.println("'assertNotEquals' test for getArmy method is passed");
    }

    @Test
    public void testGetPlayer() {
        assertNull(country.getPlayer());
        System.out.println("'assertNull' test for getPlayer method is passed");
        assertNotEquals("Name of the Player", country.getPlayer());
        System.out.println("'assertNotEqual' test for getPlayer method is passed");
    }

}


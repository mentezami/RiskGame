package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in the Continent class.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class ContinentTest {

    Continent continent;
    Country country;
    List<Country> countryList;
    HashMap<String,Country> countryMap;

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
        continent = new Continent();
        country = new Country();
        countryList = new ArrayList<>();
        countryMap = new HashMap<>();
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
     * This method tests getName method for Continent class.
     *
     */
    @Test
    public void getNameTest() {
        //first, run this to make sure the name of continent is not set.
        assertNull(continent.getName());
        System.out.println("\"assertNull\" is passed to test whether the" +
                " name of continent is not set \n");

        //set a name for the continent.
        continent.setName("North America");

        assertNotNull(continent.getName());
        assertEquals("North America", continent.getName());
        System.out.println("\"assertNotNull\" and \"assertEquals\" are passed" +
                " to test getName method. \n");
    }

    /**
     * This method tests getColor method for Continent class.
     *
     */
    @Test
    public void getColorTest() {
        //first, run this to make sure the color of continent is not set.
        assertNull(continent.getColor());
        System.out.println("\"assertNull\" is passed to test whether the" +
                " color of continent is not set. \n");

        //set a color for the continent.
        continent.setColor("Red");

        assertNotNull(continent.getColor());
        assertEquals("Red", continent.getColor());
        System.out.println("\"assertNotNull\" and \"assertEquals\" are passed" +
                " to test getColor method. \n");
    }

    /**
     * This method tests getCountries method for Continent class.
     *
     */
    @Test
    public void getCountriesTest() {
        //first, run this to make sure the country for the continent is not set.
        assertTrue(continent.getCountries().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether there" +
                " is no country assigned to the continent. \n");

        //declare a name for the country.
        country.setName("Canada");

        //add the country to the list of countries and set it to the continent.
        countryList.add(country);
        continent.setCountries(countryList);

        assertFalse(continent.getCountries().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getCountries method. \n");
    }

    /**
     * This method tests getValue method for Continent class.
     *
     */
    @Test
    public void getValueTest() {
        //first, run this to make sure the continent does not have a value.
        assertEquals(0, continent.getValue());
        System.out.println("\"assertEquals\" is passed to test whether there" +
                " is no value set to the continent. \n");

        //set a value for the continent.
        continent.setValue(1);

        assertEquals(1, continent.getValue());
        System.out.println("\"assertEquals\" is passed to test getValue method. \n");
    }

    /**
     * This method tests getCountryMap method for Continent class.
     *
     */
    @Test
    public void getCountryMapTest() {
        //first, run this to make sure the map of continent is not set.
        assertTrue(continent.getCountryMap().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether there" +
                " is no map set to the continent. \n");

        //declare, add and set a country to the map of continent.
        country.setName("Canada");
        countryMap.put("Canada", country);
        continent.setCountryMap(countryMap);

        assertFalse(continent.getCountryMap().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getCountryMap method. \n");
    }

    /**
     * This method tests isVisited method for Continent class.
     *
     */
    @Test
    public void isVisitedTest() {
        //run this to make sure the isVisited method is not set.
        assertFalse(continent.isVisited());
        System.out.println("\"assertFalse\" is passed to test whether" +
                " the isVisited methods is not set. \n");

        continent.setVisited(true);

        assertTrue(continent.isVisited());
        System.out.println("\"assertTrue\" is passed to test isVisited method. \n");
    }
}



package controller;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import entity.Continent;
import entity.Country;
import entity.Hmap;
import exception.InvalidMap;

/**
 * This is a test class for testing the methods in the MapController class.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class MapControllerTest {

    MapController mapController;
    static Continent continent;
    static Country firstCountry;
    static Country secondCountry;
    static Hmap map;
    String continentName = "North America";
    int continentValue = 2;
    String firstCountryName = "Canada";
    String secondCountryName = "USA";
    String color;

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
        map = new Hmap();
        continent = new Continent();
        firstCountry = new Country();
        secondCountry = new Country();
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
     * This method tests removeContinent method for MapController class.
     *
     */
    @Test
    public void removeContinentTest() {
        //run this to add a continent
        mapController.addContinent(map, continentName, String.valueOf(continentValue), color);

        assertEquals(true, mapController.removeContinent(map, continentName));
        System.out.println("\"assertEquals\" is passed to test removeContinent method. \n");
    }

    /**
     * This method tests the addContinent method for MapController class.
     *
     */
    @Test
    public void addContinentTest() {
        assertEquals(true, mapController.addContinent(map, continentName,
                String.valueOf(continentValue), color));
        System.out.println("\"assertEquals\" is passed to test addContinent method. \n");
    }

    /**
     * This method tests the addCountry method for MapController class.
     *
     */
    @Test
    public void addCountryTest() {
        firstCountry.setName(firstCountryName);
        List<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);
        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setContinents(continentList);

        assertFalse(mapController.addCountry(map, firstCountryName, continentName));
        System.out.println("\"assertFalse\" is passed to test addCountry method. \n");

        assertTrue(mapController.addCountry(map, secondCountryName, continentName));
        System.out.println("\"assertTrue\" is passed to test addCountry method. \n");
    }

    /**
     * This method tests mapCountryToContinent method for MapController class.
     *
     */
    @Test
    public void mapCountryToContinentTest() {
        firstCountry.setName(firstCountryName);
        assertNotNull(mapController.mapCountryToContinent(new Continent(continentName,continentValue),
                firstCountry));
        System.out.println("\"assertNotNull\" is passed to test mapCountryToContinent method. \n");
    }

    /**
     * This method tests the updateContinent name and value for MapController class.
     *
     */
    @Test
    public void updateContinentTest() throws InvalidMap {
        firstCountry.setName(firstCountryName);
        secondCountry.setName(secondCountryName);
        List<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        countryList.add(secondCountry);
        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);
        assertEquals(continent.getName(), continentName);
        assertEquals(continent.getValue(), continentValue);
        System.out.println("\"assertEquals\" to test for both getName and getValue methods are passed" +
                " to see the name and value for a continent before applying updateContinent method. \n");

        mapController.updateContinent(continent, map, "New Zealand", "7");
        assertEquals(continent.getValue(), 7);
        assertEquals(continent.getName(), "New Zealand");
        System.out.println("\"assertEquals\" to test for both getName and getValue methods are passed" +
                " to validate the result of updateContinent method. \n");
    }
}


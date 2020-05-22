package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
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
 * This is a Test Class for testing MapCommands
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class MapControllerTest {

    MapController mapController;
    static Continent continent;
    static Country country;
    static Country firstCountry;
    static Country secondCountry;
    static Hmap map;
    String continentName = "North America";
    int continentValue = 2;
    String firstCountryName = "Canada";
    String secondCountryName = "USA";
    String color;
    int controlValue;
    static Country adjacentCountry;
    static HashMap<String, String> mapData;

    /**
     * This method prepares all needs before All Testing Methods and it just runs one.
     *
     */
    @BeforeClass
    public static void initializingForTest() {
        System.out.println("Preparing for testing MapCommands_Class");
        map = new Hmap();
        mapData = new HashMap<>();
        continent = new Continent();
        country = new Country();
        firstCountry = new Country();
        secondCountry = new Country();
        adjacentCountry = new Country();
    }

    /**
     * This method runs before All test cases and runs before every test case.
     *
     */
    @Before
    public void beforeTesting() {
        mapData = new HashMap<>();
        map.setMapData(mapData);
    }

    /**
     * This method runs After All Testing.
     *
     */
    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("All tests are done");
    }

    /**
     * This method tests the remove Continent.
     *
     */
    @Test
    public void removeContinentTest() {
        assertEquals(true, mapController.removeContinent(map, continentName));
        System.out.println("This is a test for Remove Continent");
    }

    /**
     * This method tests the add Continent.
     *
     */
    @Test
    public void addContinentTest() {
        assertEquals(true, mapController.addContinent(map, continentName, String.valueOf(controlValue), color));
        boolean output = mapController.addContinent(map, continentName, String.valueOf(controlValue), color);
        assertNotNull(output);
        System.out.println("This is a test for Add Continent it was pass");
    }

    /**
     * This method tests the add country.
     *
     */
    @Test
    public void addCountryTest() {
        boolean output = mapController.addCountry(map, firstCountryName, continentName);
        System.out.println(mapController.addCountry(map, firstCountryName, continentName));
        assertNotNull(output);
        System.out.println("This is a test for AddCountry Continent");
    }

    /**
     * This method tests map country to continent.
     *
     */
    @Test
    public void mapCountryToContinentTest() {
        firstCountry.setName(firstCountryName);
        assertNotNull(mapController.mapCountryToContinent(new Continent(continentName,continentValue),
                firstCountry));
        System.out.println("\"assertNotNull\" is passed to test mapCountryToContinent. \n");
    }

    /**
     * This method tests the update Continent name and Continent value.
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


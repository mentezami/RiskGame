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
        mapController = new MapController();
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

        assertTrue(mapController.removeContinent(map, continentName));
        System.out.println("\"assertTrue\" is passed to test removeContinent method. \n");
    }

    /**
     * This method tests the addContinent method for MapController class.
     *
     */
    @Test
    public void addContinentTest() {
        assertTrue(mapController.addContinent(map, continentName,
                String.valueOf(continentValue), color));
        System.out.println("\"assertTrue\" is passed to test addContinent method. \n");
    }

    /**
     * This method tests the containsContinentName method for MapController class.
     *
     */
    @Test
    public void containsContinentNameTest() {
        firstCountry.setName(firstCountryName);
        List<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);
        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setContinents(continentList);

        assertTrue(mapController.containsContinentName(continentList,continentName));
        System.out.println("\"assertTrue\" is passed to test containsContinentName method. \n");

        assertFalse(mapController.containsContinentName(continentList,"Europe"));
        System.out.println("\"assertFalse\" is passed to test containsContinentName method. \n");
    }

    /**
     * This method tests the updateContinent method for MapController class.
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

    /**
     * This method tests the containsCountryName method for MapController class.
     *
     */
    @Test
    public void containsCountryNameTest() {
        firstCountry.setName(firstCountryName);
        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);

        assertTrue(mapController.containsCountryName(countryList,firstCountryName));
        System.out.println("\"assertTrue\" is passed to test containsCountryName method. \n");

        assertFalse(mapController.containsCountryName(countryList,secondCountryName));
        System.out.println("\"assertFalse\" is passed to test containsCountryName method. \n");
    }

    /**
     * This method tests removeCountry method for MapController class.
     *
     */
    @Test
    public void removeCountryTest() {
        //declare and run this to add a Country
        firstCountry.setName(firstCountryName);
        List<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);
        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setContinents(continentList);
        mapController.addCountry(map, firstCountryName,continentName);

        assertTrue(mapController.removeCountry(map, firstCountryName));
        System.out.println("\"assertTrue\" is passed to test removeCountry method. \n");
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
     * This method tests the updateCountry method for MapController class.
     *
     */
    @Test
    public void updateCountryTest() throws InvalidMap {
        firstCountry.setName(firstCountryName);
        firstCountry.setxCoordinate(1);
        firstCountry.setyCoordinate(1);

        secondCountry.setName(secondCountryName);
        secondCountry.setxCoordinate(2);
        secondCountry.setyCoordinate(2);

        List<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        countryList.add(secondCountry);

        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);
        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setContinents(continentList);

        assertEquals(mapController.updateCountry(secondCountry, map,"Germany",
                "3","3", firstCountry), secondCountry);
        System.out.println("\"assertEquals\" is passed to test updateCountry method. \n");

        assertNotEquals(mapController.updateCountry(secondCountry, map,"Germany",
                "3","3", firstCountry), firstCountry);
        System.out.println("\"assertNotEquals\" is passed to test updateCountry method. \n");
    }

    /**
     * This method tests removeNeighborCountry method for MapController class.
     *
     */
    @Test
    public void removeNeighborCountryTest() {
        firstCountry.setName(firstCountryName);
        secondCountry.setName(secondCountryName);

        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        countryList.add(secondCountry);

        firstCountry.setAdjacentCountries(countryList);
        secondCountry.setAdjacentCountries(countryList);

        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);

        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setCountries(countryList);

        HashMap<String, Integer> countriesIdxMap = new HashMap<>();
        countriesIdxMap.put(firstCountryName,1);
        countriesIdxMap.put(secondCountryName,2);
        map.setCountriesIdxMap(countriesIdxMap);

        map.setContinents(continentList);

        assertTrue(mapController.removeNeighborCountry(map,firstCountryName,secondCountryName));
        System.out.println("\"assertTrue\" is passed to test removeNeighborCountry method. \n");
    }

    /**
     * This method tests addNeighborCountry method for MapController class.
     *
     */
    @Test
    public void addNeighborCountryTest() {
        firstCountry.setName(firstCountryName);
        secondCountry.setName(secondCountryName);

        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        countryList.add(secondCountry);

        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);

        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setCountries(countryList);

        HashMap<String, Integer> countriesIdxMap = new HashMap<>();
        countriesIdxMap.put(firstCountryName,1);
        countriesIdxMap.put(secondCountryName,2);
        map.setCountriesIdxMap(countriesIdxMap);

        map.setContinents(continentList);

        assertTrue(mapController.addNeighborCountry(map,firstCountryName,secondCountryName));
        System.out.println("\"assertTrue\" is passed to test addNeighborCountry method. \n");
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
}


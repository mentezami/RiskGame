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
        MapController.addContinent(map, continentName, String.valueOf(continentValue), color);

        assertTrue(MapController.removeContinent(map, continentName));
        System.out.println("\"assertTrue\" is passed to test removeContinent method. \n");
    }

    /**
     * This method tests the addContinent method for MapController class.
     *
     */
    @Test
    public void addContinentTest() {
        assertTrue(MapController.addContinent(map, continentName,
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

        assertTrue(MapController.containsContinentName(continentList,continentName));
        System.out.println("\"assertTrue\" is passed to test containsContinentName method. \n");

        assertFalse(MapController.containsContinentName(continentList,"Europe"));
        System.out.println("\"assertFalse\" is passed to test containsContinentName method. \n");
    }

    /**
     * This method tests the updateContinent method for MapController class.
     *
     * @throws InvalidMap (Exception)
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

        assertEquals(continentName, continent.getName());
        assertEquals(continentValue, continent.getValue());
        System.out.println("\"assertEquals\" to test for both getName and getValue methods are passed" +
                " to see the name and value for a continent before applying updateContinent method. \n");

        MapController.updateContinent(continent, map, "New Zealand", "7");

        assertEquals(7, continent.getValue());
        assertEquals("New Zealand", continent.getName());
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

        assertTrue(MapController.containsCountryName(countryList,firstCountryName));
        System.out.println("\"assertTrue\" is passed to test containsCountryName method. \n");

        assertFalse(MapController.containsCountryName(countryList,secondCountryName));
        System.out.println("\"assertFalse\" is passed to test containsCountryName method. \n");
    }

    /**
     * This method tests removeCountry method for MapController class.
     *
     */
    @Test
    public void removeCountryTest() {
        //declare and run these to add a Country
        firstCountry.setName(firstCountryName);
        List<Country> countryList = new ArrayList<>();
        countryList.add(firstCountry);
        continent = new Continent(continentName,continentValue);
        continent.setCountries(countryList);
        List<Continent> continentList = new ArrayList<>();
        continentList.add(continent);
        map.setContinents(continentList);
        MapController.addCountry(map, firstCountryName,continentName);

        assertTrue(MapController.removeCountry(map, firstCountryName));
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

        assertFalse(MapController.addCountry(map, firstCountryName, continentName));
        System.out.println("\"assertFalse\" is passed to test addCountry method. \n");

        assertTrue(MapController.addCountry(map, secondCountryName, continentName));
        System.out.println("\"assertTrue\" is passed to test addCountry method. \n");
    }

    /**
     * This method tests the updateCountry method for MapController class.
     *
     * @throws InvalidMap (Exception)
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

        assertEquals(secondCountry, MapController.updateCountry(secondCountry, map,"Germany",
                "3","3", firstCountry));
        System.out.println("\"assertEquals\" is passed to test updateCountry method. \n");

        assertNotEquals(firstCountry, MapController.updateCountry(secondCountry, map,"Germany",
                "3","3", firstCountry));
        System.out.println("\"assertNotEquals\" is passed to test updateCountry method. \n");
    }

    /**
     * This method tests removeNeighborCountry method for MapController class.
     *
     */
    @Test
    public void removeNeighborCountryTest() {
        //first run these to add neighbor country
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

        assertTrue(MapController.removeNeighborCountry(map,firstCountryName,secondCountryName));
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

        assertTrue(MapController.addNeighborCountry(map,firstCountryName,secondCountryName));
        System.out.println("\"assertTrue\" is passed to test addNeighborCountry method. \n");
    }

    /**
     * This method tests mapCountryToContinent method for MapController class.
     *
     */
    @Test
    public void mapCountryToContinentTest() {
        firstCountry.setName(firstCountryName);
        assertNotNull(MapController.mapCountryToContinent(new Continent(continentName,continentValue),
                firstCountry));
        System.out.println("\"assertNotNull\" is passed to test mapCountryToContinent method. \n");
    }
}


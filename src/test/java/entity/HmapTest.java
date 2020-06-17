package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;

/**
 * This is a test class for testing the methods in the Hmap class.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class HmapTest {

    Hmap hmap;
    Country country;
    Continent continent;
    ArrayList<Country> countryList;
    List<Continent> continentList;
    HashMap<String,String> mapData;
    Map<String,Country> countryMap;
    HashMap<String,Integer> countriesIdxMap;
    HashMap<String,Continent> continentMap;

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
        hmap = new Hmap();
        country = new Country();
        countryList = new ArrayList<>();
        continentList = new ArrayList<>();
        mapData = new HashMap<>();
        countryMap = new TreeMap<>();
        countriesIdxMap = new HashMap<>();
        continentMap = new HashMap<>();
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
     * This method tests getMapData method for Hmap class.
     *
     */
    @Test
    public void getMapDataTest() {
        //first run this to make sure the map data is empty.
        assertTrue(hmap.getMapData().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no attribute set to the map data. \n");

        mapData.put("Canada","Canada");
        hmap.setMapData(mapData);

        assertFalse(hmap.getMapData().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getMapData method. \n");
    }

    /**
     * This method tests getCountryMap method for Hmap class.
     *
     */
    @Test
    public void getCountryMapTest() {
        //first run this to make sure the map is empty.
        assertTrue(hmap.getCountryMap().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no country set to the map. \n");

        //declare a country to add and set to the map.
        country.setName("Canada");
        countryMap.put("Canada", country);
        hmap.setCountryMap(countryMap);

        assertFalse(hmap.getCountryMap().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getCountryMap method. \n");
    }

    /**
     * This method tests getContinents method for Hmap class.
     *
     */
    @Test
    public void getContinentsTest() {
        //first run this to make sure the list of continents is empty.
        assertTrue(hmap.getContinents().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no continent set to the list of continents. \n");

        /*
        declare a country and add it to the country list for assigning to a continent,
        then declare a continent and assign the country to it for setting the continent
        to the list of continents.
         */
        country.setName("Canada");
        countryList.add(country);
        continent = new Continent("North America", 1);
        continent.setCountries(countryList);
        continentList.add(continent);
        hmap.setContinents(continentList);

        assertFalse(hmap.getContinents().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getContinents method. \n");
    }

    /**
     * This method tests getCountries method for Hmap class.
     *
     */
    @Test
    public void getCountriesTest() {
        //first run this to make sure the list of countries is empty.
        assertTrue(hmap.getCountries().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no country set to the list of country in the map. \n");

        //declare a country to set to the list of countries in the map.
        country.setName("Canada");
        countryList.add(country);
        hmap.setCountries(countryList);

        assertFalse(hmap.getCountries().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getCountries method. \n");
    }

    /**
     * This method tests getCountriesIdxMap method for Hmap class.
     *
     */
    @Test
    public void getCountriesIdxMapTest() {
        //first run this to make sure the map for index of country and its corresponded country is empty.
        assertTrue(hmap.getCountriesIdxMap().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no index for country set to the the map of country index. \n");

        //add a country and its corresponded index to the map of country index.
        countriesIdxMap.put("Canada", 1);
        hmap.setCountriesIdxMap(countriesIdxMap);

        assertFalse(hmap.getCountriesIdxMap().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getCountriesIdxMap method. \n");
    }

    /**
     * This method tests getContinentMap method for Hmap class.
     *
     */
    @Test
    public void getContinentMapTest() {
        //first run this to make sure the map of continent is empty.
        assertTrue(hmap.getContinentMap().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no continent set to the the map of continent. \n");

        /*declare a country for assigning to a continent,
        then declare a continent to set and add to the continent map.
         */
        country.setName("Canada");
        countryList.add(country);
        continent = new Continent("North America", 1);
        continent.setCountries(countryList);
        continentMap.put("North America", continent);
        hmap.setContinentMap(continentMap);

        assertFalse(hmap.getContinentMap().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getContinentMap method. \n");
    }
}

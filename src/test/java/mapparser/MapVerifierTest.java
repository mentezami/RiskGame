package mapparser;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.util.ArrayList;
import java.util.List;
import entity.Continent;
import entity.Country;
import entity.Hmap;

/**
 * This is a test class for testing the methods in the MapVerifier class.
 *
 * {@link MapVerifier}
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class MapVerifierTest {

    MapVerifier mapverifier;
    Continent continent_1;
    Continent continent_2;
    Country country_1;
    Country country_2;
    Hmap hmap;
    List<Country> countryList;
    List<Country> adjacentCountryList;
    List<Continent> continentList;

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
        continent_1 = new Continent("Asia", 1);
        continent_2 = new Continent("Europe", 2);
        country_1 = new Country();
        country_2 = new Country();
        hmap = new Hmap();
        countryList = new ArrayList<>();
        adjacentCountryList = new ArrayList<>();
        continentList = new ArrayList<>();
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
     * This method tests isContinentConnectedGraph method for MapVerifier class.
     *
     */
    @Test
    public void isContinentConnectedGraphTest() {
        //first, declare a country and assign it to a continent to build the map.
        country_1.setName("Turkey");
        countryList.add(country_1);
        continent_1.setCountries(countryList);
        continentList.add(continent_1);
        hmap.setContinents(continentList);

        assertTrue(MapVerifier.isContinentConnectedGraph(continent_1, hmap));
        System.out.println("\"assertTrue\" is passed to test isContinentConnectedGraph method. \n");
    }

    /**
     * This method tests runDfsOnCountry method for MapVerifier class.
     *
     */
    @Test
    public void runDfsOnCountryTest() {
        //first run this to make sure the country_1 is not visited.
        assertFalse(country_1.isVisited());
        System.out.println("\"assertFalse\" is passed to test whether " +
                "the country_1 is not visited. \n");

        country_1.setName("Turkey");
        country_2.setName("Greece");
        adjacentCountryList.add(country_2);
        country_1.setAdjacentCountries(adjacentCountryList);
        countryList.add(country_1);

        //run this to check traversing the countries in terms of BFS.
        MapVerifier.runDfsOnCountry(country_1, hmap);
        assertTrue(country_1.isVisited());
        System.out.println("\"assertTrue\" is passed to test runDfsOnCountry method. \n");
    }

    /**
     * This method tests isMapConnectedGraph method for MapVerifier class.
     *
     */
    @Test
    public void isMapConnectedGraphTest() {
        //First run this to make sure the map is not connected.
        assertFalse(MapVerifier.isMapConnectedGraph(hmap));
        System.out.println("\"assertFalse\" is passed to test whether " +
                "the map is not connected. \n");

        //declare, set and add some countries and continents to the map.
        country_1.setName("Turkey");
        country_2.setName("Greece");
        adjacentCountryList.add(country_2);
        country_1.setAdjacentCountries(adjacentCountryList);
        countryList.add(country_1);
        continent_1.setCountries(countryList);
        continent_2.setCountries(adjacentCountryList);
        continentList.add(continent_1);
        continentList.add(continent_2);
        hmap.setContinents(continentList);

        assertTrue(MapVerifier.isMapConnectedGraph(hmap));
        System.out.println("\"assertTrue\" is passed to test isMapConnectedGraph method. \n");
    }

    /**
     * This method tests runDfsContinent method for MapVerifier class.
     *
     */
    @Test
    public void runDfsContinentTest() {
        //first run this to make sure the continent is not visited.
        assertFalse(continent_1.isVisited());
        System.out.println("\"assertFalse\" is passed to test whether " +
                "the continent is not visited. \n");

        //declare and assign a country to the continent.
        country_1.setName("Turkey");
        countryList.add(country_1);
        continent_1.setCountries(countryList);

        //run this to check traversing the continent in terms of BFS.
        MapVerifier.runDfsContinent(continent_1, hmap);
        assertTrue(continent_1.isVisited());
        System.out.println("\"assertTrue\" is passed to test runDfsContinent method. \n");
    }

    /**
     * This method tests getAdjacentContinents method for MapVerifier class.
     *
     */
    @Test
    public void getAdjacentContinentsTest() {
        //first run this to make sure the returned list by getAdjacentContinents method is empty.
        assertTrue(MapVerifier.getAdjacentContinents(continent_1, hmap).isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                        "the returned list by getAdjacentContinents method is empty. ");

        //declare and add some countries and continents to the map.
        country_1.setName("Turkey");
        country_2.setName("Greece");
        adjacentCountryList.add(country_2);
        country_1.setAdjacentCountries(adjacentCountryList);
        countryList.add(country_1);
        continent_1.setCountries(countryList);
        continent_2.setCountries(adjacentCountryList);
        continentList.add(continent_1);
        continentList.add(continent_2);
        hmap.setContinents(continentList);

        assertFalse(MapVerifier.getAdjacentContinents(continent_1, hmap).isEmpty());
        System.out.println("\"assertFalse\" is passed to test whether " +
                "the returned list by getAdjacentContinents method is not empty. \n");
    }
}


package mapparser;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import entity.Continent;
import entity.Country;
import entity.Hmap;
import exception.InvalidMap;

/**
 * This is a test class for MapVerifier class.
 * {@link MapVerifier}
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class MapVerifierTest {

    MapVerifier mapverifier;
    static Continent continent;
    static Country country_1;
    Country country_2;
    static Hmap map;
    String continentName = "North America";
    int controlValue = 10;
    static HashMap<String, String> mapData = new HashMap<String, String>();
    List<Continent> continentList;
    List<Country> countryList;

    /**
     * This method is executed before all methods in the class.
     *
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("This is for testing MapVerifier Class");
    }

    /**
     * This method is executed before each method in the class.
     *
     */
    @Before
    public void beforeTest() {
        continent = new Continent();
        country_1 = new Country();
        country_2 = new Country();
        map = new Hmap();
        continentList = new ArrayList<Continent>();
        countryList = new ArrayList<Country>();
        map.setMapData(mapData);
        continent.setName(continentName);
        continent.setValue(controlValue);
        country_1.setName("Canada");
        country_1.setxCoordinate(1);
        country_1.setyCoordinate(1);
        continentList.add(continent);
    }

    /**
     * This method runs After All testing methods.
     *
     */
    @AfterClass
    public static void afterClassTests() {
        System.out.println("All tests are done");
    }

    /**
     * This method tests whether the map is null or not.
     *
     * @throws InvalidMap invalid map exception.
     */
    @Test(expected = InvalidMap.class)
    public void verifyNullMapTest() throws InvalidMap {
        mapverifier.verifyMap(null);
        System.out.println("This is a test for verifyNullMap");
    }

    /**
     * This method verifies the map which has at least one continent.
     *
     * @throws InvalidMap invalid map exception.
     */
    @Test(expected = InvalidMap.class)
    public void verifyMap() throws InvalidMap {
        mapverifier.verifyMap(new Hmap());
        System.out.println("The Unit Test for verifying Map is performed");
    }

    /**
     * This method is used to verify that continent is null or not.
     *
     * @throws InvalidMap invalid map exception.
     */
    @Test(expected = InvalidMap.class)
    public void verifyContinentsTest() throws InvalidMap {
        map.setContinents(continentList);
        mapverifier.verifyContinents(map);
        System.out.println("The Unit Test for verifying Continents is performed");
    }

    /**
     * This method is used to test whether a continent is a sub-graph or not.
     *
     */
    @Test
    public void isMapConnectedGraphTest() throws InvalidMap {
        assertFalse(mapverifier.isMapConnectedGraph(map));
        System.out.println("This Unit Test for Map_Connected_Graph is performed");
    }

    /**
     * This method is used to test whether the continent is connected to graph or not.
     *
     */
    @Test
    public void isContinentConnectedGraphTest() {

        System.out.println("This is a test for Continent Connected Graph");
        countryList.add(country_1);
        country_2.setName("USA");
        country_2.setxCoordinate(1);
        country_2.setyCoordinate(2);
        countryList.add(country_1);
        continent.setCountries(countryList);
        assertEquals(true, MapVerifier.isContinentConnectedGraph(continent, map));
        countryList.add(country_1);
        continent.setCountries(countryList);
        assertEquals(MapVerifier.isContinentConnectedGraph(continent, map), true);
        System.out.println("The Test for Continent_Connected_Graph is performed");
    }
}


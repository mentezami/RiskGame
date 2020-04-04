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

        @BeforeClass
        public static void beforeClass() {
            System.out.println("This is for testing MapVerifier Class");
        }

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

        @AfterClass
        public static void afterClassTests() {
            System.out.println("All tests are done");
        }

        @Test(expected = InvalidMap.class)
        public void verifyNullMapTest() throws InvalidMap {
            mapverifier.verifyMap(null);
            System.out.println("This is a test for verifyNullMap");
        }

        @Test(expected = InvalidMap.class)
        public void verifyMap() throws InvalidMap {
            mapverifier.verifyMap(new Hmap());
            System.out.println("The Unit Test for verifying Map is performed");
        }

        @Test(expected = InvalidMap.class)
        public void verifyContinentsTest() throws InvalidMap {
            map.setContinents(continentList);
            mapverifier.verifyContinents(map);
            System.out.println("The Unit Test for verifying Continents is performed");
        }

        @Test
        public void isMapConnectedGraphTest() throws InvalidMap {
            assertFalse(mapverifier.isMapConnectedGraph(map));
            System.out.println("This Unit Test for Map_Connected_Graph is performed");
        }

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


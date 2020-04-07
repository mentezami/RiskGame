package mapparser;

import static org.junit.Assert.*;

import java.util.HashMap;

//import mapparser.MapCommands;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Ignore;
import entity.Continent;
import entity.Country;
import entity.Hmap;
import exception.InvalidMap;


public class MapCommandsTest {

        MapCommands mapCommands;
        static Continent continent;
        static Hmap map;
        String nameContinent = "America";
        String nameCountry = "Canada";
        String color;
        int controlValue;
        static Country country;
        static Country adjacentCountry;
        int xCoordinate = 1;
        static HashMap<String, String> mapData;

        @BeforeClass
        public static void initializingForTest() {
            System.out.println("Preparing for testing MapCommands_Class");
            map = new Hmap();
            mapData = new HashMap<>();
            continent = new Continent();
            country = new Country();
            adjacentCountry = new Country();
        }

        @Before
        public void beforeTesting() {
            mapData = new HashMap<>();
            map.setMapData(mapData);
        }

        @AfterClass
        public static void afterPerformingTests() {
            System.out.println("All tests are done");
        }

        @Test
        public void removeContinentTest() {
            assertEquals(true, mapCommands.removeContinent(map, nameContinent));
            System.out.println("This is a test for Remove Continent");
        }

        @Test
        public void addContinentTest() {
            assertEquals(true, mapCommands.addContinent(map, nameContinent, String.valueOf(controlValue), color));
            boolean output = mapCommands.addContinent(map, nameContinent, String.valueOf(controlValue), color);
            assertNotNull(output);
            System.out.println("This is a test for Add Continent it was pass");
        }

        @Test
        public void updateContinentTest() {
            assertNotEquals(continent.getName(), nameContinent);
            System.out.println("This is a test for Update Continent");
        }

        @Test
        public void addCountryTest() {
            boolean output = MapCommands.addCountry(map, nameCountry, nameContinent);
            assertNotNull(output);
            System.out.println("This is a test for AddCountry Continent");
        }

        @Test
        public void updateCountryTest() throws InvalidMap {
            assertNotEquals(country.getxCoordinate(), xCoordinate);
            System.out.println("This is a test for UpdateCountry Continent");
        }

        @Test
        public void mapCountryToContinentTest() {
            assertNotNull(mapCommands.mapCountryToContinent(continent, country));
            System.out.println("This is a test for mapCountry to Continent");
        }

        @Ignore
        public void shouldNotBeRunThisTime() throws InvalidMap {
            continent = mapCommands.updateContinent(continent, map, nameContinent, String.valueOf(7));
            mapCommands.updateContinent(continent, map, nameContinent, String.valueOf(controlValue));
            assertEquals(continent.getValue(), controlValue);
            assertEquals(continent.getValue(), controlValue);
            assertEquals(continent.getName(), nameContinent);
        }

    }


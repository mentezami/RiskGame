package mapparser;


import static org.junit.Assert.*;

import exception.InvalidMap;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.*;
import entity.Hmap;

public class MapReaderTest {


        static File file = null;
        MapReader mapReader = null;
        Hmap hmap = null;
        ClassLoader classLoader = null;
        static String[] invalidFiles = { "world.map", "country_with_two_continents.map", "country_without_border.map",
                "country_without_continent.map", "countries_in_same_continent.map" };

        @BeforeClass
        public static void beforeClass() {
            System.out.println("The tests are started");
        }

        @Before
        public void beforeMethods() throws IOException {
            mapReader = new MapReader();
            hmap = new Hmap();
            classLoader = getClass().getClassLoader();
        }

        @AfterClass
        public static void afterAllTests() {
            System.out.println("All tests are done");
        }

        @Test
        public void testMapValidation() throws InvalidMap {
            file = new File(classLoader.getResource("world.map").getFile());
            hmap = mapReader.readMapFile(file);
            assertEquals(hmap.getContinents().size(), 6);
        }

        @Test(expected = InvalidMap.class)
        public void testCountriesInTheSameContinent() throws InvalidMap {
            file = new File(classLoader.getResource(invalidFiles[4]).getFile());
            mapReader.readMapFile(file);
        }

        @Test(expected = InvalidMap.class)
        public void testCountriesWithoutBorder() throws InvalidMap {
            file = new File(classLoader.getResource(invalidFiles[2]).getFile());
            mapReader.readMapFile(file);
        }

        @Test(expected = InvalidMap.class)
        public void testCountriesWithTwoContinents() throws InvalidMap {
            file = new File(classLoader.getResource(invalidFiles[1]).getFile());
            mapReader.readMapFile(file);
        }

        @Test(expected = InvalidMap.class)
        public void testCountriesWithoutContinents() throws InvalidMap {
            file = new File(classLoader.getResource(invalidFiles[3]).getFile());
            mapReader.readMapFile(file);
        }

    }


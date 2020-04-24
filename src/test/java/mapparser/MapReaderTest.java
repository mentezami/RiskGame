package mapparser;

import static org.junit.Assert.*;
import exception.InvalidMap;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.*;
import entity.Hmap;

/**
 * This class tests all functions for validating Map and Continent.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class MapReaderTest {

    static File file = null;
    MapReader mapReader = null;
    Hmap hmap = null;
    ClassLoader classLoader = null;
    static String[] invalidFiles = { "world.map", "country_with_two_continents.map",
            "country_without_border.map", "country_without_continent.map",
            "countries_in_same_continent.map" };

    /**
     * This method runs before running all methods in the class.
     *
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("The tests are started");
    }

    /**
     * This method runs before running each test methods.
     *
     * @throws IOException
     */
    @Before
    public void beforeMethods() throws IOException {
        mapReader = new MapReader();
        hmap = new Hmap();
        classLoader = getClass().getClassLoader();
    }

    /**
     * This method runs after all testing methods.
     *
     */
    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are done");
    }

    /**
     * This method tests map validation.
     *
     * @throws InvalidMap
     */
    @Test
    public void testMapValidation() throws InvalidMap {
        file = new File(classLoader.getResource("world.map").getFile());
        hmap = mapReader.readMapFile(file);
        assertEquals(hmap.getContinents().size(), 6);
    }

    /**
     * This method tests countries which are in the same continent.
     *
     * @throws InvalidMap (Exception)
     */
    @Test(expected = InvalidMap.class)
    public void testCountriesInTheSameContinent() throws InvalidMap {
        file = new File(classLoader.getResource(invalidFiles[4]).getFile());
        mapReader.readMapFile(file);
    }

    /**
     * This method tests Countries which do not have border.
     *
     * @throws InvalidMap (Exception)
     */
    @Test(expected = InvalidMap.class)
    public void testCountriesWithoutBorder() throws InvalidMap {
        file = new File(classLoader.getResource(invalidFiles[2]).getFile());
        mapReader.readMapFile(file);
    }

    /**
     * This method tests countries which are assigned to two continents.
     *
     * @throws InvalidMap (Exception)
     */
    @Test(expected = InvalidMap.class)
    public void testCountriesWithTwoContinents() throws InvalidMap {
        file = new File(classLoader.getResource(invalidFiles[1]).getFile());
        mapReader.readMapFile(file);
    }

    /**
     * This method tests countries which are not assigned to any continent.
     *
     * @throws InvalidMap (Exception)
     */
    @Test(expected = InvalidMap.class)
    public void testCountriesWithoutContinents() throws InvalidMap {
        file = new File(classLoader.getResource(invalidFiles[3]).getFile());
        mapReader.readMapFile(file);
    }
}


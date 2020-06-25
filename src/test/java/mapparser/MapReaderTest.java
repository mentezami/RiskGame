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
 * This is a test class for testing the methods in the MapReader class.
 *
 * @see MapReader
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class MapReaderTest {

    static File file;
    MapReader mapReader;
    Hmap hmap;
    ClassLoader classLoader;
    String[] invalidFiles = { "world.map", "country_with_two_continents.map",
            "country_without_border.map", "country_without_continent.map",
            "countries_in_same_continent.map" };

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
        mapReader = new MapReader();
        hmap = new Hmap();
        classLoader = getClass().getClassLoader();
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


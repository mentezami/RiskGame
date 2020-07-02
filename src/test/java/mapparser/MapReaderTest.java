package mapparser;

import static org.junit.Assert.*;
import exception.InvalidMap;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.*;
import java.util.Objects;
import entity.Hmap;

/**
 * This is a test class for testing the methods in the MapReader class.
 *
 * @see MapReader
 * @author Mahmoudreza
 * @version 0.0.3
 */
public class MapReaderTest {

    File file;
    MapReader mapReader;
    Hmap hmap;
    ClassLoader classLoader;
    String[] mapFiles = { "world.map", "country_with_two_continents.map",
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
     * This method tests readMapFileTest method for MapReader class.
     *
     * @throws InvalidMap (Exception)
     */
    @Test
    public void readMapFileTest() throws InvalidMap {
        //first initialize a file object to store a map file.
        file = new File(Objects.requireNonNull(classLoader.getResource(mapFiles[0])).getFile());

        //run this to check whether the readMapFile method reads the map file.
        assertNotNull(mapReader.readMapFile(file));
        System.out.println("\"assertNotNull\" is passed to test whether " +
                "the map file is read by readMapFile method. \n");
    }

    /**
     * This method tests readMapFile methods by passing a map file with country with two continents.
     *
     */
    @Test
    public void readMapFileCountryWithTwoContinentsTest() {

        try {
            //first initialize a file object to store a map file with country with two continents.
            file = new File(Objects.requireNonNull(classLoader.getResource(mapFiles[1])).getFile());
            mapReader.readMapFile(file);

            //run this to check whether the readMapFile method reads the map file with country with two continents.
            assertNotNull(mapReader.readMapFile(file));
            System.out.println("\"assertNotNull\" is passed to test whether " +
                    "the map file with \"country with two continents\" is read by \"readMapFile\" method. \n");

        } catch (InvalidMap e) {
            System.out.println("This testing method is failed to test whether " +
                    "the map file with \"country with two continents\"" +
                    " is read by \"readMapFile\" method. \n");
        }
    }

    /**
     * This method tests readMapFile methods by passing a map file with countries without border.
     *
     */
    @Test
    public void readMapFileCountriesWithoutBorderTest() {

        try {
            //first initialize a file object to store a map file with countries without border.
            file = new File(Objects.requireNonNull(classLoader.getResource(mapFiles[2])).getFile());
            mapReader.readMapFile(file);

            //run this to check whether the readMapFile method reads the map file with countries without border.
            assertNotNull(mapReader.readMapFile(file));
            System.out.println("\"assertNotNull\" is passed to test whether " +
                    "the map file with \"countries without border\" is read by \"readMapFile\" method. \n");

        } catch (InvalidMap e) {
            System.out.println("This testing method is failed to test whether " +
                    "the map file with \"countries without border\"" +
                    " is read by \"readMapFile\" method. \n");
        }
    }

    /**
     * This method tests readMapFile methods by passing a map file with countries without continents.
     *
     */
    @Test
    public void readMapFileCountriesWithoutContinentsTest() {

        try {
            //first initialize a file object to store a map file with countries without continents.
            file = new File(Objects.requireNonNull(classLoader.getResource(mapFiles[3])).getFile());
            mapReader.readMapFile(file);

            //run this to check whether the readMapFile method reads the map file with countries without continents.
            assertNotNull(mapReader.readMapFile(file));
            System.out.println("\"assertNotNull\" is passed to test whether " +
                    "the map file with \"countries without continents\" is read by \"readMapFile\" method. \n");

        } catch (Exception e) {
            System.out.println("This testing method is failed to test whether " +
                    "the map file with \"countries without continents\"" +
                    " is read by \"readMapFile\" method. \n");
        }
    }

    /**
     * This method tests readMapFile methods by passing a map file with countries in the same continent.
     *
     */
    @Test
    public void readMapFileCountriesInTheSameContinentTest() {

        try {
            //first initialize a file object to store a map file with countries in the same continent.
            file = new File(Objects.requireNonNull(classLoader.getResource(mapFiles[4])).getFile());
            mapReader.readMapFile(file);

            //run this to check whether the readMapFile method reads the map file with countries in the same continent.
            assertNotNull(mapReader.readMapFile(file));
            System.out.println("\"assertNotNull\" is passed to test whether " +
                    "the map file with \"countries in the same continent\" is read by \"readMapFile\" method. \n");

        } catch (InvalidMap e) {
            System.out.println("This testing method is failed to test whether " +
                    "the map file with \"countries in the same continent\"" +
                    " is read by \"readMapFile\" method. \n");
        }
    }
}


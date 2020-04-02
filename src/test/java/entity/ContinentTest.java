package entity;



import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import entity.Continent;


public class ContinentTest {

        Continent continent = null;

        @BeforeClass
        public static void beforeAllTesting() {
            System.out.println("This is before testing");
        }

        @Before
        public void beforeTest() {
            continent = new Continent();
        }

        @AfterClass
        public static void afterPerformingTests() {
            System.out.println("The test is done");
        }

        @Test
        public void testGetColor() {
            assertNull(continent.getColor());
            System.out.println("'assertNull' test for getColor method is passed");
            assertNotEquals("Red", continent.getColor());
            System.out.println("'assertNotEqual' test for getColor method is passed");
        }

        @Test
        public void testGetName() {
            assertNull(continent.getName());
            System.out.println("'assertNull' test for getName method is passed");
            assertNotEquals("Advance Programming", continent.getName());
            System.out.println("'assertNotEqual' test for getName method is passed");
        }

    }



package entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * This is a test class for testing CardType enum.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class CardTypeTest {
    /*
    There are three types of card in CardType enum.
    list the the types in a array.
     */
    CardType[] cardTypesArray = {CardType.INFANTRY, CardType.CAVALRY, CardType.ARTILLERY};

    /**
     * This method runs before all test methods.
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("The test method is started. \n");
    }

    /**
     * This method runs after all methods.
     *
     */
    @AfterClass
    public static void afterAllTesting() {
        System.out.println("The test is done.");
    }

    /**
     * This method tests entities in CardType enum.
     *
     */
    @Test
    public void cardTypesTest() {
        assertArrayEquals(cardTypesArray, CardType.values());
        System.out.println("\"assertArrayEquals\" is passed to test CardType enum. \n");
    }
}

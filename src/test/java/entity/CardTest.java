package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/**
 * This is a Test Class for testing card
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class CardTest {

    Card card_INFANTRY;
    Card card_CAVALRY;
    Card card_ARTILLERY;

    /**
     * This method runs before all test methods only one times.
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("This is before testing");
    }

    /**
     * This Method runs before test methods.
     *
     */
    @Before
    public void beforeTest() {
        card_INFANTRY = new Card(CardType.INFANTRY);
        card_CAVALRY = new Card(CardType.CAVALRY);
        card_ARTILLERY = new Card(CardType.ARTILLERY);
    }

    /**
     * This method run after all test methods only one time.
     *
     */
    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("The test is done");
    }

    /**
     * This method test get card INFANTRY type.
     *
     */
    @Test
    public void testCardINFANTRY() {
        assertNotNull(card_INFANTRY.getCardType());
        System.out.println("Card INFANTRY test is passed");
    }

    /**
     * This method test get card CAVALRY type.
     *
     */
    @Test
    public void testCardCAVALRY() {
        assertNotNull(card_CAVALRY.getCardType());
        System.out.println("Card CAVALRY test is passed");
    }

    /**
     * This method test get card ARTILLERY type.
     *
     */
    @Test
    public void testCardARTILLERY() {
        assertNotNull(card_ARTILLERY.getCardType());
        System.out.println("Card ARTILLERY test is passed");
    }
}



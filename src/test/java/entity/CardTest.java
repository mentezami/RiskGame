package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class CardTest {

    Card card_INFANTRY;
    Card card_CAVALRY;
    Card card_ARTILLERY;

    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("This is before testing");
    }

    @Before
    public void beforeTest() {
        card_INFANTRY = new Card(CardType.INFANTRY);
        card_CAVALRY = new Card(CardType.CAVALRY);
        card_ARTILLERY = new Card(CardType.ARTILLERY);
    }

    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("The test is done");
    }

    @Test
    public void testCardINFANTRY() {
        assertNotNull(card_INFANTRY.getCardType());
        System.out.println("Card INFANTRY test is passed");
    }
    @Test
    public void testCardCAVALRY() {
        assertNotNull(card_CAVALRY.getCardType());
        System.out.println("Card CAVALRY test is passed");
    }

    @Test
    public void testCardARTILLERY() {
        assertNotNull(card_ARTILLERY.getCardType());
        System.out.println("Card ARTILLERY test is passed");
    }
}



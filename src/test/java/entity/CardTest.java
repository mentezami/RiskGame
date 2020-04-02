package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class CardTest {


        Card card_CAVALRY;

        @BeforeClass
        public static void beforeAllTesting() {
            System.out.println("This is before testing");
        }

        @Before
        public void beforeTest() {
            card_CAVALRY = new Card(CardType.CAVALRY);
        }

        @AfterClass
        public static void afterPerformingTests() {
            System.out.println("The test is done");
        }

        @Test
        public void testGetCardType() {
            assertNotNull(card_CAVALRY.getCardType());
            System.out.println("'AssertNotNull' Test is passed");
        }

    }



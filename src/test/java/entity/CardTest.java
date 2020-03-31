package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class CardTest {


        Card card = null;

        @BeforeClass
        public static void beforeAllTesting() {
            System.out.println("This is before testing");
        }

        @Before
        public void beforeTest() {
            card = new Card(CardType.CAVALRY);
            card = new Card(CardType.ARTILLERY);
            card = new Card(CardType.INFANTRY);
        }

        @AfterClass
        public static void afterPerformingTests() {
            System.out.println("The test is done");
        }

        @Test
        public void testGetCardKind() {
            assertNotNull(card.getCardType());
            System.out.println("'AssertNotNull' Test is passed");
        }

    }



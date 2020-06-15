package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/**
 * This is a test class for testing the methods in the Card class.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
public class CardTest {

    CardType cardTypeOne;
    CardType cardTypeTwo;
    CardType cardTypThree;
    Card card;
    Country country;

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
        cardTypeOne = CardType.INFANTRY;
        cardTypeTwo = CardType.CAVALRY;
        cardTypThree = CardType.ARTILLERY;
        country = new Country();
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
     * This method tests getCardType method for Card class.
     *
     */
    @Test
    public void getCardTypeTest() {
        /*
        There are there type of cards.
        first, initialize the card object
        by pass the first type of card to to the constructor of Card class.
         */
        card = new Card(cardTypeOne);
        assertSame(cardTypeOne, card.getCardType());
        System.out.println("\"assertSame\" is passed to test getCardType method. \n");

        //initialize the card object by passing the second type of card to the constructor of Card class.
        card = new Card(cardTypeTwo);
        assertSame(cardTypeTwo, card.getCardType());
        System.out.println("\"assertSame\" is passed to test getCardType method. \n");

        //initialize the card object by passing the third type of card to the constructor of Card class.
        card = new Card(cardTypThree);
        assertSame(cardTypThree, card.getCardType());
        System.out.println("\"assertSame\" is passed to test getCardType method. \n");
    }

    /**
     * This method tests getCountryToWhichCardBelong method for Card class.
     *
     */
    @Test
    public void getCountryToWhichCardBelongTest() {
        //first, initialize the card object and define the country name.
        card = new Card(cardTypeOne);
        country.setName("Canada");
        card.setCountryToWhichCardBelong(country);

        assertEquals(country, card.getCountryToWhichCardBelong());
        System.out.println("\"assertEquals\" is passed to test getCountryToWhichCardBelong method. \n");
    }
}



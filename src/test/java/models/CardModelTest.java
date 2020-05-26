package models;

import entity.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in the CardModels class.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class CardModelTest {

    CardModel cardModel;
    Country country;
    Card card;
    Continent continent;
    Hmap map;
    Player player;
    String countryName = "Canada";
    String continentName = "North America";
    int continentValue = 1;
    ArrayList<Country> countryList;
    List<Continent> continentList;
    Stack<Card> stackOfCards;
    List<Card> cardList;

    /**
     * This method runs before all test methods.
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("The test methods are started \n");
    }

    /**
     * This method runs before each test method to initialize the objects.
     *
     */
    @Before
    public void beforeEachTest() {
        cardModel = new CardModel();
        country = new Country();
        continent = new Continent(continentName, continentValue);
        map = new Hmap();
        player = new Player(1,"Player One");
        countryList = new ArrayList<>();
        continentList = new ArrayList<>();
        stackOfCards = new Stack<>();
        cardList = new ArrayList<>();
    }

    /**
     * This method runs after all methods.
     *
     */
    @AfterClass
    public static void afterAllTesting() {
        System.out.println("The tests are done");
    }

    /**
     * This method tests getCardsToBeExchange method for CardModel class.
     *
     */
    @Test
    public void getCardsToBeExchangeTest() {
        country.setName(countryName);
        card = new Card(CardType.CAVALRY);
        card.setCountryToWhichCardBelong(country);
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);
        cardModel.setCardsToBeExchange(cardList);

        assertEquals(cardModel.getCardsToBeExchange(),cardList);
        System.out.println("\"assertEquals\" is passed to test getCardsToBeExchange method. \n");
    }

    /**
     * This method tests allocateCardsToCountry method for CardModel class.
     *
     */
    @Test
    public void allocateCardsToCountryTest() {
        country.setName(countryName);
        countryList.add(country);
        map.setCountries(countryList);

        //run this to make sure stackOfCards is empty.
        assertTrue(stackOfCards.empty());
        System.out.println("\"assertTrue\" is passed to test whether stackOfCards is empty. \n");

        //then run this to allocate Cards To Country that will be stored in stackOfCards.
        cardModel.allocateCardsToCountry(map,stackOfCards);

        assertFalse(stackOfCards.empty());
        System.out.println("\"assertFalse\" is passed to test allocateCardsToCountry method" +
                " and whether stackOfCards is still empty. \n");
    }

    /**
     * This method tests exchangeCards method for CardModel class.
     *
     */
    @Test
    public void exchangeCardsTest() {
        country.setName(countryName);
        card = new Card(CardType.CAVALRY);
        card.setCountryToWhichCardBelong(country);
        cardList.add(card);

        //run this to make sure stackOfCards is empty.
        assertTrue(stackOfCards.empty());
        System.out.println("\"assertTrue\" is passed to test whether stackOfCards is empty. \n");

        /*
        run this to make sure the number of times for card is exchanged.
        The default number start from 5.
        */
        assertEquals(cardModel.getCardExchanged(), 5);
        System.out.println("\"assertEquals\" is passed to test the number of times for cardExchanged" +
                " which is 5 by default. \n");

        //run this to make sure the number of assigned army to the player is Zero.
        assertSame(player.getArmies(),0);
        System.out.println("\"assertSame\" is passed to test whether the number of assigned army" +
                " to the player is Zero. \n");

        /*
        run this to allocate Cards To Country, armies to Player and those will be stored stackOfCards.
         */
        cardModel.exchangeCards(player,cardList,stackOfCards);

        assertFalse(stackOfCards.empty());
        System.out.println("\"assertFalse\" is passed to test exchangeCards method and whether " +
                "stackOfCards is still empty. \n");

        assertNotEquals(cardModel.getCardExchanged(), 5);
        System.out.println("\"assertNotEquals\" is passed to test whether the number of times for" +
                " cardExchanged is changed after run exchangeCards method. \n");

        assertNotSame(player.getArmies(),0);
        System.out.println("\"assertNotSame\" is passed to test whether the number of assigned army" +
                " to the player is changed. \n");
    }

    /**
     * This method tests areCardsValidForExchange method for CardModel class.
     *
     */
    @Test
    public void areCardsValidForExchangeTest() {
        card = new Card(CardType.INFANTRY);
        cardList.add(card);
        card = new Card(CardType.CAVALRY);
        cardList.add(card);
        card = new Card(CardType.ARTILLERY);
        cardList.add(card);

        assertTrue(cardModel.areCardsValidForExchange(cardList));
        System.out.println("\"assertTrue\" is passed to test areCardsValidForExchange method. \n");
    }
}
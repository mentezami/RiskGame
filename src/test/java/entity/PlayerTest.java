package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * This is a test class for testing the methods in the Player class.
 *
 * @see Player
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class PlayerTest {

    Player player;
    Card card;
    Country country;
    List<Card> cardList;

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
        player = new Player(1, "Player");
        country = new Country();
        cardList = new ArrayList<>();
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
     * This method tests getCardList method for Player class.
     *
     */
    @Test
    public void getCardListTest() {
        //first run this to make sure the list of card for the player is empty.
        assertTrue(player.getCardList().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no card set to the player. \n");

        //declare a card.
        card = new Card(CardType.ARTILLERY);

        //declare and add a country to a card.
        country.setName("Canada");
        card.setCountryToWhichCardBelong(country);

        //add the card to the list.
        cardList.add(card);

        //run this to set cardList.
        player.setCardList(cardList);

        assertFalse(player.getCardList().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getCardList method. \n");
    }

    /**
     * This method tests getId method for Player class.
     *
     */
    @Test
    public void getIdTest() {
        player.setId(2);

        assertEquals(2, player.getId());
        System.out.println("\"assertEquals\" is passed to test getId method. \n");
    }

    /**
     * This method tests getName method for Player class.
     *
     */
    @Test
    public void getNameTest() {
        player.setName("Player Test");

        assertEquals("Player Test", player.getName());
        System.out.println("\"assertEquals\" is passed to test getName method. \n");
    }

    /**
     * This method tests getArmies method for Player class.
     *
     */
    @Test
    public void getArmiesTest() {
        player.setArmies(10);

        assertEquals(10, player.getArmies());
        System.out.println("\"assertEquals\" is passed to test getArmies method. \n");
    }

    /**
     * This method tests getAssignedCountry method for Player class.
     *
     */
    @Test
    public void getAssignedCountryTest() {
        //first run this to make sure the list of assigned country to the player is empty.
        assertTrue(player.getAssignedCountry().isEmpty());
        System.out.println("\"assertTrue\" is passed to test whether " +
                "there is no country assigned to the player. \n");

        //declare a country.
        country.setName("Canada");

        //run this to assign the country to the player.
        player.setAssignedCountry(country);

        assertFalse(player.getAssignedCountry().isEmpty());
        System.out.println("\"assertFalse\" is passed to test getAssignedCountry method. \n");
    }

    /**
     * This method tests getNumberOfTimeCardsExchanged method for Player class.
     *
     */
    @Test
    public void getNumberOfTimeCardsExchangedTest() {
        player.setNumberOfTimesCardsExchanged(1);

        assertEquals(1, player.getNumberOfTimeCardsExchanged());
        System.out.println("\"assertEquals\" is passed to test " +
                "getNumberOfTimeCardsExchanged method. \n");
    }
}


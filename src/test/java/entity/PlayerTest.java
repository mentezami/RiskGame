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
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class PlayerTest {

    Player player;

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
        //declare a card
        Card card = new Card(CardType.ARTILLERY);

        //declare and set a country to a card
        Country country = new Country();
        country.setName("Canada");
        card.setCountryToWhichCardBelong(country);

        //add the card to the list
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);

        //run this to set cardList
        player.setCardList(cardList);

        assertEquals(player.getCardList().size(), 1);
        System.out.println("\"assertEquals\" is passed to test getCardList method" +
                " which returns a variable with type of \"List\", so this method tests" +
                " size of the list. \n");
    }

    /**
     * This method tests getId method for Player class.
     *
     */
    @Test
    public void getIdTest() {
        player.setId(2);

        assertEquals(player.getId(), 2);
        System.out.println("\"assertEquals\" is passed to test getId method. \n");
    }

    /**
     * This method tests getName method for Player class.
     *
     */
    @Test
    public void getNameTest() {
        player.setName("Mahmoudreza");

        assertEquals(player.getName(), "Mahmoudreza");
        System.out.println("\"assertEquals\" is passed to test getName method. \n");
    }

    /**
     * This method tests getArmies method for Player class.
     *
     */
    @Test
    public void getArmiesTest() {
        player.setArmies(10);

        assertEquals(player.getArmies(), 10);
        System.out.println("\"assertEquals\" is passed to test getArmies method. \n");
    }

    /**
     * This method tests getAssignedCountry method for Player class.
     *
     */
    @Test
    public void getAssignedCountryTest() {
        //declare a country
        Country country = new Country();
        country.setName("Canada");

        //run this to assign the country to the player
        player.setAssignedCountry(country);

        assertEquals(player.getAssignedCountry().size(), 1);
        System.out.println("\"assertEquals\" is passed to test getAssignedCountry method" +
                " which returns a variable with type of \"List\", so this method tests" +
                " size of the list. \n");
    }

    /**
     * This method tests getNumberOfTimeCardsExchanged method for Player class.
     *
     */
    @Test
    public void getNumberOfTimeCardsExchangedTest() {
        player.setNumberOfTimesCardsExchanged(1);

        assertEquals(player.getNumberOfTimeCardsExchanged(), 1);
        System.out.println("\"assertEquals\" is passed to test getArmies method. \n");
    }
}


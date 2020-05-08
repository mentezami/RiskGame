package models;

import static org.junit.Assert.*;
import entity.Continent;
import org.junit.*;
import entity.Country;
import entity.Player;

public class PlayerModelTest {

    Player player;
    PlayerModel playerModel;

    /**
     * This method executed before all the methods of the class.
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("This is for testing Player Class");
    }

    /**
     * This method is executed before every method of the class.
     */
    @Before
    public void beforeTest() {
        player = new Player(4, "TestPlayer");
        playerModel = new PlayerModel();
    }

    /**
     * This method runs After All Testing
     */
    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("The tests are done");
    }

    /**
     * This method tests 3 reinforce armies
     */
    @Test
    public void testThreeReinforceArmiesForPLayer() {

        for (int idx = 0; idx < 8; idx++) {
            Country c1 = new Country();
            Continent con1 = new Continent();
            c1.setBelongToContinent(con1);
            player.getAssignedCountry().add(c1);
        }

        int armies = playerModel.countReinforcementArmies(player);

        assertEquals(3, armies);
    }

    /**
     * This method tests more than 3 reinforce armies
     */
    @Test
    public void testReinforceArmiesCountForPLayer() {

        for (int idx = 0; idx < 25; idx++) {
            Country c1 = new Country();
            Continent con1 = new Continent();
            c1.setBelongToContinent(con1);
            player.getAssignedCountry().add(c1);
        }

        int armies = playerModel.countReinforcementArmies(player);
        assertEquals(8, armies);
    }
}
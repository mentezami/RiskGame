package playerparser;

import static org.junit.Assert.*;
import org.junit.*;
import entity.Country;
import entity.Player;

/**
 * This is a test class for PlayerCommands class.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class PlayerCommandsTest {

    Player player;
    PlayerCommands playerCommands;

    /**
     * This method is executed before all the methods in the class.
     *
     */
    @BeforeClass
    public static void beforeAllTesting() {
        System.out.println("This is for testing Player Class");
    }

    /**
     * This method is executed before every method in the class.
     *
     */
    @Before
    public void beforeTest() {
        player = new Player(4, "TestPlayer");
        playerCommands = new PlayerCommands();
    }

    /**
     * This method runs After All testing methods.
     *
     */
    @AfterClass
    public static void afterPerformingTests() {
        System.out.println("The tests are done");
    }

    /**
     * This method tests 3 reinforce armies.
     *
     */
    @Test
    public void testThreeReinforceArmiesForPLayer() {

        for (int idx = 0; idx < 8; idx++)
            player.getAssignedCountry().add(new Country());

        int armies = playerCommands.countReinforcementArmies(player);
        assertEquals(3, armies);
    }

    /**
     * This method tests more than 3 reinforce armies.
     *
     */
    @Test
    public void testReinforceArmiesCountForPLayer() {

        for (int idx = 0; idx < 25; idx++)
            player.getAssignedCountry().add(new Country());

        int armies = playerCommands.countReinforcementArmies(player);
        assertEquals(8, armies);
    }
}




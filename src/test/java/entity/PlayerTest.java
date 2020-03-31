package entity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

        Player player;

        @BeforeClass
        public static void beforeAllTesting() {
            System.out.println("This is for testing Player Class");
        }

        @Before
        public void beforeTest() {
            player = new Player(10, "Player");
        }

        @AfterClass
        public static void afterPerformingTests() {
            System.out.println("The tests are done");
        }

        @Test
        public void testGetId() {
            assertEquals(10, player.getId());
            System.out.println("'assertEquals' test for getId method is passed");

            assertTrue(player.getId() == 10);
            System.out.println("'assertTrue' test for getId method is passed");

            assertNotEquals(12, player.getId());
            System.out.println("'assertNotEquals' test for getId method is passed");
        }

    }


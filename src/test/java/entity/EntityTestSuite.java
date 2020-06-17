package entity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is a Test suite Class for all classes in Entity package.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
@RunWith(Suite.class)
@SuiteClasses({CardTest.class, CardTypeTest.class,
        ContinentTest.class, CountryTest.class, HmapTest.class, PlayerTest.class})
public class EntityTestSuite {
}

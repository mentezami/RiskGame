package entity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is a Test suite Class for testing Entity
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
@RunWith(Suite.class)
@SuiteClasses({CardTest.class, ContinentTest.class, CountryTest.class, PlayerTest.class})
public class EntityTestSuite {
}

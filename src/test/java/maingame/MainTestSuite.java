package maingame;

import models.PlayerModelTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import entity.EntityTestSuite;
import mapparser.MapParserTestSuite;

/**
 *This is a Test suite Class for all packages.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
@RunWith(Suite.class)
@SuiteClasses({ EntityTestSuite.class, MapParserTestSuite.class, PlayerModelTestSuite.class })
public class MainTestSuite {
}
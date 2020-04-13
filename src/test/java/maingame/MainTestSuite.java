package maingame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import entity.EntityTestSuite;
import mapparser.MapParserTestSuite;
import playerparser.PlayerParserTestSuite;

/**
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
@RunWith(Suite.class)
@SuiteClasses({ EntityTestSuite.class, MapParserTestSuite.class, PlayerParserTestSuite.class })
public class MainTestSuite {
}

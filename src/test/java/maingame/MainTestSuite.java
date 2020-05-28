package maingame;

import controller.ControllerTestSuite;
import models.ModelsTestSuite;
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
@SuiteClasses({ ControllerTestSuite.class, EntityTestSuite.class, MapParserTestSuite.class, ModelsTestSuite.class })
public class MainTestSuite {
}
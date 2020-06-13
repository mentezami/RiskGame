package models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is a Test suite Class for all classes in Models package.
 *
 * @author Mahmoudreza
 * @version 0.0.2
 */
@RunWith(Suite.class)
@SuiteClasses({ CardModelTest.class, DiceModelTest.class, PlayerModelTest.class })
public class ModelsTestSuite {
}
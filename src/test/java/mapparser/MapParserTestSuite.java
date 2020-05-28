package mapparser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is a Test Suite Class for testing all classes in MapParser package.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
@RunWith(Suite.class)
@SuiteClasses({MapReaderTest.class, MapVerifierTest.class})
public class MapParserTestSuite {
}

package JUnitTestRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testsByJunit4.*;

@RunWith(Suite.class)
@SuiteClasses( {
        PageObjectModelTest.class,
        SinglePageTest.class
} )

public class TestRunnerJUnit4 {
}

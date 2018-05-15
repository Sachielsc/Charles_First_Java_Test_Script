package JUnitTestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testsByJunit.SinglePageTest;

@RunWith(Suite.class)
@SuiteClasses( {
        SinglePageTest.class
} )

public class TestRunner {
}

package testSuites;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/13/14
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */

import nexusSmokeTests.ContentBasicNavigationTest;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = {
        ContentBasicNavigationTest.class
})

public class SmokeTestSuite {
}

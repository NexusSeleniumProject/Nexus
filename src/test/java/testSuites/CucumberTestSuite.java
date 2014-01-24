package testSuites;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/23/14
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@Cucumber.Options(features = "BasicNavigation.feature")
public class CucumberTestSuite {


}

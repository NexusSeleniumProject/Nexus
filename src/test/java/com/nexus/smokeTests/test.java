package com.nexus.smokeTests;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/27/14
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(

        features = "testone",//path to the features
        format = {"json:target/integration_cucumber.json"},//what formatters to use
        tags = {"@login"})//what tags to incluse(@)/exclude(@~)
public class test {
}


package com.nexus.smokeTests;

import base.BaseTest;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ui.model.NexusArticleDetailedScreen;
import ui.model.NexusLoginScreen;
import ui.model.NexusMainConsolidatedViewScreen;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/24/14
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasicNavigation {

    @Given("^Start An Application$")
    public static void startApplication(){
        BaseTest.setUp();
    }

    @When("^Login In Application with login '(.+)' and password= '(.+)'$")
    public static void loginInApplication(String login, String password) throws InterruptedException{
        NexusLoginScreen.doLogin(login, password);
    }

    @And("^Verify Consolidated View$")
    public static void verifyConsolidatedView(){
        NexusMainConsolidatedViewScreen.verifyConsolidatedView();
    }

    @And("^Open Latest News$")
    public static void openLatestNews(){
        NexusMainConsolidatedViewScreen.openLatestNews();
    }

    @Then("^Open Nexus Main Page$")
    public static void openNexusMainPage(){
        NexusMainConsolidatedViewScreen.openNexusMainPage();
    }

    @And("^Click At the First Most Popular Article$")
    public static void clickAtFirstMostPopularArticle(){
        NexusMainConsolidatedViewScreen.clickAtFirstMostPopularArticle();
    }

    @When("^Click At the First Latest Bookmart Article$")
    public static void clickAtFirstLatestBookmartArticle(){
        NexusMainConsolidatedViewScreen.clickAtFirstLatestBookmartArticle();
    }

    @And("^Click At the First Latest Reasearch Article$")
    public static void clickAtFirstLatestReasearchArticle(){
        NexusMainConsolidatedViewScreen.clickAtFirstLatestReasearchArticle();
    }

    @And("^Click At the First Latest Product Article$")
    public static void clickAtFirstLatestProductArticle(){
        NexusMainConsolidatedViewScreen.clickAtFirstLatestProductArticle();
    }


    @And("^Verify PDF Viewer Is Open$")
    public static void verifyPDFViewverIsOpened(){
        NexusArticleDetailedScreen.verifyPDFViewverIsOpened();
    }

    @And("^Click At First Article Header Product Section$")
    public static void clickAtFirstArticleHeaderProductSection() throws  InterruptedException{
        NexusArticleDetailedScreen.clickAtFirstArticleHeaderProductSection();
    }

    @And("^Click At First Article Header Research Section$")
    public static void clickAtFirstArticleHeaderResearchSection() throws  InterruptedException{
        NexusArticleDetailedScreen.clickAtFirstArticleHeaderResearchSection();
    }

    @And("^Verify Basic Attributes On Detailed View$")
    public static void verifyBasicAttributesOnArticleDetailsScreen() {
        NexusArticleDetailedScreen.verifyBasicAttributesOnArticleDetailsScreen();
    }



}

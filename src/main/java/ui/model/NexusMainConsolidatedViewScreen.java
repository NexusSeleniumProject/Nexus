package ui.model;

import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import toolkit.WaitMode;
import toolkit.controls.UIElement;
import ui.map.NexusMainConsolidatedMap;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/15/14
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class NexusMainConsolidatedViewScreen {
    public static UIElement getLnkFiler () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_FILTER.getId())));
    }
    public static UIElement getLnkMyFunnels () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(String.format(NexusMainConsolidatedMap.SammaryPage.LNK_SIDE_MENU.getId(), "My Funnels"))));
    }
    public static UIElement getLnkBookmarks () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(String.format(NexusMainConsolidatedMap.SammaryPage.LNK_SIDE_MENU.getId(), "Bookmarks"))));
    }
    public static UIElement getLnkPublicBookmarks () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(String.format(NexusMainConsolidatedMap.SammaryPage.LNK_SIDE_MENU.getId(), "Public Bookmarks"))));
    }
    public static UIElement getLnkMarktUbersicht () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(String.format(NexusMainConsolidatedMap.SammaryPage.LNK_SIDE_MENU.getId(), "Markt Übersicht"))));
    }
    public static UIElement getLnkLatestNewsHeader () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_LATEST_NEWS_HEADER.getId())));
    }
    public static UIElement getLnkFirstMostPopularArticle () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_MOST_POPULAR_ARTICLE.getId("1"))));
    }
    public static UIElement getLnkFirstLatestBookmarkArticle () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_LATEST_BOOKMARK_ARTICLE.getId("1"))));
    }
    public static UIElement getLnkFirstLatestProductArticle () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_LATEST_PRODUCT_ARTICLE.getId("1"))));
    }
    public static UIElement getLnkFirstLatestReasearchArticle () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_LATEST_RESEARCH_ARTICLE.getId("1"))));
    }
    public static UIElement getLnkNexuxLogo () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusMainConsolidatedMap.SammaryPage.LNK_NEXUS_LOGO.getId())));
    }

    public static void verifyConsolidatedView(){
        // Verify Top Menu
        Assert.assertEquals("Top Menu isn`t present", true, getLnkFiler().isDisplayed());
        // Verify Side Menu
        Assert.assertEquals("Side Menu isn`t present", true, getLnkBookmarks().isDisplayed());
        Assert.assertEquals("Side Menu isn`t present", true, getLnkMyFunnels().isDisplayed());
        Assert.assertEquals("Side Menu isn`t present", true, getLnkPublicBookmarks().isDisplayed());
        Assert.assertEquals("Side Menu isn`t present", true, getLnkMarktUbersicht().isDisplayed());
        // Verify Latest News section
        NexusMainConsolidatedViewScreen.getLnkLatestNewsHeader().waitForAccessible(5000);
        Assert.assertEquals("Latest Section does not exists", true, getLnkLatestNewsHeader().isDisplayed());
        // Verify Most Popular section is not empty
        Assert.assertEquals(getLnkFirstMostPopularArticle().isDisplayed(), true);
        // Verify Latest Public Bookmarks is not empty
        Assert.assertEquals(getLnkFirstLatestBookmarkArticle().isDisplayed(), true);
        Assert.assertEquals(getLnkFirstLatestBookmarkArticle().isDisplayed(), true);
        // Verify Latest Products section is not empty
        //Assert.assertEquals(getLnkFirstLatestProductArticle().isDisplayed(), true);
        // Verify Latest Research section is not empty
        Assert.assertEquals(getLnkFirstLatestReasearchArticle().isDisplayed(), true);
    }

    public static void openLatestNews(){
       getLnkLatestNewsHeader().click(WaitMode.AJAX);
    }

    public static void openNexusMainPage(){
        NexusMainConsolidatedViewScreen.getLnkNexuxLogo().click(WaitMode.AJAX);
    }

    public static void clickAtFirstMostPopularArticle(){
        NexusMainConsolidatedViewScreen.getLnkFirstMostPopularArticle().click(WaitMode.AJAX);
    }

    public static void clickAtFirstLatestBookmartArticle(){
        NexusMainConsolidatedViewScreen.getLnkFirstLatestBookmarkArticle().click(WaitMode.AJAX);
    }

    public static void clickAtFirstLatestReasearchArticle(){
        NexusMainConsolidatedViewScreen.getLnkFirstLatestReasearchArticle().click(WaitMode.AJAX);
    }

    public static void clickAtFirstLatestProductArticle(){
        NexusMainConsolidatedViewScreen.getLnkFirstLatestProductArticle().click(WaitMode.AJAX);
    }
}

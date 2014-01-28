package ui.model;

import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import toolkit.WaitMode;
import ui.map.NexusArticleMap;
import toolkit.controls.UIElement;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/15/14
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */

public class NexusArticleDetailedScreen {
    public static UIElement getTxtTitle () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.TXT_TITLE.getId())));
    }
    public static UIElement getLnkSource () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_SOURCE.getId())));
    }
    public static UIElement getTxtArticleBody () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.TXT_ARTICLE_BODY.getId())));
    }
    public static UIElement getBtnFeedback () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.BTN_FEEDBACK.getId())));
    }
    public static UIElement getBtnSummary () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.BTN_SUMMARY.getId())));
    }
    public static UIElement getBtnShare () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.BTN_SHARE.getId())));
    }
    public static UIElement getBtnBookmark () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.BTN_BOOKMARK.getId())));
    }
    public static UIElement getLnkFirstArticleHeaderProductSection () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_ARTICLE_HEADER_PRODUCT_SECTION.getId("1"))));
    }
    public static UIElement getLnkFirstArticleHeaderResearchSection () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_ARTICLE_HEADER_RESEARCH_SECTION.getId("1"))));
    }
    public static UIElement getLnkFirstArticleBodyProductSection () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_ARTICLE_BODY_PRODUCT_SECTION.getId("1"))));
    }
    public static UIElement getLnkFirstArticleBodyResearchSection () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_ARTICLE_BODY_RESEARCH_SECTION.getId("1"))));
    }
    public static UIElement getLnkFirstTag () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_TAG.getId("1"))));
    }
    public static UIElement getLnkFirstRelatedNewsHeader () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.LNK_RELATED_NEWS_HEADER.getId("1"))));
    }
    public static UIElement getBtnTop () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.BTN_TOP.getId())));
    }

    public static UIElement getDivPDFViewer(){
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusArticleMap.MainPage.DIV_PDF_VIEWER.getId())));
    }

    public static void verifyPDFViewverIsOpened(){
        BaseTest.switchFrame(0);
        Assert.assertEquals(NexusArticleDetailedScreen.getDivPDFViewer().isDisplayed(), true);
        BaseTest.switchToDefault();
    }

    public static void clickAtFirstArticleHeaderProductSection() throws  InterruptedException{
    getLnkFirstArticleHeaderProductSection().click(WaitMode.AJAX);
    Thread.sleep(3000);
    }

    public static void clickAtFirstArticleHeaderResearchSection() throws  InterruptedException{
        getLnkFirstArticleHeaderResearchSection().click(WaitMode.AJAX);
        Thread.sleep(3000);
    }

    public static void verifyBasicAttributesOnArticleDetailsScreen() {
        Assert.assertEquals("Title isn`t present", true, NexusArticleDetailedScreen.getTxtTitle().isDisplayed());
        Assert.assertEquals("Source isn`t present", true, NexusArticleDetailedScreen.getLnkSource().isDisplayed());
        Assert.assertEquals("Article body isn`t present", true, NexusArticleDetailedScreen.getTxtArticleBody().isDisplayed());

        Assert.assertEquals("Feedback button isn`t present", true, NexusArticleDetailedScreen.getBtnFeedback().isDisplayed());
        Assert.assertEquals("Summary button isn`t present", true, NexusArticleDetailedScreen.getBtnSummary().isDisplayed());
        // Assert.assertEquals("Share button isn`t present", true, NexusArticleDetailedScreen.btnShare.isElementDisplayed());
        Assert.assertEquals("Bookmark button isn`t present", true, NexusArticleDetailedScreen.getBtnBookmark().isDisplayed());

        Assert.assertEquals("Product section is empty", true, NexusArticleDetailedScreen.getLnkFirstArticleHeaderProductSection().isDisplayed());
        Assert.assertEquals("Research section is empty", true, NexusArticleDetailedScreen.getLnkFirstArticleHeaderResearchSection().isDisplayed());
        Assert.assertEquals("Product section is empty", true, NexusArticleDetailedScreen.getLnkFirstArticleBodyProductSection().isDisplayed());
        Assert.assertEquals("Research section is empty", true, NexusArticleDetailedScreen.getLnkFirstArticleBodyResearchSection().isDisplayed());

        Assert.assertEquals("Article Categories section is empty", true, NexusArticleDetailedScreen.getLnkFirstTag().isDisplayed());
        Assert.assertEquals("Related News section is empty", true, NexusArticleDetailedScreen.getLnkFirstRelatedNewsHeader().isDisplayed());
        Assert.assertEquals("Top button isn`t present", true, NexusArticleDetailedScreen.getBtnTop().isDisplayed());
    }
}

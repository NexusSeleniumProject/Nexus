package ui.map;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/15/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */

public class NexusArticleMap {
    public enum MainPage {
        //Article Detailed Screen
        TXT_TITLE ("//div[@id='content']/section/h1/span"),
        LNK_SOURCE ("//div[@id='content']/section/div/p/a"),
        TXT_ARTICLE_BODY("//div[@id='content']/section/article/p/span"),
        BTN_FEEDBACK ("//div[@id='content']/section/div/ul/li[@class='feedback']/a/span"),
        BTN_SUMMARY ("//div[@id='content']/section/div/ul/li[@class='summary']/a/span"),
        BTN_SHARE ("//div[@id='content']/section/div/ul/li[@class='share']/a/span"),
        BTN_BOOKMARK ("//div[@id='content']/section/div/ul/li[@class='bookmark']/a/span"),
        LNK_ARTICLE_HEADER_PRODUCT_SECTION ("//div/h2[.='Products']//ancestor::section/article[:?:]/a/h1"),
        LNK_ARTICLE_HEADER_RESEARCH_SECTION ("//div/h2[.='Research']//ancestor::section/article[:?:]/a/h1"),
        LNK_ARTICLE_BODY_PRODUCT_SECTION ("//div/h2[.='Products']//ancestor::section/article[:?:]/a/p/img"),
        LNK_ARTICLE_BODY_RESEARCH_SECTION ("//div/h2[.='Research']//ancestor::section/article[:?:]/a/p/img"),
        LNK_TAG ("//div/h4[.='Article Categories']//ancestor::div/ul/li[:?:]/a"),
        LNK_RELATED_NEWS_HEADER ("//div/h4[.='Related News']//ancestor::div/ul/li[:?:]/a"),
        BTN_TOP ("//a[.='  TOP  ']"),
        DIV_PDF_VIEWER ("//div[@id='pageContainer1']"),
        ;

        String id;

        private MainPage(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public String getId(String number) {
            return id.replace(":?:", number);
        }


    }

    public static WebElement getElementByXpath(String elementName) {
        return  BaseTest.getDriver().findElement(By.xpath(elementName));
    }
}

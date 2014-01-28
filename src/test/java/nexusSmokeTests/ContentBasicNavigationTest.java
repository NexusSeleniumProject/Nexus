package nexusSmokeTests;

import base.BaseTest;

import org.junit.Test;
import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import ui.model.NexusLoginScreen;
import ui.model.NexusArticleDetailedScreen;
import ui.model.NexusMainConsolidatedViewScreen;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/21/14
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */

public class ContentBasicNavigationTest extends BaseTest {



    @Test
    public void doBasicNavigation() throws FindFailed, InterruptedException {
        NexusLoginScreen.doLogin("test.user1@test.com", "qwerty");

        Screen screen = new Screen();
        Pattern image = new Pattern("C:\\devtools\\login_button.PNG");
        screen.click(image);





        NexusMainConsolidatedViewScreen.verifyConsolidatedView();

        // 10. Click on an article from Latest News section
        NexusMainConsolidatedViewScreen.openLatestNews();

        // 11. Verify Basic attributes
        NexusArticleDetailedScreen.verifyBasicAttributesOnArticleDetailsScreen();

        // 20. Navigate to a related product
        NexusArticleDetailedScreen.clickAtFirstArticleHeaderProductSection();

        // 21. Verify PDF is Opened
        NexusArticleDetailedScreen.verifyPDFViewverIsOpened();

        // 22. Navigate to a related research
        NexusArticleDetailedScreen.clickAtFirstArticleHeaderResearchSection();

        // 23. Verify PDF is Opened
        NexusArticleDetailedScreen.verifyPDFViewverIsOpened();

        // Go to the Main Page
        NexusMainConsolidatedViewScreen.openNexusMainPage();

        // 25. Navigate to article via Most Popular
        NexusMainConsolidatedViewScreen.clickAtFirstMostPopularArticle();
        NexusArticleDetailedScreen.verifyBasicAttributesOnArticleDetailsScreen();

        // Go to the Main Page
        NexusMainConsolidatedViewScreen.openNexusMainPage();

        // 28. Navigate to article via Latest Bookmart
        NexusMainConsolidatedViewScreen.clickAtFirstLatestBookmartArticle();
        NexusArticleDetailedScreen.verifyBasicAttributesOnArticleDetailsScreen();

        // Go to the Main Page
        NexusMainConsolidatedViewScreen.openNexusMainPage();

        // 31. Navigate to article via Last Product screen
        // NexusMainConsolidatedViewScreen.clickAtFirstLatestProductArticle();
        // NexusArticleDetailedScreen.verifyBasicAttributesOnArticleDetailsScreen();

        // Go to the Main Page
        NexusMainConsolidatedViewScreen.openNexusMainPage();

        // 34. Navigate to article via Latest Reasearch screen
        NexusMainConsolidatedViewScreen.clickAtFirstLatestReasearchArticle();
        // NexusArticleDetailedScreen.verifyBasicAttributesOnArticleDetailsScreen();

        // Go to the Main Page
        NexusMainConsolidatedViewScreen.openNexusMainPage();
    }




}

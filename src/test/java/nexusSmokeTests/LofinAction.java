package nexusSmokeTests;

import base.BaseTest;
import org.junit.Test;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import ui.model.NexusLoginScreen;
import org.sikuli.script.FindFailed;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/29/14
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class LofinAction {

    @Test
    public void test() throws FindFailed, InterruptedException {
        BaseTest.setUp();    // Start browser and open application
        NexusLoginScreen.getInpUsername().setValue("test.user1@test.com");
        NexusLoginScreen.getInpPassword().setValue("qwerty");

        Screen screen = new Screen();
        Pattern image = new Pattern("C:\\devtools\\login_button.PNG");
        screen.click(image);
    }




}

package nexusSmokeTests;

import org.junit.Test;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/29/14
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class SkypeTest {

    public static String skypeDir = "C:\\Program Files (x86)\\Skype\\Phone\\Skype.exe";
    public static Pattern loginWindow = new Pattern("C:\\SkypeTest\\skype.PNG");
    public static Pattern loginInp = new Pattern("C:\\SkypeTest\\skype.PNG");
    public static Pattern passwordInp = new Pattern("C:\\SkypeTest\\password.PNG");
    public static Pattern signInBtn = new Pattern("C:\\SkypeTest\\signInButton.PNG");
    public static Pattern errorMessage = new Pattern("C:\\SkypeTest\\errorMessage.PNG");
    public static String login = "nikolajs.okunevs";
    public static String password = "********";
    public static Screen  screen = new Screen();

    @Test
    public void skypeLoginTest() throws FindFailed, InterruptedException, Exception{
       // Open Skype Applicaton
        App skype = App.open(skypeDir);
        // Screen class Initialization
        Screen screen = new Screen();
        // Wait till skype login sscreen is opened
        screen.wait(loginWindow);
        //
        // screen.type(loginInp, login);
        screen.type(passwordInp, password);
        screen.click(signInBtn);
        Settings se = new Settings();

        //se.OcrTextSearch=true;
        //se.OcrTextRead=true;
      //  Settings.OcrTextSearch=true;
      //  Settings.OcrTextRead=true;
        System.out.print(se.OcrTextRead);

        Region dropDownRegion = new Region(screen.getLastMatch().getX(),screen.getLastMatch().getY(),300,100);

        System.out.print(dropDownRegion.text());
        System.out.print(screen.text());

        elementWait();


     // skype.close();
    }

    public static void elementWait() throws Exception{
        System.out.println(screen.exists("C:\\SkypeTest\\errorMessage.PNG", 20));
      System.out.print(screen.find(errorMessage).text());
    }
}

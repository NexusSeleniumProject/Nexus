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
    public static Pattern first_foto = new Pattern("C:\\SkypeTest\\1_foto.PNG");
    public static Pattern base = new Pattern("C:\\SkypeTest\\base.PNG");
    public static Pattern screen1 = new Pattern("C:\\SkypeTest\\screen.PNG");
    public static Pattern sikuli_t = new Pattern("C:\\SkypeTest\\sikuli_t.PNG");
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
        screen.wait(passwordInp);
        //
        // screen.type(loginInp, login);
        screen.type(passwordInp, password);
        screen.click(signInBtn);

         Settings.OcrTextRead=true;
        Settings.OcrTextSearch=true;


        elementWait();


      skype.close();
    }

    public static void elementWait() throws Exception{
        System.out.println("111111111");
        System.out.println(screen.exists("C:\\SkypeTest\\errorMessage.PNG", 20));
        System.out.println(screen.find(errorMessage).text() + " - tekst");
        System.out.println("222222222222");
    }
}

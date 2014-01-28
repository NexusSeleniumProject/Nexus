package ui.model;

import base.BaseTest;
import toolkit.WaitMode;
import ui.map.NexusLoginMap;
import org.openqa.selenium.By;
import toolkit.controls.UIElement;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/15/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class NexusLoginScreen {

    public static UIElement getInpUsername () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusLoginMap.LoginPage.INP_USERNAME.getId())));
    }

    public static UIElement getInpPassword () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusLoginMap.LoginPage.INP_PASSWORD.getId())));
    }

    public static UIElement getBtnLogin () {
        return new UIElement(BaseTest.getDriver().findElement(By.xpath(NexusLoginMap.LoginPage.BTN_LOGIN.getId())));
    }

    public static void doLogin(String login,  String passwopd) throws InterruptedException{
        NexusLoginScreen.getInpUsername().setValue(login);
        NexusLoginScreen.getInpPassword().setValue(passwopd);
        Thread.sleep(2000);
      //  NexusLoginScreen.getBtnLogin().click(WaitMode.AJAX);
    }
 }

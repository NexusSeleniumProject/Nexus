package toolkit.controls;

import base.BaseTest;
import base.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import toolkit.WaitMode;

public class UIElement {

     protected int waitTimeout = Integer.parseInt(ConfigReader.getInstance().getValueByKey("waitTimeout"));
     protected int sleepTime = Integer.parseInt(ConfigReader.getInstance().getValueByKey("sleepTimeout"));
     protected WebElement locator;
     private final static Logger LOG = Logger.getLogger(UIElement.class);

     public UIElement(WebElement locator) {
        this.locator = locator;
     }

    public void setValue(String value){
        locator.sendKeys(value);
    }

     public void waitForPageUpdate(WaitMode waitMode) {
        switch (waitMode){
            case AJAX:
                waitForElementIsHidden(waitTimeout);
                break;
           case SLEEP:
                wait(sleepTime);
                break;
        }
     }

    /*public void waitForElement(){
            new WebDriverWait(driver, waitTimeout){

        }.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driverobejct) {
                    return isDisplayed();
                }
            });
    } */



    private static void waitForElementIsHidden(int waittime) {
        long t0, t1;
        wait(1000);
        t0 = System.currentTimeMillis();
        if (BaseTest.getDriver().findElements(By.xpath("//div[@ng-include=\"'/js/app/common/templates/loading.html'\"]/div/div[1]")).isEmpty()==false){

              new WebDriverWait(BaseTest.getDriver(), waittime){

              }.until(new ExpectedCondition<Boolean>() {
                  @Override
                  public Boolean apply( WebDriver webDriver) {
                      LOG.info(BaseTest.getDriver().findElement(By.xpath("//div[@ng-include=\"'/js/app/common/templates/loading.html'\"]/div/div[1]")).isDisplayed());
                      return BaseTest.getDriver().findElement(By.xpath("//div[@ng-include=\"'/js/app/common/templates/loading.html'\"]/div/div[1]")).isDisplayed()==false;
                  }
              });
        }
    }


     private static void wait(int n) {
        long t0, t1;
        t0 = System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        }
        while (t1-t0 < n);
     }

     public String getText(){
        return  locator.getText();
     }

     public String getGetAttribute(String attribute){
        return locator.getAttribute(attribute);
     }

     public void click(WaitMode waitmode){
         LOG.info("Do click action on: " + locator);
         locator.click();
         waitForPageUpdate(waitmode);
     }

     public boolean isDisplayed(){
        return  locator.isDisplayed();
     }

     public static boolean isPresent(WebElement locator){
        return  locator.isDisplayed();
     }

     public boolean isSelected() {
         return  locator.isSelected();
     }

     public boolean isEnabled() {
             return  locator.isEnabled();
     }

     public void waitForAccessible(int timeout){
        long t0, t1;
        t0 = System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        }while ((t1-t0 < timeout)&&!((this.isDisplayed())&&(this.isEnabled())));
     }
}

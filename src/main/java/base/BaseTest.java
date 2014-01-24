package base;


import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Before;
import org.junit.AfterClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseTest {

    private static String appURL = null;
    private static String browser = null;
    private static WebDriver driver = null;
    private static ConfigReader configReader= null;

    private final static Logger LOG = Logger.getLogger(BaseTest.class);


    protected static ConfigReader getConfigReader() {
        if (configReader==null){
            configReader= ConfigReader.getInstance();
        }
        return configReader;
    }

    @Before
    public void setUp() {
        LOG.info("Test");
        browser= getConfigReader().getValueByKey("browser");
        appURL= getConfigReader().getValueByKey("app_url");
        if (browser.equals("iexplorer")){
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            System.setProperty("webdriver.ie.driver", getConfigReader().getValueByKey("ieDriverDirectory"));
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,  true);
            driver = new InternetExplorerDriver(caps);
            driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } else if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", getConfigReader().getValueByKey("chromeDriverDirectory"));
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            System.setProperty("webdriver.firefox.bin", getConfigReader().getValueByKey("firefoxDriver"));
            driver = new FirefoxDriver();
        }
        LOG.info(appURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(appURL);
    }

    @AfterClass
    public static void stopSelenium() {
      //  driver.quit();
    }

    @Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();

    public static void switchFrame(int frameNumber){
       getDriver().switchTo().frame(frameNumber);
    }

    public static void switchToDefault(){
        getDriver().switchTo().defaultContent();
    }

    public static WebDriver getDriver(){
        return driver;
    }



}
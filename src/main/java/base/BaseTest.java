package base;

import org.junit.Rule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.apache.log4j.Logger;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    private static String appURL = null;
    private static WebDriver driver = null;
    private static ConfigReader configReader= null;
    public static Browsers browser;
    private final static Logger LOG = Logger.getLogger(BaseTest.class);

    protected static ConfigReader getConfigReader() {
        if (configReader==null){
            configReader= ConfigReader.getInstance();
        }
        return configReader;
    }

    @BeforeClass
    public static void setUp() {
        browser = Browsers.browserForName(getConfigReader().getValueByKey("browser"));
        appURL= getConfigReader().getValueByKey("app_url");
        switch(browser){
            case CHROME:
                driver = createChromeDriver();
                break;
            case IEXPLORER:
                driver = createIExplorerDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
        }
        LOG.info(appURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(appURL);
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", getConfigReader().getValueByKey("chromeDriverDirectory"));
        return new ChromeDriver();
    }

    private static WebDriver createIExplorerDriver() {
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        System.setProperty("webdriver.ie.driver", getConfigReader().getValueByKey("ieDriverDirectory"));
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,  true);
        return new InternetExplorerDriver(caps);
    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.firefox.bin", getConfigReader().getValueByKey("firefoxDriver"));
        return new FirefoxDriver();
    }

    @AfterClass
    public static void stopSelenium() {
        driver.quit();
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
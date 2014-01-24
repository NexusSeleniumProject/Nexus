package base;

import java.io.File;
import java.util.Calendar;
import org.apache.log4j.Logger;
import java.io.FileOutputStream;
import org.junit.rules.MethodRule;
import java.text.SimpleDateFormat;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.junit.runners.model.Statement;
import org.openqa.selenium.TakesScreenshot;
import org.junit.runners.model.FrameworkMethod;

class ScreenshotTestRule implements MethodRule {

    static String sp = File.separator;
    public static Calendar cal = Calendar.getInstance();
    public static String testScreenshotPath = "screenshots" + sp;
    private final static Logger LOG = Logger.getLogger(ScreenshotTestRule.class);

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    // exception will be thrown only when a test fails.
                    captureScreenshot(frameworkMethod.getName());
                    // rethrow to allow the failure to be reported by JUnit
                    throw t;
                }
            }

            public void captureScreenshot(String fileName) {
                try {
                    FileOutputStream fop = null;
                    File screenshot =  ((TakesScreenshot)BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File(testScreenshotPath + frameworkMethod.getName() + new SimpleDateFormat("dd.MM.yyyy").format(cal.getTime()) + ".png"));
                     fop = new FileOutputStream(screenshot);
                    fop.flush();
                    fop.close();
                } catch (Exception e) {

                }
            }
        };
    }
}
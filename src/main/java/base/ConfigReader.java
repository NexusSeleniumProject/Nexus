package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.junit.Assert;

/**
 * Created by Schiller on 10.01.14.
 */

public class ConfigReader {

    private static final String DEFAULT_PROP_NAME = "config.properties";
    private static final ConfigReader INSTANCE = new ConfigReader();
    private static Properties props = null;

    public static synchronized ConfigReader getInstance() {
        if (props==null){
            loadConfigPropertiesFile(DEFAULT_PROP_NAME);
        }

        return INSTANCE;
    }

    private static void loadConfigPropertiesFile(String path) {
        props = new Properties();
        InputStream is = null;
        try {
            File file=new File("src\\main\\resources\\config.properties");
            is = new FileInputStream(file);
            props.load(new InputStreamReader(is));
        } catch (Exception e) {
            Assert.fail();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static String getValueByKey(String key) {
        String value=null;
        value = props.get(key).toString();
        if (value==null){
            System.err.println("Failed key value: " + props.get(key));
            Assert.fail("Parameter: "+key+" is not set");
            return null;
        }
        return value;
    }
}
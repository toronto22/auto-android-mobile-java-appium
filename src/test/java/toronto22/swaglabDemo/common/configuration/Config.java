package toronto22.swaglabDemo.common.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = getProperties();

    public static String PLATFORM_NAME = properties.getProperty("platformName");
    public static String DEVICE_NAME = properties.getProperty("deviceName");
    public static String APP = properties.getProperty("app");
    public static String APP_PACKAGE = properties.getProperty("appPackage");
    public static String APP_ACTIVITY = properties.getProperty("appActivity");
    public static boolean NO_RESET = Boolean.parseBoolean(properties.getProperty("noReset"));
    public static String AUTOMATION_NAME = properties.getProperty("automationName");
    public static Integer NEW_COMMAND_TIMEOUT = Integer.valueOf(properties.getProperty("newCommandTimeout"));
    public static String DRIVER_URL = properties.getProperty("driverURL");
    public static Integer IMPLICITLY_WAIT = Integer.valueOf(properties.getProperty("implicitlyWait"));

    private static Properties getProperties() {
        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            try {
                String propFileName = "config/config.properties";
                inputStream = Config.class.getClassLoader().getResourceAsStream(propFileName);
                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return prop;
    }
}

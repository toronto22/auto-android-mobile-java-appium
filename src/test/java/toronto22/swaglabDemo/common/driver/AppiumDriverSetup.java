package toronto22.swaglabDemo.common.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import toronto22.swaglabDemo.common.configuration.Config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverSetup {
    private static AndroidDriver driver = null;

    private AppiumDriverSetup(AndroidDriver driver) {
        System.out.println("Will not setup driver here" + driver);
    }

    public static AndroidDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Config.PLATFORM_NAME);
        capabilities.setCapability("deviceName", Config.DEVICE_NAME);
        capabilities.setCapability("app", System.getProperty("user.dir") + "/" + Config.APP);
        capabilities.setCapability("appPackage", Config.APP_PACKAGE);
        capabilities.setCapability("appActivity", Config.APP_ACTIVITY);
        capabilities.setCapability("noReset", Config.NO_RESET);
        capabilities.setCapability("automationName", Config.AUTOMATION_NAME);
        capabilities.setCapability("newCommandTimeout", Config.NEW_COMMAND_TIMEOUT);
        try {
            driver = new AndroidDriver(new URL(Config.DRIVER_URL), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Config.IMPLICITLY_WAIT));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }

    public static AndroidDriver getDriver() {
        if (driver != null) return driver;
        driver = createDriver();

        return driver;
    }
}

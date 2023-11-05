package toronto22.swaglabDemo.common.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSetup {
     private static AndroidDriver driver = null;

    private AppiumDriverSetup(AndroidDriver driver) {
    }

    public static AndroidDriver createDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/toron/IdeaProjects/auto-mobile-java-serenity-appium/app/swaglabs.apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }

    public static AndroidDriver getDriver(){
        if(driver!=null) return driver;
        driver = createDriver();

        return driver;
    }
}

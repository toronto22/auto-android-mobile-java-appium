package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;

public class BasePage {
    AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }
}

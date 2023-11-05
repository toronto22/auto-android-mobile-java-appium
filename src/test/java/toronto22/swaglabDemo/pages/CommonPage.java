package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CommonPage extends BasePage{
    public CommonPage(AppiumDriver driver) {
        super(driver);
    }

    public void logout(){
        driver.findElement(menuIcon).click();
        driver.findElement(logoutButton).click();
    }
    By menuIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
    By logoutButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]");

}

package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return driver.findElement(sortingIcon).isDisplayed();
    }

    By sortingIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
}

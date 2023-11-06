package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static toronto22.swaglabDemo.common.navigation.Scroll.scrollDown;

public class ProductsPage extends BasePage {
    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    public void addToCard(String product){
        scrollDown(driver,addToCardButton(product));
        driver.findElement(addToCardButton(product)).click();
    }

    public boolean isDisplayed() {
        return driver.findElement(sortingIcon).isDisplayed();
    }

    By sortingIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By addToCardButton(String product) {
        return By.xpath("//*[@text='"+product+"']/..//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
    }
}

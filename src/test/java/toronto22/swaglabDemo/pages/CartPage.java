package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import toronto22.swaglabDemo.common.navigation.Scroll;
import toronto22.swaglabDemo.common.navigation.Wait;

public class CartPage extends BasePage {
    public CartPage(AppiumDriver driver) {
        super(driver);
    }
    public CheckoutPage gotoCheckout(){
        Scroll.downToElement(driver,checkoutButton,10).click();
        return new CheckoutPage(driver);
    }
    public void removeItem(String product){
        Scroll.downToElement(driver,removeItemButtonByName(product)).click();
    }

    public void continueShopping(){
        Scroll.downToElement(driver,continueShoppingButton).click();
    }
    public boolean itemIsDisplayed(String product){
        return Scroll.downToElement(driver,removeItemButtonByName(product),10).isDisplayed();
    }
    By checkoutButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");
    By continueShoppingButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]/android.widget.TextView");
    By removeItemButtonByName(String product) {
        return By.xpath("//*[@text='"+product+"']/../..//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]");
    }
}


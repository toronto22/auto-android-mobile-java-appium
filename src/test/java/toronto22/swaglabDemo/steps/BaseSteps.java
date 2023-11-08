package toronto22.swaglabDemo.steps;

import io.appium.java_client.android.AndroidDriver;
import toronto22.swaglabDemo.common.driver.AppiumDriverSetup;
import toronto22.swaglabDemo.pages.*;

public class BaseSteps {
    AndroidDriver driver =  AppiumDriverSetup.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CommonPage commonPage = new CommonPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CartPage cartPage = new CartPage(driver);
}

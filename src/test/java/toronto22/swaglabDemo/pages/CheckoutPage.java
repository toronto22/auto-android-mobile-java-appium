package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import toronto22.swaglabDemo.common.navigation.Scroll;

import static toronto22.swaglabDemo.common.navigation.Scroll.downToElement;

public class CheckoutPage extends BasePage {
    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    public void CheckoutWith(String firstName, String lastName, String postalCode){
            driver.findElement(firstNameInput).sendKeys(firstName);
            driver.findElement(lastNameInput).sendKeys(lastName);
            driver.findElement(postalCodeInput).sendKeys(postalCode);
            driver.findElement(continueButton).click();

            Scroll.downToElement(driver,finishButton,10).click();
    }

    public boolean isCheckoutCompleted(){
        return driver.findElement(backHomeButton).isDisplayed();
    }

    //Checkout: Information
    By firstNameInput = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    By lastNameInput = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    By postalCodeInput = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    By continueButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");
    //Checkout: Overview
    By finishButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");
    //Checkout: Completed
    By backHomeButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]/android.widget.TextView");

}

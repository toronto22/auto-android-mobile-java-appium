package toronto22.swaglabDemo.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import toronto22.swaglabDemo.common.driver.navigation.Wait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        if(username!=null){
            Wait.forDisplayed(driver,usernameInput, Duration.ofSeconds(10)).sendKeys(username);
        }
        if(password!=null){
            driver.findElement(passwordInput).sendKeys(password);
        }
        driver.findElement(loginButton).click();
    }

    public boolean isDisplayed(){
        return driver.findElement(usernameInput).isDisplayed();
    }

    public String errorMessage(){
        return driver.findElement(errorMessageLabel).getText();
    }

    By usernameInput = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By passwordInput = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView");
    By errorMessageLabel = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");


}

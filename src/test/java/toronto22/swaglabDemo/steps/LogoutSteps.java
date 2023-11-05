package toronto22.swaglabDemo.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import toronto22.swaglabDemo.common.driver.AppiumDriverSetup;
import toronto22.swaglabDemo.pages.CommonPage;

public class LogoutSteps extends BaseSteps {
    @When("I logout of the system")
    public void iLogoutOfTheSystem() {
        commonPage = new CommonPage(AppiumDriverSetup.getDriver());
        commonPage.logout();
    }

    @Then("I am logged out successfully")
    public void iAmLoggedOutSuccessfully() {
        Assertions.assertTrue(loginPage.isDisplayed());
    }
}

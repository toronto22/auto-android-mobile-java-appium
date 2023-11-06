package toronto22.swaglabDemo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps extends BaseSteps {
    @When("^I start and login with credential$")
    public void iStartAndLoginWithCredential(DataTable table) {
        String username = table.asMaps().get(0).get("username");
        String password = table.asMaps().get(0).get("password");
        loginPage.login(username,password);
    }

    @Then("^I am logged in successfully$")
    public void iAmLoggedInSuccessfully() {
        Assertions.assertTrue(productsPage.isDisplayed());
    }

    @Then("^I should see the login error message$")
    public void iShouldSeeTheLoginErrorMessage(DataTable table) {
        String expectedErrorMessage = table.asMaps().get(0).get("message");
        Assertions.assertEquals(expectedErrorMessage,loginPage.errorMessage());
    }
}

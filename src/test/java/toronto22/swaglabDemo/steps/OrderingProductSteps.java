package toronto22.swaglabDemo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class OrderingProductSteps extends BaseSteps {
    @When("I add products to my cart")
    public void iAddProductsToMyCart(DataTable table) {
        List<String> items = table.asList();
        for (String item : items) {
            productsPage.addToCard(item);
        }
    }

    @And("I finish checkout products in my cart")
    public void iFinishCheckoutProductsInMyCart(DataTable table) {
        String firstName = table.asMaps().get(0).get("firstName");
        String lastName = table.asMaps().get(0).get("lastName");
        String postalCode = table.asMaps().get(0).get("postalCode");

        productsPage
                .goToCart()
                .gotoCheckout()
                .CheckoutWith(firstName, lastName, postalCode);
    }

    @Then("I checkout my products successfully")
    public void iCheckoutMyProductsSuccessfully() {
        Assertions.assertTrue(checkoutPage.isCheckoutCompleted());
    }
}

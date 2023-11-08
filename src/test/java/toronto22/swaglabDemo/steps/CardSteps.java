package toronto22.swaglabDemo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class CardSteps extends BaseSteps {
    @And("I view my cart")
    public void iViewMyCart() {
        productsPage.goToCart();
    }

    @Then("I should see my selected products")
    public void iShouldSeeMySelectedProducts(DataTable table) {
        List<String> items = table.asList();
        for (String item: items) {
            Assertions.assertTrue(cartPage.itemIsDisplayed(item));
        }
    }

    @And("I remove products from my cart")
    public void iRemoveProductsFromMyCart(DataTable table) {
        List<String> items = table.asList();
        for (String item: items) {
            cartPage.removeItem(item);
        }
    }

    @And("I choose to continue shopping")
    public void iChooseToContinueShopping() {
        cartPage.continueShopping();
    }

    @Then("I should see the Products page")
    public void iShouldSeeTheProductsPage() {
        productsPage.isDisplayed();
    }
}

package toronto22.swaglabDemo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class OrderingProductSteps extends BaseSteps {
    @When("I add products to my cart")
    public void iAddProductsToMyCart(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        for (Map<String, String> item: list) {
            String product = item.get("product");
            productsPage.addToCard(product);
        }
    }

    @And("I finish checkout products in my cart")
    public void iFinishCheckoutProductsInMyCart(DataTable table) {
        String x= "1";
    }

    @Then("I checkout my products successfully")
    public void iCheckoutMyProductsSuccessfully() {
    }
}

package steps;

import Pages.BasePage;
import Pages.ProductsDetailsPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SelecProductTest {

    @Given("The products list {string}")
    public void theProductsList(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);

    }
    @When("I looking for the product listed with title {string}")
    public void iLookingForTheProductListedWithTitle(String product) throws Exception {
       Boolean titleCheck = new ProductsPage().getProductTitle(product).equalsIgnoreCase(product);
       Assert.assertTrue("titleCheck = " + titleCheck , titleCheck );


    }
   @When("I click in the {string}")
   public void iClickInThe(String products)  throws Exception {

        new ProductsPage().pressProductTitle(products);


   }
    @Then("I add the product in the cart")
    public void iAddTheProductInTheCart() throws Exception {

        new ProductsPage().pressProductTitle2("test-Precio");
        new ProductsPage().pressProductTitle2("test-AÑADIR A CARRITO");



    }

    @Then("I back to  the list {string}")
    public void iBackToTheList(String string) {
        new ProductsDetailsPage().pressBackToProductsBtn();
    }
}

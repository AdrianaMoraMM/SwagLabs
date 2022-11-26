package steps;

import Pages.LoginPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTest {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {

        new LoginPage().enterPassword(password);
    }

    @When("I login")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @Then("Login should fail with an error {string}")
    public void loginShouldFailWithAnError(String error) {

        Assert.assertEquals(new LoginPage().getErrTxt(), error);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }
}
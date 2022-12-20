package steps.webApps;

import forms.LoginTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.TestBase;

import java.net.MalformedURLException;

public class LoginSteps {

    TestBase testBase = new TestBase();
    LoginTests loginTests;

    @Given("user is redirected to login url")
    public void openUrl() throws MalformedURLException {
        loginTests = new LoginTests(testBase.getdriver());
        loginTests.openUrl();
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginTests = new LoginTests(testBase.getdriver());
        loginTests.enterCredentials(username, password);
    }

    @And("user clicks on login button")
    public void clickLogin() {
        loginTests = new LoginTests(testBase.getdriver());
        loginTests.clickLogin();
    }

    @Then("user should be logged in successfully")
    public void verifyDashboardLogo() {
        loginTests = new LoginTests(testBase.getdriver());
        loginTests.verifyDashboardLogo();
    }
}

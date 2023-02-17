package steps.mobileApps;

import forms.AndroidTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.TestBase;

import java.net.MalformedURLException;

public class AndroidTestSteps {

    TestBase testBase = new TestBase();
    AndroidTests androidTests;

    @Given("User launch app by tapping on app icon")
    public void User_launch_app_by_tapping_on_app_icon() throws MalformedURLException {
        androidTests = new AndroidTests(testBase.getDriver());
        androidTests.launchAndroidApp();
    }

    @Then("Application should be launched")
    public void application_should_be_launched() {
        androidTests = new AndroidTests(testBase.getDriver());
        //androidTests.verifyAppLaunch();
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button() {
        androidTests = new AndroidTests(testBase.getDriver());
        androidTests.clickAgreeAndContinueButton();
    }

    @Then("User should be navigated to {string} screen")
    public void user_should_be_navigated_to_screen() {
        androidTests = new AndroidTests(testBase.getDriver());
        androidTests.verifyAgreeAndContinueButton();
    }
}

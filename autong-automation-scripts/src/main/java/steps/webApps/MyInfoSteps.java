package steps.webApps;

import forms.MyInfoTests;
import io.cucumber.java.en.And;
import base.TestBase;

public class MyInfoSteps {

    TestBase testBase = new TestBase();
    MyInfoTests myInfoTests;

    @And("user redirects to My Info from side nav menu")
    public void clickMyInfoSideNav() {
        myInfoTests = new MyInfoTests(testBase.getDriver());
        myInfoTests.clickMyInfoSideNavLink();
    }

    @And("user clicks on Add attachment button")
    public void userClicksOnAddAttachmentButton() {
        myInfoTests = new MyInfoTests(testBase.getDriver());
        testBase.pause(2000);
        testBase.scrollToBottom();
        myInfoTests.clickAddAttachmentBtn();
    }

    @And("user uploads an attachment successfully")
    public void userUploadsAnAttachmentSuccessfully() {
        myInfoTests = new MyInfoTests(testBase.getDriver());
        myInfoTests.uploadAttachment();
    }
}

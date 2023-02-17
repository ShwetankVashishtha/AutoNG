package steps.webApps;

import forms.AdminTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import base.TestBase;

public class AdminSteps {

    TestBase testBase = new TestBase();
    AdminTests adminTests;

    @And("user redirects to Admin from side nav menu")
    public void clickAdminSideNavLink() {
        adminTests = new AdminTests(testBase.getDriver());
        adminTests.clickAdminSideNavLink();
    }

    @And("user selects user role as admin")
    public void userSelectsUserRoleAs() {
        adminTests = new AdminTests(testBase.getDriver());
        adminTests.selectValueFromUserRoleDropdown();
    }

    @And("user scrolls down to the bottom of the page")
    public void userScrollsDownToTheBottomOfThePage() {
        adminTests = new AdminTests(testBase.getDriver());
        adminTests.scrollToPageFooter();
    }

    @Then("user should be able to view copyright text on footer note")
    public void userShouldBeAbleToViewCopyrightTextOnFooterNote() {
        adminTests = new AdminTests(testBase.getDriver());
        Assert.assertTrue(adminTests.getCopyrightYearText().contains("©")
                && adminTests.getCopyrightYearText().contains("2005 - 2022")
                && adminTests.getCopyrightYearText().contains("OrangeHRM, Inc. All rights reserved."));
    }

    @And("user should be able to click on web link on footer note")
    public void userShouldBeAbleToClickOnWebLinkOnFooterNote() {
        adminTests = new AdminTests(testBase.getDriver());
        adminTests.clickFooterHyperlink();
        Assert.assertTrue(testBase.getPageTitle().contains("OrangeHRM HR Software | Free & Open Source HR Software"));
    }

    @And("user right click on mouse to open context menu")
    public void userRightClickOnMouseToOpenContextMenu() {
        adminTests = new AdminTests(testBase.getDriver());
        adminTests.openContextMenu();
    }

    @And("user mouse hover search button")
    public void userMouseHoverSearchButton() {
        adminTests = new AdminTests(testBase.getDriver());
        adminTests.mouseHoverSearchBtn();
    }
}

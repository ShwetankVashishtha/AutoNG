package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;
import base.TestBase;

import java.util.List;
import java.util.logging.Logger;

import static locators.Locators.AdminLocators.*;

public class AdminTests extends PageBase {

    TestBase testBase = new TestBase();
    Logger logger = Logger.getLogger("AutoNG logger");

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public AdminTests(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ADMIN_SIDE_NAV)
    private WebElement adminSideNav;

    public WebElement getAdminSideNav() {
        return adminSideNav;
    }

    @FindBy(xpath = USER_ROLES_LABEL)
    private List<WebElement> userRolesLabel;

    public List<WebElement> getUserRolesLabel() {
        return userRolesLabel;
    }

    @FindBy(xpath = USER_ROLES_DROPDOWN)
    private WebElement userRolesDropdown;

    public WebElement getUserRolesDropdown() {
        return userRolesDropdown;
    }

    @FindBy(xpath = FOOTER_LINK)
    private WebElement footerLink;

    public WebElement getFooterLink() {
        return footerLink;
    }

    @FindBy(xpath = COPYRIGHT_YEAR)
    private WebElement copyrightYear;

    public WebElement getCopyrightYear() {
        return copyrightYear;
    }

    @FindBy(xpath = SEARCH_BTN)
    private WebElement searchBtn;

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public void clickAdminSideNavLink() {
        testBase.waitForElementToBeClickable(10, getAdminSideNav());
        getAdminSideNav().click();
        testBase.implicitWait(10);
    }

    public void selectValueFromUserRoleDropdown() {
        for (WebElement userRole : getUserRolesLabel()) {
            if (userRole.getText().equals("User Role")) {
                logger.info("Found record that reads User Role");
            }
        }
    }

    public void scrollToPageFooter() {
        testBase.pause(1000);
        testBase.scrollToBottom();
        testBase.waitForElementVisible(10, getFooterLink());
    }

    public String getCopyrightYearText() {
        testBase.waitForElementVisible(10, getCopyrightYear());
        return getCopyrightYear().getText();
    }

    public void clickFooterHyperlink() {
        testBase.waitForElementVisible(10, getFooterLink());
        testBase.waitForElementToBeClickable(10, getFooterLink());
        getFooterLink().click();
        testBase.switchBrowserTab(1);
    }

    public void openContextMenu() {
        testBase.contextClick(getSearchBtn());
        testBase.pause(4000);
    }

    public void mouseHoverSearchBtn() {
        testBase.mouseHover(getSearchBtn());
        testBase.pause(4000);
    }
}

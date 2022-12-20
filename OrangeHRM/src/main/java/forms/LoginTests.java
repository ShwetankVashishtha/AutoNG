package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.fileOperations.PropertyManager;
import base.PageBase;
import base.TestBase;

import java.net.MalformedURLException;

import static locators.Locators.LoginLocators.*;

public class LoginTests extends PageBase {

    PropertyManager pm = new PropertyManager();
    TestBase testBase = new TestBase();

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public LoginTests(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = USERNAME)
    private WebElement username;

    public WebElement getUsername() {
        return username;
    }

    @FindBy(xpath = PASSWORD)
    private WebElement password;

    public WebElement getPassword() {
        return password;
    }

    @FindBy(xpath = LOGIN)
    private WebElement login;

    public WebElement getLogin() {
        return login;
    }

    @FindBy(xpath = DASHBOARD_LOGO)
    private WebElement dashboardLogo;

    public WebElement getDashboardLogo() {
        return dashboardLogo;
    }

    public void openUrl() throws MalformedURLException {
        testBase.setupBrowser(pm.getResourceBundle.getProperty("browser"),
                pm.getResourceBundle.getProperty("BASE_URL"));
    }

    public void enterCredentials(String username, String password) {
        testBase.waitForElementToBeClickable(10, getUsername());
        getUsername().clear();
        getUsername().sendKeys(username);
        testBase.waitForElementToBeClickable(10, getPassword());
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickLogin() {
        testBase.waitForElementToBeClickable(10, getLogin());
        getLogin().click();
        testBase.implicitWait(10);
    }

    public boolean verifyDashboardLogo() {
        if (getDashboardLogo().isDisplayed()) {
            return true;
        }
        return false;
    }
}

package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.fileOperations.PropertyManager;
import base.PageBase;
import base.TestBase;

import static locators.Locators.MyInfoLocators.*;

public class MyInfoTests extends PageBase {

    PropertyManager pm = new PropertyManager();
    TestBase testBase = new TestBase();

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public MyInfoTests(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = MYINFO_SIDE_NAV)
    private WebElement myInfoSideNav;

    public WebElement getMyInfoSideNav() {
        return myInfoSideNav;
    }

    @FindBy(xpath = ADD_ATTACHMENT_BTN)
    private WebElement addAttachmentBtn;

    public WebElement getAddAttachmentBtn() {
        return addAttachmentBtn;
    }

    @FindBy(xpath = BROWSE_BTN)
    private WebElement browseBtn;

    public WebElement getBrowseBtn() {
        return browseBtn;
    }

    @FindBy(xpath = FILE_PATH_INPUT)
    private WebElement filePathInput;

    public WebElement getFilePathInput() {
        return filePathInput;
    }

    public void clickMyInfoSideNavLink() {
        testBase.waitForElementVisible(10, getMyInfoSideNav());
        testBase.waitForElementToBeClickable(10, getMyInfoSideNav());
        getMyInfoSideNav().click();
        testBase.implicitWait(10);
    }

    public void clickAddAttachmentBtn() {
        testBase.waitForElementVisible(10, getAddAttachmentBtn());
        testBase.waitForElementToBeClickable(10, getAddAttachmentBtn());
        getAddAttachmentBtn().click();
    }

    public void uploadAttachment() {
        getFilePathInput().sendKeys(System.getProperty("user.dir") + pm.getResourceBundle.getProperty("ATTACHMENT_PATH"));
    }
}

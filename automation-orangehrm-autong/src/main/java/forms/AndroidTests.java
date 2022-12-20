package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import base.PageBase;
import base.TestBase;

import java.net.MalformedURLException;
import java.util.List;

import static locators.Locators.AndroidLocators.*;

public class AndroidTests extends PageBase {

    TestBase testBase = new TestBase();

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public AndroidTests(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = WELCOME_TO_WHATSAPP_SCREEN)
    private WebElement welcomeToWhatsAppScreen;

    public WebElement getWelcomeToWhatsAppScreen() {
        return welcomeToWhatsAppScreen;
    }

    @FindBy(id = AGREE_AND_CONTINUE_BTN)
    private WebElement agreeAndContinueBtn;

    public WebElement getAgreeAndContinueBtn() {
        return agreeAndContinueBtn;
    }

    @FindBys(@FindBy(id = ENTER_YOUR_PHONE_NUMBER_SCREEN))
    private List<WebElement> enterYourPhoneNumberScreen;

    public List<WebElement> getEnterYourPhoneNumberScreen() {
        return enterYourPhoneNumberScreen;
    }

    public void launchAndroidApp() throws MalformedURLException {
        testBase.setUpAndroid(true, true);
    }

    public boolean verifyAppLaunch() {
        if (getWelcomeToWhatsAppScreen().isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickAgreeAndContinueButton() {
        getAgreeAndContinueBtn().click();
    }

    public boolean verifyAgreeAndContinueButton() {
        testBase.pause(3);
        if (getEnterYourPhoneNumberScreen().size() != 0) {
            return true;
        }
        return false;
    }
}

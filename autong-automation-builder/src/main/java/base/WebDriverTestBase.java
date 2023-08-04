package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public abstract class WebDriverTestBase {

    protected static WebDriver driver;

    public abstract WebDriver getDriver();

    public abstract void setupBrowser(String browser, String URL) throws MalformedURLException;

    public abstract void setUpiOS() throws MalformedURLException;

    public abstract void setUpAndroid(Boolean skipUnlock, Boolean noReset) throws MalformedURLException;

    public abstract void closeActiveSessions();

    public abstract void closeCurrentSession();

    public abstract void openURL(String AUT_URL);

    public abstract void refreshPage();

    public abstract void waitForElementToBeClickable(long timeout, WebElement element);

    public abstract void waitForElementDisappear(long timeout, WebElement element);

    public abstract void waitForElementVisible(long timeout, WebElement element);

    public abstract void waitForPageLoad(long timeout);

    public abstract void fluentWait(long timeout, long polling);

    public abstract void implicitWait(long timeout);

    public abstract void pause(long timeout);

    public abstract void waitForPageExpire(long timeout);

    public abstract void waitForTextToBePresentInElement(long timeout, WebElement element, String text);

    public abstract void setAsyncScriptTimeout(long timeout);

    public abstract void openCurrentBrowserInstance();

    public abstract void openNewBrowserTab();

    public abstract void waitForPageTitle(long timeout, String pageTitle);

    public abstract void frameToBeAvailableAndSwitch(long timeout, String frameID);

    public abstract void scrollToBottom();

    public abstract void scrollToTop();

    public abstract void javaScriptClick(WebElement element);

    public abstract void scrollToElement(WebElement element);

    public abstract void scrollUsingCoordinates();

    public abstract String getPageTitle();

    public abstract void switchBrowserTab(int tabId);

    public abstract void contextClick(WebElement element);

    public abstract void mouseHover(WebElement element);

    public abstract void dragAndDrop(WebElement fromElement, WebElement toElement);

    public abstract void dragAndDropBy(WebElement fromElement, WebElement toElement);

    public abstract void pressEnterKey();

    public abstract void cleanup();
}

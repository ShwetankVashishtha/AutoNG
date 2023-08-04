package base;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.fileOperations.PropertyManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class TestBase extends WebDriverTestBase {

    Logger logger = Logger.getLogger("AutoNG logger");
    PropertyManager pm = new PropertyManager();
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setupBrowser(String browser, String URL) throws MalformedURLException {
        if (System.getProperty("os.name").startsWith("Mac")) {
            if (browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("chrome")) {
                Map<String, Object> pref = new HashMap<>();
                pref.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setExperimentalOption("prefs", pref);
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless") || browser.equalsIgnoreCase("phantomjs")) {
                System.setProperty("phantomjs.binary.path",
                        System.getProperty("user.dir") + pm.getResourceBundle.getProperty("PHANTOMJS_DRIVER_PATH_MAC"));
                driver = new PhantomJSDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("safari")) {
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                driver.manage().window().maximize();
                openURL(URL);
            }
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            if (browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless") || browser.equalsIgnoreCase("phantomjs")) {
                driver = new PhantomJSDriver();
                driver.manage().window().maximize();
                openURL(URL);
            }
        }
    }

    @Override
    public void setUpiOS() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", pm.getResourceBundle.getProperty("IOS_PLATFORM_NAME"));
        desiredCapabilities.setCapability("platformVersion", pm.getResourceBundle.getProperty("IOS_PLATFORM_VERSION"));
        desiredCapabilities.setCapability("deviceName", pm.getResourceBundle.getProperty("IOS_DEVICE_NAME"));
        desiredCapabilities.setCapability("udid", "auto");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, pm.getResourceBundle.getProperty("APP_FILE"));
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Override
    public void setUpAndroid(Boolean skipUnlock, Boolean noReset) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", pm.getResourceBundle.getProperty("ANDROID_PLATFORM_NAME"));
        desiredCapabilities.setCapability("platformVersion", pm.getResourceBundle.getProperty("ANDROID_PLATFORM_VERSION"));
        desiredCapabilities.setCapability("deviceName", pm.getResourceBundle.getProperty("ANDROID_DEVICE_NAME"));
        desiredCapabilities.setCapability("appPackage", pm.getResourceBundle.getProperty("ANDROID_APP_PACKAGE"));
        desiredCapabilities.setCapability("appActivity", pm.getResourceBundle.getProperty("ANDROID_APP_ACTIVITY"));
        desiredCapabilities.setCapability("noReset", noReset);
        desiredCapabilities.setCapability("skipUnlock", skipUnlock);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Override
    public void openURL(String AUT_URL) {
        driver.get(AUT_URL);
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Override
    public void closeCurrentSession() {
        driver.close();
    }

    @Override
    public void closeActiveSessions() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Override
    public void openCurrentBrowserInstance() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
    }

    @Override
    public void openNewBrowserTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    @Override
    public void pause(long timeoutInMilliSeconds) {
        try {
            Thread.sleep(timeoutInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void implicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    @Override
    public void fluentWait(long timeout, long polling) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(polling)).ignoring(NoSuchElementException.class);
    }

    @Override
    public void waitForPageLoad(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    @Override
    public void waitForElementVisible(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementDisappear(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOf(element));
    }

    @Override
    public void waitForElementToBeClickable(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitForPageExpire(long timeout) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
    }

    @Override
    public void setAsyncScriptTimeout(long timeout) {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeout));
    }

    @Override
    public void waitForTextToBePresentInElement(long timeout, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    @Override
    public void waitForPageTitle(long timeout, String pageTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.titleIs(pageTitle));
    }

    @Override
    public void frameToBeAvailableAndSwitch(long timeout, String frameID) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameID)));
    }

    @Override
    public void scrollToBottom() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Override
    public void scrollToElement(WebElement element) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    @Override
    public void scrollToTop() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    @Override
    public void javaScriptClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Override
    public void scrollUsingCoordinates() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,500)");
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void switchBrowserTab(int tabId) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabId));
    }

    @Override
    public void contextClick(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).contextClick().build().perform();
    }

    @Override
    public void mouseHover(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    @Override
    public void dragAndDrop(WebElement fromElement, WebElement toElement) {
        actions = new Actions(driver);
        actions.dragAndDrop(fromElement, toElement).perform();
    }

    @Override
    public void dragAndDropBy(WebElement fromElement, WebElement toElement) {
        actions = new Actions(driver);
        Rectangle start = fromElement.getRect();
        Rectangle finish = toElement.getRect();
        actions.dragAndDropBy(fromElement, finish.getX() - start.getX(), finish.getY() - start.getY()).build().perform();
    }

    @Override
    public void pressEnterKey() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cleanup() {
        String folderPath = pm.getResourceBundle.getProperty("TARGET_FOLDER_PATH");
        try {
            if (Files.exists(Path.of(folderPath)) && !folderPath.isEmpty()) {
                FileUtils.deleteDirectory(new File(folderPath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void getBrokenLinks(String baseUrl) {
        String url = "";
        HttpURLConnection httpURLConnection = null;
        int responseCode = 200;

        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> iterator = links.iterator();

        while (iterator.hasNext()) {
            url = iterator.next().getAttribute("href");
            if (url == null || url.isEmpty() || !url.startsWith(baseUrl)) {
                logger.info("URL may be configured for anchor tag or it is empty or from other domain");
                continue;
            }

            try {
                httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();

                if (responseCode >= 400) {
                    logger.info(url + " is a broken link");
                } else {
                    logger.info(url + " is a valid link");
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
package com.autong.base;

import com.autong.utilities.annotations.ElementMeta;
import com.autong.utilities.annotations.MobileSpecificField;
import com.autong.utilities.annotations.WebSpecificField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestBase {

    private static final Logger logger = Logger.getLogger(TestBase.class.getName());
    @Getter protected static WebDriver driver;
    protected static WebDriver mobileDriver;
    static Actions actions;
    static JavascriptExecutor javascriptExecutor;

    /**
     * This function initialise browser-specific drivers
     * and opens a web url in selected browser with maximized browser window
     * <p>
     * Supported browsers: Chrome, Firefox, IE Edge, Safari
     * Supported OS: Mac OS-X and Windows
     * <p>
     * Post browser initialization, function further executes to maximize browser window
     * pointing to {@link #setupBrowser(String, String)}
     *
     * @param browser execution browser name
     * @param URL     web app url
     */
    public static void setupBrowser(String browser, String URL) {
        try {
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
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--allow-file-access-from-files");
                    chromeOptions.addArguments("--allow-file-access");
                    chromeOptions.addArguments("--disable-notifications");
                    LoggingPreferences logs = new LoggingPreferences();
                    logs.enable(LogType.BROWSER, Level.ALL);
                    chromeOptions.setCapability("goog:loggingPrefs", logs);
                    driver = new ChromeDriver(chromeOptions);
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
                    Map<String, Object> pref = new HashMap<>();
                    pref.put("profile.default_content_setting_values.notifications", 2);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.setExperimentalOption("prefs", pref);
                    chromeOptions.addArguments("--disable-notifications");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    openURL(URL);
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * This function initialise browser-specific drivers
     * and opens a web url in selected browser with maximized browser window
     * <p>
     * Supported browsers: Chrome, Firefox, IE Edge, Safari
     * Supported OS: Mac OS-X and Windows
     * <p>
     * Post browser initialization, function further executes to maximize browser window
     * pointing to {@link #setupBrowser(String, String, String, String)}
     *
     * @param browser       execution browser name
     * @param URL           web app url
     * @param audioFilePath accepts .wav audio file
     */
    public static void setupBrowser(String browser, String URL, String audioFilePath, String videoFilePath) {
        try {
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
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--allow-file-access-from-files");
                    chromeOptions.addArguments("--allow-file-access");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--use-fake-ui-for-media-stream");
                    chromeOptions.addArguments("--use-fake-device-for-media-stream");
                    chromeOptions.addArguments("--use-file-for-fake-audio-capture=" + audioFilePath);
                    chromeOptions.addArguments("--use-file-for-fake-video-capture=" + videoFilePath);
                    LoggingPreferences logs = new LoggingPreferences();
                    logs.enable(LogType.BROWSER, Level.ALL);
                    chromeOptions.setCapability("goog:loggingPrefs", logs);
                    driver = new ChromeDriver(chromeOptions);
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
                    Map<String, Object> pref = new HashMap<>();
                    pref.put("profile.default_content_setting_values.notifications", 2);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.setExperimentalOption("prefs", pref);
                    chromeOptions.addArguments("--disable-notifications");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    openURL(URL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function helps to determine if web app driver is in opened or closed state
     * and conclude if an action needs to be performed o discarded
     *
     * @return boolean value - true if found web app driver to be active
     */
    public static boolean isWebDriverOpen() {
        if (driver != null) {
            logger.info("Found open web app driver");
            return true;
        }
        return false;
    }

    /**
     * This function helps to determine if mobile app driver is in opened or closed state
     * and conclude if an action needs to be performed o discarded
     *
     * @return boolean value - true if found mobile app driver to be active
     */
    public static boolean isMobileDriverOpen() {
        if (mobileDriver != null) {
            logger.info("Found open mobile app driver");
            return true;
        }
        return false;
    }

    /**
     * This function passes application url in opened browser window
     * and implicitly wait for page to load
     *
     * @param AUT_URL accepts url to open
     */
    public static void openURL(String AUT_URL) {
        driver.get(AUT_URL);
    }

    /**
     * This function refreshes web page in opened browser window
     * and implicitly wait for page to load.
     */
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * This function checks for opened web driver
     *
     * @return boolean value
     */
    public static boolean isWeb() {
        if (isWebDriverOpen()) {
            return true;
        } else {
            logger.info("No web app open session found!");
        }
        return false;
    }

    /**
     * This function checks for opened mobile driver
     *
     * @return boolean value
     */
    public static boolean isMobile() {
        if (isMobileDriverOpen()) {
            return true;
        } else {
            logger.info("No mobile app open session found!");
        }
        return false;
    }

    /**
     * This function closes current browser window
     * Given that driver value isn't null
     */
    public static void closeCurrentSession() {
        if (isWebDriverOpen()) {
            driver.close();
        } else {
            logger.info("No web app open session found!");
        }
    }

    /**
     * This function closes all browser windows
     * Given that driver value isn't null
     */
    public static void closeActiveSessions() {
        if (isWebDriverOpen()) {
            driver.manage().deleteAllCookies();
            driver.quit();
        } else {
            logger.info("No web app open session found!");
        }
    }

    /**
     * This function opens a new browser window
     * Given that driver value isn't null
     */
    public static void openCurrentBrowserInstance() {
        if (isWebDriverOpen()) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
        } else {
            logger.info("No web app open session found!");
        }
    }

    /**
     * This function opens a new browser tab
     * Given that driver value isn't null
     */
    public static void openNewBrowserTab() {
        if (isWebDriverOpen()) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        } else {
            logger.info("No web app open session found!");
        }
    }

    /**
     * This function sets browser activity logs into centralised logger controller
     * and could be utilised in analysing failures
     * <p>
     *
     * @return LogEntries as a list
     */
    public static LogEntries setLogger() {
        if (isWebDriverOpen()) {
            return TestBase.getDriver().manage().logs().get(LogType.BROWSER);
        } else {
            logger.info("No web app open session found!");
        }
        return null;
    }

    /**
     * This function puts execution at sleep for specified halt time
     * Execution resumes only after it passes provided pause time
     * <p>
     * Note: Not recommended. Look for dynamic waits instead.
     *
     * @param timeoutInMilliSeconds accepts sleep time in milliseconds
     */
    public static void pause(long timeoutInMilliSeconds) {
        try {
            Thread.sleep(timeoutInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void implicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public static void fluentWait(long timeout, long polling) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(polling)).ignoring(NoSuchElementException.class);
    }

    public static void waitForPageLoad(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public static void waitForElementVisible(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementDisappear(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToBeClickable(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPageExpire(long timeout) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
    }

    public static void setAsyncScriptTimeout(long timeout) {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeout));
    }

    public static void waitForTextToBePresentInElement(long timeout, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean waitForPageTitle(long timeout, String pageTitle) {
        boolean pageTitleStatus = false;
        try {
            if (new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.titleIs(pageTitle))) {
                pageTitleStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageTitleStatus;
    }

    public static void frameToBeAvailableAndSwitch(long timeout, String frameID) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameID)));
    }

    public static void scrollToBottom() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToElement(WebElement element) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollToTop() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollUsingCoordinates() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,500)");
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static void contextClick(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).contextClick().build().perform();
    }

    public static void mouseHover(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void dragAndDrop(WebElement fromElement, WebElement toElement) {
        actions = new Actions(driver);
        actions.dragAndDrop(fromElement, toElement).perform();
    }

    public static void dragAndDropBy(WebElement fromElement, WebElement toElement) {
        actions = new Actions(driver);
        Rectangle start = fromElement.getRect();
        Rectangle finish = toElement.getRect();
        actions.dragAndDropBy(fromElement, finish.getX() - start.getX(), finish.getY() - start.getY()).build().perform();
    }

    public static void pressEnterKey() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot(String filePath) {
        try {
            if (driver != null) {
                TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
                File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public static void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    public static void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public static void getBrokenLinks(String baseUrl) {
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

    public static void openAndSwitchBrowserTab(String URL, int tabId) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabId));
        openURL(URL);
    }

    public static void switchBrowserTab(int tabId) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabId));
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static boolean isViewMobile() {
        return true;
    }

    public static List<Field> getFieldsForPlatform(Object object) {
        if (isViewMobile()) {
            return Arrays.stream(object.getClass().getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(ElementMeta.class) &&
                            !field.isAnnotationPresent(WebSpecificField.class))
                    .collect(Collectors.toList());
        } else {
            return Arrays.stream(object.getClass().getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(ElementMeta.class) &&
                            !field.isAnnotationPresent(MobileSpecificField.class))
                    .collect(Collectors.toList());
        }
    }
}
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class PageBase {

    /**
     * The driver.
     */
    protected WebDriver driver = null;

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver
     */
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

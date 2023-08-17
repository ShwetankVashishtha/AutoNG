package com.autong.utilities.annotations;

import com.autong.base.TestBase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProcessElementMeta {

    public static WebElement getSelenideElement(LocateUsing locatedBy, String value) {
        switch (locatedBy) {
            case ID:
                return TestBase.getDriver().findElement(By.id(value));
            case CSS:
                return TestBase.getDriver().findElement(By.cssSelector(value));
            case XPATH:
                return TestBase.getDriver().findElement(By.xpath(value));
            case PARTIAL_TEXT:
                return TestBase.getDriver().findElement(By.partialLinkText(value));
            case CLASS:
                return TestBase.getDriver().findElement(By.className(value));
            case LINK_TEXT:
                return TestBase.getDriver().findElement(By.linkText(value));
            default:
            case NAME:
                return TestBase.getDriver().findElement(By.name(value));
        }
    }
}

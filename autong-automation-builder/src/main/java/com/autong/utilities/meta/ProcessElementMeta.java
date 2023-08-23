package com.autong.utilities.meta;

import com.autong.base.TestBase;
import com.autong.utilities.annotations.ElementMeta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProcessElementMeta {

    public static WebElement getWebElement(LocateUsing locatedBy, String value) {
        return switch (locatedBy) {
            case ID -> TestBase.getDriver().findElement(By.id(value));
            case CSS -> TestBase.getDriver().findElement(By.cssSelector(value));
            case XPATH -> TestBase.getDriver().findElement(By.xpath(value));
            case PARTIAL_TEXT -> TestBase.getDriver().findElement(By.partialLinkText(value));
            case CLASS -> TestBase.getDriver().findElement(By.className(value));
            case LINK_TEXT -> TestBase.getDriver().findElement(By.linkText(value));
            case TAG_NAME -> TestBase.getDriver().findElement(By.tagName(value));
            default -> TestBase.getDriver().findElement(By.name(value));
        };
    }

    public static WebElement getWebElement(Field f) {
        Map<LocatorProperties, Object> properties = getDefinedProperties(f);
        LocateUsing locateUsing = (LocateUsing) properties.get(LocatorProperties.LOCATE_USING);
        String locator = (String) properties.get(LocatorProperties.LOCATOR);
        String elementName = (String) properties.get(LocatorProperties.ELEMENT_NAME);
        try {
            return getWebElement(locateUsing, locator);
        }
        catch (NoSuchElementException e) {
            fail("Unable to locate Selenide Element for field " + f.getName() + " decorated with name " + elementName + ".");
        }
        return null;
    }

    public static Map<LocatorProperties, Object> getDefinedProperties(Field f) {
        if (!f.isAnnotationPresent(ElementMeta.class))
            fail("Unable to process the field " +  f.getName() + " because it is not decorated with @ElementsMeta annotation.");
        EnumMap<LocatorProperties, Object> properties = new EnumMap<>(LocatorProperties.class);
        properties.put(LocatorProperties.LOCATE_USING, f.getAnnotation(ElementMeta.class).locateUsing());
        properties.put(LocatorProperties.LOCATOR, f.getAnnotation(ElementMeta.class).locator());
        properties.put(LocatorProperties.ELEMENT_NAME, f.getAnnotation(ElementMeta.class).elementName());
        return properties;
    }

    enum LocatorProperties {
        LOCATE_USING,
        LOCATOR,
        ELEMENT_NAME
    }
}

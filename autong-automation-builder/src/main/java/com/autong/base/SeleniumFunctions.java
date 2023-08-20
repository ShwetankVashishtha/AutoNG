package com.autong.base;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFunctions {

    public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
        try {
            element.sendKeys(valueToBeSent);
        } catch (Exception e) {
            System.out.println("Value enter in field: " + fieldName + " is failed due to exception: " + e);
        }
    }

    //custom click method to log evey click action in to extent report
    public void click_custom(WebElement element, String fieldName) {
        try {
            element.click();
        } catch (Exception e) {
            //log failure in extent
            System.out.println("Unable to click on field: " + fieldName + " due to exception: " + e);
        }
    }


    //clear data from field
    public void clear_custom(WebElement element, String fieldName) {
        try {
            element.clear();
            Thread.sleep(250);
        } catch (Exception e) {
            System.out.println("Unable to clear Data on field: " + fieldName + " due to exception: " + e);

        }
    }

    //custom mouseHover
    public void moveToElement_custom(WebElement element, String fieldName) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) TestBase.getDriver();
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            Actions actions = new Actions(TestBase.getDriver());
            actions.moveToElement(element).build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to hover mouse on field: " + fieldName + " due to exception: " + e);
        }
    }

    //check if element is Present
    public boolean isElementPresent_custom(WebElement element, String fieldName) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            return flag;
        } catch (Exception e) {
            System.out.println("Checking for presence of field: " + fieldName + " not tested due to exception: " + e);
            return flag;
        }
    }


    //Select dropdown value value by visibleText
    public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText) throws Throwable {
        try {
            Select s = new Select(element);
            s.selectByVisibleText(ddVisibleText);
        } catch (Exception e) {
            System.out.println("Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
        }
    }

    //Select dropdown value value by value
    public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
        try {
            Select s = new Select(element);
            s.selectByValue(ddValue);
        } catch (Exception e) {
            System.out.println("Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
        }
    }

    //String Asserts
    public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
        try {
            if (actualValue.equals(expvalue)) {
                System.out.println("String Assertion is successful on field " + locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
            } else {
                System.out.println("String Assertion FAILED on field " + locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }

    //Get text from webelement
    public String getText_custom(WebElement element, String fieldName) {
        String text = "";
        try {
            text = element.getText();
            return text;
        } catch (Exception e) {
            System.out.println(fieldName + "==> Text not retried due to exception: " + e);

        }
        return text;
    }
}

package com.autong.utilities.meta;

import com.autong.base.TestBase;
import com.autong.utilities.annotations.ObjectLoaderMeta;
import com.autong.utilities.annotations.WaitForLoad;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectLoader {

    /**
     * This function returns the first occurrence of method @ObjectLoadMeta
     * depending on the platform where the portal was opened.
     *
     * @param methods   These are the declared methods in a given base page
     *                  component.
     * @param className This is the name of the class passed to the function to
     *                  throw <br>
     *                  relevant error message.
     * @return It returns the Method annotated with @ObjectLoadMeta.
     * @author Shwetank Vashishtha
     */
    public static Method getObjectLoaderMethod(Method[] methods, String className) {
        boolean isMobile = TestBase.isMobile();
        Method method = (isMobile) ? Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(ObjectLoaderMeta.class) &&
                        !m.getAnnotation(ObjectLoaderMeta.class).platform().equals(Platform.WEB))
                .findFirst()
                .orElse(null)
                : Arrays.stream(methods)
                        .filter(m -> m.isAnnotationPresent(ObjectLoaderMeta.class) &&
                                !m.getAnnotation(ObjectLoaderMeta.class).platform().equals(Platform.MOBILE))
                        .findFirst()
                        .orElse(null);
        String platform = (isMobile) ? "MOBILE" : "WEB";
        if (method == null)
            fail("Object Loader not found for the " + platform + " platform in the class" + className);
        return method;
    }

    /**
     * A page component is said to be loaded in browser in case all its fields are
     * loaded successfully.
     * This function validates the same and is used
     *
     * @param fieldList It is the list of the fields in the Page Component
     * @author Shwetank Vashishtha
     */
    public static void applyWaitOnFields(List<Field> fieldList) {
        for (Field field : fieldList) {
            WebElement element = ProcessElementMeta.getWebElement(field);
            assert element != null;
            new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOf(element));
        }
    }

    /**
     * This function is used by the ObjectLoader to wait for the page component to
     * load.
     *
     * @param objectClass This is the class for the page component on which wait
     *                    needs to be applied.
     * @throws NoSuchMethodException  - Throws when class is missing a No Arguments
     *                                Constructor.
     * @throws IllegalAccessException - Throws when No Arguments Constructor is not
     *                                set to public.
     * @author Shwetank Vashishtha
     */
    public static void waitForObjectToLoad(Class<?> objectClass)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object object = objectClass.getDeclaredConstructor().newInstance();
        List<Field> allFields = TestBase.getFieldsForPlatform(object);
        List<Field> waitForLoadFields = allFields.stream()
                .filter(f -> f.isAnnotationPresent(WaitForLoad.class)).collect(Collectors.toList());
        applyWaitOnFields(waitForLoadFields);
    }

    public static void waitForElement(Field field, WaitCondition waitCondition) {
        WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(30));
        switch (waitCondition) {
            case Visible:
                wait.until(ExpectedConditions.visibilityOf(ProcessElementMeta.getWebElement(field)));
            case Clickable:
                wait.until(ExpectedConditions.elementToBeClickable(ProcessElementMeta.getWebElement(field)));
            case Invisibility:
                wait.until(ExpectedConditions.invisibilityOf(ProcessElementMeta.getWebElement(field)));
        }
    }
}

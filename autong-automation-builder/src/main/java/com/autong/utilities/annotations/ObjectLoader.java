package com.autong.utilities.annotations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.fail;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectLoader {

    /**
     * This function returns the first occurrence of method @ObjectLoadMeta depending on the platform where the portal was opened.
     *
     * @param methods   These are the declared methods in a given base page component.
     * @param className This is the name of the class passed to the function to throw <br> relevant error message.
     * @return It returns the Method annotated with @ObjectLoadMeta.
     * @author Shwetank Vashishtha
     */
    private static Method getObjectLoaderMethod(Method[] methods, String className) {
        boolean isMobile = false;
        Method method = (isMobile) ?
                Arrays.stream(methods)
                        .filter(m -> m.isAnnotationPresent(ObjectLoaderMeta.class) &&
                                !m.getAnnotation(ObjectLoaderMeta.class).platform().equals(Platform.WEB))
                        .findFirst()
                        .orElse(null)
                :
                Arrays.stream(methods)
                        .filter(m -> m.isAnnotationPresent(ObjectLoaderMeta.class) &&
                                !m.getAnnotation(ObjectLoaderMeta.class).platform().equals(Platform.MOBILE))
                        .findFirst()
                        .orElse(null);
        String platform = (isMobile) ? "MOBILE" : "WEB";
        if (method == null) fail("Object Loader not found for the " + platform + " platform in the class" + className);
        return method;
    }
}

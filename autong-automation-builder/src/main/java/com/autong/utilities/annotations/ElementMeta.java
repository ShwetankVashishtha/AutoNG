package com.autong.utilities.annotations;

import com.autong.utilities.meta.LocateUsing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ElementMeta {
    LocateUsing locateUsing() default LocateUsing.XPATH;

    String locator() default "";

    String elementName() default "";
}

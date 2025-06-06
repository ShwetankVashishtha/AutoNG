package com.autong.utilities.annotations;

import com.autong.utilities.meta.Platform;

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
@Target(ElementType.METHOD)
public @interface ObjectLoaderMeta {
    Platform platform() default Platform.COMMON;
}

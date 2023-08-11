package com.autong.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecBuilder {

    /**
     * @param basePath
     * @param username
     * @param password
     * @param headers  accepts api request headers
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String basePath, String username, String password, Map<String, String> headers) {
        return new RequestSpecBuilder()
                .setAuth(RestAuthenticator.setAuthentication(username, password))
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }

    /**
     * @param basePath
     * @param headers  accepts api request headers
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String basePath, Map<String, String> headers) {
        return new RequestSpecBuilder()
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }

    /**
     * @param basePath
     * @param username
     * @param password
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String basePath, String username, String password) {
        return new RequestSpecBuilder()
                .setAuth(RestAuthenticator.setAuthentication(username, password))
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * @param basePath
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String basePath) {
        return new RequestSpecBuilder()
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * @return Response specifications
     */
    public static ResponseSpecification responseSpecs() {
        return new ResponseSpecBuilder()
                .build();
    }
}

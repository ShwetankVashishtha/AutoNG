package com.autong.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecBuilder {

    private static final Logger logger = Logger.getLogger(SpecBuilder.class.getName());

    /**
     * @param username
     * @param password
     * @param headers  accepts api request headers
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String username, String password, Map<String, String> headers) {
        return new RequestSpecBuilder()
                .setAuth(RestAuthenticator.setAuthentication(username, password))
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }

    /**
     * @param headers  accepts api request headers
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(Map<String, String> headers) {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }

    /**
     * @param username
     * @param password
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String username, String password) {
        return new RequestSpecBuilder()
                .setAuth(RestAuthenticator.setAuthentication(username, password))
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs() {
        return new RequestSpecBuilder()
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

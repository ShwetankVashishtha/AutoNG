package com.autong.base;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

import static com.autong.base.SpecBuilder.requestSpecs;
import static io.restassured.RestAssured.given;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestResources {

    /**
     * @param path        accepts request uri
     * @param requestBody accepts request body as POJO
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String path, Object requestBody) {
        return given(SpecBuilder.requestSpecs())
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param path        accepts request uri
     * @param requestBody accepts request body as JSON File
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String path, File requestBody) {
        return given(SpecBuilder.requestSpecs())
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param path accepts request uri
     * @return Request Specifications
     * @apiNote GET request
     */
    public static Response get(String path) {
        return given(SpecBuilder.requestSpecs())
                .when().get(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }
}

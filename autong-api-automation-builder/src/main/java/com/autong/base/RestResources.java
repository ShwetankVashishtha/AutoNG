package com.autong.base;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestResources {

    /**
     * @param basePath
     * @param path        accepts request uri
     * @param username
     * @param password
     * @param requestBody accepts request body as POJO
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String basePath, String path, String username, String password, Object requestBody) {
        return given(SpecBuilder.requestSpecs(basePath, username, password))
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path        accepts request uri
     * @param requestBody accepts request body as POJO
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String basePath, String path, Object requestBody) {
        return given(SpecBuilder.requestSpecs(basePath))
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path        accepts request uri
     * @param username
     * @param password
     * @param requestBody accepts request body as JSON File
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String basePath, String path, String username, String password, File requestBody) {
        return given(SpecBuilder.requestSpecs(basePath, username, password))
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path        accepts request uri
     * @param requestBody accepts request body as JSON File
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String basePath, String path, File requestBody) {
        return given(SpecBuilder.requestSpecs(basePath))
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path        accepts request uri
     * @param requestBody accepts request body
     * @param headers     accepts request headers
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String basePath, String path, Object requestBody, Map<String, String> headers) {
        return given(SpecBuilder.requestSpecs(basePath, headers)).log().all()
                .body(requestBody).expect().defaultParser(Parser.JSON)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path        accepts request uri
     * @param requestBody accepts request body
     * @param username
     * @param password
     * @param headers     accepts request headers
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String basePath, String path, Object requestBody, String username, String password, Map<String, String> headers) {
        return given(SpecBuilder.requestSpecs(basePath, username, password, headers)).log().all()
                .body(requestBody).expect().defaultParser(Parser.JSON)
                .when()
                .post(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @return Request Specifications
     * @apiNote GET request
     */
    public static Response get(String basePath, String path) {
        return given(SpecBuilder.requestSpecs(basePath))
                .when().get(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param username
     * @param password
     * @param path     accepts request uri
     * @return Request Specifications
     * @apiNote GET request
     */
    public static Response get(String basePath, String path, String username, String password) {
        return given(SpecBuilder.requestSpecs(basePath, username, password))
                .when().get(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @param headers
     * @return Request Specifications
     * @apiNote DELETE request
     */
    public static Response delete(String basePath, String path, Map<String, String> headers) {
        return given(SpecBuilder.requestSpecs(basePath, headers))
                .when().delete(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @param headers
     * @param username
     * @param password
     * @return Request Specifications
     * @apiNote DELETE request
     */
    public static Response delete(String basePath, String path, Map<String, String> headers, String username, String password) {
        return given(SpecBuilder.requestSpecs(basePath, username, password, headers))
                .when().delete(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @param headers
     * @return Request Specifications
     * @apiNote PUT request
     */
    public static Response put(String basePath, String path, Map<String, String> headers, Object requestBody) {
        return given(SpecBuilder.requestSpecs(basePath, headers))
                .body(requestBody).expect().defaultParser(Parser.JSON)
                .when().put(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @param headers
     * @param username
     * @param password
     * @return Request Specifications
     * @apiNote PUT request
     */
    public static Response put(String basePath, String path, Map<String, String> headers, String username, String password, Object requestBody) {
        return given(SpecBuilder.requestSpecs(basePath, username, password, headers))
                .body(requestBody).expect().defaultParser(Parser.JSON)
                .when().put(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @param username
     * @param password
     * @return Request Specifications
     * @apiNote PUT request
     */
    public static Response put(String basePath, String path, String username, String password, Object requestBody) {
        return given(SpecBuilder.requestSpecs(basePath, username, password))
                .body(requestBody).expect().defaultParser(Parser.JSON)
                .when().put(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param basePath
     * @param path     accepts request uri
     * @return Request Specifications
     * @apiNote PUT request
     */
    public static Response put(String basePath, String path, Object requestBody) {
        return given(SpecBuilder.requestSpecs(basePath))
                .body(requestBody).expect().defaultParser(Parser.JSON)
                .when().put(path)
                .then().spec(SpecBuilder.responseSpecs())
                .extract()
                .response();
    }
}

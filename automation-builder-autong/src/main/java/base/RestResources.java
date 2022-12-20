package base;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

import static io.restassured.RestAssured.given;
import static base.SpecBuilder.requestSpecs;
import static base.SpecBuilder.responseSpecs;

/**
 * @author shwetankvashishtha
 * @version 1.0
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
    public static Response post(String username, String password, String path, Object requestBody) {
        return given(requestSpecs(username, password))
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param path        accepts request uri
     * @param requestBody accepts request body as JSON File
     * @return Request Specifications
     * @apiNote POST request
     */
    public static Response post(String username, String password, String path, File requestBody) {
        return given(requestSpecs(username, password))
                .log().all()
                .body(requestBody)
                .when()
                .post(path)
                .then().spec(responseSpecs())
                .extract()
                .response();
    }

    /**
     * @param path accepts request uri
     * @return Request Specifications
     * @apiNote GET request
     */
    public static Response get(String username, String password, String path) {
        return given(requestSpecs(username, password))
                .when().get(path)
                .then().spec(responseSpecs())
                .extract()
                .response();
    }
}

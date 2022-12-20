package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

import static base.RestAuthenticator.setAuthentication;

/**
 * @author shwetankvashishtha
 * @version 1.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecBuilder {

    /**
     * @param headers accepts api request headers
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(Map<String, String> headers, String username, String password) {
        return new RequestSpecBuilder()
                .setAuth(setAuthentication(username, password))
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }

    /**
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs(String username, String password) {
        return new RequestSpecBuilder()
                .setAuth(setAuthentication(username, password))
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

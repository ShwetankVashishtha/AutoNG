package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

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
    public static RequestSpecification requestSpecs(Map<String, String> headers) {
        return new RequestSpecBuilder()
                .setBasePath("")
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }

    /**
     * @return Request Specifications
     */
    public static RequestSpecification requestSpecs() {
        return new RequestSpecBuilder()
                .setBasePath("")
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
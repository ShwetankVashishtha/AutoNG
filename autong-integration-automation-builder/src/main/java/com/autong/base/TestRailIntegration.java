package com.autong.base;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
@Getter
@Setter
@AllArgsConstructor
public class TestRailIntegration {

    private static final Logger logger = Logger.getLogger(TestRailIntegration.class.getName());
    static Response response;
    static private String testRailHostUrl, testRailUsername, testRailPassword, runId;

    public static void getRun() {
        response = RestResources.get(testRailHostUrl + "/api/v2/get_run/", testRailUsername, testRailPassword + runId);
        logger.info(response.asPrettyString());
    }
}

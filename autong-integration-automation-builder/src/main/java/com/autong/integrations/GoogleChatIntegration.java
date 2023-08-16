package com.autong.integrations;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class GoogleChatIntegration {

    private static final Logger logger = Logger.getLogger(GoogleChatIntegration.class.getName());
    private static final Gson gson = new Gson();
    private static final HttpClient client = HttpClient.newHttpClient();

    /**
     * Publish test execution results in google chat space "Phoenix-Admin-App_QA-Automation"
     * defines pass, fail & skip test count
     * external link to cucumber shared execution report
     *
     * @param googleChatSpaceUrl
     * @param cucumberReportUrl
     * @param env
     * @param suiteType
     * @param pass
     * @param fail
     * @param skip
     */
    public static void publishResults(String googleChatSpaceUrl, String cucumberReportUrl, String env, String suiteType, int pass, int fail, int skip) throws Exception {

        String message = gson.toJson(Map.of("text", "Status of the App (" + env + ") " + suiteType + '\n' + '\n' +
                "Pass: " + pass + '\n' +
                "Fail: " + fail + '\n' +
                "Skip: " + skip + '\n' + '\n' +
                "Detailed report: " + cucumberReportUrl));

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(googleChatSpaceUrl))
                .header("accept", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        logger.info(response.body());
    }
}
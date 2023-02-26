package steps.restAPIs;

import base.Assertions;
import base.RestResources;
import base.StatusCodeValidator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class UsersSteps {

    Response response;

    @When("user executes post call to add test result")
    public void postAddTestResult() {
        response = RestResources.get("https://reqres.in/api/users");
        System.out.println(response.asPrettyString());
    }

    @Then("user should be able to receive a valid response")
    public void validateResponse() {
        Assertions.validateOkResponse(response);
        Assertions.validateResponseTime(response);
    }
}

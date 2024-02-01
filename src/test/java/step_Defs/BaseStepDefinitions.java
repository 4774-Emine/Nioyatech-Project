package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.Base;

import static org.junit.Assert.assertEquals;

public class BaseStepDefinitions extends Base {
    @Given("{string} path parameters are prepared for the request")
    public void path_parameters_are_prepared_for_the_request(String pathParams) {
        preparePathParams(pathParams);
        logger.info("Prepared path params: "+pathParams);
    }
    @Given("{string} query parameter is set {int} for request")
    public void query_parameter_is_set_for_request(String queryParam, int value) {
        spec.queryParam(queryParam,value);
        logger.info("The query param "+queryParam+" is set "+value);
    }
    @When("GET request sent response is saved")
    public void get_request_sent_response_is_saved() {
        sendGet();
        logger.info("Get request sent and response is saved and converted");
    }
    @Then("Verify response status code is {int}")
    public void Verify_response_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode());
        logger.info("Status code: "+expectedStatusCode);
    }
}

package services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Base {
    public static final Logger logger = LogManager.getLogger(Base.class);

    // SPEC-PARAMS
    public static RequestSpecification spec;
    public static String specParams;


    // RESPONSE
    protected static Response response;
    protected static JSONObject responseBodyJson;
    protected static JsonPath responseJsonPath;
    protected static String responseStr;

    public void convertResponse() {
        responseJsonPath = response.jsonPath();
        responseStr = responseJsonPath.prettify();
        responseBodyJson = new JSONObject(responseStr);
    }

    public void sendGet() {
        response = given(spec).when().get(specParams);
        convertResponse();
    }


    public void preparePathParams(String pathParams) {

        spec.pathParam("pp0", pathParams);
        specParams = "/{pp0}";

    }
}
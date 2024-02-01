package step_Defs;

import io.cucumber.java.en.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import services.Breeds;

public class BreedsStepDefinitions extends Breeds {

    @Then("Verify that the {string} key value of the object at the {int} index is {string}")
    public void verifyingTheKeyValueAtTheDesiredIndex(String key,int index,String expectedValue) {
        JSONArray dataJsonArray=responseBodyJson.getJSONArray("data");
        JSONObject breed=dataJsonArray.getJSONObject(index);
        Assert.assertEquals(expectedValue,breed.get(key));
        logger.info("It has been confirmed that the  " + key + "  key value of the object at the  " + index + "  index is " + expectedValue + "  .");
    }

    @Then("Verify that there are {int} objects in the returned data")
    public void verifyingTheDesiredNumberOfObjectsInTheReturnedData(int expectedObjectCount) {
        JSONArray dataJsonArray=responseBodyJson.getJSONArray("data");
        Assert.assertEquals(expectedObjectCount,dataJsonArray.length());
        logger.info("It has been confirmed that there are " +expectedObjectCount+ " objects in the returned data.");
    }
}
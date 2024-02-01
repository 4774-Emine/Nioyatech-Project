package step_Defs;

import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.junit.Assert;
import services.Facts;

public class FactsStepDefinitions extends Facts {

    @Then("Verify that each returned fact is less than {int} characters")
    public void characterVerificationOfEachFact(int expectedMaximumLength) {
        JSONArray dataJsonArray = responseBodyJson.getJSONArray("data");
        boolean flag = true;
        for (int i = 0; i < dataJsonArray.length(); i++) {
            if (dataJsonArray.getJSONObject(i).length() > expectedMaximumLength) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
        logger.info("Each fact returned was verified to be less than"+expectedMaximumLength+"characters.");
    }

    @Then("Verify the returned random fact is less than {int} characters")
    public void characterVerificationOfRandomFact(int expectedMaximumLength) {
        Assert.assertTrue(responseJsonPath.getString("fact").length() <= expectedMaximumLength);
        Assert.assertTrue(responseBodyJson.getString("fact").length() <= expectedMaximumLength);
        logger.info("Verified that the returned random fact is less than"+expectedMaximumLength+"characters.");
    }


}

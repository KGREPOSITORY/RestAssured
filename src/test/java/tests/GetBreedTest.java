package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetBreedTest extends BaseTest{
    String expectedName = "abob2";

    @Test
    @Description("Check that expected breed is present")
    @Severity(value = SeverityLevel.BLOCKER)
    public void getBreedTest(){
        logger.info("Get all breeds");
        Response response = requests.getBreedList();

        logger.info("Assert that request was performed successfully");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        logger.info("Assert that expected breed is present");
        Assert.assertEquals(response.jsonPath().getString("id[2]"), expectedName);
    }

}

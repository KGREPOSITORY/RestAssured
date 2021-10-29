package tests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetBreedTest extends BaseTest{
    String expectedName = "abob2";

    @Test
    public void getBreedTest(){
        logger.info("Get all breeds");
        Response response = requests.getBreedList();

        logger.info("Assert that request was performed successfully");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        logger.info("Assert that expected breed is present");
        Assert.assertEquals(response.jsonPath().getString("id[2]"), expectedName);
    }

}
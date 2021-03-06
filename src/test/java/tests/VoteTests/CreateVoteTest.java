package tests.VoteTests;

import Froms.VoteForm;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.BaseTest;


public class CreateVoteTest extends BaseVoteTest {


    @Test(dataProvider = "Vote list with valid data", dataProviderClass = BaseTest.class, singleThreaded = true)
    @Description("Check that it is possible to create new vote")
    public void createVoteTest(VoteForm voteForm){

            logger.info("Create new vote with image_id :" + voteForm.getImageId());
            Response response = voteAPISteps.createVote(voteForm);
            response.then().assertThat().statusCode(HttpStatus.SC_OK);
            voteForm.setId(Integer.parseInt(response.jsonPath().get("id").toString()));
            response = voteAPISteps.getVote(voteForm.getId());
            response.then().assertThat().statusCode(HttpStatus.SC_OK);

            logger.info("Assert that new instance was created with id : " + voteForm.getId());
            response.then().log().body();
            VoteForm actualForm = response.then().extract().body().as(VoteForm.class);
            assertTrue(voteForm.equals(actualForm));

    }
}
package tests;

import Froms.VoteForm;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class CreateVoteTest extends BaseTest{


    @Test(dataProvider = "Vote list with valid data", dataProviderClass = BaseTest.class, singleThreaded = true)
    @Description("Check that it is possible to create new vote")
    public void createVoteTest(VoteForm voteForm){

            logger.info("Create new vote with image_id :" + voteForm.getImageId());
            Response response = requests.createVote(voteForm);
            response.then().assertThat().statusCode(HttpStatus.SC_OK);
            voteForm.setId(Integer.parseInt(response.jsonPath().get("id").toString()));
            response = requests.getVote(voteForm.getId());
            response.then().assertThat().statusCode(HttpStatus.SC_OK);

            logger.info("Assert that new instance was created with id : " + voteForm.getId());
            response.then().log().body();
            VoteForm actualForm = response.then().extract().body().as(VoteForm.class);
            voteSteps.assertThatObjectsAreEquals(voteForm, actualForm);

    }
}

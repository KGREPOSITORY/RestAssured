package tests;

import Froms.VoteForm;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class CreateVoteTest extends BaseTest{


    @Test
    @Description("Check that it is possible to create new vote")
    public void createVoteTest(){
        logger.info("Create new voite");
        Response response = requests.createVote(voteForm);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        VoteForm expectedVoteForm = (VoteForm) voteForm;
        expectedVoteForm.setId(Integer.parseInt(response.jsonPath().get("id").toString()));
        response = requests.getVote(expectedVoteForm.getId());
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        logger.info("Assert that new instance was created");
        response.then().log().body();
        VoteForm actualForm = response.then().extract().body().as(VoteForm.class);
        voteSteps.assertThatObjectsAreEquals(expectedVoteForm, actualForm);
    }
}

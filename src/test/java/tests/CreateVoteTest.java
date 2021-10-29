package tests;

import Froms.VoteForm;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateVoteTest extends BaseTest{


    @Test
    public void createVoteTest(){

        logger.info("Create new voite");
        Response response = requests.createVote(voteForm);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        VoteForm actualVoteForm = (VoteForm) voteForm;
        actualVoteForm.setId(Integer.parseInt(response.jsonPath().get("id").toString()));
        response = requests.getVote(actualVoteForm.getId());
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        logger.info("Assert that new instance was created");
        response.then().log().body();
        VoteForm actualForm = response.then().extract().body().as(VoteForm.class);
        Assert.assertTrue(actualForm.equals(actualVoteForm));
    }
}
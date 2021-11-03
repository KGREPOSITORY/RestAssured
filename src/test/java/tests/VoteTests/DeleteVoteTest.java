package tests.VoteTests;

import APIsteps.VoteAPISteps;
import Froms.VoteForm;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DeleteVoteTest extends BaseVoteTest {

    @Test(dataProvider = "Vote data", dataProviderClass = BaseTest.class)
    @Severity(SeverityLevel.MINOR)
    @Description("Check that it is possible to delete vote")
    public void deleteVoiteTest(VoteForm voteForm){


        logger.info("Create new voite");
        Response response = new VoteAPISteps().createVote(voteForm);

        logger.info("Assert that new voite was created successfully");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        logger.info("Delete created voite");
        int id = response.jsonPath().get("id");
        response = voteAPISteps.deleteVote(id);
        response.then().statusCode(HttpStatus.SC_OK);

        logger.info("Assert that voite was deleted");
        response = voteAPISteps.getVote(id);
        response.then().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

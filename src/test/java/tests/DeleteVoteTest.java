package tests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class DeleteVoteTest extends BaseTest {

    @Test
    public void deleteVoiteTest(){
        logger.info("Create new voite");
        Response response = requests.createVote(voteForm);

        logger.info("Assert that new voite was created successfully");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        logger.info("Delete created voite");
        int id = response.jsonPath().get("id");
        response = requests.deleteVote(id);
        response.then().statusCode(HttpStatus.SC_OK);

        logger.info("Assert that voite was deleted");
        response = requests.getVote(id);
        response.then().statusCode(HttpStatus.SC_NOT_FOUND);


    }
}

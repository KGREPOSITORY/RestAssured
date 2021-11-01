package steps;


import Froms.VoteForm;
import io.qameta.allure.Step;
import org.testng.Assert;

public class VoteSteps {

    @Step
    public void assertThatObjectsAreEquals(VoteForm voteForm1, VoteForm voteForm2){
        Assert.assertTrue(voteForm1.equals(voteForm2));
    }
}

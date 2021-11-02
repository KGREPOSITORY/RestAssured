package tests;

import Froms.Form;
import Froms.VoteForm;
import frame.Requests;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import steps.VoteSteps;

import java.util.logging.Logger;


public class BaseTest extends Assert {
    protected static Requests requests;
    protected static Logger logger = Logger.getLogger("Step logger");
    protected VoteSteps voteSteps = new VoteSteps();


    @BeforeSuite
    @Step("Prepare requests class")
    public void initRequest(){
        requests = new Requests();
    }


    @DataProvider(name = "Vote list with valid data")
    public static Object[][] prepareVoteDataList(){
        return new Object[][]{
                {new VoteForm("qwe1","my-user-12",1)},
                {new VoteForm("qwe2","my-user-1",1)},
                {new VoteForm("qwe3","my-user-10",1)},
                {new VoteForm("qwe4","my-user-9",1)},
        };
    }

    @DataProvider(name = "Vote data")
        public static Object[][] prepareVoteData(){
        return new Object[][]{{new VoteForm("qwe1","my-user-12",1)}};
    }
}

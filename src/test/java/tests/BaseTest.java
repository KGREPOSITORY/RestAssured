package tests;

import Froms.Form;
import Froms.VoteForm;
import frame.Requests;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import steps.VoteSteps;

import java.util.logging.Logger;


public class BaseTest {
    protected static Requests requests;
    protected Form voteForm;
    protected static Logger logger = Logger.getLogger("Step logger");
    protected VoteSteps voteSteps = new VoteSteps();


    @BeforeClass
    @Step("Prepare vote class form")
    public void init(){
        voteForm = new VoteForm("asf2","my-user-1234", 1 );
    }

    @BeforeTest()
    @Step("Prepare requests class")
    public void initRequest(){
        requests = new Requests();
    }
}

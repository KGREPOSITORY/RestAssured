package tests;

import Froms.Form;
import Froms.VoteForm;
import frame.Requests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;


public class BaseTest {
    protected static Requests requests;
    protected Form voteForm;
    protected static Logger logger = Logger.getLogger("Step logger");


    @BeforeClass
    public void init(){
        voteForm = new VoteForm("asf2","my-user-1234", 1 );
    }

    @BeforeTest()
    public void initRequest(){
        requests = new Requests();
    }
}

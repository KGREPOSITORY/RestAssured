package tests;

import Froms.VoteForm;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.logging.Logger;


public class BaseTest extends Assert {
    protected static Logger logger = Logger.getLogger("Step logger");


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

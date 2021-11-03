package tests.BreedTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetBreedByNameTest extends BaseBreedTest {


    @Severity(SeverityLevel.BLOCKER)
    @Parameters({"BreedName"})
    @Test
    public void getBreedByNameTest(String name){
        logger.info("Try to get breed by " + name + " BreedName");
        Response response = breedSteps.getBreedByName(name);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        assertEquals(response.jsonPath().get("name").toString(), '['+name+']');
    }
}

package frame;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class APIConfigs {
    protected RestAssured restAssured = new RestAssured();

    protected APIConfigs(RequestSpecification requestSpecification){
        restAssured.requestSpecification = requestSpecification;
    }


}

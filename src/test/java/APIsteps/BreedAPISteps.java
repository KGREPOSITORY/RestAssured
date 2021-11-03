package APIsteps;


import api.BaseRequest;
import enums.Endpoint;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BreedAPISteps extends BaseRequest{

    @Step("Perform get breed list request")
    public Response getBreedList(){
        return apiRequests.getRequest(Endpoint.BREEDS);
    }
}

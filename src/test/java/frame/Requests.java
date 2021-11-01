package frame;

import Froms.Form;
import enums.Endpoint;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Requests {
    private final String BACEURL = "https://api.thecatapi.com/v1/";

    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BACEURL)
            .addHeader("x-api-key", System.getProperty("token"))
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.ANY)
            .build();
    private ApiRequests apiRequests = new ApiRequests(requestSpecification);


    @Step("Perform get breed list request")
    public Response getBreedList(){
        return apiRequests.getRequest(Endpoint.BREEDS);
    }

    @Step("Perform get vote request with following parameters {voteId} ")
    public Response getVote(int voteId){
        return apiRequests.getRequest(Endpoint.VOTE, voteId);
    }

    @Step("Perform create request for vote")
    public Response createVote(Form form){
        return apiRequests.postRequest(Endpoint.VOTE, form);
    }

    @Step("Perform delete request for vote with {voiteId} id")
    public Response deleteVote(int voiteId){
        return apiRequests.deleteRequest(Endpoint.VOTE, voiteId);
    }


}

package APIsteps;

import Froms.Form;
import api.BaseRequest;
import enums.Endpoint;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class VoteAPISteps extends BaseRequest {

    @Step("Perform get vote request with following parameters {voteId}")
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

package api;

import Froms.Form;
import enums.Endpoint;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiRequests {


    public ApiRequests(RequestSpecification requestSpecification){
        RestAssured.requestSpecification = requestSpecification;
    }

    public Response getRequest(Endpoint endpoint){
       return RestAssured
                .given()
                    .when()
                .and().log().all()
                    .get(endpoint.getEndpoint());
    }

    public Response getRequest(Endpoint endpoint, int value){
        return RestAssured
                .given()
                .when()
                .and().log().all()
                .get(endpoint.getEndpoint()+"/"+value);
    }

    public Response postRequest(Endpoint endpoint, Form pojo){
        return RestAssured
                .given()
                .body(pojo)
                .when().body(pojo)
                .and().log().all()
                .post(endpoint.getEndpoint());
    }

    public Response deleteRequest(Endpoint endpoint, int value){
        return RestAssured
                .given()
                .when().log().all()
                .delete(endpoint.getEndpoint() +'/'+value);

    }
}

package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

        protected static final String BACEURL = "https://api.thecatapi.com/v1/";

        protected static RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BACEURL)
                .addHeader("x-api-key", System.getProperty("token"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.ANY)
                .build();

        protected ApiRequests apiRequests = new ApiRequests(requestSpecification);
}

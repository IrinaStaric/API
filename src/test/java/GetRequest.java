import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;

import org.junit.jupiter.api.Test;

public class GetRequest {
    @Test
    public void GetBookingDetails() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://");

        Response response = request.get();
        String responseData = response.asString();
        System.out.println("The Response Data: " + responseData);

        String responsePrettyData = response.asPrettyString();
        System.out.println("The Response Pretty Data: " + responsePrettyData);

        ValidatableResponse respData = response.then();
        respData.statusCode(200);
        respData.statusLine("HTTP/1.1 200 OK");
    }
}

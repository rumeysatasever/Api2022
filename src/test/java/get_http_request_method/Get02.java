package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get02 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
   @Test
   public void get02(){

    spec.pathParams("first","booking","second",1);
//send the request and get the response
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
       response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
      assertTrue(response.asString().contains("Not found"));

      assertFalse(response.asString().contains("TechProEd"));

      assertEquals("Cowboy",response.getHeader("Server"));




   }
}

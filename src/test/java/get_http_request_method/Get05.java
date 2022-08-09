package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

/*
Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Mark" and last name is "Ericsson"
 */
@Test

public void Get05(){

    //1.step:Set the URL

    spec.
            pathParam("first","booking").
            queryParams("firstname","Mary","lastname","Ericsson");

    //2.step:Set the expected data
    //3.step:Send request get data
     Response response =   given().spec(spec).when().get("/{first}");
     response.prettyPrint();
     //4.step:Do the assertion
    response.then().assertThat().statusCode(200);
    assertTrue(response.asString().contains("bookingid"));



}





}

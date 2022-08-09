package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get09 extends HerOkuAppBaseUrl {
//    Given
//    https://restful-booker.herokuapp.com/booking/91
//    When
//    I send GET Request to the url
//            Then
//    Response body should be like that;
//    {
//        "firstname":"James" ,
//          "lastname": "Brown" ,
//            "totalprice": 111,
//            "depositpaid": true,
//            "bookingdates": {
//             "checkin": "2018-01-01",
//             "checkout": "2019-01-01"
//
//
//
@Test
    public void get09(){

    spec.pathParams("first","booking","second",91);
    //2.step;Set the expected data
    Map<String,String>expectedbookingdates = new HashMap<>();
    expectedbookingdates.put("checkin","2018-01-01");
    expectedbookingdates.put("checkout","2019-01-01");

   Map<String,Object>expectedData= new HashMap<>();
    expectedData.put("lastname", "Brown");
   expectedData.put( "totalprice", 111);
    expectedData.put("depositpaid", true );
    expectedData.put("bookingdates",expectedbookingdates);
    expectedData.put("additionalneeds","Late Checkout");
    System.out.println(expectedData);

    //3.step;Send the request and get the response
    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    Map<String,Object>actualData = response.as(HashMap.class);
    System.out.println(actualData);

    //4.step:Do assertion
    assertEquals(expectedData.get("firstname"),actualData.get("firstname'"));





}





}

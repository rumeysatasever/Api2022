package post_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post01 extends HerOkuAppBaseUrl {
    /*
    Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
*/

@Test
    public void post01(){
    //1.step:Set the url
    spec.pathParam("first","booking");

   //2.step:Set the expected data
    Map<String,String>expectedbookingdates = new HashMap<>();
    expectedbookingdates.put("checkin","2021-09-09");
    expectedbookingdates.put("checkout","2021-09-21");
    Map<String,Object> expectedData= new HashMap<>();
    expectedData.put("firstname", "John");
    expectedData.put("lastname", "Doe");
    expectedData.put( "totalprice", 11111);
    expectedData.put("depositpaid", true );
    expectedData.put("bookingdates",expectedbookingdates);
    System.out.println(expectedData);
//3.step:Send the post request and get the response
   Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
   response.prettyPrint();

//4.step:Do assertion
    Map<String,Object>actualData = response.as(HashMap.class);
    System.out.println(actualData);

    assertEquals(expectedData.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
    assertEquals(expectedData.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
    assertEquals(expectedData.get("totalprice"),((Map)actualData.get("booking")).get("totalprice"));
    assertEquals(expectedData.get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));

    assertEquals(expectedbookingdates.get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
    assertEquals(expectedbookingdates.get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));


}










}

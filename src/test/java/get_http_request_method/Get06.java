package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {

 @Test
 public void get06(){
  //1.step:Set the URL
     spec.pathParams("first","booking","second",5);
//2.step:Set the expected data
     //3.step:Send the request get the data
     Response response=given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();
     //4.step:Do assertion
     //1.way
     response.
             then().
             assertThat().
             statusCode(200).
             contentType(ContentType.JSON).body("firstname",equalTo("Mark"),
                     "lastname",equalTo("Jones"),
                     "totalprice",equalTo(258),
                     "depositpaid",equalTo(false),
                     "bookingdates.checkin",equalTo("2016-04-22"),
                     "bookingdates.checkout",equalTo("2021-01-07"));

     //2.way(Use JsonPath)
     response.
             then().
             assertThat().
             statusCode(200).
             contentType(ContentType.JSON);
     //Create JsonPath object from response object
     JsonPath json = response.jsonPath();
     assertEquals("firstname is not matching","Mark",json.getString("firstname"));
     assertEquals("lastname is not matching","Jones",json.getString("lastname"));

    //3.way:Soft assertion
     //i)create softassert object

     SoftAssert softAssert = new SoftAssert();


     //ii)by using softAssert object do assertion
     softAssert.assertEquals(json.getString("firstname"),"Mark","firstname is not matching");
     softAssert.assertEquals(json.getString("lastname"),"Jones","lastname is not matching");
     softAssert.assertEquals(json.getInt("totalprice"),258,"totalprice is not matching");
     //iii)do not forget to use assertAll()
    softAssert.assertAll();


 }


    }




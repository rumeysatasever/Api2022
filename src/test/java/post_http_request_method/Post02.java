package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post02 extends JsonPlaceHolderBaseUrl {
   @Test
    public void post02(){

     //1.step:Set the url
     spec.pathParam("first","todos");
     //2.step;Set the expected data
       JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
       Map<String,Object> expectedDataMap = expectedData.expectedDataSetUp(66,"Tidy your room",false);


       //3.step:Send the request,get the response
       Response response =given().
               spec(spec).
               auth().basic("admin","1234").
               contentType(ContentType.JSON).
               body(expectedDataMap ).
               when().
               post("/{first}");
       response.prettyPrint();
       expectedDataMap .put("StatusCode",201);

//4.step:do assertion
       Map<String,Object>actualData = response.as(HashMap.class);
       System.out.println(actualData);

       assertEquals(expectedDataMap .get("StatusCode"),response.getStatusCode());
       assertEquals(expectedDataMap .get("userId"),actualData.get("userId"));
       assertEquals(expectedDataMap .get("title"),actualData.get("title"));
       assertEquals(expectedDataMap .get("completed"),actualData.get("completed"));

   }


}

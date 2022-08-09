package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

   @Test
    public void get08(){
    //1.step:Set the URL
      spec.pathParams("first","todos","second", 2);

   //2.STEP:Set the expected data
       Map<String,Object> expectedData = new HashMap<>();
       expectedData.put("userId",1);
       expectedData.put("id",2);
       expectedData.put("title","quis ut nam facilis et officia qui");
       expectedData.put("completed" , false);
       expectedData.put("status code",200);
       expectedData.put("Via","1.1 vegur");
       expectedData.put("Server","cloudflare");
       System.out.println(expectedData);

   //3.step:Send the request get the response
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
//by using GSON we are able to convert Json Data which is coming from API to Java Object
       Map<String,Object>actualData = response.as(HashMap.class);
       System.out.println(actualData);

   //4.step:Do assertions
       assertEquals(expectedData.get("userId"),actualData.get("userId"));
       assertEquals(expectedData.get("id"),actualData.get("id"));
       assertEquals(expectedData.get("title"),actualData.get("title"));
       assertEquals(expectedData.get("completed"),actualData.get("completed"));
       assertEquals(expectedData.get("status code"),response.getStatusCode());
       assertEquals(expectedData.get("Via"),response.getHeader("Via"));
       assertEquals(expectedData.get("Server"),response.getHeader("Server"));

   }






        }











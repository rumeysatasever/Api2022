package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get07 extends JsonPlaceHolderBaseUrl {
   /* Given
    https://jsonplaceholder.typicode.com/todos
    When
    I send GET Request to the URL
            Then
			1)Status code is 200
            2)Print all ids greater than 190 on the console
              Assert that there are 10 ids greater than 190
            3)Print all userIds whose ids are less than 5 on the console
               //Assert that maximum userIds  less than 5 is 4
            4)Print all titles whose ids are less than 5
              Assert that "delectus aut autem" is one of the titles whose id is less than 5
              */


    @Test
    public void get07(){
        //1.step:set the url
        spec.pathParam("first","todos");
        //2.step:set the expected data
        //3.step:Send request and get the response

       Response response= given().spec(spec).when().get("/{first}");
       response.prettyPrint();
       //4.step: Do assertions

        response.then().assertThat().statusCode(200);

   //Print all ids greater than 190 on the console
        JsonPath json = response.jsonPath();

      List<Integer> idList =  json.getList("findAll{it.id>190}.id");
        System.out.println(idList);
   // Assert that there are 10 ids greater than 190

        assertEquals("id list doesnot have expected size",10,idList.size());
        // Print all userIds whose ids are less than 5 on the console

       List<Integer>userIdList =json.getList("findAll{it.userId<5}.userId");
        System.out.println(userIdList);
        //Assert that maximum userIds  less than 5 is 4
        Collections.sort(userIdList);
        assertEquals((Integer)4,userIdList.get(userIdList.size()-1));

        //Print all titles whose ids are less than 5

        List<Integer>titles =json.getList("findAll{it.id<5}.title");
        System.out.println(titles);
      assertTrue(titles.contains("delectus aut autem"));

    }
}





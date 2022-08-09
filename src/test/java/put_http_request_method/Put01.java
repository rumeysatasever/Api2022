package put_http_request_method;


import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

public class Put01 extends JsonPlaceHolderBaseUrl {

     /*
        Given
           1)https://jsonplaceholder.typicode.com/todos/198
           2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
         I send PUT Request to the Url
       Then
             Status code is 200
             And response body is like   {
                               "userId": 21,
                               "title": "Wash the dishes",
                               "completed": false
                              }
     */

@Test
    public void put01(){
    //1.step:Set the url
    spec.pathParams("first","todos","second",198);
    //2.step:Set the request body
    JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
    requestBody.expectedDataSetUp(21,"Wash the dishes",false);




}


        }



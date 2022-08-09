package get_http_request_method;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
   @Test
   public void get01(){

      // i) Set the URL
      String url = "https://restful-booker.herokuapp.com/booking/101";

      // ii) Set the expected data(Post-Put-Patch)

      //iii) Type code to send request
      Response response = given().when().get(url);
      //response.prettyPrint();

      //iv) Do assertion
      response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

      //How to print 'Status Code' on the console
      System.out.println("Status Code: "+response.getStatusCode());

      //How to print 'Content Type' on the console
      System.out.println("Content Type: "+response.getContentType());

      //How to print 'Status Line' on the console
      System.out.println("Status Line: "+response.getStatusLine());

      //How to print 'Header' on the console
      System.out.println(response.getHeader("Connection"));

      //How to print 'Headers' on the console
      System.out.println(response.getHeaders());

      //How to print 'Time' on console.
      System.out.println(response.getTime());

   }
}






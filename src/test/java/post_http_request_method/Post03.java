package post_http_request_method;

import base_urls.AgroMonitoringApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.AgroMonitoringTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class Post03 extends AgroMonitoringApiBaseUrl {

    @Test
    public void post03(){
        //1.step:set the url
        spec.pathParams("first","agro","second",1.0,"third","polygons").
                queryParam("appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

    //2.step:Set the expected data
        AgroMonitoringTestData expectedData= new AgroMonitoringTestData();
       Map<String,Object> expectedDataMap= expectedData.requestBodySetUp();
   //3.step:
      Response response =  given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}/{second}/{third}");
      response.prettyPrint();


    }







}

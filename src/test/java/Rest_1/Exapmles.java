package Rest_1;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Exapmles {
 //   @Test   // this test will not be run
    public void test_get(){
        baseURI="http://localhost:3000/"; 
        given().
                param("name","Automation").
                get("/user").
                then().
                statusCode(200).
                log().all();

    }

    @Test
    public void test_post(){
        JSONObject request=new JSONObject();
        request.put("firstName","Tom");
        request.put("lastName","Ezz");
        request.put("subjectId",1);
        baseURI="http://localhost:3000/";
        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type","application/json").
                body(request.toJSONString()).
                when().post("/user").
                then().
                statusCode(201).
                log().all();

    }

}

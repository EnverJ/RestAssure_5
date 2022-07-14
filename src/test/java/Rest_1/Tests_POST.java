package Rest_1;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Tests_POST {
    @Test
    public  void test_1_post(){
     //Use Json library
      //  Map<String, Object>   map=new HashMap<String, Object>();
      //  map.put("name","Ezmet");
     //   map.put("Job","IT");
    //    System.out.println(map);
        // ADD Json simple library in order to create as Json Format  https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1

    //    JSONObject request=new JSONObject(map);
        JSONObject request=new JSONObject();
        request.put("name","Ezmet");
        request.put("Job","IT");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/Json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201);
    }
    @Test
    public  void test_2_Put(){

        JSONObject request=new JSONObject();
        request.put("name","Ezmet");
        request.put("Job","IT");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/Json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200).
                log().all();
    }

    @Test
    public  void test_3_Patch(){

        JSONObject request=new JSONObject();
        request.put("name","Ezmet");
        request.put("Job","IT");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/Json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users/2").
                then().statusCode(200).
                log().all();
    }
    @Test
    public  void test_4_Delete(){
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().all();
    }
}

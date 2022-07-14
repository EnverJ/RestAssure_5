package Rest_1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_01_Get {
    @Test
    void test_01(){
        Response response= RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("STRING: "+response.asString());
        System.out.println( "Body"+response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int resCode=response.getStatusCode();
        Assert.assertEquals(resCode,200);

    }
    @Test
    void test_02(){
    //    given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]",equalTo(8));
    }

}

package Rest_1;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class DataDriven_1 extends DataForTests {

    //What is TestNG DataProvider
    //- Helps to write data driven tests
    //- Same test can be run multiple times with diff sets of data
    //- Annotation @DataProvider
    //- The annotated method is used to return object containing test data
    //- This test data can be used in actual tests
    //
    //@Parameters
    //
    //You can support my mission for education by sharing this knowledge and helping as many people as you can
    //
    //If my work has helped you, consider helping https://animalaidunlimited.org/
    // or any animal welfare group near you.




 //   @Test(dataProvider ="Data for post")
    public void  test_post(String firstName, String lastName,int subjectId){

        //npm install -g json-server
        //json-server --watch db.json
        JSONObject request=new JSONObject();
        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);
        baseURI="http://localhost:3000/";
        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type","application/json").
                body(request.toJSONString()).
                when().post("/user").
                then().
                statusCode(201).
                log().all();
    }




     @Test(dataProvider = "Delete data")
    public void test_delete(int userId){
        baseURI="http://localhost:3000/";
        when().
                delete("/user/+userId").
                then().statusCode(200);
    }

}

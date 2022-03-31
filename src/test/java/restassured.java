import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class restassured {

    @Test
    public void test_get_call()
    {
        given().
                baseUri("https://jsonplaceholder.typicode.com/posts").
                header("Content-Type","application/json").
        when().
                get("/u").
        then().
                statusCode(200).body("userId[39]",equalTo(4)).body("title[39]",equalTo("enim quo cumque"));

    }

    @Test
    public void test_put_call()
    {
        File jsondata = new File("src//test//resources/putdata.json");
        given().
                baseUri("https://reqres.in/api/users").
                body(jsondata).
                header("Content-Type","application/json").
        when().
                put("/users").
        then().
                statusCode(201).body("name",equalTo("Arun")).body("job",equalTo("Manager"));

    }
}

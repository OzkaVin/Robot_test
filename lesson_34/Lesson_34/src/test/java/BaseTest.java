import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class BaseTest {
    protected String sessionToken;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://www.robotdreams.karpenko.cc/";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        User newUser = new User("UserName" + randomAlphanumeric(3), "Lesson#34");

        // User Creation request
        RestAssured.given()
                .body(newUser)
                .when()
                .post("/user").then().statusCode(200);

        // Logging in request
        Response sessionResponse = RestAssured.given()
                .queryParam("username", newUser.name)
                .queryParam("password", newUser.password)
                .when()
                .get("/login");
        sessionResponse.then().statusCode(200);
        JSONObject joTokenResponse = new JSONObject(sessionResponse.asString());
        sessionToken = joTokenResponse.getString("session_token");

        System.out.println(sessionToken);
    }
}

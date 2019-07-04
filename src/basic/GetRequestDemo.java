package basic;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import io.restassured.http.Cookie;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetRequestDemo {

    @BeforeClass
    public void setup() {
//        RestAssured.baseURI = "https://maps.googleapis.com";
//        RestAssured.basePath = "/maps/api";

        RestAssured.baseURI = "https://uat.simplify.com";
        RestAssured.basePath = "/ah/api";
    }

    @Test
    public void statusCodeVerification() {

        given()
                .param("units", "imperial")
                .param("origins", "Washington,DC")
                .param("destinations", "New+York+City,NY")
                .param("key", "AIzaSyAlLbmzK-tRJ5qEbeaPvSvG4-UcF2GqZRg")

                .when()
                .get("/distancematrix/json")

                .then()
                .statusCode(200);
    }

    @Test
    public void statusCodeVerificationSimplify() {
        //given().cookie(new Cookie("XSRF-TOKEN", "977281889350")).cookie(new Cookie("XSRF-TOKEN", "1551143718431"))
        given()

                .param("password", "Password1")
                .param("username", "tyro.admin.simplify@gmail.com")
                .when()
                .get("/jwt")

                .then()
                .statusCode(200);
    }


}

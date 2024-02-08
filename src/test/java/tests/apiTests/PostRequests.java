package tests.apiTests;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.equalTo;


import static io.restassured.RestAssured.given;

public class PostRequests {

    @Test
    void createUserSuccessfullTest(){
        String body = "{ \"name\": \"anatoli\", \"job\": \"leader\" }";

        given()
                .log().uri()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("anatoli"));


    }

    @Test
    void successfulLoginTest(){
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given().
                log().uri().
                body(body).
                contentType(ContentType.JSON).
                when().
                post("https://reqres.in/api/login").
                then().
                log().status().
                log().body().
                statusCode(200).
                body("token", is("QpwL5tke4Pnpja7X4"));

    }
}

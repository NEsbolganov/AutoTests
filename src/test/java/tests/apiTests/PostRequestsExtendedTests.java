package tests.apiTests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import models.lombok.LoginBodyLombokModel;
import models.lombok.LoginResponseLombokModel;
import models.pojo.LoginBodyPojoModel;
import models.pojo.LoginResponsePojoModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRequestsExtendedTests {

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


    @Test
    void successfulLoginWithPojoTest(){

        LoginBodyPojoModel loginBody = new LoginBodyPojoModel();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");
        LoginResponsePojoModel responseModel = given().
                log().uri().
                body(loginBody ).
                contentType(ContentType.JSON).
                when().
                post("https://reqres.in/api/login").
                then().
                log().status().
                log().body().
                statusCode(200).
                extract().as(LoginResponsePojoModel.class);

//        assertEquals("QpwL5tke4Pnpja7X4",responseModel.getToken());
        assertThat(responseModel.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    void successfulLoginWithLombokTest(){

        LoginBodyLombokModel loginBody = new LoginBodyLombokModel();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");
        LoginResponseLombokModel responseModel = given().
                log().uri().
                body(loginBody ).
                contentType(ContentType.JSON).
                when().
                post("https://reqres.in/api/login").
                then().
                log().status().
                log().body().
                statusCode(200).
                extract().as(LoginResponseLombokModel.class);

        assertThat(responseModel.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    void successfulLoginWithAllureTest(){

        LoginBodyLombokModel loginBody = new LoginBodyLombokModel();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");
        LoginResponseLombokModel responseModel = given().
                filter(new AllureRestAssured()).
                log().uri().
                body(loginBody ).
                contentType(ContentType.JSON).
                when().
                post("https://reqres.in/api/login").
                then().
                log().status().
                log().body().
                statusCode(200).
                extract().as(LoginResponseLombokModel.class);

        assertThat(responseModel.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}

package tests.apiTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Enums.Locale;

import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRequests {

    @Test
    void listUsersEmailCheckTest(){
        String expectedEmail = "michael.lawson@reqres.in";

        String actualEmail = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .extract().path("page");
    }

    static Stream<Arguments>listUsersPageCheck(){
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2)
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка номера страницы в ответе по URL")
    @Test
    void listUsersPageCheck(Integer pageNumber){

        Integer actualPage = given()
                .when()
                .get("https://reqres.in/api/users?page="+String.valueOf(pageNumber))
                .then()
                .log().body()
                .extract().path("page");


        assertEquals(pageNumber,actualPage);
    }


    @Test
    void delayedResponseTextTest(){
        String actualText = given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .log().body()
                .extract().path("support.text");

        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",actualText);
    }
}

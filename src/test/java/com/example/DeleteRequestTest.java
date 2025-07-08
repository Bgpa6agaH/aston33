package com.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestTest {
    private final String BASE_URL = "https://postman-echo.com/";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testSuccessfulDeleteRequestTest(){

        given()
                .log().all()
                .body("This is expected to be sent back as part of response body.")
                .when().delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("data",equalTo("This is expected to be sent back as part of response body."));

    }

}

package com.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PutRequestTest {
    private final String BASE_URL = "https://postman-echo.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testSuccessfulPutRequest() {
        given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .time(lessThan(2000L));
    }

}

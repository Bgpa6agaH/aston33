package com.example;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestTest {

    private final String BASE_URL = "https://postman-echo.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testSuccessfulGetRequest() {
        given()
                .log().all()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URL + "/get?foo1=bar1&foo2=bar2"));
    }


    @Test
    public void testGetRequestWithDifferentOrder() {
        given()
                .queryParam("foo2", "bar1")
                .queryParam("foo1", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("args.foo1", equalTo("bar2"))
                .body("args.foo2", equalTo("bar1"));
    }

    @Test
    public void testGetRequestWithExtraParameter() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .queryParam("extra", "value")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testNotFound() {
        given()
                .when()
                .get("/nonexistent-endpoint")
                .then()
                .statusCode(404);
    }

    @Test
    public void testBadRequest() {
        given()
                .queryParam("veryLongParameter", generateString(20000))  // Generate a very long string
                .when()
                .get("/get")
                .then()
                .statusCode(431);
    }

    // Helper method to generate a long string
    private String generateString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

}


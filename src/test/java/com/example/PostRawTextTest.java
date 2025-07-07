package com.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostRawTextTest {
    private final String BASE_URL = "https://postman-echo.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testSuccessfulPostRawText() {
        String row = "row text";
        String expectedDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", Locale.US));

        given().body(row)
                .when().post("/post")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("date", containsString(expectedDate))
                .body("data", equalTo(row))
                .time(lessThan(2000L));

    }


}

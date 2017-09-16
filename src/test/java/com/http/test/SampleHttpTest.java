package com.http.test;

import com.http.test.dto.BodyExample;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class SampleHttpTest {

    private static final String BASE_URL = "http://httpbin.org";
    private static final String APPLICATION_JSON = "application/json";

    @Test
    public void getTest() {
        when().
                get(BASE_URL + "/get").
        then().
                statusCode(200);
    }

    @Test
    public void postTest() {

        BodyExample bodyExample = new BodyExample();
        bodyExample.setId(1);
        bodyExample.setName("myName");

        given().
                body(bodyExample).
                contentType(APPLICATION_JSON).
        when().
                post(BASE_URL + "/post").
        then().
                statusCode(200).
                body("json.id", is(bodyExample.getId())).
                body("json.name", is(bodyExample.getName()));
    }

    @Test
    public void putTest() {

        BodyExample bodyExample = new BodyExample();
        bodyExample.setId(1);
        bodyExample.setName("myName");

        given().
                body(bodyExample).
                contentType(APPLICATION_JSON).
        when().
                put(BASE_URL + "/put").
        then().
                statusCode(200).
                body("json.id", is(bodyExample.getId())).
                body("json.name", is(bodyExample.getName()));
    }

    @Test
    public void deleteTest() {
        when().
                delete(BASE_URL + "/delete").
                then().
                statusCode(200);
    }
}

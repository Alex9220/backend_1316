package com.geekbrains.lesson4.dto;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class lesson4test {
    private static final String API_KEY = "93777889f8304e0ebc929326946a465e";
    private static RequestSpecification BASE_SPEC;
    private static ResponseSpecification RESPONSE_SPEC;
    private static final String Username = "alex9220";
    private static final String Hash = "b3a7cd48f79b6eafc574187aa88a692e88a3aa4a";
    String id;

    /*    @{
        "status": "success",
            "username": "alex9220",
            "hash": "b3a7cd48f79b6eafc574187aa88a692e88a3aa4a"
    }*/

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = "https://api.spoonacular.com";

        BASE_SPEC = new RequestSpecBuilder()
                .addQueryParam("hash", Hash)
                .addQueryParam("apiKey", API_KEY)
                .log(LogDetail.ALL)
                .build();


        RESPONSE_SPEC = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(Matchers.lessThan(5000L))
                .log(LogDetail.BODY)
                .build();
    }

    @Test
    void testPostMealPlan() throws IOException, JSONException {

        id = given()
                .spec(BASE_SPEC)
                .body("{\n"
                        + "    \"date\": 1644881179,\n"
                        + "    \"slot\": 1,\n"
                        + "    \"position\": 0,\n"
                        + "    \"type\": \"INGREDIENTS\",\n"
                        + "    \"value\": {\n"
                        + "        \"ingredients\": [\n"
                        + "            {\n"
                        + "                \"name\": \"1 banana\"\n"
                        + "            }\n"
                        + "        ]\n"
                        + "    }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/alex9220/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
    }

    @Test
    void testPostMenuItem() throws IOException, JSONException {

        id = given()
                .spec(BASE_SPEC)
                .body("{\n"
                        + "    \"date\":  1589500800,\n"
                        + "    \"slot\": 1,\n"
                        + "    \"position\": 0,\n"
                        + "    \"type\": \"CUSTOM_FOOD\",\n"
                        + "    \"value\": {\n"
                        + "        \"id\": 348,\n"
                        + "            \"servings\": 1,\n"
                        + "            \"title\": \"Aldi Spicy Cashews - 30g\",\n"
                        + "            \"image\": \"https://spoonacular.com/cdn/ingredients_100x100/cashews.jpg\",\n"
                        + "    }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/alex9220/items")
                .then()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

    }


    @AfterEach
    void tearDown() {
        given()
                .spec(BASE_SPEC)
                .delete("https://api.spoonacular.com/mealplanner/alex9220/items/" + id)
                .then()
                .statusCode(200);
    }
}

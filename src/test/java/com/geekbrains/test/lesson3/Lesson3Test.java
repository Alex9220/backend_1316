/*
package com.geekbrains.test.lesson3;

import com.geekbrains.test.AbstractTest;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import net.javacrumbs.jsonunit.JsonAssert;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.is;

public class Lesson3Test extends AbstractTest {

    private static String API_KEY = "93777889f8304e0ebc929326946a465e";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";
    }

    @Test
    void testGetRecipesComplexSearch() throws IOException {

        String actual = given()
                .param("apiKey", API_KEY)
                .param("query", "burger")
                .param("number", "10")
                .log()
                .all()
                .expect()
                .statusCode(200)
                .time(Matchers.lessThan(3000L))
                .body("offset", is(0))
                .body("totalResults", is(54))
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();


        String expected = getResourceAsString("expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actual,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }


    @Test
    void testPostCuisine()  {

        String postActual = given()
                .queryParam("title", "Pork roast with green beans")
                .queryParam("ingredientList", "3 oz pork shoulder")
                .log()
                .all()
                .expect()
                .statusCode(200)
                .time(Matchers.lessThan(3000L))
                .body("{\n"
                       + "cuisine": "Mediterranean",
                       + "cuisines": [
                       + "Mediterranean",
                       + "European",
                       + "Italian"],
                       + "confidence": 0.0
                       +  "}"
        "{\n"
                + "    \"cuisine\": \"Mediterranean\",\n"
                + "    \"cuisines\": 1,\n"
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
                .log()
                .all()
                .when()
                .post("https://api.spoonacular.com/mealplanner/alex9220/items")
                .body()
                .asPrettyString();

        System.out.println(postActual);



  */
/*      JsonAssert.assertJsonEquals(
                actual1,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );*//*



    }
}


*/

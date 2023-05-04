package com.cybertek.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest {

    @BeforeAll
    public static void init(){

        //sav baseUrl inside this variable  so that we dont need to type each https method
        RestAssured.baseURI = "http://100.26.102.114:8000";
    }

/*
//  Given Accept type application/xml
//  When user send GET request to /api/spartans/10 end point
//  Then status code must 406
//  And response content type must be application/xml:charset=UTF-8
 */

    @DisplayName("GET request to api/spartans/10")
            @Test
            public void test1(){

        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans/10");

        // verif the status code is 406
        assertEquals(406, response.statusCode());

        // verify content type
        assertEquals("application/xml;charset=UTF-8", response.contentType());

    }

}

package com.cybertek.Day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequests {

    // BeforeAll is annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){

        //sav baseUrl inside this variable  so that we dont need to type each https method
        RestAssured.baseURI = "http://100.26.102.114:1000/ords/hr";

    }

    @DisplayName("GET request to / regions")
    @Test
    public void test1(){

        Response response = RestAssured.get("/regions");

        System.out.println(response.statusCode());

    }

    /*
    Given accept type is application/json
    When user sends get request to /regions/2
    Then response status code must be 200
    And content type equals to application/json
    And response body contains Americas
     */

    @DisplayName("GET request to / regions2")
    @Test
    public void test2(){

        Response response = RestAssured.get("/regions/2");

        // verify status code
        Assertions.assertEquals(200, response.statusCode());

        // verify content tpe
        Assertions.assertEquals("application/json", response.contentType());

        response.prettyPrint();

        // veridy body contains Americas
        Assertions.assertEquals(response.body().asString().contains("Americas"), true);

    }

}

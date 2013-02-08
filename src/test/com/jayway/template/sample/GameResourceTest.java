package com.jayway.template.sample;


import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;


/**
 * Created with IntelliJ IDEA.
 * User: magnuskivi
 * Date: 2013-02-08
 * Time: 13:27
 * To change this template use File | Settings | File Templates.
 */
public class GameResourceTest {

    @Test
    public void getGives200AsReturnCode() {
        expect().statusCode(200).when().get("/api/game");
    }

    @Test
    public void createGameShouldReturnId() {
        given().contentType("application/json").param("userName", "Henrik").expect().statusCode(201).when().post("/api/game");
    }


}

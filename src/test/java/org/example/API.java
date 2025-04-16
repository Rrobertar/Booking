package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class API{


    @Test

public void testGetPosts(){

        Response response = RestAssured.get("https://www.booking.com");

        assertEquals(200,response.getStatusCode());
        System.out.println("the response is 200! ");


        assertTrue(response.getBody().asString().contains("title"));
        System.out.println("Contain title : Găsiți următorul sejur\n" +
                "Găsiți oferte la hoteluri, locuințe și multe altele...");




    }

}
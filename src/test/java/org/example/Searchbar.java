package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;


import static org.junit.Assert.*;

public class Searchbar {
    WebDriver driver;

    public static void asteapta(int n) {

        try {

            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test
    public void shouldbeanswerWithTrue() {

        driver.get("https://www.booking.com/");

        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        assertEquals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations", title);

        if (title.contains("Booking.com | Official site | The best hotels, flights, car rentals & accommodations")) {
            System.out.println("We are on the  Booking.com page! ");
        } else {
            System.out.println("We are not on the Booking.com page! ");
        }


            asteapta(3);

            WebElement acceptcokie = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
            assertTrue("The button is not visible! ", acceptcokie.isDisplayed());
            assertTrue("The button is not working! ", acceptcokie.isEnabled());
            acceptcokie.click();

            WebElement searchbar = driver.findElement(By.cssSelector("#\\:rh\\:"));
            assertTrue("The search bar is not visible! ", searchbar.isDisplayed());
            searchbar.click();
            searchbar.sendKeys("iasi");

            WebElement data = driver.findElement(By.cssSelector("#indexsearch > div.hero-banner-searchbox > div > form > div > div:nth-child(2) > div > div > button:nth-child(2) > span"));
            assertTrue("The table with date is not open! ", data.isDisplayed());
            data.click();


            WebElement checkin = driver.findElement(By.cssSelector("#calendar-searchboxdatepicker > div > div.a10b0e2d13.c807ff2d48 > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(3) > span"));
            checkin.click();


            WebElement checkout = driver.findElement(By.cssSelector("#calendar-searchboxdatepicker > div > div.a10b0e2d13.c807ff2d48 > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(6) > span"));
            checkout.click();

            WebElement butoncauta = driver.findElement(By.cssSelector("#indexsearch > div.hero-banner-searchbox > div > form > div > div.e22b782521.d12ff5f5bf > button"));
            assertTrue("The button is not displayed! ", butoncauta.isDisplayed());
            butoncauta.click();

            WebElement paginadeschisa = driver.findElement(By.cssSelector("#b2searchresultsPage"));
            assertTrue("The page is not open! ", paginadeschisa.isDisplayed());

            if(paginadeschisa.isDisplayed())
                System.out.println("The page with results is open! ");
            else{
                System.out.println("The page with results is not oepn! ");
            }


        }
 @After
 public void teardown() {
        driver.quit();
    }
}


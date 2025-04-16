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

public class ChangeLanguage {
    WebDriver driver;


    @Before

    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    @Test

    public void souldbeanswerWithTrue() {
        driver.get("https://www.booking.com/");

        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        assertEquals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations", title);

        if (title.contains("Booking.com | Official site | The best hotels, flights, car rentals & accommodations")) {
            System.out.println("We are on the  Booking.com page! ");
        } else {
            System.out.println("We are not on the Booking.com page! ");
        }

        WebElement acceptcokie = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        assertTrue("The button is not visible! ", acceptcokie.isDisplayed());
        assertTrue("The button is not working! ", acceptcokie.isEnabled());
        acceptcokie.click();

        WebElement langlistBttn = driver.findElement(By.cssSelector("#b2indexPage > div:nth-child(4) > div > div > header > div > nav.Header_bar > div.c624d7469d.f034cf5568.dab7c5c6fa.c62ffa0b45.a3214e5942 > span:nth-child(2) > button"));
        assertTrue("The button is not visible! ", langlistBttn.isDisplayed());
        langlistBttn.click();

        WebElement chooseLangDe = driver.findElement(By.cssSelector("#header_language_picker > div > div > div.f7c2c6294c > div > div:nth-child(2) > div > div > div > ul > li:nth-child(3) > button > div > div.dc5041d860.c72df67c95.fb60b9836d > span"));
        assertTrue("The language is not visible! ", chooseLangDe.isDisplayed());
        chooseLangDe.click();

        WebElement text = driver.findElement(By.cssSelector("#indexsearch > div:nth-child(1) > div > div > div > div > header > h1 > span"));
        assertTrue("Finden Sie Ihre nächste Unterkunft", text.isDisplayed());
        if (text.isDisplayed()) {
            System.out.println("The german language is selected!  ");
        } else {
            System.out.println("The language has not been changed! ");
        }


        try {
            WebElement popupGeniusclose = driver.findElement(By.cssSelector("#b2indexPage > div.b9720ed41e.cdf0a9297c > div > div > div > div.dd5dccd82f > div.ffd93a9ecb.dc19f70f85.eb67815534 > div > button > span > span > svg"));
            popupGeniusclose.click();
        } catch (Exception e) {
            System.out.println("Pop-up is not displayed! ");
        }
    }

    @After
        public void teardown () {
            driver.quit();

        }
    }

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

public class ViewLocation {
    WebDriver driver;


    @Before

    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public static void asteapta(int n) {

        try {

            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Locationphotos() {
        driver.get("https://www.booking.com/");

        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        assertEquals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations", title);

        if (title.contains("Booking.com | Official site | The best hotels, flights, car rentals & accommodations")) {
            System.out.println("We are on the  Booking.com page!");
        } else {
            System.out.println("We are not on the Booking.com page! ");
        }

        WebElement acceptcokie = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        assertTrue("The button is not visible! ", acceptcokie.isDisplayed());
        assertTrue("The button is not working! ", acceptcokie.isEnabled());
        acceptcokie.click();


        WebElement citysearch = driver.findElement(By.cssSelector("#\\:rh\\:"));
        citysearch.click();
        citysearch.sendKeys("Iasi");

        asteapta(2);


        WebElement selectCity = driver.findElement(By.xpath("//*[@id=\"autocomplete-result-0\"]/div/div/div/div[1]"));
        selectCity.click();


        WebElement Search = driver.findElement(By.cssSelector("#indexsearch > div.hero-banner-searchbox > div > form > div > div.e22b782521.d12ff5f5bf > button"));
        Search.click();

        asteapta(4);


        WebElement popupGeniuscloses = driver.findElement(By.cssSelector("#b2searchresultsPage > div.b9720ed41e.cdf0a9297c > div > div > div > div.dd5dccd82f > div.ffd93a9ecb.dc19f70f85.eb67815534 > div > button"));
        popupGeniuscloses.click();


        WebElement primaLocatie = driver.findElement(By.cssSelector("#bodyconstraint-inner > div > div > div.af5895d4b2 > div.df7e6ba27d > div.bcbf33c5c3 > div.dcf496a7b9.bb2746aad9 > div.d4924c9e74 > div:nth-child(4) > div.c066246e13.d8aec464ca > div.c1edfbabcb > div > div > div.dc5041d860.c72df67c95 > div > div:nth-child(1) > div.d6767e681c > h3 > a > div.f6431b446c.a15b38c233"));
        primaLocatie.click();
    }

    @After
    public void teardown () {
        driver.quit();
    }
}
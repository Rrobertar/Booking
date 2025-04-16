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

public class SelectLocation {
    WebDriver driver;

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

        WebElement acceptcokie = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        assertTrue("The button is not visible! ", acceptcokie.isDisplayed());
        assertTrue("The button is not working! ", acceptcokie.isEnabled());
        acceptcokie.click();


        WebElement City = driver.findElement(By.cssSelector("#basiclayout > div:nth-child(8) > div > div > div.f395e522bd.false > a:nth-child(2) > div > div > div > picture > img"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", City);


        assertTrue("The option is not displayed! ", City.isDisplayed());
        City.click();

    }


    @After
    public void teardown() {
        driver.quit();
    }
}

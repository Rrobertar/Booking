package org.example;

import com.beust.ah.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Attraction {
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
    public void Attraction() {

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


        WebElement Attractionbtn= driver.findElement(By.cssSelector("#attractions"));
        Attractionbtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement primalocatie= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div > div.css-ngwlx1 > div > div > div > div:nth-child(5) > section > ul > li:nth-child(1) > a > div.css-1oaaad8 > img")));
        primalocatie.click();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
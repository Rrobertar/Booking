
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

public class HelpService{
    WebDriver driver;

     public static void asteapta(int n) {

        try {

            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @Test
     public void HelpService(){
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

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement HelpButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#b2indexPage > div:nth-child(4) > div > div > header > div > nav.Header_bar > div.c624d7469d.f034cf5568.dab7c5c6fa.c62ffa0b45.a3214e5942 > span:nth-child(3) > a > span > span > svg")));
        assertTrue("The button is not visible! ", HelpButton.isDisplayed());
        HelpButton.click();

        WebElement PageisOpen= driver.findElement(By.cssSelector("#b2helpPage"));
        assertTrue("Page si not open!",PageisOpen.isDisplayed());
        if(PageisOpen.isDisplayed()){
            System.out.println("The HelpCenter page is open! ");
        }
        else {
            System.out.println("The HelpCenter page is not open! ");
        }

        WebElement CancellationOption = driver.findElement(By.cssSelector("#\\30  > div > div > button:nth-child(1) > div > div.dc5041d860.c72df67c95.fb60b9836d > div > div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", CancellationOption);
        assertTrue("The button is not visible! ", CancellationOption.isDisplayed());
        CancellationOption.click();
        if(CancellationOption.isDisplayed()){
            System.out.println("Cancellation Option is displayed and clickable! ");
        }
        else{
            System.out.println("Cancellation Option is not displayed and clickable! ");
        }

        WebElement CancellationList = driver.findElement(By.cssSelector("#maincontent > div > div > div > div > div.c624d7469d.a0e60936ad.a3214e5942 > div:nth-child(1) > div > div"));
        assertTrue("The list with details about cancellation is not open! ", CancellationList.isDisplayed());
        if(CancellationList.isDisplayed()){
            System.out.println("Cancellation list is open! ");
        }
        else{
            System.out.println("Cancellation list is not open! ");

        }

    }

}
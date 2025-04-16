package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


import static org.junit.Assert.*;



public class PropertyType {
    WebDriver driver;

    //Wait

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

    public void shouldbeanswerWithTrue(){

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



        //elementul cautat
        WebElement Hotels = driver.findElement(By.cssSelector("#\\:r1i\\: > li:nth-child(1) > a > div > div.f2cf178bcd.c3a4d3369f > h3"));

        //validam cu assert ca optiunea este vizibila
        assertTrue("The option is not visible! ", Hotels.isDisplayed());


        //scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Hotels);



        //click elementul gasit
        Hotels.click();

        //inchidem popupul

        try{
            WebElement popupsigninClose= driver.findElement(By.cssSelector("#b2searchresultsPage > div.b9720ed41e.cdf0a9297c > div > div > div > div.dd5dccd82f > div.ffd93a9ecb.dc19f70f85.eb67815534 > div > button > span > span > svg"));
            popupsigninClose.click();
        }
        catch(Exception e){
            System.out.println("Pop-up is not displayed! ");

        }

        //seelecteaza hotelul

        WebElement selecthotel= driver.findElement(By.cssSelector("#bodyconstraint-inner > div.lp-bui-section-wrap > div:nth-child(1) > div > div > div:nth-child(2) > div > div:nth-child(1) > div.ecc9a4771b > div.fe5b3e7dac > a > div > h3"));
        assertTrue("The hotel is not displayed on the page! ", selecthotel.isDisplayed());
        selecthotel.click();

        //apasam btonul rezervati acum

        WebElement RezervatiAcum= driver.findElement(By.cssSelector("#hcta > span.bui-button__text"));
        RezervatiAcum.click();

        assertTrue(" The reservation details page is not open! ", RezervatiAcum.isDisplayed());

    }


    @After
    public void teardown() {
        driver.quit();
      }
}


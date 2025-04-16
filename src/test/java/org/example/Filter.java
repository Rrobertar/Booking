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

public class Filter{
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

    public void FilterApplication(){
         driver.get("https://www.booking.com/");

        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        assertEquals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations", title);

        if (title.contains("Booking.com | Official site | The best hotels, flights, car rentals & accommodations")) {
            System.out.println("We are on the Booking.com page! ");
        } else {
            System.out.println("We are not on the Booking.com page! ");
        }


        asteapta(1);

        //Accept cookies

        WebElement acceptcokie = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        assertTrue("Button is not visible! ", acceptcokie.isDisplayed());
        assertTrue("Button not function! ", acceptcokie.isEnabled());
        acceptcokie.click();

        //Write on searchBar

        WebElement searchbar = driver.findElement(By.cssSelector("#\\:rh\\:"));
        assertTrue("Searchbar is not displayed! ", searchbar.isDisplayed());
        searchbar.click();
        searchbar.sendKeys("iasi");

        WebElement data = driver.findElement(By.cssSelector("#indexsearch > div.hero-banner-searchbox > div > form > div > div:nth-child(2) > div > div > button:nth-child(2) > span"));
        assertTrue("The table with data is not open! ", data.isDisplayed());
        data.click();


        WebElement checkin = driver.findElement(By.cssSelector("#calendar-searchboxdatepicker > div > div.a10b0e2d13.c807ff2d48 > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(3) > span"));
        checkin.click();


        WebElement checkout = driver.findElement(By.cssSelector("#calendar-searchboxdatepicker > div > div.a10b0e2d13.c807ff2d48 > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(6) > span"));
        checkout.click();

        WebElement searchbutton = driver.findElement(By.cssSelector("#indexsearch > div.hero-banner-searchbox > div > form > div > div.e22b782521.d12ff5f5bf > button"));
        assertTrue("Button is not displayed! ", searchbutton.isDisplayed());
        searchbutton.click();

        asteapta(1);



        WebElement popupGeniuscloses = driver.findElement(By.cssSelector("#b2searchresultsPage > div.b9720ed41e.cdf0a9297c > div > div > div > div.dd5dccd82f > div.ffd93a9ecb.dc19f70f85.eb67815534 > div > button"));
        popupGeniuscloses.click();

        WebElement ResultOfSearch = driver.findElement(By.cssSelector("#bodyconstraint-inner > div > div > div.af5895d4b2"));
        assertTrue("The result is not displayed! ",ResultOfSearch.isDisplayed());


        if(ResultOfSearch.isDisplayed()){
            System.out.println("The results is displayed! ");
        }
        else{
            System.out.println("The results is not displayed! ");

        }

        //Filters select

            // -parking

        WebElement Filterparking = driver.findElement(By.cssSelector("#filter_group_hotelfacility_\\:r1a\\: > div:nth-child(1) > label > span.dc5041d860.c72df67c95 > div > div.fa7ed6270d > div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Filterparking);
        Filterparking.click();
        assertTrue("Option is not displayed! ", Filterparking.isDisplayed());

        if(Filterparking.isDisplayed()){
            System.out.println("The option Parking is selected! ");
        }
        else{
            System.out.println("The option Parking is not selected! ");
        }

            // - roomfacilities

        WebDriverWait  Wait =  new WebDriverWait(driver,Duration.ofSeconds(3));
        WebElement balcony = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#filter_group_roomfacility_\\:r2v\\: > div:nth-child(1) > label > span.dc5041d860.c72df67c95 > div > div.fa7ed6270d > div")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", balcony);
        balcony.click();
        assertTrue("Option is not displayed! ",balcony.isDisplayed());

        if(balcony.isDisplayed()){
            System.out.println("The option balcony is selected! ");
        }
        else{
            System.out.println("The option balcony is not selected! ");
        }

            // - meals

        WebElement BreakfastIncluded = driver.findElement(By.cssSelector("#filter_group_mealplan_\\:r2h\\: > div:nth-child(2) > label > span.ef785aa7f4"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", BreakfastIncluded);
        BreakfastIncluded.click();
        assertTrue("Option is not displayed! ",BreakfastIncluded.isDisplayed());

        if(BreakfastIncluded.isDisplayed()){
            System.out.println("The option BreakfastIncluded is selected! ");
        }
        else{
            System.out.println("The option BreakfastIncluded is not selected! ");
        }
    }


    @After
    public void teardown() {
        driver.quit();
    }
 }

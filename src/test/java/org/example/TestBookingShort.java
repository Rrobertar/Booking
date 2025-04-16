package org.example;
import org.junit.Test;

public class TestBookingShort {

@Test
    public void setup() throws Exception {

    Searchbar test1=new Searchbar();
        test1.setup();
        test1.shouldbeanswerWithTrue();
        test1.teardown();

    SelectLocation test2= new SelectLocation();
        test2.setup();
        test2.shouldbeanswerWithTrue();
        test2.teardown();

    PropertyType test3= new PropertyType();
        test3.setup();
        test3.shouldbeanswerWithTrue();
        test3.teardown();

    ChangeLanguage test4= new ChangeLanguage();
        test4.setup();
        test4.souldbeanswerWithTrue();
        test4.teardown();

    ViewLocation test5 =  new ViewLocation() ;
        test5.setup();
        test5.Locationphotos();
        test5.teardown();

    Filter test6 =  new Filter();
        test6.setup();
        test6.FilterApplication();
        test6.teardown();

    HelpService test7=  new HelpService();
        test7.setup();
        test7.HelpService();
        test7.setup();




}
}

package com.phonebook.tests;

import com.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHomePage().isHomeComponentPresent()){
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest(){
        //app.driver.findElement(By.xpath("//div[2]//h1"));
        //System.out.println("Home component is " + app.isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());

    }


}

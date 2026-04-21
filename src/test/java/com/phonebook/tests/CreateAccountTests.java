package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.core.ApplicationManager.softAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void newUserRegisterPositiveTest(){
//For HomeWork
        // int i = (int) ((System.currentTimeMillis()/1000)%3600);
//driver.findElement(By.name("email")).sendKeys("kristitomash001"+ i + "@gmail.com");

        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));

        //click on Register button
        app.getUser().clickOnRegistrationButton();

        //assert SigOut button is present
        //Assert.assertTrue(app.getUser().isSignOutButtonPresent());
        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();




    }

    @Test
    public void existedUserRegisterNegativeTest() {

        //click on Login link
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));

        //click on Register button
        app.getUser().clickOnRegistrationButton();

        //assert alert appears
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}



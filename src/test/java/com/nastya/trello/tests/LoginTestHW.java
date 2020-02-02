package com.nastya.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logout();
        }
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("lanastasiatest@gmail.com", "test1234test");
        app.getSession().pause(20000);
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());
    }
    @Test
    public void testLogInWithAtlassianAcc2() throws InterruptedException {
        // app.takeScreenshot();
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("lanastasiatest@gmail.com", "test1234test");
        app.getSession().pause(20000);
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("test", "");
        app.getSession().pause(8000);
        Assert.assertTrue(app.getSession().isErrorPresent());
        Assert.assertTrue
                (!app.getSession().isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void testLogInOldAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormOldAcc("lanastasiatest@gmail.com", "test1234test");
        app.getSession().confirmLogin();
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());
    }


}


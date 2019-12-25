package com.nastya.trello;

import org.testng.annotations.Test;

public class LoginTestHW extends TastBase {
    @Test
    public void testLogin() throws InterruptedException {

        clickLoginLink("lanastasiatest@gmail.com", "test1234test");
        fillLoginForm("lanastasiatest@gmail.com", "test1234test");
        confirmLogin();
    }


}



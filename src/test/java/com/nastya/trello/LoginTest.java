package com.nastya.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TastBase {
    @Test
    public void testLogin() throws InterruptedException {

        clickLoginLink();
    }
    public void clickLoginLink() throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        click(By.id("user"));
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("lanastasiatest@gmail.com");

        if(wd.findElement(By.id("password")).isDisplayed()){
            click(By.id("password"));
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("test1234test");
        }
        click(By.id("login"));

        if(isElementPresent(By.id("login-submit")));
        click(By.id("login-submit"));

        click(By.id("password"));
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("test1234test");
        click(By.id("login-submit"));
    }
    }



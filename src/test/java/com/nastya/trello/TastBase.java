package com.nastya.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TastBase {
    WebDriver wd;


    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public void confirmLogin() {
    }

    public void fillLoginForm(String userName, String password) {
        type(By.id("user"), userName);
        click(By.id("login"));
        click(By.id("login-submit"));
        type(By.id("password"), password);
        click(By.id("login-submit"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickLoginLink(String userName, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));

    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }


    @AfterClass
   public void tearDown(){
        wd.quit();
    }
}

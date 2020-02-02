package com.nastya.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;

public class SessionHelper extends HelperBase {
    HeaderHelper header = new HeaderHelper(wd);

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
        type(By.id("user"), user);
        pause(5000);
        click(By.id("login"));
        click(By.id("login-submit"));
        Thread.sleep(5000);
        type(By.cssSelector("input[id=password]"), pwd);
        click(By.id("login-submit"));
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginFormOldAcc(String userName, String password) {
        type(By.id("user"), userName);
        type(By.id("password"), password);
    }

    public void clickLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void loginWhithBothAccs() throws InterruptedException {

        type(By.id("user"), "lanastasiatest@gmail.com");
        Thread.sleep(10000);
        if (wd.findElement(By.id("password")).isDisplayed()) {
            type(By.id("password"), "123test123");
        }
        click(By.id("login"));

        if (isElementPresent(By.id("login-submit"))) {
            click(By.id("login-submit"));

            type(By.id("password"), "123test123");
            click(By.id("login-submit"));
        }
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        header.clickOnAvatar();
        clickLogoutButton();
    }

    public void loginAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("lanastasiatest@gmail.com", "test1234test");
        pause(10000);

    }

    public boolean isErrorPresent() {
        return isElementPresent(By.id("error"));
    }

    public void clickLogoutButton() {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void openProfileAndVisibility() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void openAndSwitchToAtlassianProfile() {
        click(By.cssSelector("[href $=manage-profile]"));
        String trellow = wd.getWindowHandle();
//    System.out.println(trellow);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
    }

    public void addPictureAndCloseWindow() throws InterruptedException {
        new Actions(wd)
                .moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).perform();
        click(By.cssSelector("[data-test-selector='profile-hover-info']"));
        if (isElementPresent(By.cssSelector("[role=menu]"))) {
            click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
        }
        attach(By.id("image-input"), new File("C:/Users/nastya/Documents/GitHub/trello-selenium-tests-Nastya/src/test/resources/DSC_4659.JPG"));
        click(By.xpath("//*[contains(text(),'Upload')]"));
        pause(5000);
        wd.close();
        pause(3000);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }
    }
}


//"lanastasiatest@gmail.com", "123test123"
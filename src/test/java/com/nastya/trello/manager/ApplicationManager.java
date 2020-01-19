package com.nastya.trello.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    HeaderHelper header;
    WebDriver wd;

    public TeamHelper getTeam() {
        return team;
    }

    public SessionHelper getSession() {
        return session;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public void init() {
        String browser =
                System.getProperty("browser", BrowserType.CHROME);
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else
        if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");

        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
        session = new SessionHelper(wd);
        header= new HeaderHelper(wd);

    }

    public void stop() {
        wd.quit();
    }

    public BoardHelper getBoardHelper() {
        return board;
    }
}

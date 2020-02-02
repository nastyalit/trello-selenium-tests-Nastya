package com.nastya.trello.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAtlassianAcc();
        }
        if (!app.getBoard().isThereBoard()) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        app.getBoard().openFirstBoard();
        app.getBoard().clickOpenMore();
        app.getBoard().startCloseBoard();
        app.getBoard().confirmCloseBoard();
        app.getBoard().permanentlyDeleteBoard();
    }

    @Test
    public void testFirstBoardDeletion2() throws InterruptedException {
        app.getBoard().openFirstBoard();
        app.getBoard().pause(10000);
        app.getBoard().clickOpenMore();
        app.getBoard().startCloseBoard();
        app.getBoard().confirmCloseBoard();
        app.getHeader().returnToHomePage();
    }

}
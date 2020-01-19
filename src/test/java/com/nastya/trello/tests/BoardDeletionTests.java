package com.nastya.trello.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAtlassianAcc();
        }
        if (!app.getBoardHelper().isThereBoard()) {
            app.getBoardHelper().createBoard();
        }
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        app.getBoardHelper().openFirstBoard();
        app.getBoardHelper().clickOpenMore();
        app.getBoardHelper().startCloseBoard();
        app.getBoardHelper().confirmCloseBoard();
        app.getBoardHelper().permanentlyDeleteBoard();
    }

    @Test
    public void testFirstBoardDeletion2() throws InterruptedException {
        app.getBoardHelper().openFirstBoard();
        app.getBoard().pause(10000);
        app.getBoardHelper().clickOpenMore();
        app.getBoardHelper().startCloseBoard();
        app.getBoardHelper().confirmCloseBoard();
        app.getSession().returnToHomePage();
    }

}
package com.nastya.trello.tests;

import com.nastya.trello.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().loginAtlassianAcc();
        }
    }
    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before =   app.getBoard().getBoardsCount();
        app.getBoard().clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardForm(new BoardData("qa22" + System.currentTimeMillis()));
        app.getBoard().confirmBoardCreation();
        app.getBoard().pause(15000);
        app.getHeader().returnToHomePage();
        int after = app.getBoard().getBoardsCount();

        Assert.assertEquals(after, before+1);
    }

    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = app.getBoard().getBoardsCount();
        while (boardsCount>4){
            app.getBoard().deleteBoard();
            boardsCount = app.getBoard().getBoardsCount();
        }
    }
}

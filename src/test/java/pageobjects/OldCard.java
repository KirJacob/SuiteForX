package pageobjects;

import enums.TestData;
import enums.WidgetColor;
import enums.WidgetState;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tests.Run;
import utils.Service;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.PublicKey;

public class OldCard {
    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardsFirstIdeaGeneration(WebDriver driver, int number, boolean isLogged) throws InterruptedException {
        String name;
        String dynamicPart;
        final String IDEA_CARD_X_PATH_FIRST_PART = "html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div/";
        final String IDEA_CARD_X_PATH_BUTTON = "/div[1]/div[1]/div/button";
        final String IDEA_CARD_X_PATH_TEXT = "/div[1]/div[1]/div[1]/textarea";
        final String IDEA_CARD_X_PATH_ADD_CARD = "/div";

        driver.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/textarea")).sendKeys(Run.currentBrowser +
                Service.nowTimeForObjectName() + "Idea Card 1");
        driver.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div[1]/div/button")).click();

        for (int i = 2; i <= number; i++) {
            name = Integer.toString(i);
            dynamicPart = "div[" + name + "]";
            if (isLogged) System.out.println(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_ADD_CARD);
            driver.findElement(By.xpath(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_ADD_CARD)).click();

            if (isLogged) System.out.println(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_TEXT);
            driver.findElement(By.xpath(IDEA_CARD_X_PATH_FIRST_PART +
                    dynamicPart + IDEA_CARD_X_PATH_TEXT)).sendKeys(Run.currentBrowser +
                    Service.nowTimeForObjectName() + " Idea Card " + name);

            if (isLogged) System.out.println(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_BUTTON);
            driver.findElement(By.xpath(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_BUTTON)).click();
            Thread.sleep(300);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardsFirstBoardGeneration(WebDriver driver, int numberY, int numberX, boolean isLogged) throws InterruptedException {
        String stringCounterX;
        String stringCounterY;
        String dynamicPartX;
        String dynamicPartY;
        String currentXpathForAdding;
        String currentXpathForNaming;
        String currentXpathForSaving;

        final String BOARD_CARD_X_PATH_FIRST_PART = "html/body/div[3]/div[1]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[1]/div/";
        final String BOARD_CARD_X_PATH_ADD_CARD = "/div";
        final String BOARD_CARD_X_PATH_TEXT = "/div/div[1]/div[1]/textarea";
        final String BOARD_CARD_X_PATH_BUTTON = "/div/div[1]/div/button";
        final String BOARD_CARD_X_PATH_MEDIUM = "/div[2]/";

        if (numberX > 2) Column.columnsCreation(driver, numberX - 2, isLogged);
        for (int i = 1; i <= numberY; i++) {
            stringCounterX = Integer.toString(i);
            if (i == 1) dynamicPartX = "div";
            else dynamicPartX = "div[" + stringCounterX + "]";

            for (int j = 1; j <= numberX; j++) {
                stringCounterY = Integer.toString(j);
                dynamicPartY = "div[" + stringCounterY + "]";
                currentXpathForAdding = BOARD_CARD_X_PATH_FIRST_PART + dynamicPartY + BOARD_CARD_X_PATH_MEDIUM + dynamicPartX + BOARD_CARD_X_PATH_ADD_CARD;
                currentXpathForNaming = BOARD_CARD_X_PATH_FIRST_PART + dynamicPartY + BOARD_CARD_X_PATH_MEDIUM + dynamicPartX + BOARD_CARD_X_PATH_TEXT;
                currentXpathForSaving = BOARD_CARD_X_PATH_FIRST_PART + dynamicPartY + BOARD_CARD_X_PATH_MEDIUM + dynamicPartX + BOARD_CARD_X_PATH_BUTTON;
                if (isLogged) System.out.println(currentXpathForAdding);
                driver.findElement(By.xpath(currentXpathForAdding)).click();
                if (isLogged) System.out.println(currentXpathForNaming);
                driver.findElement(By.xpath(currentXpathForNaming)).sendKeys(Run.currentBrowser +
                        Service.nowTimeForObjectName() + " Board Card " + stringCounterX + stringCounterY);
                if (isLogged) System.out.println(currentXpathForSaving);
                driver.findElement(By.xpath(currentXpathForSaving)).click();
                Thread.sleep(200);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardOpenIdeaCard(WebDriver driver, int numberX, boolean isLogged) {
        final String IDEA_CARD_X_PATH_FIRST_PART = "html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div/";
        final String IDEA_CARD_X_PATH_ADD_CARD = "/div";

        String name;
        String dynamicPart;
        name = Integer.toString(numberX);
        dynamicPart = "div[" + name + "]";
        if (isLogged) System.out.println(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_ADD_CARD);
        driver.findElement(By.xpath(IDEA_CARD_X_PATH_FIRST_PART + dynamicPart + IDEA_CARD_X_PATH_ADD_CARD)).click();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardCancel(WebDriver driver) {
        final String CARD_CANCEL_CSS = ".popup-window-toolbar-button.mod-cancel.js-popup-cancel";
        driver.findElement(By.cssSelector(CARD_CANCEL_CSS)).click();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardSave(WebDriver driver) {
        final String CARD_SAVE_CSS = ".popup-window-toolbar-button.mod-done.js-popup-done";
        driver.findElement(By.cssSelector(CARD_SAVE_CSS)).click();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDelete(WebDriver driver, boolean isLogged) {
        final String CARD_DELETE_CSS = ".popup-window-toolbar-button.mod-remove.js-tap-indication.js-popup-remove";
        driver.findElement(By.cssSelector(CARD_DELETE_CSS)).click();
        if (isLogged) System.out.println("Card was removed");
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDeleteMany(WebDriver driver, int number, int boardRow, boolean isLogged) throws InterruptedException {
        for (int i = 1; i <= number; i++) {
            cardOpenIdeaCard(driver, 1, isLogged);
            cardDelete(driver, isLogged);
            cardOpenBoardCard(driver, 1, boardRow, isLogged);
            cardDelete(driver, isLogged);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardArchiveUnarchive(WebDriver driver, boolean isLogged) {
        final String CARD_ARCHIVE_CSS = ".popup-window-toolbar-button.mod-archive.js-tap-indication.js-popup-archive";
        driver.findElement(By.cssSelector(CARD_ARCHIVE_CSS)).click();
        if (isLogged) System.out.println("Card was archived / unarchived");
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardArchiveMany(WebDriver driver, int number, int boardRow, boolean isLogged) throws InterruptedException {
        for (int i = 1; i <= number; i++) {
            cardOpenIdeaCard(driver, 1, isLogged);
            cardArchiveUnarchive(driver, isLogged);
            cardOpenBoardCard(driver, 1, boardRow, isLogged);
            cardArchiveUnarchive(driver, isLogged);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardSetName(WebDriver driver, String cardName) {
        final String CARD_NAME_ID = "menu-popup-input-name";
        driver.findElement(By.id(CARD_NAME_ID)).clear();
        driver.findElement(By.id(CARD_NAME_ID)).sendKeys(cardName);
    }//------------------------------------------------------------------------------------------------------------------------------------------------

    // DOESNT WORK CORRECT
    public static String cardGetName(WebDriver driver) {
        final String CARD_NAME_ID = "menu-popup-input-name";
        final String CARD_NAME_XPATH = "html/body/div[3]/div/div/div[1]/div[2]/div[1]/div[1]/textarea";
        String name;
        name = driver.findElement(By.xpath(CARD_NAME_XPATH)).getText();
        return name;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddElementsToWidget(WebDriver driver, String[] listOfTags, String[] listOfUsers,
                                               int ideaCardNum, int boardCardX, int boardCardY) throws InterruptedException {
        for (int i = 1; i <= ideaCardNum; i++) {
            for (String tagElement : listOfTags) {
                cardOpenIdeaCard(driver, i, false);
                cardAddTag(driver, tagElement, false);
                cardSave(driver);
            }
            cardOpenIdeaCard(driver, i, false);
            cardAddListOfPeople(driver, listOfUsers, false);
            cardSave(driver);
        }
        for (int j = 1; j <= boardCardX; j++) {
            for (int k = 1; k <= boardCardY; k++) {
                for (String tagElement : listOfTags) {
                    cardOpenBoardCard(driver, j, k, false);
                    cardAddTag(driver, tagElement, false);
                    cardSave(driver);
                }
                cardOpenBoardCard(driver, j, k, false);
                cardAddListOfPeople(driver, listOfUsers, false);
                cardSave(driver);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddListOfPeople(WebDriver driver, String[] listOfPeople, boolean isLogged) throws InterruptedException {
        for (String element : listOfPeople) {
            cardAddPeople(driver, element, false);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddTag(WebDriver driver, String tagName, boolean isLogged) throws InterruptedException {
        final String CARD_TAGFIELD_ID = "menu-popup-input-labels";
        final String CARD_ADD_NEWTAG_CSS = ".autocomplete-add";
        final String CARD_ADD_TAG_FIRST_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[1]/div[3]/div[2]";
        final String CARD_ADD_TAGS_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[1]/div[3]/div[3]";

        if (!driver.findElement(By.xpath(CARD_ADD_TAGS_XPATH)).isDisplayed()) {
            driver.findElement(By.xpath(CARD_ADD_TAG_FIRST_XPATH)).click();
            if (isLogged) System.out.println("Press Add tag field");
        } else {
            driver.findElement(By.xpath(CARD_ADD_TAGS_XPATH)).click();
            if (isLogged) System.out.println("Press Add tag field");
        }
        Thread.sleep(500);
        driver.findElement(By.id(CARD_TAGFIELD_ID)).sendKeys(tagName);
        if (isLogged) System.out.println("Enter " + tagName + " to Add tag field");
        Thread.sleep(500);
        driver.findElement(By.id(CARD_TAGFIELD_ID)).sendKeys(Keys.ENTER);
//        old variant
//        driver.findElement(By.cssSelector(CARD_ADD_NEWTAG_CSS)).click();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddManyNewTagsToCard(WebDriver driver, int number, int ideaCardNum, int boardCardX, int boardCardY) throws InterruptedException {
        int randomNumber = (int) (Math.random() * 1000000);
        cardOpenIdeaCard(driver, ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea card with Many Tags");
        cardSave(driver);

        cardOpenBoardCard(driver, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board card with Many Tags");
        cardSave(driver);
        for (int i = 1; i <= number; i++) {
            cardOpenIdeaCard(driver, ideaCardNum, false);
            cardAddTag(driver, Integer.toString(randomNumber) + "Idea_Tag" + Integer.toString(i), false);
            Thread.sleep(300);
            cardSave(driver);
        }
        for (int i = 1; i <= number; i++) {
            cardOpenBoardCard(driver, boardCardX, boardCardY, false);
            cardAddTag(driver, Integer.toString(randomNumber) + "Board_Tag" + Integer.toString(i), false);
            Thread.sleep(300);
            cardSave(driver);
        }
        Thread.sleep(1000);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddTask(WebDriver driver, String taskName, boolean isLogged) {
        final String CARD_ADD_FIRST_TASK_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[2]/div[3]/div[3]";
        final String CARD_ADD_TASKS_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[2]/div[3]/div[4]";
        final String CARD_ENTER_TASK_NAME_CSS = ".fastcardpopup-userfield.fastcardpopup-taskinput-input.js-addtask-input";
        final String CARD_ADD_TASK_BUTTON_CSS = ".fastcardpopup-taskinput-button.js-addtask-button";

        if (!Service.isElementPresent(By.xpath(CARD_ADD_TASKS_XPATH), driver)) {
            driver.findElement(By.xpath(CARD_ADD_FIRST_TASK_XPATH)).click();
        } else {
            driver.findElement(By.xpath(CARD_ADD_TASKS_XPATH)).click();
        }

        driver.findElement(By.cssSelector(CARD_ENTER_TASK_NAME_CSS)).sendKeys(taskName);
        driver.findElement(By.cssSelector(CARD_ADD_TASK_BUTTON_CSS)).click();
        if (isLogged) System.out.println("  Task " + taskName + " was added");
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddManyTasks(WebDriver driver, int numberOfTasks, int ideaCardNum, int boardCardX, int boardCardY, boolean isLogged) throws InterruptedException {
        cardOpenIdeaCard(driver, ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea card with Many Tasks");
        cardSave(driver);
        cardOpenBoardCard(driver, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board card with Many Tasks");
        cardSave(driver);
        for (int i = 1; i <= numberOfTasks; i++) {
            cardOpenIdeaCard(driver, ideaCardNum, false);
            cardAddTask(driver, "IdeaTask" + Integer.toString(i), false);
            cardSave(driver);
        }
        for (int i = 1; i <= numberOfTasks; i++) {
            cardOpenBoardCard(driver, boardCardX, boardCardY, false);
            cardAddTask(driver, "BoardTask" + Integer.toString(i), false);
            cardSave(driver);
        }
        Thread.sleep(1000);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddComment(WebDriver driver, String commentText) throws InterruptedException, IOException {

        final String CARD_ADD_COMMENT_XPATH =   "html/body/div[4]/div/div/div[1]/div[2]/div[6]/div/div[2]/div[1]";
        final String CARD_ENTER_COMMENT_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[6]/div/div[2]/textarea";
        final String CARD_POST_COMMENT_CSS = ".click-to-edit-save.js-click-to-edit-save-button.js-tap-indication";

        driver.findElement(By.xpath(CARD_ADD_COMMENT_XPATH)).click();
        driver.findElement(By.xpath(CARD_ENTER_COMMENT_XPATH)).sendKeys(commentText);
        driver.findElement(By.cssSelector(CARD_POST_COMMENT_CSS)).click();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardCommentAddMany(WebDriver driver, String commentText, int occurenceNumber, int ideaCardNum, int boardCardX, int boardCardY,
                                          boolean isLogged) throws IOException, InterruptedException {
        for (int i = 1; i <= occurenceNumber; i++) {
            cardOpenIdeaCard(driver, ideaCardNum, false);
            cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea Card with Comments");
            cardAddComment(driver, commentText);
            cardSave(driver);
        }
        for (int i = 1; i <= occurenceNumber; i++) {
            cardOpenBoardCard(driver, boardCardX, boardCardY, false);
            cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board Card with Comments");
            cardAddComment(driver, commentText);
            cardSave(driver);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDatesSet(WebDriver driver, String startDate, String finishDate, boolean isLogged) throws InterruptedException {
        final String CARD_START_OPEN_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]";
        final String CARD_START_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[3]/input";
        final String CARD_FINISH_OPEN_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]";
        final String CARD_FINISH_XPATH = "html/body/div[4]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[3]/input";

        if (startDate != null) {
            driver.findElement(By.xpath(CARD_START_OPEN_XPATH)).click();
            driver.findElement(By.xpath(CARD_START_XPATH)).sendKeys(startDate);
            Thread.sleep(1000);
        }
        if (finishDate != null) {
            driver.findElement(By.xpath(CARD_FINISH_OPEN_XPATH)).click(); //***
            driver.findElement(By.xpath(CARD_FINISH_XPATH)).sendKeys(finishDate);
            Thread.sleep(1000);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDatesAddFew(WebDriver driver, int firstCard, int columnNum,
                                       String startDate, String finishDate, boolean isLogged) throws InterruptedException {
        //Set Dates for Ideas Cards
        cardOpenIdeaCard(driver, firstCard, false);
        cardDatesSet(driver, startDate, finishDate, false);
        cardSave(driver);
        cardOpenIdeaCard(driver, firstCard + 1, false);
        cardDatesSet(driver, startDate, null, false);
        cardSave(driver);
        cardOpenIdeaCard(driver, firstCard + 2, false);
        cardDatesSet(driver, null, finishDate, false); //***
        cardSave(driver);

        //Set Dates for Board Cards
        cardOpenBoardCard(driver, firstCard, columnNum, false);
        cardDatesSet(driver, startDate, finishDate, false);
        cardSave(driver);
        Thread.sleep(1000);
        cardOpenBoardCard(driver, firstCard + 1, columnNum, false);
        cardDatesSet(driver, startDate, null, false);
        cardSave(driver);
        Thread.sleep(1000);
        cardOpenBoardCard(driver, firstCard + 2, columnNum, false);
        cardDatesSet(driver, null, finishDate, false);
        cardSave(driver);
        Thread.sleep(1000);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDatesAddCalendar(WebDriver driver, String month, boolean isLogged) throws InterruptedException {
        String dateField;
        Widget.widgetsCreation(driver, 1,"", WidgetState.EXPANDED, WidgetColor.DARKGREEN, true, false);
        cardsFirstBoardGeneration(driver, 7, 5, false);

        String dateName = "";
        int xCardIndex;
        int yCardIndex;

        for (int i = 1; i <= 32; i++) {
            xCardIndex = ((i - 1) % 7) + 1;
            yCardIndex = ((i - 1) / 7) + 1;
            cardOpenBoardCard(driver, xCardIndex, yCardIndex, false);
            cardSetName(driver, "Day " + Integer.toString(i));
            dateName = "2015-10-" + Integer.toString(i);
            Thread.sleep(1000);
            cardDatesSet(driver, null, dateName, false);
            Thread.sleep(1000);
            cardSave(driver);
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddDescription(WebDriver driver, String descriptionText) throws InterruptedException {
        final String CARD_DESCRIPTION_CLICK_CSS = ".fastcardpopup-button.fastcardpopup-description-button.js-fastcardpopup-show.js-tap-indication";
        final String CARD_DESCRIPTION_CSS = ".click-to-edit.click-to-edit-styling.fastcardpopup-description-click-to-edit." +
                "js-click-to-edit-card-description.js-click-to-edit-input";
        driver.findElement(By.cssSelector(CARD_DESCRIPTION_CLICK_CSS)).click();
        driver.findElement(By.cssSelector(CARD_DESCRIPTION_CSS)).sendKeys(descriptionText);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDescriptionAddtoManyCards(WebDriver driver, String descriptionText, int ideaCardNum, int boardCardX, int boardCardY, boolean isLogged) throws InterruptedException {
        Card.cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + " Idea Card with Big Description");
        Card.cardAddDescription(driver, descriptionText);
        cardSave(driver);
        Card.cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + " Board Card with Big Description");
        Card.cardAddDescription(driver, descriptionText);
        cardSave(driver);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddPeople(WebDriver driver, String userName, boolean isLogged) throws InterruptedException {

        final String CARD_ADD_PEOPLE_CSS = ".fastcardpopup-button.js-userfield.js-fastcardpopup-show.js-tap-indication";
        final String CARD_NAME_ADD_PEOPLE_ID = "menu-popup-avatar";

        driver.findElement(By.cssSelector(CARD_ADD_PEOPLE_CSS)).click();
        driver.findElement(By.id(CARD_NAME_ADD_PEOPLE_ID)).sendKeys(userName);
        Thread.sleep(500);
        driver.findElement(By.id(CARD_NAME_ADD_PEOPLE_ID)).sendKeys(Keys.ENTER);
        driver.findElement(By.id(CARD_NAME_ADD_PEOPLE_ID)).sendKeys(Keys.ESCAPE);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddFewPeople(WebDriver driver, String[] userNames, int ideaCardNum, int boardCardX, int boardCardY) throws InterruptedException {
        cardOpenIdeaCard(driver, ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea card with Assignment");
        for (String selectedName : userNames) {
            cardAddPeople(driver, selectedName, false);
        }
        cardSave(driver);

        cardOpenBoardCard(driver, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board card with Assignment");
        for (String selectedName : userNames) {
            cardAddPeople(driver, selectedName, false);
        }
        cardSave(driver);
//        Thread.sleep(500);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardOpenBoardCard(WebDriver driver, int numberX, int numberY, boolean isLogged) throws InterruptedException {
        String stringCounterX;
        String stringCounterY;
        String dynamicPartX;
        String dynamicPartY;
        String currentXpathForAdding;

        final String BOARD_CARD_X_PATH_FIRST_PART_V2 = "html/body/div[3]/div[1]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/";
        final String BOARD_CARD_X_PATH_ADD_CARD = "/div";
        final String BOARD_CARD_X_PATH_MEDIUM = "/div[2]/";

        stringCounterX = Integer.toString(numberX);
        if (numberX == 1) dynamicPartX = "div";
        else dynamicPartX = "div[" + stringCounterX + "]";
        stringCounterY = Integer.toString(numberY);
        dynamicPartY = "div[" + stringCounterY + "]";
        currentXpathForAdding = BOARD_CARD_X_PATH_FIRST_PART_V2 + dynamicPartY + BOARD_CARD_X_PATH_MEDIUM + dynamicPartX + BOARD_CARD_X_PATH_ADD_CARD;
        driver.findElement(By.xpath(currentXpathForAdding)).click();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardFileAdd(WebDriver driver, String filepath, int ideaCardNum, int boardCardX, int boardCardY, boolean isLogged) throws InterruptedException, AWTException {
        StringSelection stringSelection = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Card.cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea Card with File");
        driver.findElement(By.cssSelector(".fastcardpopup-button.js-addfile")).click();
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        cardSave(driver);
        Thread.sleep(5000);

        Card.cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board Card with File");
        driver.findElement(By.cssSelector(".fastcardpopup-button.js-addfile")).click();
        Thread.sleep(2000);
        Robot robot2 = new Robot();
        robot2.keyPress(KeyEvent.VK_CONTROL);
        robot2.keyPress(KeyEvent.VK_V);
        robot2.keyRelease(KeyEvent.VK_CONTROL);
        robot2.keyRelease(KeyEvent.VK_V);
        Thread.sleep(500);
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        cardSave(driver);
        Thread.sleep(5000);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardBreakDownToIdea(WebDriver driver) {

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardBreakDownToBoard(WebDriver driver) {

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardLanesCreation(WebDriver driver, int number) {

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardLaneOpen(WebDriver driver, int number) {

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------
}

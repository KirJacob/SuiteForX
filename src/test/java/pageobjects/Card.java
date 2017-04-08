package pageobjects;

import enums.TestData;
import enums.WidgetColor;
import enums.WidgetState;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.Run;
import utils.Service;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.PublicKey;

public class Card {

    final static String CARD_MENU_USER_CSS = ".ui-button-black.cardpopup-sidebar-button.js-tap-indication.js-add-users";
    final static String CARD_MENU_TAG_CSS = ".ui-button-black.cardpopup-sidebar-button.js-tap-indication.js-add-tags";
    final static String CARD_MENU_TASK_CSS = ".ui-button-black.cardpopup-sidebar-button.js-tap-indication.js-add-task";
    final static String CARD_MENU_DATE_CSS = ".ui-button-black.cardpopup-sidebar-button.js-tap-indication.js-start-due-date";
    final static String CARD_MENU_FILE_CSS = ".ui-button-black.cardpopup-sidebar-button.js-tap-indication.js-add-file";
    final static String CARD_MENU_ADD_TAG_FIELD = "#js-add-tag-autocomplete";
    final static String CARD_MENU_ADD_USER_FIELD = "#js-add-user-autocomplete";
    final static String CARD_MENU_MORE_XPATH = "//div[@class='cardpopup-more-link cardpopup-sidebar-button js-card-more-menu js-tap-indication']";
    final static String CARD_MENU_MORE_BREAKDOWNTO_BOARD = "//div[@class='widget-menu-choice-text'][contains(text(),'Break down to Board')]";
    final static String CARD_MENU_MORE_BREAKDOWNTO_IDEA = "//div[@class='widget-menu-choice-text'][contains(text(),'Break down to Backlog')]";
    final static String CARD_SUBPOPUP_CLOSE = ".js-popup-close";
    final static String CARD_POPUP_OUTSIDE = ".js-close-cardpopup";

    //--NVD2--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardsFirstIdeaGeneration(WebDriver driver, int number, boolean isLogged) throws InterruptedException {
        String name;
        final String IDEA_ADD_CARD_XPATH = "(//div[@class='workspace-widgetpane widgetpane-backlogs js-backlogs ui-resizable']" +
                "//*[@class='js-paged-list-end mod-not-draggable'])";
        final String IDEA_ENTER_XPATH = "//div[@class='workspace-widgetpane widgetpane-backlogs js-backlogs ui-resizable']" +
                "//*[@class='ui-textfield-input']/textarea";
        final String IDEA_BUTTON_XPATH = "//div[@class='workspace-widgetpane widgetpane-backlogs js-backlogs ui-resizable']" +
                "//*[@class='ui-textfield-input']/parent::div/div[2]/button";
        for (int i = 1; i <= number; i++) {
            name = Integer.toString(i);
            if (isLogged) System.out.println(IDEA_ADD_CARD_XPATH);
            driver.findElement(By.xpath(IDEA_ADD_CARD_XPATH)).click();
            if (isLogged) System.out.println(IDEA_ENTER_XPATH);
            driver.findElement(By.xpath(IDEA_ENTER_XPATH)).sendKeys(Run.currentBrowser + Service.nowTimeForObjectName() + " Idea Card " + name);
            if (isLogged) System.out.println(IDEA_BUTTON_XPATH);
            driver.findElement(By.xpath(IDEA_BUTTON_XPATH)).click();
            Thread.sleep(300);
        }
    }

    //--NVD2--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardsFirstBoardGeneration(WebDriver driver, int numberY, int numberX, boolean isLogged) throws InterruptedException {
        String stringCounterX;
        String stringCounterY;
        String dynamicPartY;
        String currentXpathForAdding;
        String currentXpathForNaming;
        String currentXpathForSaving;
//        (//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']/div/div/div/div[1]//*[@class='js-paged-list-end mod-not-draggable'])
        final String BOARD_ADD_CARD_XPATH = "(//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']/div/div/div/div[1]" +
                "//*[@class='js-paged-list-end mod-not-draggable'])";
        final String BOARD_ENTER_XPATH = "(//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']/div/div/div/div[1]" +
                "//*[@class='js-textfield ui-textfield js-card-textfield'])/div[1]/textarea";
        final String BOARD_BUTTON_XPATH = "(//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']/div/div/div/div[1]" +
                "//*[@class='js-textfield ui-textfield js-card-textfield'])/div[2]/button";
        if (numberX > 2) Column.columnsCreation(driver, numberX - 2, isLogged);
        for (int i = 1; i <= numberY; i++) {
            stringCounterX = Integer.toString(i);
            for (int j = 1; j <= numberX; j++) {
                stringCounterY = Integer.toString(j);
                dynamicPartY = "[" + stringCounterY + "]";
                currentXpathForAdding = BOARD_ADD_CARD_XPATH + dynamicPartY;
                currentXpathForNaming = BOARD_ENTER_XPATH;
                currentXpathForSaving = BOARD_BUTTON_XPATH;
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

    //--NVD2--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardOpenIdeaCard(WebDriver driver, int ideaNum, int cardNum, boolean isLogged) {
        final String IDEA_CARD_PART1 = "html/body/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div/";
        final String IDEA_CARD_PART2 = "/div[2]/div/div/";
        final String IDEA_CARD_PART3 = "/div[1]/div/div/div";
        String dynamicPartY;
        String dynamicPartX;
        String currentXpathForAdding;
        dynamicPartY = "div["+Integer.toString(ideaNum)+"]";
        dynamicPartX = "div["+Integer.toString(cardNum)+"]";
        currentXpathForAdding = IDEA_CARD_PART1 + dynamicPartY + IDEA_CARD_PART2 + dynamicPartX + IDEA_CARD_PART3;
        if (isLogged) System.out.println(currentXpathForAdding);
        driver.findElement(By.xpath(currentXpathForAdding)).click();
    }

    //--NVD2--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardOpenBoardCard(WebDriver driver, int boardNum, int cardNum, int columnNum, boolean isLogged) throws InterruptedException {
    //((//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']/div/div[2]/div/div[2]//*[@class='board-column js-board-column'])[2]//*[@class='card js-nav-to js-boarditem'])[2]
//        html/body/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div[Z]/div[2]/div[1]/div[2]/div[X]/div[1]/div[2]/div[Y]/div/div/div/div
        final String BOARD_CARD_PART1 = "html/body/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div/";
        final String BOARD_CARD_PART2 = "/div[2]/div[1]/div[2]/";
        final String BOARD_CARD_PART3 = "/div[1]/div[2]/";
        final String BOARD_CARD_PART4 = "/div/div/div/div";
        String dynamicPartZ;
        String dynamicPartY;
        String dynamicPartX;
        String currentXpathForAdding;
        dynamicPartZ = "div["+Integer.toString(boardNum)+"]";
        dynamicPartY = "div["+Integer.toString(columnNum)+"]";
        dynamicPartX = "div["+Integer.toString(cardNum)+"]";
        currentXpathForAdding = BOARD_CARD_PART1 + dynamicPartZ + BOARD_CARD_PART2 + dynamicPartY + BOARD_CARD_PART3+
                dynamicPartX+BOARD_CARD_PART4;
//        currentXpathForAdding="((//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']/div/div[2]/div/div[1]//*[@class='board-column js-board-column'])[1]//*[@class='card js-nav-to js-boarditem'])[1]/div/div/div[1]/div";
        if (isLogged) System.out.println(currentXpathForAdding);
        driver.findElement(By.xpath(currentXpathForAdding)).click();

    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardCancel(WebDriver driver) {
        final String CARD_CANCEL_XPATH = "(//div[@class='cardpopup-topbar'])/" +
                "child::div[@class='cardpopup-close js-close-cardpopup js-tap-indication']";
        driver.findElement(By.xpath(CARD_CANCEL_XPATH)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDelete(WebDriver driver, boolean isLogged) {
        final String CARD_DELETE_XPATH = "(//div[@class='ui-button-text'])[last()]";
        driver.findElement(By.xpath(CARD_DELETE_XPATH)).click();
        driver.findElement(By.xpath(CARD_DELETE_XPATH)).click();
        if (isLogged) System.out.println("Card was removed");
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDeleteMany(WebDriver driver, int number, int boardRow, boolean isLogged) throws InterruptedException {
        for (int i = 1; i <= number; i++) {
            cardOpenIdeaCard(driver, 1, 1, isLogged);
            cardDelete(driver, isLogged);
            cardOpenBoardCard(driver, 1, 1, boardRow, isLogged);
            cardDelete(driver, isLogged);
        }
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardArchiveUnarchive(WebDriver driver, boolean isLogged) {
        final String CARD_ARCHIVE_CSS = ".ui-button-black.cardpopup-sidebar-button.js-tap-indication.js-archive-card";
        driver.findElement(By.cssSelector(CARD_ARCHIVE_CSS)).click();
        if (isLogged) System.out.println("Card was archived / unarchived");
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardArchiveMany(WebDriver driver, int number, int boardRow, boolean isLogged) throws InterruptedException {
        for (int i = 1; i <= number; i++) {
            cardOpenIdeaCard(driver,1, 1, isLogged);
            cardArchiveUnarchive(driver, isLogged);
            cardCancel(driver);
            cardOpenBoardCard(driver,1, 1, boardRow, isLogged);
            cardArchiveUnarchive(driver, isLogged);
            cardCancel(driver);
        }
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardSetName(WebDriver driver, String cardName) {
        final String CARD_TITLE_FIELD_CSS = ".click-to-edit.js-click-to-edit";
        final String CARD_TITLE_ENTER_CSS = ".click-to-edit.click-to-edit-styling.js-click-to-edit-input";
        final String CARD_TITLE_SAVE_CSS = ".click-to-edit-save.js-click-to-edit-save-button.js-tap-indication";
        driver.findElement(By.cssSelector(CARD_TITLE_FIELD_CSS)).click();
        driver.findElement(By.cssSelector(CARD_TITLE_ENTER_CSS)).clear();
        driver.findElement(By.cssSelector(CARD_TITLE_ENTER_CSS)).sendKeys(cardName);
        driver.findElement(By.cssSelector(CARD_TITLE_SAVE_CSS)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static String cardGetName(WebDriver driver) {
        final String CARD_TITLE_FIELD_CSS = ".click-to-edit.js-click-to-edit";
        String name;
        name = driver.findElement(By.cssSelector(CARD_TITLE_FIELD_CSS)).getText();
        return name;
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddTag(WebDriver driver, String tagName, boolean isLogged) throws InterruptedException {

        driver.findElement(By.cssSelector(CARD_MENU_TAG_CSS)).click();
        driver.findElement(By.cssSelector(CARD_MENU_ADD_TAG_FIELD)).sendKeys(tagName);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(CARD_MENU_ADD_TAG_FIELD)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(CARD_SUBPOPUP_CLOSE)).click();
//        driver.findElement(By.cssSelector(CARD_POPUP_OUTSIDE)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddManyNewTagsToCard(WebDriver driver, int number, int ideaCardNum, int boardCardX, int boardCardY) throws InterruptedException {
        int randomNumber = (int) (Math.random() * 1000000);
        cardOpenIdeaCard(driver, 1,ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea card with Many Tags");
        cardCancel(driver);

        cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board card with Many Tags");
        cardCancel(driver);
        for (int i = 1; i <= number; i++) {
            cardOpenIdeaCard(driver,1, ideaCardNum, false);
            cardAddTag(driver, Integer.toString(randomNumber) + "Idea_Tag" + Integer.toString(i), false);
            Thread.sleep(300);
            cardCancel(driver);
        }
        for (int i = 1; i <= number; i++) {
            cardOpenBoardCard(driver,1, boardCardX, boardCardY, false);
            cardAddTag(driver, Integer.toString(randomNumber) + "Board_Tag" + Integer.toString(i), false);
            Thread.sleep(300);
            cardCancel(driver);
        }
        Thread.sleep(1000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddPeople(WebDriver driver, String userName, boolean isLogged) throws InterruptedException {

        driver.findElement(By.cssSelector(CARD_MENU_USER_CSS)).click();
        driver.findElement(By.cssSelector(CARD_MENU_ADD_USER_FIELD)).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(CARD_MENU_ADD_USER_FIELD)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(CARD_SUBPOPUP_CLOSE)).click();
//        driver.findElement(By.cssSelector(CARD_POPUP_OUTSIDE)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddListOfPeople(WebDriver driver, String[] listOfPeople, boolean isLogged) throws InterruptedException {
        for (String element : listOfPeople) {
            cardAddPeople(driver, element, false);
        }
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddFewPeople(WebDriver driver, String[] userNames, int ideaCardNum, int boardCardX, int boardCardY) throws InterruptedException {
        cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea card with Assignment");
        for (String selectedName : userNames) {
            cardAddPeople(driver, selectedName, false);
        }
        cardCancel(driver);

        cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board card with Assignment");
        for (String selectedName : userNames) {
            cardAddPeople(driver, selectedName, false);
        }
        cardCancel(driver);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddElementsToWidget(WebDriver driver, String[] listOfTags, String[] listOfUsers,
                                               int ideaCardNum, int boardCardX, int boardCardY) throws InterruptedException {
        for (int i = 1; i <= ideaCardNum; i++) {
            for (String tagElement : listOfTags) {
                cardOpenIdeaCard(driver, 1, i, false);
                cardAddTag(driver, tagElement, false);
                cardCancel(driver);
            }
            cardOpenIdeaCard(driver, 1, i, false);
            cardAddListOfPeople(driver, listOfUsers, false);
            cardCancel(driver);
        }
        for (int j = 1; j <= boardCardX; j++) {
            for (int k = 1; k <= boardCardY; k++) {
                for (String tagElement : listOfTags) {
                    cardOpenBoardCard(driver, 1, j, k, false);
                    cardAddTag(driver, tagElement, false);
                    cardCancel(driver);
                }
                cardOpenBoardCard(driver, 1, j, k, false);
                cardAddListOfPeople(driver, listOfUsers, false);
                cardCancel(driver);
            }
        }
    }
    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddRandomTagsToBoard(WebDriver driver, String[] listOfTags, int maximumTags, int boardCardX, int boardCardY) throws InterruptedException {
        int numberOfTags;
        Thread.sleep(40000);
        for (int j = 380 ; j <= boardCardX; j++) {
            for (int k = 1; k <= boardCardY; k++) {
                numberOfTags = (int)(Math.random()*maximumTags) - 1 ;
                for (int z = 1; z <= numberOfTags;z++){
                    cardOpenBoardCard(driver, 1, j, k, false);
//                    System.out.println(cardGetName(driver));
                    cardAddTag(driver, listOfTags[z-1], false);
                    cardCancel(driver);
                }
            }
        }
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddComment(WebDriver driver, String commentText) throws InterruptedException, IOException {
        final String CARD_ADD_COMMENT_CSS = ".card-popup-comment-placeholder";
        final String CARD_ENTER_COMMENT_CSS = ".click-to-edit.click-to-edit-styling.card-popup-comment.js-click-to-edit-input";
        final String CARD_POST_COMMENT_XPATH = "//div[@class='click-to-edit-save js-click-to-edit-save-button js-tap-indication' and contains(text(),'Post comment')]";

        driver.findElement(By.cssSelector(CARD_ADD_COMMENT_CSS)).click();
        driver.findElement(By.cssSelector(CARD_ENTER_COMMENT_CSS)).sendKeys(commentText);
        driver.findElement(By.xpath(CARD_POST_COMMENT_XPATH)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardCommentAddMany(WebDriver driver, String commentText, int occurenceNumber, int ideaCardNum, int boardCardX, int boardCardY,
                                          boolean isLogged) throws IOException, InterruptedException {
        cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea Card with Comments");
        for (int i = 1; i <= occurenceNumber; i++) {
            cardAddComment(driver, commentText);
        }
        cardCancel(driver);
        cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board Card with Comments");
        for (int i = 1; i <= occurenceNumber; i++) {
            cardAddComment(driver, commentText);
        }
        cardCancel(driver);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDatesSet(WebDriver driver, String startDate, String finishDate, boolean isLogged) throws InterruptedException {
        //other xpathes and css selectors dont work, somehow
        final String CARD_START_XPATH = "html/body/div[5]/div/div[3]/div[1]/div[1]/div[1]";
        final String CARD_FINISH_XPATH = "html/body/div[5]/div/div[3]/div[2]/div[1]/div[1]";
        final String CARD_START_ENTER_XPATH = "html/body/div[5]/div/div[3]/div[1]/div[2]/div[1]/input[1]";
        final String CARD_FINISH_ENTER_XPATH = "html/body/div[5]/div/div[3]/div[2]/div[2]/div[1]/input[1]";
        //the following xpathes dont work
        final String CARD_START_BLOCK_CSS = "//div[@class='date-picker-title'][contains(text(),'Set start date')]";
        final String CARD_FINISH_BLOCK_CSS = "//div[@class='date-picker-title'][contains(text(),'Set due date')]";
        final String CARD_START_BLOCK_XPATH1 = "(//div[@class='date-picker-title'])[3]']";

        driver.findElement(By.cssSelector(CARD_MENU_DATE_CSS)).click();

        if (finishDate != null) {
            driver.findElement(By.xpath(CARD_FINISH_ENTER_XPATH)).click();
            driver.findElement(By.xpath(CARD_FINISH_ENTER_XPATH)).sendKeys(finishDate);
            Thread.sleep(1000);
        }
        if (startDate != null) {
            driver.findElement(By.xpath(CARD_START_XPATH)).click();
            driver.findElement(By.xpath(CARD_START_ENTER_XPATH)).click();
            driver.findElement(By.xpath(CARD_START_ENTER_XPATH)).sendKeys(startDate);
            Thread.sleep(1000);
        }
        driver.findElement(By.cssSelector(CARD_SUBPOPUP_CLOSE)).click();
//        driver.findElement(By.cssSelector(CARD_POPUP_OUTSIDE)).click();
        Thread.sleep(1000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDatesAddFew(WebDriver driver, int firstCard, int columnNum,
                                       String startDate, String finishDate, boolean isLogged) throws InterruptedException {
        //Set Dates for Ideas Cards
        cardOpenIdeaCard(driver, 1, firstCard, false);
        cardDatesSet(driver, startDate, finishDate, false);
        cardCancel(driver);
        Thread.sleep(1000);
        cardOpenIdeaCard(driver, 1, firstCard + 1, false);
        cardDatesSet(driver, startDate, null, false);
        cardCancel(driver);
        Thread.sleep(1000);
        cardOpenIdeaCard(driver, 1, firstCard + 2, false);
        cardDatesSet(driver, null, finishDate, false); //***
        cardCancel(driver);
        Thread.sleep(1000);

        //Set Dates for Board Cards
        cardOpenBoardCard(driver, 1, firstCard, columnNum, false);
        cardDatesSet(driver, startDate, finishDate, false);
        cardCancel(driver);
        Thread.sleep(1000);
        cardOpenBoardCard(driver, 1, firstCard + 1, columnNum, false);
        cardDatesSet(driver, startDate, null, false);
        cardCancel(driver);
        Thread.sleep(1000);
        cardOpenBoardCard(driver, 1, firstCard + 2, columnNum, false);
        cardDatesSet(driver, null, finishDate, false);
        cardCancel(driver);
        Thread.sleep(1000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDatesAddCalendar(WebDriver driver, String month, boolean isLogged) throws InterruptedException {
        String dateField;
        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.DARKGREEN, true, false);
        cardsFirstBoardGeneration(driver, 7, 5, false);

        String dateName = "";
        int xCardIndex;
        int yCardIndex;

        for (int i = 1; i <= 32; i++) {
            xCardIndex = ((i - 1) % 7) + 1;
            yCardIndex = ((i - 1) / 7) + 1;
            cardOpenBoardCard(driver, 1, xCardIndex, yCardIndex, false);
            cardSetName(driver, "Day " + Integer.toString(i));
            dateName = "2015/12/" + Integer.toString(i);
            Thread.sleep(1000);
            cardDatesSet(driver, null, dateName, false);
            Thread.sleep(1000);
            cardCancel(driver);
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddDescription(WebDriver driver, String descriptionText) throws InterruptedException {
        final String CARD_DESCRIPTION_CLICK_CSS = ".card-popup-description-placeholder";
        final String CARD_DESCRIPTION_CSS = ".click-to-edit.click-to-edit-styling.card-popup-description.js-click-to-edit-input";
        final String CARD_DESCRIPTION_SAVE_XPATH = "html/body/div[4]/div/div/div/div[3]/div[1]/div[5]/div[2]/div/div[2]/div[3]";
        //div[@class='.click-to-edit-save.js-click-to-edit-save-button.js-tap-indication']

        driver.findElement(By.cssSelector(CARD_DESCRIPTION_CLICK_CSS)).click();
        driver.findElement(By.cssSelector(CARD_DESCRIPTION_CSS)).sendKeys(descriptionText);
        driver.findElement(By.xpath(CARD_DESCRIPTION_SAVE_XPATH)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardDescriptionAddtoManyCards(WebDriver driver, String descriptionText, int ideaCardNum, int boardCardX, int boardCardY, boolean isLogged) throws InterruptedException {
        Card.cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + " Idea Card with Big Description");
        Card.cardAddDescription(driver, descriptionText);
        cardCancel(driver);
        Card.cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + " Board Card with Big Description");
        Card.cardAddDescription(driver, descriptionText);
        cardCancel(driver);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddTask(WebDriver driver, String taskListName, String[] listOfTasks, boolean isLogged) throws InterruptedException {
        final String CARD_TASKLIST_ENTERNAME_XPATH = "//textarea[contains(@class,'card-tasklist-title')]";
        final String CARD_ENTER_TASK_NAME_XPATH =
                "(//div[@class='card-task-list-container js-card-task-list js-tap-hold-drag js-tap-indication ui-sortable-handle']/" +
                        "child::div[2]/child::div/child::div/child::textarea)[last()]";
        final String CARD_ENTER_TASK_NAME_ADDTASK_CSS = ".click-to-edit-save.js-click-to-edit-save-button.js-tap-indication";
        final String CARD_ENTER_TASK_NAME_CANCEL_CSS = ".click-to-edit-cancel.js-click-to-edit-cancel-button.js-tap-indication";

        driver.findElement(By.cssSelector(CARD_MENU_TASK_CSS)).click();
        driver.findElement(By.xpath(CARD_TASKLIST_ENTERNAME_XPATH)).sendKeys(taskListName);
        driver.findElement(By.xpath(CARD_TASKLIST_ENTERNAME_XPATH)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(CARD_TASKLIST_ENTERNAME_XPATH)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        for (String taskSingleName : listOfTasks) {
            driver.findElement(By.xpath(CARD_ENTER_TASK_NAME_XPATH)).sendKeys(taskSingleName);
            driver.findElement(By.xpath(CARD_ENTER_TASK_NAME_XPATH)).sendKeys(Keys.ENTER);
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("(//div[@class='click-to-edit-cancel js-click-to-edit-cancel-button js-tap-indication'])[last()-1]")).click();
        Thread.sleep(1000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardAddManyTasks(WebDriver driver, int numberOfTaskLists, int numberOfTasks,
                                        int ideaCardNum, int boardCardX, int boardCardY, boolean isLogged) throws InterruptedException {
        cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea card with Many Tasks");
        cardCancel(driver);
        cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board card with Many Tasks");
        cardCancel(driver);
        String[] taskLists = new String[numberOfTaskLists];
        String[] tasks = new String[numberOfTasks];
        for (int i = 0; i < numberOfTaskLists; i++) {
            taskLists[i] = "TaskList" + (i + 1);
        }
        for (int j = 0; j < numberOfTasks; j++) {
            tasks[j] = "Task" + (j + 1);
        }
        for (int i = 0; i < numberOfTaskLists; i++) {
            cardOpenIdeaCard(driver, 1, ideaCardNum, false);
            cardAddTask(driver, taskLists[i], tasks, false);
            Thread.sleep(1000);
            cardCancel(driver);
            cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
            cardAddTask(driver, taskLists[i], tasks, false);
            Thread.sleep(1000);
            cardCancel(driver);
        }
        Thread.sleep(2000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    //Need to be included to suites
    public static void cardBreakDownToIdea(WebDriver driver) {
        driver.findElement(By.xpath(CARD_MENU_MORE_XPATH)).click();
        driver.findElement(By.xpath(CARD_MENU_MORE_BREAKDOWNTO_IDEA)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    //Need to be included to suites
    public static void cardBreakDownToBoard(WebDriver driver) {
        driver.findElement(By.xpath(CARD_MENU_MORE_XPATH)).click();
        driver.findElement(By.xpath(CARD_MENU_MORE_BREAKDOWNTO_BOARD)).click();
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardBreakDownToWidgets(WebDriver driver) throws InterruptedException {
        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.GREEN, true, false);
        Card.cardsFirstIdeaGeneration(driver, 2, false);
        Card.cardsFirstBoardGeneration(driver, 2, 2, false);

        Card.cardOpenIdeaCard(driver, 1, 1, false);
        Card.cardSetName(driver, "Breakdown to IdeaList Card");
        Card.cardBreakDownToIdea(driver);
        Card.cardOpenBoardCard(driver, 1, 1, 1, false);
        Card.cardSetName(driver, "Breakdown to Board Card");
        Card.cardBreakDownToBoard(driver);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void cardFileAdd(WebDriver driver, String filepath, int ideaCardNum, int boardCardX, int boardCardY, boolean isLogged) throws InterruptedException, AWTException {
        StringSelection stringSelection = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Card.cardOpenIdeaCard(driver, 1, ideaCardNum, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Idea Card with File");
        driver.findElement(By.cssSelector(CARD_MENU_FILE_CSS)).click();
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
        cardCancel(driver);
        Thread.sleep(5000);

        Card.cardOpenBoardCard(driver, 1, boardCardX, boardCardY, false);
        Card.cardSetName(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".Board Card with File");
        driver.findElement(By.cssSelector(CARD_MENU_FILE_CSS)).click();
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
        cardCancel(driver);
        Thread.sleep(5000);
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static WebElement takeIdeaCardWebElement(WebDriver driver, int ideaWidgetNum, int ideaCardNum,boolean isLogged) {
        /* (//div[@class='widget-backlog'])[X]/div/div[Y] */
        String cardXpath="(//div[@class='widget-backlog'])[" + Integer.toString(ideaWidgetNum) + "]" +
                "/div/div[" + Integer.toString(ideaCardNum) + "]";
        if (isLogged) System.out.println(cardXpath);
        return driver.findElement(By.xpath(cardXpath));
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void openIdeaCardByWebelement(WebDriver driver, int ideaWidgetNum, int ideaCardNum) {
        takeIdeaCardWebElement(driver, ideaWidgetNum, ideaCardNum,false).click();
    }

    //--NCP-----------------------------------------------------------------------------------------------------------------------------------------------
    public static WebElement takeBoardCardWebElement(WebDriver driver, int boardWidgetNum, int boardColumnTo, int boardCardTo,boolean isLogged) {
        /* (//div[@class='widget-board-content'])[X] //*[@class='board-column js-board-column'][Y]/div[2]/div[Z] */
        String cardXpath="((//div[@class='widget-board-content js-board-content'])[" + Integer.toString(boardWidgetNum) + "]" +
                " //*[@class='board-column js-board-column'])[" + Integer.toString(boardColumnTo) + "]" +
                "/div[2]/div[" + Integer.toString(boardCardTo) + "]";
        if (isLogged) System.out.println(cardXpath);
        return driver.findElement(By.xpath(cardXpath));
    }

    //--NCP----------------------------------------------------------------------------------------------------------------------------------------------
    public static void openBoardCardByWebelement(WebDriver driver, int boardWidgetNum, int boardColumnTo, int boardCardTo) {
        takeBoardCardWebElement(driver, boardWidgetNum, boardColumnTo, boardCardTo, false).click();
    }

}

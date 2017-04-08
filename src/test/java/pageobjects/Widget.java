package pageobjects;

import enums.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.Run;
import utils.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Widget {
    /**
     * .xaddbutton-icon
     * 16.10.2015 - 235 lines
     * 1. widgetsCreation
     * 2. widgetsArchive
     * 3. widgetsCurrentRename
     * 4. widgetsRemoval
     * 5. widgetsShowArchived
     * to be developed
     * >* 6. widgetFilterShowArchived
     * >* 7. widgetFilterShowAssignedToMeOnly
     * >* 8. widgetGetListOfWidgets
     * >* 9. widgetChoseWidget
     * 10.widgetShowRelations
     * >* 11.widgetApps
     * 12.EXTEND BOARD and IDEA FROM WIDGETS
     * >* 13.widgetShareManually
     * >* 14.widgetShareMakePrivate
     * >* 15.widgetsAddtoCollection
     * >* 16.widgetViewinNewTab
     * >* 17.widgetSubscribe
     * >* 18.widgetAppsShowLeadTime
     * >* 19.widgetAppsEnableLanes
     */
    //basics and creation
    //new visual design
    final static String WIDGET_CREATE_CSS = ".img.workspacelink-icon.workspacelink-addicon.js-collection-add";
    final static String BOARD_CREATE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Create Board')]";
    final static String IDEA_CREATE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Create Backlog')]";
    final static String TRELLO_IMPORT_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Import board from Trello')]";
    final static String WIDGET_ENTER_XPATH = "//input[@class='widget-title-edit js-textfield-textarea']";
    final static String WIDGET_SAVE_XPATH = "//button[@class='widget-title-save js-textfield-save']";
    final static String IDEA_HEADER_XPATH = "(//div[@class='workspace-widgetpane widgetpane-backlogs js-backlogs ui-resizable']//*[@class='widget-title-name'])[1]";
    final static String BOARD_HEADER_XPATH = "(//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']//*[@class='widget-title-name'])[1]";
    final static String IDEA_MENU_XPATH = "(//div[@class='workspace-widgetpane widgetpane-backlogs js-backlogs ui-resizable']//*[@class='widget-buttons'])[1]";
    final static String BOARD_MENU_XPATH = "(//div[@class='workspace-widgetpane widgetpane-tracking js-tracking']//*[@class='widget-buttons'])[1]";
    final static String IDEA_MENU_OPTIONS_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Options')]";
    final static String BOARD_MENU_OPTIONS_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Options')]";
    //rename
    final static String WIDGET_RENAME_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Rename')]";
    //archive
    final static String WIDGET_ARCHIVE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Archive')]";
    final static String WIDGET_UNARCHIVE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Unarchive')]";
    //removal
    final static String WIDGET_DELETE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Delete')]";
    final static String WIDGET_CONFIRM_DELETE_XPATH = "//div[@class='ui-button-red ui-button-popup-menu js-tap-indication js-widget-delete-confirmed']";
    //show archived
    final static String COLLECTION_MENU_XPATH = "//div[@class='workspace-collection-title-text']";
    final static String WIDGET_CHECKBOX_SHOWARCHIVED_XPATH="//div[@class='widget-menu-choice-text'][contains(text(),'Show Archived')]";
    //board and idea menu. sharing
    final static String WIDGET_MENU_SHARE = "//div[contains(text(),'Share')]";
    final static String WIDGET_MENU_SHARING_OPTIONS = "//div[contains(text(),'Configure public access')]";
    final static String WIDGET_MENU_SHARING_CANCEL = ".popup-window-toolbar-button.mod-cancel.js-popup-cancel";
    final static String WIDGET_MENU_SHARING_DONCE = ".popup-window-toolbar-button.mod-done.js-popup-done";
    final static String WIDGET_MENU_SHARING_SPECIFIC = "//div[contains(text(),'Off — Specific people only')]";
    final static String WIDGET_MENU_SHARING_ALL = "//div[contains(text(),'On — All members of this collection')]";
    final static String WIDGET_MENU_SHARING_INTERNET = "//div[contains(text(),'On — Everyone on the Internet')]";
    final static String WIDGET_MENU_SHARING_ENTER_USER = "//input[contains(@id,'menu-popup-avatar')]";
    final static String WIDGET_MENU_SHARING_SELECT = ".ui-dropdown-select.js-ui-dropdown.js-tap-indication.js-tap-direct.js-share-users-option";
    //board and idea menu. other
    final static String WIDGET_MENU_SUBSCRIBE = "//div[contains(text(),'Subscribe')]";
    final static String WIDGET_MENU_FULLSCREEN = "//div[contains(text(),'View in new tab')]";
    final static String WIDGET_MENU_REPORTS = "//div[contains(text(),'Reports')]";
    final static String WIDGET_MENU_ADDTOCOLLECTION = "//div[contains(text(),'Add to collection')]";
    //board and idea menu. apps & integrations
    final static String WIDGET_MENU_APPS_INTEGRATIONS = "//div[contains(text(),'App Store')]";
    final static String WIDGET_MENU_APPS_POPUP = ".popup-bg.mod-transparent.js-workspace-popup-bg";
    final static String WIDGET_MENU_APPS_VALUES = "//div[@class='expandable-title-text'][contains(text(),'Default values')]";
    final static String WIDGET_MENU_APPS_WORKFLOW = "//div[@class='expandable-title-text'][contains(text(),'Defined workflow')]";
    final static String WIDGET_MENU_APPS_LANES = "//div[@class='expandable-title-text'][contains(text(),'Lanes')]";
    final static String WIDGET_MENU_APPS_LEADTIME = "//div[@class='expandable-title-text'][contains(text(),'Lead time')]";
    final static String WIDGET_MENU_APPS_WIP = "//div[@class='expandable-title-text'][contains(text(),'WIP limit')]";
    final static String WIDGET_MENU_APPS_ENABLE = ".ui-button-green.js-app-enable";
    final static String WIDGET_MENU_APPS_DISABLE = ".ui-button-red.js-tap-indication.js-ui-button-delete";
    final static String WIDGET_MENU_APPS_DISABLE_CONFIRMATION = ".ui-button-red-confirmation.js-tap-indication.js-app-disable";
    final static String WIDGET_MENU_APPS_CLOSE = ".js-close-popup";
    final static String WIDGET_MENU_FILTER_CARDS = "//div[contains(text(),'Filter cards')]";
    final static String WIDGET_MENU_FILTER_SHOW_ARCHIVED = "//div[contains(text(),'Show archived cards')]";
    final static String WIDGET_MENU_FILTER_SHOW_ASSIGNED = "//div[contains(text(),'Show assigned to me only')]";
    final static String WIDGET_MENU_SHOW_ON_CARDS = "//div[contains(text(),'Show on cards')]";
    final static String WIDGET_MENU_SHOW_RELATIONS = "//div[contains(text(),'Relations')]";
    final static String WIDGET_MENU_SHOW_LEADTIME = "//div[contains(text(),'Lead time')]";
    //lanes
    final static String WIDGET_ADD_LANE = "(//div[contains(text(),'Add lane')])";

    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetsCreation(WebDriver driver, int number, String additionalName, WidgetState widgetState, WidgetColor widgetColor, boolean refreshBefore, boolean isLogged) throws InterruptedException {
        String name;
        String colorId;
        String colorName = "";
        int colorCode = 0;
        if (refreshBefore) driver.navigate().refresh(); //to get constant xpath links
        Thread.sleep(3000);
        for (int i = 11; i < 11 + number; i++) {
            if (widgetColor == WidgetColor.RANDOM) {
                if (i % 10 == 0) colorCode = 10;
                else colorCode = i % 10;
                colorId = Integer.toString(colorCode);
                colorName = WidgetColor.values()[colorCode].toString();
            } else if (widgetColor == WidgetColor.DEFAULT) {
                colorId = "1";
                colorName = WidgetColor.values()[colorCode].toString();
            } else {
                colorId = Integer.toString(widgetColor.ordinal());
                colorName = widgetColor.toString();
            }
            if (!additionalName.equals("")) name = Integer.toString(i - 10) + " " + colorName;
            else name = Integer.toString(i) + " " + colorName;
            //Create Idea Widget with Sequential Name 1,2,..
            driver.findElement(By.cssSelector(WIDGET_CREATE_CSS)).click();
            driver.findElement(By.xpath(IDEA_CREATE_XPATH)).click();
            Thread.sleep(1000);
            if (!additionalName.equals(""))
                driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(additionalName + name);
            else
                driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(name + " " + Run.currentBrowser + Service.nowTimeForObjectName() + "Idea " + name);
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(Keys.ENTER);
            if (isLogged) System.out.println(Service.nowTime() + " Idea " + name + " was created:");
            //Create Board Widget with Sequential Name 1,2,..
            driver.findElement(By.cssSelector(WIDGET_CREATE_CSS)).click();
            driver.findElement(By.xpath(BOARD_CREATE_XPATH)).click();
            if (!additionalName.equals(""))
                driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(additionalName + name);
            else
                driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(name + " " + Run.currentBrowser + Service.nowTimeForObjectName() + "Board " + name);
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(Keys.ENTER);
            if (isLogged) System.out.println(Service.nowTime() + " Board " + name + " was created:");
            if (widgetState == WidgetState.COLLAPSED) {
                driver.findElement(By.xpath(IDEA_HEADER_XPATH)).click();
                if (isLogged) System.out.println(Service.nowTime() + " Idea " + name + " was collapsed:");
                driver.findElement(By.xpath(BOARD_HEADER_XPATH)).click();
                if (isLogged) System.out.println(Service.nowTime() + " Board " + name + " was collapsed:");
            }
            if (isLogged)
                System.out.println(Service.nowTime() + " Color=" + WidgetColor.values()[colorCode] + " Set up for Board" + colorId);
            driver.findElement(By.xpath(BOARD_MENU_XPATH)).click();
            driver.findElement(By.xpath(BOARD_MENU_OPTIONS_XPATH)).click();
            driver.findElement(By.id(colorId)).click();
            if (isLogged) {
                System.out.println(Service.nowTime() + " Color=" + WidgetColor.values()[colorCode] + " Set up for Idea");
            }
            driver.findElement(By.xpath(IDEA_MENU_XPATH)).click();
            driver.findElement(By.xpath(IDEA_MENU_OPTIONS_XPATH)).click();
            driver.findElement(By.id(colorId)).click();
        }
    }

    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetsCurrentRename(WebDriver driver, String name, WidgetType widgetType, boolean isLogged) throws InterruptedException {
        String widgetName;
        if (widgetType == WidgetType.BOARD) {
            widgetName = driver.findElement(By.xpath(BOARD_HEADER_XPATH)).getText();
            driver.findElement(By.xpath(BOARD_MENU_XPATH)).click();
            driver.findElement(By.xpath(BOARD_MENU_OPTIONS_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_RENAME_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).clear();
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(Run.currentBrowser +
                    Service.nowTimeForObjectName() + " Board " + name);
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(Keys.ENTER);
            if (isLogged)
                System.out.println("  " + Service.nowTime() + "  Board:'" + widgetName + "' was renamed to 'Board " + name);
        } else {
            widgetName = driver.findElement(By.xpath(IDEA_HEADER_XPATH)).getText();
            driver.findElement(By.xpath(IDEA_MENU_XPATH)).click();
            driver.findElement(By.xpath(IDEA_MENU_OPTIONS_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_RENAME_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).clear();
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(Run.currentBrowser + Service.nowTimeForObjectName()
                    + "Idea " + name);
            driver.findElement(By.xpath(WIDGET_ENTER_XPATH)).sendKeys(Keys.ENTER);
            if (isLogged)
                System.out.println("  " + Service.nowTime() + "  Idea:'" + widgetName + "' was renamed to 'Idea " + name);
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetsArchive(WebDriver driver, int number, WidgetOperation widgetOperation, boolean isLogged) throws InterruptedException {
        String boardName;
        String ideaName;
        if (widgetOperation == WidgetOperation.UNARCHIVE) {
            widgetsShowArchived(driver, false);
        }
        for (int i = 1; i <= number; i++) {
            //Idea Archiving- Unarchiving
            ideaName = driver.findElement(By.xpath(IDEA_HEADER_XPATH)).getText();
            if (widgetOperation == WidgetOperation.ARCHIVE) {
                if (isLogged) System.out.println("  " + Service.nowTime() + " Idea:'" + ideaName + "' was archived");
                widgetsCurrentRename(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".ARCHIVED IDEA" + i, WidgetType.IDEA, false);
            }
            if (widgetOperation == WidgetOperation.UNARCHIVE) {
                if (isLogged) System.out.println("  " + Service.nowTime() + " Idea:'" + ideaName + "' was unarchived");
                widgetsCurrentRename(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".UNARCHIVED IDEA" + i, WidgetType.IDEA, false);
            }
            driver.findElement(By.xpath(IDEA_MENU_XPATH)).click();
            driver.findElement(By.xpath(IDEA_MENU_OPTIONS_XPATH)).click();
            Thread.sleep(500);
            if (widgetOperation == WidgetOperation.ARCHIVE){
                driver.findElement(By.xpath(WIDGET_ARCHIVE_XPATH)).click();
            }else {
                driver.findElement(By.xpath(WIDGET_UNARCHIVE_XPATH)).click();
            }
            //Board Archiving- Unarchiving
            boardName = driver.findElement(By.xpath(BOARD_HEADER_XPATH)).getText();
            if (widgetOperation == WidgetOperation.ARCHIVE) {
                if (isLogged) System.out.println("  " + Service.nowTime() + " Board:'" + boardName + "' was archived");
                widgetsCurrentRename(driver, "ARCHIVED BOARD" + i, WidgetType.BOARD, false);
            }
            if (widgetOperation == WidgetOperation.UNARCHIVE) {
                if (isLogged)
                    System.out.println("  " + Service.nowTime() + " Board:'" + boardName + "' was unarchived");
                widgetsCurrentRename(driver, "UNARCHIVED BOARD" + i, WidgetType.BOARD, false);
            }
            driver.findElement(By.xpath(BOARD_MENU_XPATH)).click();
            driver.findElement(By.xpath(BOARD_MENU_OPTIONS_XPATH)).click();
            Thread.sleep(500);
            if (widgetOperation == WidgetOperation.ARCHIVE){
                driver.findElement(By.xpath(WIDGET_ARCHIVE_XPATH)).click();
            }else {
                driver.findElement(By.xpath(WIDGET_UNARCHIVE_XPATH)).click();
            }
        }
        if (widgetOperation == WidgetOperation.UNARCHIVE) {
            widgetsShowArchived(driver, false);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetsRemoval(WebDriver driver, int number, boolean isLogged) throws InterruptedException {
        String boardName;
        String ideaName;
        for (int i = 1; i <= number; i++) {
            ideaName = driver.findElement(By.xpath(IDEA_HEADER_XPATH)).getText();
            driver.findElement(By.xpath(IDEA_MENU_XPATH)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(IDEA_MENU_OPTIONS_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_DELETE_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_CONFIRM_DELETE_XPATH)).click();
            if (isLogged) System.out.println("  " + Service.nowTime() + " Idea:'" + ideaName + "' was removed");

            boardName = driver.findElement(By.xpath(BOARD_HEADER_XPATH)).getText();
            driver.findElement(By.xpath(BOARD_MENU_XPATH)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(BOARD_MENU_OPTIONS_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_DELETE_XPATH)).click();
            driver.findElement(By.xpath(WIDGET_CONFIRM_DELETE_XPATH)).click();
            if (isLogged) System.out.println("  " + Service.nowTime() + " Board:'" + boardName + "' was removed");
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetsShowArchived(WebDriver driver, boolean isLogged) throws InterruptedException {
        driver.findElement(By.xpath(COLLECTION_MENU_XPATH)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(WIDGET_CHECKBOX_SHOWARCHIVED_XPATH)).click();
        Thread.sleep(1000);
        if (isLogged) System.out.println("  " + Service.nowTime() + " Archived Ideas are / arent shown");
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
//    Widget.widgetsCreateBigWidgets(driver, 80, 80, 4);
    public static void widgetsCreateBigWidgets(WebDriver driver, int yIdea, int yBoard, int xBoard) throws InterruptedException {
        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.RED, true, false);
        Widget.widgetsCurrentRename(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".MANY CARDS IDEA", WidgetType.IDEA, false);
        Widget.widgetsCurrentRename(driver, Run.currentBrowser + Service.nowTimeForObjectName() + ".MANY CARDS BOARD", WidgetType.BOARD, false);
        Card.cardsFirstBoardGeneration(driver, yBoard, xBoard, false);
        Card.cardsFirstIdeaGeneration(driver, yIdea, false);
        for (int j = 1; j <= yBoard; j++) {
            for (int i = 1; i <= xBoard; i++) {
                Card.cardAddManyNewTagsToCard(driver, 3, j, j, i);
                String[] users = {"zKirill", "livatekgithub4", "livatekgithub", "6", "1"};
                Card.cardAddFewPeople(driver, users, j, j, i);
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void startTrialMode(WebDriver driver){
        driver.findElement(By.xpath(BOARD_MENU_XPATH)).click();
        driver.findElement(By.xpath(WIDGET_MENU_APPS_INTEGRATIONS)).click();
        driver.findElement(By.xpath(WIDGET_MENU_APPS_VALUES)).click();
        driver.findElement(By.cssSelector(WIDGET_MENU_APPS_ENABLE)).click();
        driver.findElement(By.cssSelector(".js-trial-now")).click();
        driver.findElement(By.cssSelector(".workspacedit-billing-free-close")).click();
        driver.findElement(By.cssSelector(".popup-window-topbar-close")).click();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void enableDisableIntegrations(WebDriver driver, boolean enableYN) {
        if (enableYN) driver.findElement(By.cssSelector(WIDGET_MENU_APPS_ENABLE)).click();
        else {
            driver.findElement(By.cssSelector(WIDGET_MENU_APPS_DISABLE)).click();
            driver.findElement(By.cssSelector(WIDGET_MENU_APPS_DISABLE_CONFIRMATION)).click();
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetEnableSettings(WebDriver driver, WidgetType widgetType, WidgetSettings widgetSettings,
                                            boolean enableYesNo, boolean isLogged) throws InterruptedException {
        if (widgetType == WidgetType.BOARD) driver.findElement(By.xpath(BOARD_MENU_XPATH)).click();
        if (widgetType == WidgetType.IDEA) driver.findElement(By.xpath(IDEA_MENU_XPATH)).click();
        driver.findElement(By.xpath(WIDGET_MENU_APPS_INTEGRATIONS)).click();
//        driver.findElement(By.cssSelector(WIDGET_MENU_APPS_POPUP)).click();
        switch (widgetSettings) {
            case VALUES: {
                driver.findElement(By.xpath(WIDGET_MENU_APPS_VALUES)).click();
                enableDisableIntegrations(driver, enableYesNo);
                driver.findElement(By.xpath(WIDGET_MENU_APPS_VALUES)).click();
            }
            break;
            case WORKFLOW: {
                driver.findElement(By.xpath(WIDGET_MENU_APPS_WORKFLOW)).click();
                enableDisableIntegrations(driver, enableYesNo);
                driver.findElement(By.xpath(WIDGET_MENU_APPS_WORKFLOW)).click();
            }
            break;
            case LANES: {
                driver.findElement(By.xpath(WIDGET_MENU_APPS_LANES)).click();
                enableDisableIntegrations(driver, enableYesNo);
                driver.findElement(By.xpath(WIDGET_MENU_APPS_LANES)).click();
            }
            break;
            case LEADTIME: {
                driver.findElement(By.xpath(WIDGET_MENU_APPS_LEADTIME)).click();
                enableDisableIntegrations(driver, enableYesNo);
                driver.findElement(By.xpath(WIDGET_MENU_APPS_LEADTIME)).click();
            }
            break;
            case WIP: {
                driver.findElement(By.xpath(WIDGET_MENU_APPS_WIP)).click();
                enableDisableIntegrations(driver, enableYesNo);
                driver.findElement(By.xpath(WIDGET_MENU_APPS_WIP)).click();
            }
            break;
            default: {
            }
            break;
        }
        driver.findElement(By.cssSelector(WIDGET_MENU_APPS_CLOSE)).click();
//        driver.findElement(By.cssSelector(".popup-bg.mod-transparent.js-workspace-popup-bg")).click();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetEnableAllIntegrationsYN(WebDriver driver, boolean enableYesNo) throws InterruptedException {
        if (enableYesNo) widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.GREEN, true, false);
        if (!Users.isElementPresent(By.cssSelector(".js-trial-badge"), driver)) {
            Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.GREEN, true, false);
            Widget.startTrialMode(driver);
        }
        widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.VALUES, enableYesNo, false);
        widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.WORKFLOW, enableYesNo, false);
        widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.LANES, enableYesNo, false);
        widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.LEADTIME, enableYesNo, false);
        widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.WIP, enableYesNo, false);
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void lanesCreate(WebDriver driver, int widgetNumber, int lanesNumber, boolean isLogged) {
        String addLaneXpath;
        for (int i = 1; i < lanesNumber; i++) {
            addLaneXpath = WIDGET_ADD_LANE + "[" + Integer.toString(widgetNumber) + "]";
            driver.findElement(By.xpath(addLaneXpath)).click();
            driver.findElement(By.xpath("//textarea")).sendKeys("Lane " + Integer.toString(i + 1));
            driver.findElement(By.xpath("//textarea")).sendKeys(Keys.ENTER);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void lanesCreate(WebDriver driver, int widgetNumber, String[] listOfLanes, boolean isLogged) {
        String addLaneXpath;
        for (String laneElement : listOfLanes) {
            addLaneXpath = WIDGET_ADD_LANE + "[" + Integer.toString(widgetNumber) + "]";
            driver.findElement(By.xpath(addLaneXpath)).click();
            driver.findElement(By.xpath("//textarea")).sendKeys(laneElement);
            driver.findElement(By.xpath("//textarea")).sendKeys(Keys.ENTER);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void lanesRemove(WebDriver driver, int lanesNumber, boolean isLogged) {
        final String WIDGET_CHOOSE_LANE = "(//div[@class='card-title-text card-title-text-lanes'])";
        driver.findElement(By.xpath(WIDGET_CHOOSE_LANE + "[" + lanesNumber + "]")).click();
        Card.cardDelete(driver, false);
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void createCardsWithinLane(WebDriver driver, int boardNumberX, int lanesNumberY, int columnNumberZ, String cardName, boolean isLogged) throws InterruptedException {
        final String WIDGET_BOARD_AXIS = "(//div[@class=\"workspace-content workspace-content-tracking mod-scrollable-y\"]/div/div";
        final String WIDGET_LANE_AXIS = "//*[@class=\"widget-board-lane js-widgetlane-main\"]";
        final String WIDGET_COLUMN_AXIS = "//*[@class=\"js-paged-list-end mod-not-draggable\"])";
        String addCardXPath = "";
        addCardXPath = WIDGET_BOARD_AXIS + "[" + boardNumberX + "]" + WIDGET_LANE_AXIS + "[" + lanesNumberY + "]" + WIDGET_COLUMN_AXIS + "[" + columnNumberZ + "]";
        Thread.sleep(1000);
//        System.out.println(addCardXPath);
        driver.findElement(By.xpath(addCardXPath)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea")).sendKeys(cardName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class=\"board-title-save js-textfield-save\"]")).click();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void createLanesWithManyCards(WebDriver driver, int numberOfColumnsX, int numberOfLanesY, int numberOfCardsZ, boolean isLogged) throws InterruptedException {
        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.VIOLET, true, false);
        Widget.widgetsCurrentRename(driver, ".MANY LANES BOARD" + numberOfColumnsX + "x" + numberOfLanesY + "x" + numberOfCardsZ, WidgetType.BOARD, false);
        Widget.widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.LANES, true, false);
        if (numberOfColumnsX > 2) Column.columnsCreation(driver, numberOfColumnsX - 2, false);
        Widget.lanesCreate(driver, 1, numberOfLanesY, false);
        String cardName;
        for (int i = 1; i <= numberOfLanesY; i++) {
            for (int j = 1; j <= numberOfColumnsX; j++) {
                for (int k = 1; k <= numberOfCardsZ; k++) {
                    cardName = Integer.toString(j) + Integer.toString(i) + Integer.toString(k);
                    createCardsWithinLane(driver, 1, i, j, "Card " + cardName, false);
                }
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void moveCardFromIdeaToIdea(WebDriver driver,int ideaWidgetFrom,int ideaCardFrom, int ideaWidgetTo,int ideaCardTo,boolean isLogged){
        WebElement elementCardFrom =Card.takeIdeaCardWebElement(driver,ideaWidgetFrom,ideaCardFrom,false);
        WebElement elementCardTo = Card.takeIdeaCardWebElement(driver,ideaWidgetTo,ideaCardTo,false);
        (new Actions(driver)).dragAndDrop(elementCardFrom, elementCardTo).perform();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void moveCardFromIdeaToBoard(WebDriver driver,int ideaWidgetFrom,int ideaCardFrom, int boardWidgetTo,int boardColumnTo,int boardCardTo,boolean isLogged){
        WebElement elementCardFrom = Card.takeIdeaCardWebElement(driver,ideaWidgetFrom,ideaCardFrom,false);
        WebElement elementCardTo = Card.takeBoardCardWebElement(driver, boardWidgetTo, boardColumnTo, boardCardTo,false);
        (new Actions(driver)).dragAndDrop(elementCardFrom, elementCardTo).perform();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void moveCardFromBoardToBoard(WebDriver driver,int boardWidgetFrom,int boardColumnFrom,int boardCardFrom,
                                                int boardWidgetTo,int boardColumnTo,int boardCardTo,boolean isLogged){
        WebElement elementCardFrom = Card.takeBoardCardWebElement(driver, boardWidgetFrom, boardColumnFrom, boardCardFrom,false);
        WebElement elementCardTo = Card.takeBoardCardWebElement(driver, boardWidgetTo, boardColumnTo, boardCardTo,false);
        (new Actions(driver)).dragAndDrop(elementCardFrom, elementCardTo).perform();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void moveCardFromBoardToIdea(WebDriver driver,int boardWidgetFrom,int boardColumnFrom,int boardCardFrom,
                                               int ideaWidgetTo,int ideaCardTo,boolean isLogged){
        WebElement elementCardFrom = Card.takeBoardCardWebElement(driver, boardWidgetFrom, boardColumnFrom, boardCardFrom,false);
        WebElement elementCardTo = Card.takeIdeaCardWebElement(driver, ideaWidgetTo, ideaCardTo,false);
        (new Actions(driver)).dragAndDrop(elementCardFrom, elementCardTo).perform();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void relationsStaticTest(WebDriver driver) throws InterruptedException {
        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.GREEN, false, false);
        Widget.widgetsCurrentRename(driver, ".RELATIONS IDEA1", WidgetType.IDEA, false);
        Widget.widgetsCurrentRename(driver, ".RELATIONS BOARD1", WidgetType.BOARD, false);

        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.RED, false, false);
        Widget.widgetsCurrentRename(driver, ".RELATIONS IDEA2", WidgetType.IDEA, false);
        Widget.widgetsCurrentRename(driver, ".RELATIONS BOARD2", WidgetType.BOARD, false);
        Card.cardsFirstBoardGeneration(driver, 2, 3, false);
        Card.cardsFirstIdeaGeneration(driver, 2, false);
        Card.openIdeaCardByWebelement(driver, 1, 1);
        Card.cardAddTag(driver, "USA", false);
        Card.cardCancel(driver);
        Card.openBoardCardByWebelement(driver, 1, 1, 1);
        Card.cardAddTag(driver, "USA", false);
        Card.cardCancel(driver);

        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.DARKGREEN, false, false);
        Widget.widgetsCurrentRename(driver, ".RELATIONS IDEA3", WidgetType.IDEA, false);
        Widget.widgetsCurrentRename(driver, ".RELATIONS BOARD3", WidgetType.BOARD, false);
        Card.cardsFirstBoardGeneration(driver, 3, 3, false);
        Card.cardsFirstIdeaGeneration(driver, 3, false);
        Card.openIdeaCardByWebelement(driver, 1, 1);
        Card.cardAddTag(driver, "USA", false);
        Card.cardCancel(driver);
        Card.openBoardCardByWebelement(driver, 1, 1, 1);
        Card.cardAddTag(driver, "USA", false);
        Card.cardCancel(driver);

        Widget.moveCardFromIdeaToIdea(driver, 1, 1, 2, 1, false);
        Widget.moveCardFromIdeaToBoard(driver, 1, 1, 1, 3, 1, false);
        Widget.moveCardFromBoardToBoard(driver, 1, 3, 1, 2, 3, 1, false);
        Widget.moveCardFromIdeaToIdea(driver, 1, 1, 1, 3, false);
        Widget.moveCardFromBoardToBoard(driver, 2, 1, 1, 2, 2, 1, false);
        Widget.moveCardFromIdeaToIdea(driver, 1, 1, 3, 1, false);
        Widget.moveCardFromBoardToBoard(driver, 1, 1, 1, 3, 1, 1, false);
        Widget.moveCardFromBoardToIdea(driver, 3, 1, 1, 3, 1, false);

    }


    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void widgetEnableShowSetting(WebDriver driver, WidgetShowSettings widgetShowSettings, boolean isLogged) {

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void movingCardsFast(WebDriver driver,int numOfCards)throws InterruptedException{
        Widget.widgetsCreation(driver,1,"",WidgetState.EXPANDED,WidgetColor.YELLOW,false,false);
        Column.columnsCreation(driver, 1, false);
        Widget.widgetEnableSettings(driver, WidgetType.BOARD, WidgetSettings.WIP, true, false);
        Column.columnSetupWIPLimit(driver, 1, 1, 2*numOfCards);
        Column.columnSetupWIPLimit(driver, 1, 2, 2*numOfCards);
        Card.cardsFirstBoardGeneration(driver, numOfCards, 1, false);
        for (int i=1;i<=numOfCards;i++){
            Widget.moveCardFromBoardToBoard(driver,1,1,1,1,2,1,false);
        }
    }

}

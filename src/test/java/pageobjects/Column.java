package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tests.Run;
import utils.Service;

public class Column {
    //Add column
    final static String COULMN_ADD_XPATH = "//div[@class='workspace-content workspace-content-tracking mod-scrollable-y']/div/div[1]" +
            "//*[@class='widget-board-add js-widget-board-add-list js-tap-indication']";
    //Open column menu
    final static String COLUMN_MENU_FIRSTPART_XPATH ="(//div[@class='workspace-content workspace-content-tracking mod-scrollable-y']/div/div[1]" +
            "//*[@class='board-column-title-text'])";
    //Rename column
    final static String COLUMN_RENAME_XPATH = "//input[@class='board-column-title-edit js-textfield-textarea']";

    //--NVD2----------------------------------------------------------------------------------------------------------------------------------------------
    public static String getOpenColumnMenuXpathByNumber(int number) {
        return COLUMN_MENU_FIRSTPART_XPATH + "[" + Integer.toString(number) + "]";
    }

    //--NVD2----------------------------------------------------------------------------------------------------------------------------------------------
    public static String getRenameColumnXpathByNumber(int number) {
        return COLUMN_RENAME_XPATH;
    }

    //--NVD2----------------------------------------------------------------------------------------------------------------------------------------------
    public static void columnsCreation(WebDriver driver, int number, boolean isLogged) {
        String currentXpathForRenaming;
        int shiftedValue;
        for (int i = 1; i <= number; i++) {
            shiftedValue = i + 2;
            currentXpathForRenaming = getRenameColumnXpathByNumber(shiftedValue);
            if (isLogged) System.out.println("Log: " + COULMN_ADD_XPATH);
            driver.findElement(By.xpath(COULMN_ADD_XPATH)).click();
            if (isLogged) System.out.println("Log: " + currentXpathForRenaming);
            driver.findElement(By.xpath(currentXpathForRenaming)).sendKeys(Run.currentBrowser + Service.nowTimeForObjectName()+
                    ".Column " + shiftedValue);
            if (isLogged) System.out.println("Column" + (shiftedValue) + " created. Xpath=" + COULMN_ADD_XPATH);
            driver.findElement(By.xpath(currentXpathForRenaming)).sendKeys(Keys.ENTER);
        }
    }

    //--NVD2----------------------------------------------------------------------------------------------------------------------------------------------
    public static void columnRemove(WebDriver driver, int columnNumber, boolean isLogged) throws InterruptedException {
        final String COLUMN_MENU_REMOVE_CSS = ".widget-menu-choice.editboardcolumn-delete-text.js-boardcolumn-delete.js-tap-indication";
        driver.findElement(By.xpath(getOpenColumnMenuXpathByNumber(columnNumber))).click();
        driver.findElement(By.cssSelector(COLUMN_MENU_REMOVE_CSS)).click();
        driver.findElement(By.cssSelector(COLUMN_MENU_REMOVE_CSS)).click();
    }

    //--NVD2----------------------------------------------------------------------------------------------------------------------------------------------
    public static void columnRename(WebDriver driver, int columnNumber, String newName, boolean isLogged) {
        final String COLUMN_MENU_RENAME_CSS = ".widget-menu-choice.js-boardcolumn-rename.js-tap-indication";
        driver.findElement(By.xpath(getOpenColumnMenuXpathByNumber(columnNumber))).click();
        driver.findElement(By.cssSelector(COLUMN_MENU_RENAME_CSS)).click();
        driver.findElement(By.xpath(getRenameColumnXpathByNumber(columnNumber))).clear();
        driver.findElement(By.xpath(getRenameColumnXpathByNumber(columnNumber))).sendKeys(newName);
        driver.findElement(By.xpath(getRenameColumnXpathByNumber(columnNumber))).sendKeys(Keys.ENTER);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void columnsArchiveAll(WebDriver driver, int columnNumber, boolean isLogged) {
        final String COLUMN_MENU_ARCHIVEALL_CSS = ".widget-menu-choice.js-boardcolumn-archiveall.js-tap-indication";
        driver.findElement(By.xpath(getOpenColumnMenuXpathByNumber(columnNumber))).click();
        driver.findElement(By.cssSelector(COLUMN_MENU_ARCHIVEALL_CSS)).click();
        columnRename(driver, columnNumber, "ArchivedAll", false);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void columnSubscribe(WebDriver driver, int columnNumber, boolean isLogged) {
        final String COLUMN_MENU_SUBSCRIBE_XPATH = "//div[@class='editboardcolumn-menu']/div[1]";
        driver.findElement(By.xpath(getOpenColumnMenuXpathByNumber(columnNumber))).click();
        driver.findElement(By.xpath(COLUMN_MENU_SUBSCRIBE_XPATH)).click();
        columnRename(driver,columnNumber,"Subscribed",false);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------
    public static void columnSetupWIPLimit(WebDriver driver, int boardNumber, int columnNumber, int wiplimitNumber) throws InterruptedException {
        final String COLUMN_MENU_WIP_LIMIT="//div[@class='editboardcolumn-menu']/div[2]";
        final String COLUMN_WIP_LIMIT_FIELD="//input[@class='widget-menu-choice-input js-boardcolumn-wip-limit-input']";
        driver.findElement(By.xpath(getOpenColumnMenuXpathByNumber(columnNumber))).click();
        driver.findElement(By.xpath(COLUMN_MENU_WIP_LIMIT)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(COLUMN_WIP_LIMIT_FIELD)).clear();
        driver.findElement(By.xpath(COLUMN_WIP_LIMIT_FIELD)).sendKeys(Integer.toString(wiplimitNumber));
        driver.findElement(By.xpath(COLUMN_WIP_LIMIT_FIELD)).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        columnRename(driver, columnNumber, "Wip Limit" + columnNumber, false);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
}
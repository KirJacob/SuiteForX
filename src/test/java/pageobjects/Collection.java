package pageobjects;

import enums.CollectionColor;
import enums.CollectionSharingMode;
import enums.WidgetColor;
import enums.WidgetState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.Run;
import utils.Service;

public class Collection {


    final static String COLLECTION_BROWSER_XPATH = "(//div[@class='workspace-collection-navto js-navto-collectionsbrowser'])[1]";
    //creation
    final static String COLLECTION_ADD_CSS = ".workspace-collections-browser-topbar-button.js-create-new";
    final static String COLLECTION_ENTER_NAME_XPATH = "//input[@class='workspace-collection-edit js-textfield-textarea']";
    final static String COLLECTION_SAVE_XPATH = "//div[@class='ui-textfield-toolbar workspace-collection-edit-toolbar']/button";
    final static String COLLECTION_SHARE_XPATH = "(//div[@class='workspace-collection-bottom-toolbar-icon mod-share js-collection-share'])[1]";
    final static String COLLECTION_CONFIGURE_PUBLIC_XPATH = "//div[@class='expandable-expand']";
    final static String COLLECTION_SHARE_WITH_ORG_XPATH = "//div[@class='ui-radiobutton-label'][contains(text(),'All members')]";
    final static String COLLECTION_SHARE_WITH_EVERYONE_XPATH = "//div[@class='ui-radiobutton-label'][contains(text(),'Everyone')]";
    final static String COLLECTION_DONE_BUTTON_XPATH = "//div[@class='popup-window-toolbar-button mod-done js-popup-done']";
    final static String COLLECTION_GETNAME_XPATH = "(//div[@class='workspace-collection-title js-collection-title'])[1]";
    final static String COLLECTION_MENU_XPATH = "(//div[@class='workspace-collection-bottom-toolbar-icon mod-settings js-collection-options'])[1]";
    final static String COLLECTION_MENU_ARCHIVE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Archive')]";
    final static String COLLECTION_MENU_REMOVE_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Delete')]";
    final static String COLLECTION_MENU_REMOVE_CONFIRM_XPATH = "//div[@class='ui-button-red ui-button-popup-menu js-tap-indication js-collection-delete-confirmed'][contains(text(),'Confirm')]";
    final static String COLLECTION_MENU_RENAME_XPATH = "//div[@class='widget-menu-choice-text'][contains(text(),'Rename')]";
    final static String COLLECTION_STAR="(//div[@class='workspace-collection-bottom-toolbar-icon mod-star js-collection-star'])[1]";

    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void checkIfCollectionBrowserOpened(WebDriver driver){
        if (!driver.findElement(By.cssSelector(COLLECTION_ADD_CSS)).isDisplayed()) {
            driver.findElement(By.xpath(COLLECTION_BROWSER_XPATH)).click();
        }
    }
    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void collectionCreation(WebDriver driver, int number, CollectionSharingMode pageSharingMode, boolean isLogged) throws InterruptedException {
        String name;
        String nameTemplate;
        checkIfCollectionBrowserOpened(driver);
        if (pageSharingMode == CollectionSharingMode.PUBLIC) nameTemplate = Run.currentBrowser +
                Service.nowTimeForObjectName() + ".Collection.Public";
        else if (pageSharingMode == CollectionSharingMode.EVERYONE) nameTemplate = Run.currentBrowser +
                Service.nowTimeForObjectName() + ".Collection.EveryOne";
        else nameTemplate = Run.currentBrowser +
                    Service.nowTimeForObjectName() + "Collection.Private";
        for (int i = 1; i <= number; i++) {
            name = nameTemplate + " " + Integer.toString(i);
            driver.findElement(By.cssSelector(COLLECTION_ADD_CSS)).click();
            if (isLogged) System.out.println(Service.nowTime() + " "+name + " was created:");
//            Thread.sleep(2000);
            driver.findElement(By.xpath(COLLECTION_ENTER_NAME_XPATH)).clear();
            driver.findElement(By.xpath(COLLECTION_ENTER_NAME_XPATH)).sendKeys(name);
            driver.findElement(By.xpath(COLLECTION_SAVE_XPATH)).click();
            if (pageSharingMode == CollectionSharingMode.PUBLIC) {
                driver.findElement(By.xpath(COLLECTION_SHARE_XPATH)).click();
                driver.findElement(By.xpath(COLLECTION_CONFIGURE_PUBLIC_XPATH)).click();
                driver.findElement(By.xpath(COLLECTION_SHARE_WITH_ORG_XPATH)).click();
                driver.findElement(By.xpath(COLLECTION_DONE_BUTTON_XPATH)).click();
                collectionSetColor(driver, CollectionColor.GREEN);
            }else if (pageSharingMode == CollectionSharingMode.EVERYONE) {
                driver.findElement(By.xpath(COLLECTION_SHARE_XPATH)).click();
                driver.findElement(By.xpath(COLLECTION_CONFIGURE_PUBLIC_XPATH)).click();
                driver.findElement(By.xpath(COLLECTION_SHARE_WITH_EVERYONE_XPATH)).click();
                driver.findElement(By.xpath(COLLECTION_DONE_BUTTON_XPATH)).click();
                collectionSetColor(driver, CollectionColor.MAGENTA);
            }else {
                if (i%2==0) Collection.collectionSetColor(driver, CollectionColor.RED);
                else Collection.collectionSetColor(driver, CollectionColor.VIOLET);
            }
        }
    }

    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void collectionRemoving(WebDriver driver, int number, boolean isLogged) throws InterruptedException {
        String name;
        checkIfCollectionBrowserOpened(driver);
        for (int i = 1; i <= number; i++) {
            name = driver.findElement(By.xpath(COLLECTION_GETNAME_XPATH)).getText();
//            Thread.sleep(500);
            driver.findElement(By.xpath(COLLECTION_MENU_XPATH)).click();
            driver.findElement(By.xpath(COLLECTION_MENU_REMOVE_XPATH)).click();
            driver.findElement(By.xpath(COLLECTION_MENU_REMOVE_CONFIRM_XPATH)).click();
            if (isLogged) System.out.println(Service.nowTime() + " Collection " + name + " was removed:");
        }
    }

    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void collectionArchiving(WebDriver driver, int number, boolean isLogged) throws InterruptedException {
        String name;
        checkIfCollectionBrowserOpened(driver);
        for (int i = 1; i <= number; i++) {
            name = Run.currentBrowser + Service.nowTimeForObjectName() + ".CollectionArch" + Integer.toString(i);
            driver.findElement(By.cssSelector(COLLECTION_ADD_CSS)).click();
            if (isLogged) System.out.println(Service.nowTime() + " CollectionArch " + i + " was created:");
            driver.findElement(By.xpath(COLLECTION_ENTER_NAME_XPATH)).clear();
            driver.findElement(By.xpath(COLLECTION_ENTER_NAME_XPATH)).sendKeys(name);
//            Thread.sleep(2000);
            driver.findElement(By.xpath(COLLECTION_SAVE_XPATH)).click();
            collectionSetColor(driver, CollectionColor.YELLOW);
            driver.findElement(By.xpath(COLLECTION_MENU_XPATH)).click();
            driver.findElement(By.xpath(COLLECTION_MENU_ARCHIVE_XPATH)).click();
        }
    }
    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void removeAllCollection(WebDriver driver) throws InterruptedException {
        checkIfCollectionBrowserOpened(driver);
        try{
            while(true){
                Collection.collectionRemoving(driver,1,false);
            }
        }catch (Exception e){
            System.out.println(Service.nowTime()+" All collections were removed");
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void collectionRenameCurrent(WebDriver driver, String name) {
        checkIfCollectionBrowserOpened(driver);
        driver.findElement(By.xpath(COLLECTION_MENU_XPATH)).click();
        driver.findElement(By.xpath(COLLECTION_MENU_RENAME_XPATH)).click();
        driver.findElement(By.xpath(COLLECTION_ENTER_NAME_XPATH)).clear();
        driver.findElement(By.xpath(COLLECTION_ENTER_NAME_XPATH)).sendKeys(name);
        driver.findElement(By.xpath(COLLECTION_SAVE_XPATH)).click();
    }

    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void collectionSetColor(WebDriver driver, CollectionColor collectionColor){
        String collectionColorCode;
        String colorCollectionXPath;
        if (collectionColor==CollectionColor.VIOLET){
            colorCollectionXPath="//div[@class='collection-bg collection-bg-selector-1 js-page-bg mod-selected']";
        }else {
            collectionColorCode=Integer.toString(collectionColor.ordinal()+1);
            colorCollectionXPath="//div[@class='collection-bg collection-bg-selector-"+(collectionColorCode)+" js-page-bg']";
        }
        checkIfCollectionBrowserOpened(driver);
        driver.findElement(By.xpath(COLLECTION_MENU_XPATH)).click();
        driver.findElement(By.xpath(colorCollectionXPath)).click();
    }
    //--NVD2-----------------------------------------------------------------------------------------------------------------------------------------------
    public static void showHideArchivedCollection(WebDriver driver){
        checkIfCollectionBrowserOpened(driver);
        driver.findElement(By.xpath("//img[@class='workspace-button-dropdown']")).click();
        driver.findElement(By.xpath("//div[@class='widget-menu-choice-text'][contains(text(),'Show archived Collections')]")).click();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void starCollection(WebDriver driver){
        checkIfCollectionBrowserOpened(driver);
        driver.findElement(By.xpath(COLLECTION_STAR)).click();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void openFirstCollection(WebDriver driver){
        driver.findElement(By.xpath("//div[@class='workspace-collection js-browser-collection']")).click();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void collectionCreateManyWithWidgets(WebDriver driver, int numberOfCollections, int numberOfWidgets) throws InterruptedException {
        for (int i = 1; i <= numberOfCollections; i++) {
            Collection.collectionCreation(driver, 1, CollectionSharingMode.PUBLIC, false);
            Widget.widgetsCreation(driver, numberOfWidgets, Integer.toString(i), WidgetState.EXPANDED, WidgetColor.RANDOM, true, false);
        }
    }
}

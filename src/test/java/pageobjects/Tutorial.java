package pageobjects;

import enums.CollectionSharingMode;
import enums.WidgetColor;
import enums.WidgetState;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Service;




public class Tutorial {
    final static String TUTORIAL_RUN_XPATH = "//div[@class='app-menu-choice-title'][contains(text(),\"Run Tutorial\")]";
    public static void runTutorial(WebDriver driver, boolean isLogged) throws InterruptedException {
        Users.openMainMenu(driver);
        driver.findElement(By.xpath(TUTORIAL_RUN_XPATH)).click();
        System.out.println(Service.nowTime() + " Starting tutorial");
        System.out.println(Service.nowTime() + " *** Tutorial.Step1. Create a Collection");
//        Service.waitFor(driver, By.xpath("//div[@class='xaddbutton-icon tutorial-hilight-pulse']"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='xaddbutton-icon tutorial-hilight-pulse']")).click();
        driver.findElement(By.xpath("//input[@id='menu-popup-input-name']")).clear();
        System.out.println(Service.nowTime() + " *** Tutorial.Step2. Name your Collection");
        driver.findElement(By.xpath("//input[@id='menu-popup-input-name']")).sendKeys("Tutorial Collection");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='popup-window-toolbar-button mod-done js-popup-done']")).click();
        System.out.println(Service.nowTime() + " *** Tutorial.Step3. Create an Idea List");
        Service.waitFor(driver, By.cssSelector(".xaddbutton-icon.tutorial-hilight-pulse"));
        driver.findElement(By.cssSelector(".xaddbutton-icon.tutorial-hilight-pulse")).click();
        Thread.sleep(1000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step4. Name the Idea List");
        driver.findElement(By.xpath("//input[@class='widget-title-edit js-textfield-textarea']")).sendKeys("Tutorial Idea");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='widget-title-save js-textfield-save']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step5. Add at least three cards");
        // This crazy code is here because xpath are changing, after running first tutorial
        String addCardxPath;
        String addCardsTutorialsXpath="(//div[@class='board-column-addcard js-board-column-add js-nav-to js-create-item js-tap-indication js-tap-direct'])";
        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                addCardxPath = "//div[@class='board-column-addcard js-board-column-add js-nav-to" +
                        " js-create-item js-tap-indication js-tap-direct tutorial-hilight-pulse']";
            } else {
                addCardxPath = addCardsTutorialsXpath+"[2]";
                WebElement elementKey = driver.findElement(By.xpath(addCardxPath));
                System.out.println("[2]"+elementKey.isDisplayed());
                if (!elementKey.isDisplayed()) {
                    addCardxPath = addCardsTutorialsXpath+"[1]";
                    elementKey = driver.findElement(By.xpath(addCardxPath));
                    System.out.println("[1]"+elementKey.isDisplayed());
                    if (!elementKey.isDisplayed()) {
                        addCardxPath = addCardsTutorialsXpath+"[4]";
                        elementKey = driver.findElement(By.xpath(addCardxPath));
                        System.out.println("[4]"+elementKey.isDisplayed());
                    }
                }
            }
            Thread.sleep(2000);
            System.out.println(Service.nowTime()+"*** "+addCardxPath);
            driver.findElement(By.xpath(addCardxPath)).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@class='boarditem-card-edit js-textfield-textarea']")).sendKeys("Tutorial Card " + i);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@class='board-title-save js-textfield-save']")).click();
        }
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step6. Edit you card details");
        driver.findElement(By.xpath("//div[@class='card-as-board-card js-nav-to card js-boarditem'][last()]")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step7. Editing a Card");
        driver.findElement(By.xpath("//div[@class='ui-button-black cardpopup-sidebar-button js-tap-indication js-add-users tutorial-hilight-pulse']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step8. Editing a Card");
        driver.findElement(By.xpath("//input[@id='js-add-user-autocomplete']")).click();
        driver.findElement(By.xpath("//input[@id='js-add-user-autocomplete']")).sendKeys("use");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='js-add-user-autocomplete']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step9. Finish Editing a Card");
        driver.findElement(By.xpath("//div[@class='cardpopup-close js-close-cardpopup js-tap-indication tutorial-hilight-pulse']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step10. Create a Board");
        driver.findElement(By.xpath("//div[@class='xaddbutton-icon tutorial-hilight-pulse']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step11. Name Your Board");
        driver.findElement(By.xpath("//div[@class='ui-textfield-input tutorial-hilight-pulse']/input")).sendKeys("Tutorial Board");
        driver.findElement(By.xpath("//div[@class='ui-textfield-input tutorial-hilight-pulse']/input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step12. Start Working on an Idea"); //Write a method for moving cards
        // This crazy code is here because xpath are changing, after running first tutorial
        String boardTo="(//div[@class='widget-board-content']//*[@class='board-column-addcard js-board-column-add js-nav-to js-create-item js-tap-indication js-tap-direct'])";
        String cardBoardTo=boardTo+"[1]";
        WebElement elementCardIdeaFrom = driver.findElement(By.xpath("//div[@class='card-as-board-card js-nav-to card js-boarditem ui-sortable-handle tutorial-hilight-pulse']/div[1]"));
        WebElement elementCardBoardTo = driver.findElement(By.xpath(cardBoardTo));
        if (!elementCardBoardTo.isDisplayed()){
            cardBoardTo=boardTo+"[3]";
            elementCardBoardTo=driver.findElement(By.xpath(cardBoardTo));
        }
        (new Actions(driver)).dragAndDrop(elementCardIdeaFrom, elementCardBoardTo).perform();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step13. This card is now being tracked"); // Press Got it
        driver.findElement(By.xpath("//div[@class='xsolidbutton mod-blue js-gotit']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step14. Update the card status"); //Move card to Done column
        // This crazy code is here because xpath are changing, after running first tutorial
        WebElement elementCardBoardFrom2;
        WebElement elementCardBoardTo2;
        if (driver.findElement(By.xpath("(//div[@class='widget-board-content'])[1]/div/div[1]/div[2]/div[1]")).isDisplayed()){
            elementCardBoardFrom2=driver.findElement(By.xpath("(//div[@class='widget-board-content'])[1]/div/div[1]/div[2]/div[1]"));
        }else {
            elementCardBoardFrom2=driver.findElement(By.xpath("(//div[@class='widget-board-content'])[2]/div/div[1]/div[2]/div[1]"));
        }
        if (driver.findElement(By.xpath("(//div[@class='widget-board-content'])[1]/div/div[2]/div[2]/div")).isDisplayed()){
            elementCardBoardTo2=driver.findElement(By.xpath("(//div[@class='widget-board-content'])[1]/div/div[2]/div[2]/div"));
        }else {
            elementCardBoardTo2=driver.findElement(By.xpath("(//div[@class='widget-board-content'])[2]/div/div[2]/div[2]/div"));
        }
        (new Actions(driver)).dragAndDrop(elementCardBoardFrom2, elementCardBoardTo2).perform();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step15. Tracking Progress"); //Got it
        driver.findElement(By.xpath("//div[@class='xsolidbutton mod-blue js-gotit']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step16. Searching"); //Press Search icon
        driver.findElement(By.xpath("//div[@class='img workspacelink-icon workspacelink-searchicon js-workspace-search tutorial-hilight-pulse']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step17. Search for a card"); // Enter search query
        driver.findElement(By.xpath("//input[@class='search-edit search-edit-searchicon']")).click();
        driver.findElement(By.xpath("//input[@class='search-edit search-edit-searchicon']")).sendKeys("card");
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step18. Searching"); // Dismiss
        driver.findElement(By.xpath("//input[@class='search-edit']")).sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step19. To do list"); // Press To do icon
        driver.findElement(By.xpath("//div[@class='img workspacelink-icon workspacelink-todoicon js-workspace-todolist tutorial-hilight-pulse']")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step20. Working with To do list"); // Got it
        driver.findElement(By.xpath("//div[@class='tutorial-layout']/div[3]")).click();
        Thread.sleep(2000);
        System.out.println(Service.nowTime() + " *** Tutorial.Step21. The end"); // The end
        driver.findElement(By.xpath("//div[@class='xsolidbutton mod-blue js-gotit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='img workspacelink-icon workspacelink-todoicon js-workspace-todolist mod-animate-hover-on']")).click();
    }
}

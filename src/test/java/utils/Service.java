package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Service {
    public long timeStart;
    public long timeFinish;

    public void startCount() {
        timeStart = System.currentTimeMillis();
    }

    public void stopCount() {
        timeFinish = System.currentTimeMillis();
    }

    public double getTimeDurationInMinutes() {
        return (1.00) * ((timeFinish - timeStart) / 60000);
    }
    public double getTimeDurationInSeconds() {
        return (1.00) * ((timeFinish - timeStart) / 1000);
    }

    public static void waitFor(WebDriver driver, By elementBy){
        new WebDriverWait(driver, 120).
                until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static String nowTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static String nowTimeForFileName() {
        String dateCurrent = nowTime();
        dateCurrent = dateCurrent.replace("/", "");
        dateCurrent = dateCurrent.replace(':', '.');
        dateCurrent = dateCurrent.replace(" ", "_");
        return dateCurrent;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static String nowTimeForObjectName() {
        String monthDateAndHour = nowTimeForFileName();
        monthDateAndHour=monthDateAndHour.substring(4, 14);
        return monthDateAndHour;
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static String nowTimeForOrgName() {
        String monthAndDate = nowTimeForObjectName();
        monthAndDate=monthAndDate.substring(0, 4);
        return monthAndDate;
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static String hourForOrg() {
        String hour = nowTimeForObjectName();
        hour=hour.substring(5, 7);
        return hour;
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        System.out.println("*** Save Screenshot ***");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(AccessData.SCREENSHOTS_PATH + fileName));
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

package setup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Tutorial;
import pageobjects.Users;
import utils.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class FirefoxLongTest {
    private WebDriver driver;
    private final String browser="FIREFOX.ln";
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {
        Users.loginUser(driver,AccessData.TESTURL,AccessData.TESTLOGIN_LONGTESTS,AccessData.TESTPASSWORD_LONGTESTS,"Firefox");
        tests.Run.RunLong(driver, browser);
        Thread.sleep(3000);
        Tutorial.runTutorial(driver, false);
        Thread.sleep(3000);
//        General.userSignOut(driver);
    }

    @After
    public void tearDown() throws Exception {
        Service.takeScreenshot(driver,Service.nowTimeForFileName()+" "+browser+".screenshot.png");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}


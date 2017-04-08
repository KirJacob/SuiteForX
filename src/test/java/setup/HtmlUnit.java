package setup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.Users;
import utils.AccessData;
import utils.Service;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class HtmlUnit {
    private WebDriver driver;
    private final String browser="HTML-UNIT";
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
//        driver = new HtmlUnitDriver();
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {
//        Users.loginUser(driver);
        tests.Run.RunShort(driver, browser);
        Thread.sleep(3000);
//        General.userSignOut(driver);
    }

    @After
    public void tearDown() throws Exception {
        Service.takeScreenshot(driver, Service.nowTimeForFileName() + " " + browser + ".screenshot.png");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
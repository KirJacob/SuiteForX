package setup; /**
 * Created by kyak on 03.08.2015.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Tutorial;
import pageobjects.Users;
import utils.AccessData;
import utils.Service;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ChromeLongTest {
    private WebDriver driver;
    private final String browser = "CHROME.ln.";
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", AccessData.CHROME_DRIVER__PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//20
    }

    @Test
    public void testLogin() throws Exception {
        Users.loginUser(driver, AccessData.TESTURL, AccessData.TESTLOGIN_LONGTESTS, AccessData.TESTPASSWORD_LONGTESTS,"Chrome");
//        Users.makeCurrentOrgStandard(driver);
//        Users.createNewOrganization(driver,"000 000 - zAutoTests_"+Service.nowTimeForObjectName()+"_User1(LongRun)");
        driver.get(AccessData.TESTURLX);
        Thread.sleep(5000);
        tests.Run.RunLong(driver, browser);
        Thread.sleep(3000);
        Tutorial.runTutorial(driver, false);
        Thread.sleep(3000);
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

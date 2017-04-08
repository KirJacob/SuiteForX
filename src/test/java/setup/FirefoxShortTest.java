package setup;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Tutorial;
import pageobjects.Users;
import utils.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class FirefoxShortTest {
    private static WebDriver driver;
    private static final String browser="FIREFOX.sh";
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void settingUp()throws Exception{
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//20
        Users.loginUser(driver, AccessData.TESTURL, AccessData.TESTLOGIN_SHORTTESTS, AccessData.TESTPASSWORD_SHORTTESTS,"Firefox");
    }

    @Before
    public void setUp() throws Exception {
        driver.get(AccessData.TESTURLX);
        Thread.sleep(5000);
    }

    @Test
    public void testMain() throws Exception {
        tests.Run.RunShort(driver, browser);
    }

//    @Test
//    public void testTutorial() throws Exception {
//        Tutorial.runTutorial(driver, false);
//    }

    @AfterClass
    public static void tearDown() throws Exception {
        Service.takeScreenshot(driver,Service.nowTimeForFileName()+" "+browser+".screenshot.png");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}


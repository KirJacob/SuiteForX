package setup; /**
 * Created by kyak on 03.08.2015.
 */

import enums.CollectionSharingMode;
import enums.WidgetColor;
import enums.WidgetOperation;
import enums.WidgetState;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.Collection;
import pageobjects.Tutorial;
import pageobjects.Users;
import pageobjects.Widget;
import utils.AccessData;
import utils.Service;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ChromeShortTest {
    private static WebDriver driver;
    private static final String browser = "CHROME.sh.";
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void settingUp()throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", AccessData.CHROME_DRIVER__PATH + "chromedriver.exe");
        driver = new ChromeDriver(options);
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);//20
        Users.loginUser(driver, AccessData.TESTURL, AccessData.TESTLOGIN_SHORTTESTS, AccessData.TESTPASSWORD_SHORTTESTS,"Chrome");
//        if (Service.hourForOrg().equals("21"))
//            Users.createNewOrganization(driver, "000 000 - zAutoTests_" + Service.nowTimeForObjectName() + "_User13(ShortRun)");
    }

    @Before
    public void setUp() throws Exception {
//        driver.get(AccessData.TESTURLX);
//        Thread.sleep(5000);
    }

    @Test
    public void testMain() throws Exception {
        tests.Run.RunShort(driver, browser);
    }

//    @Test
//    public void testTutorial() throws Exception {
//        Tutorial.runTutorial(driver, false);
//        Thread.sleep(2000);
//    }
//    @Test
//    public void testTutorial2() throws Exception {
//        Tutorial.runTutorial(driver, false);
//        Thread.sleep(2000);
//    }
//    @Test
//    public void testTutorial3() throws Exception {
//        Tutorial.runTutorial(driver, false);
//        Thread.sleep(2000);
//    }
//    @Test
//    public void testTutorial4() throws Exception {
//        Tutorial.runTutorial(driver, false);
//        Thread.sleep(2000);
//    }

    @AfterClass
    public static void tearDown() throws Exception {
        Service.takeScreenshot(driver, Service.nowTimeForFileName() + " " + browser + ".screenshot.png");

        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}



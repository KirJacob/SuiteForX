package setup;

import enums.TestData;
import enums.UserOrgRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Users;
import utils.AccessData;
import utils.Service;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class JUnitChrome {

    private static WebDriver driver;
    private final String browser = "CHROME.sh.";
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", AccessData.CHROME_DRIVER__PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//20
        Users.loginUser(driver, AccessData.TESTURL, AccessData.TESTLOGIN_SHORTTESTS, AccessData.TESTPASSWORD_SHORTTESTS,"Chrome");
//        driver.get(AccessData.TESTURLX);
        Thread.sleep(5000);
    }
    @Before
    public void settingUp() throws Exception {

    }
    @Test
    public void stage_1_removeAllUsersFromOrg() throws Exception {
        System.out.println("stage_1_removeAllUsersFromOrg");
        System.out.println(Service.nowTime() + " : 1. Users Block");
        System.out.println(Service.nowTime() + " : 1a. Remove All users and Add Four Users to Organization(R+4)");
        Users.usersRemoveAllFromOrganization(driver, false);
    }
    @Test
    public void stage_2_addUsersToOrg() throws Exception {
        System.out.println("stage_2_addUsersToOrg");
        Users.usersAddToOrganization(driver, 5, TestData.testUsersForShortRun, false);
    }
    @Test
    public void stage_3_removeParticularUserFromOrg() throws Exception {
        System.out.println("stage_3_removeParticularUserFromOrg");
        System.out.println(Service.nowTime() + " : 1b. Delete chosen User");
        Users.usersOpenMembersList(driver);
        Users.usersParticularUserRemoval(driver, TestData.testUsersForShortRun[0]);
    }
    @Test
    public void stage_4_setParticularUserPermission() throws Exception {
        System.out.println("stage_4_setParticularUserPermission");
        System.out.println(Service.nowTime() + " : 1c. Change Users Permissions to Administrator/Full Member and Restricted");
        Users.usersSetupPermission(driver, TestData.testUsersForShortRun[2], UserOrgRoles.FULL_MEMBER);
        Users.usersSetupPermission(driver, TestData.testUsersForShortRun[3], UserOrgRoles.ADMINISTRATOR);
        Users.closeEditOrganizationMenu(driver);
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

package setup;

import enums.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Collection;
import pageobjects.Tutorial;
import pageobjects.Users;
import pageobjects.Widget;
import utils.AccessData;
import utils.Service;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ChromeCombinedTest {

    private static WebDriver driver;
    private static final String browser = "CHROME.sh.";
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void settingUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", AccessData.CHROME_DRIVER__PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = AccessData.TESTURL;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//20
        Users.loginUser(driver, AccessData.TESTURL, AccessData.TESTLOGIN_SHORTTESTS, AccessData.TESTPASSWORD_SHORTTESTS,"Chrome");
        if (Service.hourForOrg().equals("21"))
            Users.createNewOrganization(driver, "000 000 - zAutoTests_" + Service.nowTimeForObjectName() + "_User13(ShortRun)");
    }

    @Before
    public void setUp() throws Exception {
        driver.get(AccessData.TESTURLX);
        Thread.sleep(5000);
    }

    @Test
    public void testTutorial() throws Exception {
        System.out.println("*** TestTutoriaal ***");
        Tutorial.runTutorial(driver, false);
        Thread.sleep(2000);
    }

    @Test
    public static void testUsers()throws Exception{
        System.out.println("*** TestUsers ***");
        System.out.println(Service.nowTime() + " : 1. Users Block");
        System.out.println(Service.nowTime() + " : 1a. Remove All users and Add Four Users to Organization(R+4)");
        Users.usersRemoveAllFromOrganization(driver, false);
        Users.usersAddToOrganization(driver, 5, TestData.testUsersForShortRun, false);
        System.out.println(Service.nowTime() + " : 1b. Delete chosen User");
        Users.usersOpenMembersList(driver);
        Users.usersParticularUserRemoval(driver, TestData.testUsersForShortRun[0]);
        System.out.println(Service.nowTime() + " : 1c. Change Users Permissions to Administrator/Full Member and Restricted");
        Users.usersSetupPermission(driver, TestData.testUsersForShortRun[2], UserOrgRoles.FULL_MEMBER);
        Users.usersSetupPermission(driver, TestData.testUsersForShortRun[3], UserOrgRoles.ADMINISTRATOR);
        Users.closeEditOrganizationMenu(driver);
    }
    @Test
    public void testCollections() throws Exception {
        System.out.println("*** TestCollections ***");
        System.out.println(Service.nowTime() + " : 2. Collections Creation(2)");
        Collection.collectionCreation(driver, 1, CollectionSharingMode.PRIVATE, false);
        Collection.collectionCreation(driver, 1, CollectionSharingMode.PUBLIC, false);
        Collection.collectionCreation(driver, 1, CollectionSharingMode.EVERYONE, false);

        System.out.println(Service.nowTime() + " : 3. Collections Archiving(2)");
        Collection.collectionArchiving(driver, 2, false);

        System.out.println(Service.nowTime() + " : 4. Collections Removing(2)");
        Collection.collectionCreation(driver, 1, CollectionSharingMode.PUBLIC, false);
        Collection.collectionCreation(driver, 1, CollectionSharingMode.PRIVATE, false);
        Collection.collectionRemoving(driver, 2, false);
    }

    @Test
    public void testWidgets() throws Exception {
        System.out.println("*** TestWidgets ***");
        System.out.println(Service.nowTime() + " : 5. Collections Renaming(1)");
        System.out.println(Service.nowTime() + " : 6a. Widgets Collapsed Creation(5)/Removal(1)/Archive(2)/Unarchive(1). Fixed Color ");
        Collection.collectionCreation(driver, 1, CollectionSharingMode.PUBLIC, false);
        Collection.collectionRenameCurrent(driver, browser + Service.nowTimeForObjectName() + ".MANY WIDGETS COLLECTION");
        Widget.widgetsCreation(driver, 4, "", WidgetState.COLLAPSED, WidgetColor.GREEN, true, false);
        Widget.widgetsRemoval(driver, 1, false);
        Widget.widgetsArchive(driver, 2, WidgetOperation.ARCHIVE, false);
        Widget.widgetsArchive(driver, 1, WidgetOperation.UNARCHIVE, false);
    }

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


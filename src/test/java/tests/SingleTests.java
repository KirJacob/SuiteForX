package tests;

/**
 * Created by kyak on 27.04.2016.
 */
public class SingleTests {

//        SINGLE TESTS
// --------------------------------------------------------------------
//        1. Create Many Collections with Many Widgets

//        Collection.collectionCreateManyWithWidgets(driver,7,10);
//        int allAttempts=0;
//        int successAttempts=0;
//        int failedAttemptsmpts=0;
//        for (int i=1;i<=10;i++){
//            allAttempts++;
//            try{
//                driver.navigate().refresh();
//                Tutorial.runTutorial(driver, false);
//                System.out.println(i + " - Attempt succesful");
//                System.out.println("****************************************");
//                driver.navigate().refresh();
//                successAttempts++;
//            }catch (Exception e) {
//                System.out.println(i+" - Attempt failed");
//                e.printStackTrace();
//                failedAttemptsmpts++;
//            }
//        }
//        System.out.println("Summary"+allAttempts);
//        System.out.println("SuccessAttempts"+successAttempts);
//        System.out.println("FailedAttempts"+failedAttemptsmpts);
// --------------------------------------------------------------------
//        2. Create Many cards with many tags

//        System.out.println(Service.nowTime() + " : 8c.  Create Widget with Constant tags and Users");
//        Widget.widgetsCreation(driver, 1, "", WidgetState.EXPANDED, WidgetColor.DARKGREEN, true, false);
//        Card.cardsFirstBoardGeneration(driver, 1500, 3, false);
//        String[] tags1 = {"FIN", "UK", "USA", "GER", "POL", "SPA", "ITA", "FRA", "SWE", "UKR", "HUN"};
//        Card.cardAddRandomTagsToBoard(driver, tags1, 12, 1500, 3);
// --------------------------------------------------------------------
//        3. Create Many Collections

//        Users.usersAddToOrganization(driver, 5, TestData.testUsersForShortRun, false);
//        Collection.removeAllCollection(driver);
//        System.out.println(Service.nowTime() + " : 2. Collections Creation(2)");
////        Collection.collectionCreation(driver, 100, CollectionSharingMode.PRIVATE, false);
////        Collection.starCollection(driver);
//        Collection.collectionCreation(driver, 200, CollectionSharingMode.PUBLIC, false);
//        Collection.starCollection(driver);
////        Collection.collectionCreation(driver, 100, CollectionSharingMode.EVERYONE, false);
////        Collection.starCollection(driver);
//
////        System.out.println(Service.nowTime() + " : 3. Collections Archiving(2)");
//        Collection.collectionArchiving(driver, 100, false);
////
//        // STOPSTATEMENT
//        boolean x = true;
//        if (x) return;

}

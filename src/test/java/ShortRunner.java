import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import setup.ChromeShortTest;
import setup.FirefoxShortTest;
import setup.IEShortTest;

public class ShortRunner {
    public static void main(String[] args) {
        Result result= JUnitCore.runClasses(FirefoxShortTest.class, ChromeShortTest.class, IEShortTest.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Overall Tests Result = "+result.wasSuccessful());
    }

}

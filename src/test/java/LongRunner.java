import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import setup.*;

public class LongRunner {
    public static void main(String[] args) {
        Result result= JUnitCore.runClasses(FirefoxLongTest.class, ChromeLongTest.class, IELongTest.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Overall Tests Result = "+result.wasSuccessful());
    }

}

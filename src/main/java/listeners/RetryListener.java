package listeners;

import global.GlobalData;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    private int retryAttempt = 1;

    public boolean retry(ITestResult result) {
        if (retryAttempt <= GlobalData.RETRY_COUNT) {
            System.out.println(System.lineSeparator() + "------- Retrying TestCase = " + result.getName()
                    + " -------" + System.lineSeparator());
            retryAttempt++;
            return true;
        }
        return false;
    }
}

package listeners;

import driver.DriverManager;
import global.GlobalData;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvocationListener implements IInvokedMethodListener {

    @Override
    public synchronized void beforeInvocation(IInvokedMethod method, ITestResult result) {
        if (method.isTestMethod()) {
            WebDriver driver = GlobalData.DRIVER_QUEUE.poll();
            DriverManager.setDriver(driver);
        }
    }

    @Override
    public synchronized void afterInvocation(IInvokedMethod method, ITestResult result) {
        if (method.isTestMethod()) {
                GlobalData.DRIVER_QUEUE.add(DriverManager.getDriver());
        }
    }
}

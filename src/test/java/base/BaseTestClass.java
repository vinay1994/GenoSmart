package base;

import generic.GenericFunctions;
import listeners.AnnotationTransformer;
import listeners.InvocationListener;
import listeners.TestNGReportListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({TestNGReportListener.class, InvocationListener.class})
public class BaseTestClass {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("================= Inside Before Suite =================");
        GenericFunctions.initDirectories();
        GenericFunctions.initExtentReports();
        GenericFunctions.startDrivers();
        GenericFunctions.addExecutionDetailsExtentReport();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("================= Inside After Suite =================");
        GenericFunctions.quitDrivers();
    }
}

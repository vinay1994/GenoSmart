package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import global.GlobalData;

public class ExtentManager {
    private static ExtentReports extent = null;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private ExtentManager() {
    }

    public synchronized static ExtentTest getTest() {
        return test.get();
    }

    public synchronized static void setTest(ExtentTest test) {
        ExtentManager.test.set(test);
    }

    public synchronized static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(GlobalData.OUTPUT_FOLDER_REPORT + GlobalData.FILE_NAME_REPORT);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setReportName(GlobalData.EXTENT_REPORT_REPORT_NAME);
        htmlReporter.config().setDocumentTitle(GlobalData.EXTENT_REPORT_DOCUMENT_TITLE);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding(GlobalData.REPORT_ENCODING);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    public synchronized static void flush() {
        extent.flush();
    }

    public synchronized static void addSystemInfo(String key, String value) {
        extent.setSystemInfo(key, value);
        flush();
    }

    public synchronized static void setTestRunnerOutput(String log) {
        extent.setTestRunnerOutput(log);
    }

    public synchronized static void createTest(String testName, String description) {
        setTest(extent.createTest(testName, description));
    }

    public synchronized static void deleteCurrentTest() {
        extent.removeTest(ExtentManager.getTest());
    }

}

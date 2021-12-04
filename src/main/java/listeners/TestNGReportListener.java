package listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driver.DriverManager;
import extentreports.ExtentManager;
import global.GlobalData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TestNGReportListener implements ITestListener {

    public static synchronized String[][] getParameterArray(HashMap<String, String> hm) {
        String[][] parameters = new String[hm.size()][2];
        int row = 0;
        int column = 0;
        for (String str : hm.keySet()) {
            parameters[row][column] = "<b>" + str + "</b>";
            column++;
            parameters[row][column] = hm.get(str);
            row++;
            column = 0;
        }
        return parameters;
    }

    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        addConsoleLogsToReport();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println("--------- Executing :- " + getMethodNameWithParams(result) + " ---------");
        ExtentManager.createTest(getMethodNameWithParams(result), getTestDescription(result));
        addParametersInReport(result);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        logStatusToConsole(result);
        assignCategoryToTest(result);
        addExtentLabelToTest(result);
        ExtentManager.flush();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        logStatusToConsole(result);
        assignCategoryToTest(result);
        assignExceptionToTest(result);
        addScreenShotToReport(result);
        addExtentLabelToTest(result);
        ExtentManager.flush();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        if (result.wasRetried())
            removeRetriedTest();
        else {
            logStatusToConsole(result);
            assignCategoryToTest(result);
            assignExceptionToTest(result);
            addScreenShotToReport(result);
            addExtentLabelToTest(result);
            ExtentManager.flush();
        }
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    private synchronized String takeScreenshot(WebDriver driver, String methodName) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
        Date date = new Date();
        String dateName = dateFormat.format(date);
        String filePathExtent = GlobalData.OUTPUT_FOLDER_SCREENSHOTS + methodName + "_" + dateName + ".png";
        String filePath = "./" + GlobalData.OUTPUT_FOLDER_REPORT + filePathExtent;
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(filePath));
        return filePathExtent;
    }

    private synchronized void addScreenShotToReport(ITestResult result) {
        try {
            ExtentManager.getTest().addScreenCaptureFromPath(takeScreenshot(DriverManager.getDriver(), getSimpleMethodName(result)));
        } catch (Exception e) {
            System.out.println("-- Unable to Capture Screenshot --");
        }

    }

    private synchronized void logStatusToConsole(ITestResult result) {
        String status = "";

        if (result.getStatus() == ITestResult.SUCCESS)
            status = "Pass";

        else if (result.getStatus() == ITestResult.FAILURE)
            status = "Fail";

        else if (result.getStatus() == ITestResult.SKIP)
            status = "Skip";

        System.out.println(getSimpleMethodName(result) + " = [" + status + "]" + System.lineSeparator());
        Reporter.log(getSimpleMethodName(result) + " = [" + status + "]<br>");
    }

    private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }

    private synchronized String getSimpleMethodName(ITestResult result) {
        return result.getName();
    }

    private synchronized String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription();
    }

    private synchronized void assignCategoryToTest(ITestResult result) {
        ExtentManager.getTest().assignCategory(getSimpleClassName(result));
    }

    private synchronized void assignExceptionToTest(ITestResult result) {
        ExtentManager.getTest().debug(result.getThrowable());
    }

    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));

        else if (result.getStatus() == ITestResult.FAILURE)
            ExtentManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));

        else
            ExtentManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));

    }

    private synchronized void addConsoleLogsToReport() {
        for (String s : Reporter.getOutput()) {
            ExtentManager.setTestRunnerOutput(s + System.lineSeparator());
        }
    }

    private synchronized String getMethodNameWithParams(ITestResult result) {
        String methodName = result.getName();

        if (result.getParameters().length > 0 && result.getParameters()[0] instanceof HashMap) {
            methodName = methodName + result.getParameters()[0].toString();
        }

        return methodName;
    }

    private synchronized void addParametersInReport(ITestResult result) {
        if (result.getParameters().length > 0 && result.getParameters()[0] instanceof HashMap) {
            ExtentManager.getTest().log(Status.PASS, MarkupHelper.createTable(getParameterArray((HashMap<String, String>) result.getParameters()[0])));
        }
    }

    private synchronized void removeRetriedTest() {
        ExtentManager.deleteCurrentTest();
        ExtentManager.flush();
    }


}
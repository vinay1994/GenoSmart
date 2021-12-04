package global;

import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GlobalData {

    public static final String EXTENT_REPORT_DOCUMENT_TITLE = "Automation Reports";
    public static final String EXTENT_REPORT_REPORT_NAME = "GenoSmart";
    public static final String OUTPUT_FOLDER_REPORT = "extentreport/";
    public static final String OUTPUT_FOLDER_SCREENSHOTS = "screenshots/";
    public static final String REPORT_ENCODING = "utf-8";
    public static final String FILE_NAME_REPORT = "/extentreport.html";
    public static final String FILE_NAME_REPORT_SCREENSHOT = "reportscreenshot";

    public static final String DRIVER_TYPE = System.getProperty("drivertype", "chrome");
    public static final String SUITE_TYPE = System.getProperty("suitetype", "system");
    public static final String ENVIRONMENT = System.getProperty("environment", "live");
    public static final String PLATFORM = System.getProperty("platform", "web");
    public static final String NAMES = System.getProperty("names", "");
    public static final int THREAD_COUNT = Integer.parseInt(System.getProperty("threadcount", "1"));

    public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");
    public static final ResourceBundle TEST_DATA_BUNDLE = ResourceBundle.getBundle("testdata/" + ENVIRONMENT + "/testdata");
    public static final int RETRY_COUNT = 1;
    public static String BASE_URL;
    public static BlockingQueue<WebDriver> DRIVER_QUEUE = new ArrayBlockingQueue<>(20);

    static {
        if (ENVIRONMENT.equalsIgnoreCase("live"))
            BASE_URL = RESOURCE_BUNDLE.getString("BASE_URL_PROD");
        else
            BASE_URL = RESOURCE_BUNDLE.getString("BASE_URL_STAGING");

        System.out.println("Platform = " + PLATFORM.toUpperCase());
        System.out.println("Driver Type = " + DRIVER_TYPE.toUpperCase());
        System.out.println("Environment = " + ENVIRONMENT.toUpperCase());
        System.out.println("Suite Type = " + SUITE_TYPE.toUpperCase());
        if (NAMES.length() > 0)
            System.out.println("Names = " + NAMES.toUpperCase());
        System.out.println("Thread Count = " + THREAD_COUNT);
    }

}

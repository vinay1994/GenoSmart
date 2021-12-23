package generic;

import constants.Constants;
import extentreports.ExtentManager;
import global.GlobalData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.time.Duration;

public class GenericFunctions {

    public static void startDrivers() {
        for (int i = 0; i < GlobalData.THREAD_COUNT; i++) {
            WebDriver driver = starDriverWeb();
            GlobalData.DRIVER_QUEUE.add(driver);
        }
    }

    public static void quitDrivers() {
        for (WebDriver driver : GlobalData.DRIVER_QUEUE)
            driver.quit();
    }

    private static WebDriver starDriverWeb() {
        WebDriver driver = null;

        if (GlobalData.DRIVER_TYPE.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities capabilities = new DesiredCapabilities();
           
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("profile.default_content_setting_values.notifications", 1);
            options.setExperimentalOption("prefs", jsonObject);
             capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
             capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        	 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        	 options.merge(capabilities);
        	 driver = new ChromeDriver(options);
        } else if (GlobalData.DRIVER_TYPE.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("***** Specify a Valid Driver - Chrome/Firefox ********");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.Timeouts.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.Timeouts.DEFAULT_IMPLICIT_WAIT));
        return driver;
    }

    public static synchronized void initExtentReports() {
        ExtentManager.createInstance();
    }

    public synchronized static void initDirectories() {
        try {
            File reportDirectory = new File(GlobalData.OUTPUT_FOLDER_REPORT);
            FileUtils.forceMkdir(reportDirectory);
            FileUtils.cleanDirectory(reportDirectory);
            File screenshotsDirectory = new File(GlobalData.OUTPUT_FOLDER_REPORT + GlobalData.OUTPUT_FOLDER_SCREENSHOTS);
            FileUtils.forceMkdir(screenshotsDirectory);
            FileUtils.cleanDirectory(screenshotsDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void addExecutionDetailsExtentReport() {
        ExtentManager.addSystemInfo("Platform", StringUtils.capitalize(GlobalData.PLATFORM));
        ExtentManager.addSystemInfo("DriverType", StringUtils.capitalize(GlobalData.DRIVER_TYPE));
        ExtentManager.addSystemInfo("Environment", StringUtils.capitalize(GlobalData.ENVIRONMENT));
        ExtentManager.addSystemInfo("SuiteType", StringUtils.capitalize(GlobalData.SUITE_TYPE));
        if (!GlobalData.SUITE_TYPE.equalsIgnoreCase("system"))
            ExtentManager.addSystemInfo("Names", StringUtils.capitalize(GlobalData.NAMES));
        ExtentManager.addSystemInfo("ThreadCount", GlobalData.THREAD_COUNT + "");
    }

}

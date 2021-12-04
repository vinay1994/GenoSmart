package listeners;

import actions.ActionHelper;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import global.GlobalData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {
        try {
            By dashboard_Btn = By.xpath("//a[@view='dashboard-view']");

            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            File file = new File(GlobalData.OUTPUT_FOLDER_REPORT + GlobalData.FILE_NAME_REPORT);
            driver.get("File:///" + file.getAbsolutePath());

            driver.findElement(dashboard_Btn).click();
            ActionHelper.gotoSleep(1000);

            Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 500, true).withName(GlobalData.FILE_NAME_REPORT_SCREENSHOT)
                    .save(GlobalData.OUTPUT_FOLDER_REPORT + GlobalData.OUTPUT_FOLDER_SCREENSHOTS);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("XXXXX Unable to Get Report ScreenShot XXXXX");
        }
    }
}

package actions;

import constants.Constants;
import csvreader.CSVReader;
import driver.DriverManager;
import global.GlobalData;
import logger.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locator;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ActionHelper {
    private static String parentWindow;
    private static CSVReader csvReader;

    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        waitForLoaderToHide();
        Logger.logPass("Opening Url : " + url);
    }

    public static void waitForLoaderToHide() {
        waitUntilElementInvisible(By.id("loader"));
        Logger.logPass("Wait for Loader to Hide");
    }

    public static void gotoSleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentURL() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static WebElement findElement(By by) {
        return waitUntilElementVisible(by);
    }


    public static void click(Locator locator) {
        try {
            findElement(locator).click();
            Logger.logPass("Click with Selenium on = " + getCallingMethodName());
        } catch (Exception e) {
            clickJS(locator.getBy());
            Logger.logPass("Click with JS on = " + getCallingMethodName());
        }
        waitForLoaderToHide();
    }
    public static void click(WebElement webElement) {
        try {
        	webElement.click();
            Logger.logPass("Click with Selenium on = " + getCallingMethodName());
        } catch (Exception e) {
            clickJS(webElement);
            Logger.logPass("Click with JS on = " + getCallingMethodName());
        }
        waitForLoaderToHide();
    }
    public static void click(By by) {
        try {
            findElement(by).click();
            Logger.logPass("Click with Selenium on = " + getCallingMethodName());
        } catch (Exception e) {
            clickJS(by);
            Logger.logPass("Click with JS on = " + getCallingMethodName());
        }
        waitForLoaderToHide();
    }

    public static void clickJS(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", findElement(by));
    }

    public static void clickJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
    
    public static void clickJS(Locator locator) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", findElement(locator));
    }

    public static void setImplicitWait(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static WebElement waitUntilElementVisible(Locator locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
    }

    public static WebElement waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitUntilElementClickable(Locator locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
    }

    public static void waitUntilElementInvisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.LOADER_TIMEOUT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitUntilPageReady() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.PAGE_LOAD_TIMEOUT));
        ExpectedCondition<Boolean> javascriptReady = driver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
        wait.until(javascriptReady);
    }

    public static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static List<WebElement> waitUntilAllElementsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static List<WebElement> waitUntilAllElementsVisible(Locator locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.Timeouts.ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator.getBy()));
    }

    public static WebElement findElement(Locator locator) {
        return waitUntilElementVisible(locator.getBy());
    }

    public static List<WebElement> findElements(By by) {
        return waitUntilAllElementsVisible(by);
    }

    public static void fill(Locator locator, String input) {
        if (input.length() < 1)
            return;
        WebElement webElement = findElement(locator.getBy());
        webElement.clear();
        webElement.sendKeys(input);
        Logger.logPass("Fill Text Box = " + getCallingMethodName() + ", with value = " + input);
    }

    public static void uploadFile(Locator locator, String filePath) {
        findElement(locator).sendKeys(filePath);
        Logger.logPass("Upload File to = " + getCallingMethodName() + ", From FilePath = " + filePath);
    }


    public static void selectValueFromDropDown(Locator locator, String value) {
        new Select(waitUntilElementPresent(locator.getBy())).selectByVisibleText(value);
        Logger.logPass("Selecting value from dropdown = " + getCallingMethodName() + " , Value = " + value);
    }


    public static String getSelectedValue_DD(Locator locator) {
        String value = new Select(waitUntilElementPresent(locator.getBy())).getFirstSelectedOption().getText();
        Logger.logPass("Get value from DropDown " + getCallingMethodName() + " , Selected Value = " + value);
        return value;
    }

    public static void selectIndexFromDropDown(Locator locator, int index) {
        new Select(waitUntilElementPresent(locator.getBy())).selectByIndex(index);
    }

    public static String getDate_PlusDays(int plusDays) {
        DateTime dateTime = DateTime.now();
        return String.valueOf(dateTime.plusDays(plusDays).getDayOfMonth());
    }

    public static void performMouseHover(By by) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(by)).build().perform();
    }

    public static void performMouseHover(WebElement webElement) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(webElement).build().perform();
    }

    public static void performMouseHoverAndClick(Locator webElement, Locator targetWebElement) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(webElement)).build().perform();
        actions.click(findElement(targetWebElement));
    }

    public static boolean isPresent(By by) {
        boolean flag = false;
        WebDriver driver = DriverManager.getDriver();
        ActionHelper.setImplicitWait(0);
        if (driver.findElements(by).size() > 0 && driver.findElement(by).isDisplayed()) {
            flag = true;
        }
        ActionHelper.setImplicitWait(Constants.Timeouts.DEFAULT_IMPLICIT_WAIT);
        Logger.logPass("Check visibility of element " + getCallingMethodName() + " = " + flag);
        return flag;
    }


    public static boolean isPresent(Locator locator) {
        boolean flag = false;
        WebDriver driver = DriverManager.getDriver();
        By by = locator.getBy();
        ActionHelper.setImplicitWait(0);
        if (driver.findElements(by).size() > 0 && driver.findElement(by).isDisplayed()) {
            flag = true;
        }
        ActionHelper.setImplicitWait(Constants.Timeouts.DEFAULT_IMPLICIT_WAIT);
        Logger.logPass("Check visibility of element " + getCallingMethodName() + " = " + flag);
        return flag;
    }

    public static boolean isPresentWithWait(String xpath) {
        By by = By.xpath(xpath);
        WebDriver driver = DriverManager.getDriver();
        try {
            waitUntilElementVisible(by);
        } catch (Exception ignored) {

        }
        setImplicitWait(0);
        if (driver.findElements(by).size() > 0 && driver.findElement(by).isDisplayed()) {
            return true;
        } else {
            setImplicitWait(Constants.Timeouts.DEFAULT_IMPLICIT_WAIT);
            return false;
        }
    }

    public static boolean isPresentWithWait(Locator locator) {
        By by = locator.getBy();
        WebDriver driver = DriverManager.getDriver();
        boolean flag = false;
        try {
            waitUntilElementVisible(by);
        } catch (Exception ignored) {

        }
        setImplicitWait(0);
        if (driver.findElements(by).size() > 0 && driver.findElement(by).isDisplayed()) {
            flag = true;
        }
        Logger.logPass("Check Visibility of Element " + getCallingMethodName() + " = " + flag);
        setImplicitWait(Constants.Timeouts.DEFAULT_IMPLICIT_WAIT);
        return flag;
    }

    public static String getText(Locator locator) {
        String text = findElement(locator.getBy()).getText();
        Logger.logPass("Fetching value of " + getCallingMethodName() + " [ " + text + " ]");
        return text;
    }

    public static String getText(By by) {
        String text = findElement(by).getText();
        Logger.logPass("Fetching value of " + getCallingMethodName() + " [ " + text + " ]");
        return text;
    }

    public static void check_CheckBox(Locator locator) {
        WebElement webElement = waitUntilElementPresent(locator.getBy());
        if (!webElement.isSelected())
            webElement.click();
        Logger.logPass("Checking checkbox = " + getCallingMethodName());
    }


    public static String getCallingMethodName() {
        String methodName;
        try {
            String str[] = Thread.currentThread().getStackTrace()[3].getMethodName().split("_");
            String newStr = "";
            for (int i = 0; i < str.length; i++) {
                if (i == 0 || i == str.length - 1)
                    continue;
                else
                    newStr = newStr + str[i] + "_";
            }

            methodName = newStr.substring(0, newStr.length() - 1);
        } catch (Exception e) {
            methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        }
        return methodName;
    }


    public static void clearCookies() {
        DriverManager.getDriver().manage().deleteAllCookies();
        Logger.logPass("Deleted All Browser Cookies");
    }

    public static void performMouseHover(Locator locator) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(locator)).build().perform();
    }

    public static void switchToFrame(String id) {
        ActionHelper.waitUntilElementVisible(By.id(id));
        DriverManager.getDriver().switchTo().frame(id);
        Logger.logPass("Switch to iFrame with ID = " + id);
    }

    public static void switchToDefaultContent() {
        DriverManager.getDriver().switchTo().defaultContent();
        Logger.logPass("Switch to Default Content");
    }

    public static void switchToNewWindow() {
        parentWindow = DriverManager.getDriver().getWindowHandle();

        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        for (String windowId : windowHandles) {
            DriverManager.getDriver().switchTo().window(windowId);
        }
    }

    public static void switchToParentWindow() {
        DriverManager.getDriver().switchTo().window(parentWindow);
    }

    public static void switchToFrameByXpath(Locator locator) {
        gotoSleep(1000);
        WebElement xpath = findElement(locator);
        DriverManager.getDriver().switchTo().frame(xpath);
        Logger.logPass("Switch to iFrame with XPATH");
    }

    public static double convert_String_Into_Double(String s) {
        return Double.parseDouble(s);

    }

    public static double get_Percentage(double productPrice, double percentageFactor) {
        return productPrice * percentageFactor / 100;
    }


    public static void pressEnter(Locator locator) {
        DriverManager.getDriver().findElement(locator.getBy()).sendKeys(Keys.ENTER);
    }

    public static boolean IsEnableOrDisplay(Locator locator) {
        WebElement element = findElement(locator);
        return element.isEnabled();
    }

    public static String JdbcConnection(String sql_query, String columnName) {
        String result = null, hostName = "2schooldbm", password = "flip@159$$*";

        try {
            if (GlobalData.ENVIRONMENT.equalsIgnoreCase("STAGING")) {
                hostName = "stggroupdb";
                password = "flip@159$$";
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://" + hostName + ".fliplearn.com:3306/ums_api", "root", password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_query);
            System.out.println(sql_query);
            while (rs.next()) {
                result = rs.getString(columnName);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static void scrollTo_Element(Locator locator) {
        WebElement Element = findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView();", Element);

    }


      public static void  uploadFile_RobotClass(String filePath){

              try {
                  //Setting clipboard with file location
                  StringSelection stringSelection = new StringSelection(filePath);
                  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

                  Robot robot = new Robot();
                  robot.delay(3000);
                  robot.keyPress(KeyEvent.VK_CONTROL);
                  robot.keyPress(KeyEvent.VK_V);
                  robot.keyRelease(KeyEvent.VK_V);
                  robot.keyRelease(KeyEvent.VK_CONTROL);
                  robot.keyPress(KeyEvent.VK_ENTER);
                  robot.keyRelease(KeyEvent.VK_ENTER);
              } catch (Exception exp) {
                  exp.printStackTrace();
              }
      }
      
      public static Boolean validate_currentUrl(String expected, Locator locator) {
   	      switchToNewWindow();
		  String currentUrl =DriverManager.getDriver().getCurrentUrl();
		  if(currentUrl.contains(expected) && isPresentWithWait(locator)) {
			 switchToParentWindow();
		  return true;
		  }
		   return false;	
   }
   
  public static String getCommonString(String key) {
	   csvReader=new CSVReader(Constants.FILEPATH_COMMON_TEXT);
	   return csvReader.convertToMap().get(key);
  }
   
      
      
}


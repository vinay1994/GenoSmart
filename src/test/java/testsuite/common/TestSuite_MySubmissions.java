package testsuite.common;

import org.testng.annotations.Test;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import pageobjects.HomePage;

public class TestSuite_MySubmissions extends BaseTestClass {

	
	
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that user is able to view the Sample details when clicking on any Sample  name (hyperlink) under 'Sample' column.")
    public void TC_001() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }
	
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that user is able to see a pop-up box that should show the details of sample as below - --Sample Details (Heading)   -- Sample Name --XML Version --Pipeline Version --Submission Date as per the designs")
    public void TC_002() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }
    
    
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that the details in the pop is correct as per the sample record")
    public void TC_003() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }
    
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that user is able to click on 'Cross' icon at the top right corner of the pop-up box to close it and navigate back to submissions page")
    public void TC_004() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }  
    
}

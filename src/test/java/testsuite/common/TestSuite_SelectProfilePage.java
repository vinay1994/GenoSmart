package testsuite.common;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SelectProfilePage;

public class TestSuite_SelectProfilePage extends BaseTestClass {

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that the select profile option is a dropdown")
    public void TC_001_Validate_Select_profile_Options() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        SelectProfilePage selectProfilePage = SelectProfilePage.getInstance();
        selectProfilePage.click_Sign_In_Btn();
        selectProfilePage.click_google_Lnk();

    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that after signing for first time user should be able to select their profile. Select profile screen must be as per the designs")
    public void TC_002_Validate_User_AbleToSelectProfile() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        SelectProfilePage selectProfilePage = SelectProfilePage.getInstance();

    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that Submit button is disabled until profile is selected from the dropdown")
    public void TC_003_Validate_Submit_button() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();

    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that on clicking Select profile option following options are visible in the dropdown 1. Clinician 2.Lab Analyst 3. Researcher 4. Other as per the design")
    public void TC_004_Validate_Select_profile_DropDown_Options() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that when user selects Clinician from the dropdown, Submit button is enabled. Clicking on Submit button further take the user to Home Page as Signed In user")
    public void TC_005_Validate_UserAbleToSelect_clinician() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that when user selects Lab Analyst from the dropdown, Submit button is enabled. Clicking on Submit button further take the user to Home Page as Signed In user")
    public void TC_006_Validate_UserAbleToSelect_Lab_Analyst() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that when user selects Researcher from the dropdown, Submit button is enabled. Clicking on Submit button further take the user to Home Page as Signed In user")
    public void TC_007_Validate_UserAbleToSelect_Researcher() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that when user selects Other from the dropdown, Optional text box appears on the screen with 'please specify' written in the textbox in grey out color to enter the text as per design and Submit button is enabled")
    public void TC_007_Validate_UserAbleToSelect_Other() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "After click on 'Submit' button user should navigate to 'Home' screen.")
    public void TC_008_Validate_UserAbleToSelect_Other() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "User should be able click on 'Submit' button even after leaving the profile name textbox blank")
    public void TC_009_Validate_UserAbleToSelect_Other() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that the max limit of optional textbox is 32 length")
    public void TC_010_Validate_UserAbleToSelect_Other() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that when user enters the Profile name in optional textbox of other profile and click on submit, user is able to navigate to Home screen as signed in user")
    public void TC_011_Validate_UserAbleToSelect_Other() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that when user enters the Profile name in optional text box of other profile and click on submit, user is able to navigate to Home screen as signed in user")
    public void TC_012_Validate_UserAbleToSelect_Other() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage = HomePage.getInstance();


    }
    
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify User should be able to click on on 'Sign In' button)")
    public void TC_013() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        SelectProfilePage selectProfilePage=new SelectProfilePage();
        selectProfilePage.click_Sign_In_Btn();
        CustomAssert.assertTrue(selectProfilePage.validate_google_lnk(),"Sign in button is not clickable");
  }
  
  
  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "User should be able see Sign In Screen with Google and Microsoft sign In option as per the designs)")
    public void TC_014() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        SelectProfilePage selectProfilePage=new SelectProfilePage();
        selectProfilePage.click_Sign_In_Btn();
        selectProfilePage.validate_google_lnk();
        CustomAssert.assertTrue(selectProfilePage.validate_google_lnk(),"Google link is not aailable for login");
        CustomAssert.assertTrue(selectProfilePage.validate_microSoft_Lnk(),"User not redirecting at expected page after logout");
  }
    
    
    
}

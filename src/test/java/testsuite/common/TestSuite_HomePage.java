package testsuite.common;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SelectProfilePage;
import pageobjects.UploadFilePage;

public class TestSuite_HomePage extends BaseTestClass {

	
	
	  
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To Validate sign in button present at homepage")
    public void TC_001() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To Validate need help button present at homepage")
    public void TC_002() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.need_Help_IsPresent(),"Need help button is not present");
    }
    
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see additional options as 'My Submissions' in Hamburger menu after Signing In")
	    public static void TC_003() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_MySubscription_Btn(),"My Submissions button is not available");
	    }
	  
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see additional options as  'Completed Reports' in Hamburger menu after Signing In")
	    public void TC_004() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_CompleteReport_Btn(),"Completed Reports button is not available");
	    }
	  
	  
	  
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify 'Sign In' button should be removed from the top right side corner of the screen when user gets Signed In")
	    public void TC_005() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_Sign_Btn_visibility(),"sign in  button is present  ");
	    }  
	  
	  
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "User name should be in capital letter")
	    public void TC_006() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_EmailUser_Name(),"User name is not in Capital letter  ");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see \"NEWS & BLOGS\" section as per the attached image")
	    public void TC_007() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.validate_newsblockSection(),"News & Blogs section is not aailable");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see content in \"NEWS & BLOGS\" section in bullet points")
	    public void TC_008() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.valide_ContentInnewsblock(),"Content in News & Blogs section is not available");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Home option as preselected in Hamburger menu")
	    public void TC_009() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.IsPresent_Home_lnk(),"Home link is not present in hamburger menu");
	    } 
	  
	  
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Upload files option in Hamburger menu and look and feel should be as per designs")
	    public void TC_010() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_Upload_lnk(),"Upload file link is not present in hamburger menu");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user should be able to navigate to signIn screen on selecting Upload Files")
	    public void TC_011() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        UploadFilePage.getInstance().click_Upload_file_Btn();
	        CustomAssert.assertTrue(SelectProfilePage.getInstance().validate_google_lnk(),"User is not able to nevigate to sign screen");
	  }
	  
	
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user should be able to navigate to Publications screen on selecting Publications")
	    public void TC_012() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_Publicatios();
	        CustomAssert.assertTrue(homePage.validate_Publications_Url(),"Publications button is not clickable");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Twitter in Hamburger menu and look and feel should be as per designs")
	    public void TC_013() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_Twitter(),"Twitter button is not present");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that Twitter is non clickable")
	    public void TC_014() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_Twitter(),"Twitter is clickable");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that New and Blogs is non clickable")
	    public void TC_015() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_NewsAndBlogs(),"New and blogs is clickable");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Wiki in Hamburger menu and look and feel should be as per designs")
	    public void TC_016() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_wiki_hamburg(),"wiki is not present in hamburger");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that Wiki option is non clickable")
	    public void TC_017() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_wiki_hamburg()," Wiki option is  clickable");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Contact Us in Hamburger menu and look and feel should be as per designs")
	    public void TC_018() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_ContactUs(),"Cantact Us is not visible");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that Contact Us option is non clickable",enabled = false)
	    public void TC_019() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_contactUs_hamburg(),"Cantact Us is not clickable");
	  }
	  
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user is able to see the logout option on clicking on Username coming at top right corner of screen")
	    public void TC_020() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_UserName();
	        CustomAssert.assertTrue(homePage.validate_logout_Btn(),"logout button is not available");
	  }  
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user is able to see sign In button instead of UserName on clicking on logout text on tooltip")
	    public void TC_021() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_UserName();
	        homePage.click_logout();
	        CustomAssert.assertTrue(homePage.validate_SignIn_Btn(),"sign in button is not available");
	  }
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify on 'Logout', User is able to navigate back to Home screen(without Sign In)")
	    public void TC_022() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_UserName();
	        homePage.click_logout();
	        CustomAssert.assertTrue(homePage.validate_SignIn_Btn(),"User not redirecting at expected page after logout");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},enabled = false,
	            description = "Verify user should be able navigate to compose email screen email To: arlg_geno-smart@mc.duke.edu screen in their email browser")
	    public void TC_023() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_contactUs();
	        CustomAssert.assertTrue(homePage.isClickable_contactUs_hamburg(),"Cantact Us is not clickable");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Publications in Hamburger menu and look and feel should be as per designs")
	    public void TC_024() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_publications_btn(),"Publications button is not visible");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Home option when mouse hover on hamburger icons on collapsed hamburger menu")
	    public void TC_025() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_home_img();
	        CustomAssert.assertTrue(homePage.isVisible_Home(),"home button is not visible");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Upload Files option when mouse hover on hamburger icons on collapsed hamburger menu")
	    public void TC_026() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_home_img();
	        CustomAssert.assertTrue(homePage.isVisible_uploadFile(),"upload file button is not visible");
	  }
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see My Submissions option when mouse hover on hamburger icons on collapsed hamburger menu")
	    public void TC_027() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_home_img();
	        CustomAssert.assertTrue(homePage.isVisible_mySubmission()," My Submissions button is not visible");
	  }
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Publications option when mouse hover on hamburger icons on collapsed hamburger menu")
	    public void TC_028() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_home_img();
	        CustomAssert.assertTrue(homePage.isVisible_publication()," Publications button is not visible");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see About us option when mouse hover on hamburger icons on collapsed hamburger menu")
	    public void TC_029() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_home_img();
	        CustomAssert.assertTrue(homePage.isVisible_about_us()," about us button is not visible");
	  }
	  
	  
	  
	  @Test(dependsOnGroups="Login",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Completed Reports option when mouse hover on hamburger icons on collapsed hamburger menu")
	    public void TC_030() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_home_img();
	        CustomAssert.assertTrue(homePage.isVisible_completed_Report(),"Completed Report button is not visible");
	  }
	  
	  
}

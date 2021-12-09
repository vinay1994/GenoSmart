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
	            description = "Verify Once user clicks on 'About us' section from hamburger menu, the user should navigate to 'About us' screen")
	    public void TC_003_Validate_About_Us_Btn() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        CustomAssert.assertTrue(homePage.validate_AboutUs_Url(),"by clicking on about us user not redirecting on about us page");
	    }
	
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to click on 'Arlg.org' hyperlink option to navigate to external arlg link.")
	    public void TC_004_Validate_Org_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_Org_Lnk();
	        CustomAssert.assertTrue(homePage.validate_Org_Url(),"by clicking on Org Link user not redirecting on org  page");
	    }
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "User should be able to click on 'GENO-SMART Team members' hyperlink option and navigate to GENO-SMART team section on the same page.")
	    public void TC_005_Validate_GenoSmart_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_GenoSmart_lnk();
	        CustomAssert.assertTrue(homePage.validate_Genosmart_Section(),"by clicking on Genomart Link user not nevigating on Gene smart section ");
	    }
	  
	  @Test(dependsOnMethods="TC_005_Validate_GenoSmart_Lnk",groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "User should be able to click on 'ARLG CRACKLE-2' hyperlink option to navigate to next paragraph in 'OUR KNOWLEDGE BASE' section of the same page.")
	    public void TC_006_Validate_ARLG_CRACKLE_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_ARLG_lnk();
	        CustomAssert.assertTrue(homePage.validate_Genosmart_Section(),"by clicking on ARLG CRACKLE Link user not nevigating on OUR KNOWLEDGE BASE section ");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "User should be able to click on 'publication' hyperlink under ''OUR KNOWLEDGE BASE' section and navigate to external publication page.")
	    public void TC_007_Validate_publication_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_publication_lnk();
	        CustomAssert.assertTrue(homePage.validate_publication_Url(),"by clicking on publication Link user not nevigating on publication section ");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to click on 'pipeline' hyperlink under 'HOW TO USE' section and navigate to external Git Repo page")
	    public void TC_008_Validate_pipeline_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_pipline_lnk();
	        CustomAssert.assertTrue(homePage.validate_pipeline_Url(),"by clicking on pipeline Link user not nevigating on Git Repo page");
	    } 
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to click on 'GitWiki' hyperlink under 'HOW TO USE' and 'The University of Texas Health Science Center at Houston School of Public Health' section and navigate to external GitWiki page")
	    public void TC_009_Validate_wiki_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_wiki_lnk();
	        CustomAssert.assertTrue(homePage.validate_wiki_Url(),"by clicking on GitWiki Link user not navigate to external GitWiki page");
	    }
	 
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to click on the hyperlink superscript reference no. 1 under GENO-SMART Team section and it will navigate to reference no. 1 in the footer section")
	    public void TC_010_Validate_superscript_Lnk() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_About_Us();
	        homePage.click_wiki_lnk();
	        CustomAssert.assertTrue(homePage.validate_wiki_Url(),"by clicking on superscript reference no. 1 Link user not it will navigate to reference no. 1 in the footer section");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see additional options as 'My Submissions' in Hamburger menu after Signing In")
	    public void TC_010() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_MySubscription_Btn(),"My Submissions button is not available");
	    }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see additional options as  'Completed Reports' in Hamburger menu after Signing In")
	    public void TC_011() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_CompleteReport_Btn(),"Completed Reports button is not available");
	    }
	  
	  
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify 'Sign In' button should be removed from the top right side corner of the screen when user gets Signed In")
	    public void TC_012() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_Sign_Btn_visibility(),"sign in  button is present  ");
	    }  
	  
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Use name should be in capital letter")
	    public void TC_013() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_EmailUser_Name(),"User name is not in Capital letter  ");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see \"NEWS & BLOGS\" section as per the attached image")
	    public void TC_014() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.validate_newsblockSection(),"News & Blogs section is not aailable");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see content in \"NEWS & BLOGS\" section in bullet points")
	    public void TC_015() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.valide_ContentInnewsblock(),"Content in News & Blogs section is not available");
	    }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Home option as preselected in Hamburger menu")
	    public void TC_016() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.IsPresent_Home_lnk(),"Home link is not present in hamburger menu");
	    } 
	  
	  
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Upload files option in Hamburger menu and look and feel should be as per designs")
	    public void TC_017() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_Upload_lnk(),"Upload file link is not present in hamburger menu");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user should be able to navigate to signIn screen on selecting Upload Files")
	    public void TC_018() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        UploadFilePage.getInstance().click_Upload_file_Btn();
	        CustomAssert.assertTrue(SelectProfilePage.getInstance().validate_google_lnk(),"User is not able to nevigate to sign screen");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Publications in Hamburger menu and look and feel should be as per designs")
	    public void TC_019() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_publications_btn(),"Publications button is not visible");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user should be able to navigate to Publications screen on selecting Publications")
	    public void TC_020() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        homePage.click_Publicatios();
	        CustomAssert.assertTrue(homePage.validate_Publications_Url(),"Publications button is not clickable");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Twitter in Hamburger menu and look and feel should be as per designs")
	    public void TC_021() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_Twitter(),"Twitter button is not present");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that Twitter is non clickable")
	    public void TC_022() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_Twitter(),"Twitter is clickable");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that New and Blogs is non clickable")
	    public void TC_023() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_NewsAndBlogs(),"New and blogs is clickable");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Wiki in Hamburger menu and look and feel should be as per designs")
	    public void TC_024() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_wiki_hamburg(),"wiki is not present in hamburger");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that Wiki option is non clickable")
	    public void TC_025() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_wiki_hamburg()," Wiki option is  clickable");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify User should be able to see Contact Us in Hamburger menu and look and feel should be as per designs")
	    public void TC_026() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isPresent_ContactUs(),"Cantact Us is not visible");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify that Contact Us option is non clickable")
	    public void TC_027() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        CustomAssert.assertTrue(homePage.isClickable_contactUs_hamburg(),"Cantact Us is not clickable");
	  }
	  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user is able to see the logout option on clicking on Username coming at top right corner of screen")
	    public void TC_028() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_UserName();
	        CustomAssert.assertTrue(homePage.validate_logout_Btn(),"logout button is not available");
	  }  
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify user is able to see sign In button instead of UserName on clicking on logout text on tooltip")
	    public void TC_029() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_UserName();
	        homePage.click_logout();
	        CustomAssert.assertTrue(homePage.validate_SignIn_Btn(),"sign in button is not available");
	  }
	  
	  @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
	            description = "Verify on 'Logout', User is able to navigate back to Home screen(without Sign In)")
	    public void TC_030() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=new SelectProfilePage();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        homePage.click_UserName();
	        homePage.click_logout();
	        CustomAssert.assertTrue(homePage.validate_SignIn_Btn(),"User not redirecting at expected page after logout");
	  }
	  
	
	  
	  
	  
	  
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To Validate sign in button present at homepage")
    public void TC_001_Validate_Sign_In_ButtonPresent() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To Validate need help button present at homepage")
    public void TC_002_Validate_Sing_In_ButtonPresent() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.need_Help_IsPresent(),"Need help button is not present");
    }
    
  
    
    
}

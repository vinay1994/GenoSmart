package testsuite.common;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import org.testng.annotations.Test;
import pageobjects.HomePage;

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
            description = "To Validate sign in button present at homepage")
    public void TC_001_Validate_Sign_In_ButtonPresent() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"Sign in button is not present");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To Validate sign in button present at homepage")
    public void TC_002_Validate_Sing_In_ButtonPresent() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        HomePage homePage= HomePage.getInstance();
        CustomAssert.assertTrue(homePage.need_Help_IsPresent(),"Need help button is not present");
    }
    
  
    
    
}

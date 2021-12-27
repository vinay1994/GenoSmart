package testsuite.common;

import org.testng.annotations.Test;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import pageobjects.HomePage;
import pageobjects.MySubmissionsPage;
import pageobjects.SelectProfilePage;

public class TestSuite_MySubmissions extends BaseTestClass {

	MySubmissionsPage mySubmission=null;
	
    @Test(dependsOnGroups="upload_file",groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that user is able to view the Sample details when clicking on any Sample  name (hyperlink) under 'Sample' column.")
    public void TC_001() {
         ActionHelper.clearCookies();
         ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
         mySubmission= MySubmissionsPage.getInstance();
         SelectProfilePage.getInstance().click_Sign_In_Btn();
         SelectProfilePage.getInstance().click_google_Lnk();
         SelectProfilePage.getInstance().login_email();
         mySubmission.click_MySubmissions();
         mySubmission.click_sample_lnk();
        CustomAssert.assertTrue(mySubmission.isPresent_DetailsHeader(),"Sample details is not present");
    }
	
    @Test(dependsOnGroups="upload_file",groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that user is able to see a pop-up box that should show the details of sample as below - --Sample Details (Heading)   -- Sample Name --XML Version --Pipeline Version --Submission Date as per the designs")
    public void TC_002() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        mySubmission= MySubmissionsPage.getInstance();
        SelectProfilePage.getInstance().click_Sign_In_Btn();
        SelectProfilePage.getInstance().click_google_Lnk();
        SelectProfilePage.getInstance().login_email();
        mySubmission.click_MySubmissions();
        mySubmission.click_sample_lnk();
        CustomAssert.assertTrue(mySubmission.verify_popUp_Content(),"Details on pop up is not present as expected");
    }
    
    
    @Test(dependsOnGroups="upload_file",groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that the details in the pop is correct as per the sample record")
    public void TC_003() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        mySubmission= MySubmissionsPage.getInstance();
        SelectProfilePage.getInstance().click_Sign_In_Btn();
        SelectProfilePage.getInstance().click_google_Lnk();
        SelectProfilePage.getInstance().login_email();
        mySubmission.click_MySubmissions();
        String sName=mySubmission.get_sampleName();
        String sDate=mySubmission.get_SumbDate();
        mySubmission.click_sample_lnk();
        CustomAssert.assertEquals(mySubmission.get_SubmissionDate(),sDate,"Submission date did not matched on pop up");
        CustomAssert.assertEquals(mySubmission.get_SampleName_PopUp(),sName,"Sample name did  not matched on pop up");
    }
    
    @Test(dependsOnGroups="upload_file", groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "Verify that user is able to click on 'Cross' icon at the top right corner of the pop-up box to close it and navigate back to submissions page")
    public void TC_004() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        mySubmission= MySubmissionsPage.getInstance();
        SelectProfilePage.getInstance().click_Sign_In_Btn();
        SelectProfilePage.getInstance().click_google_Lnk();
        SelectProfilePage.getInstance().login_email();
        mySubmission.click_MySubmissions();
        mySubmission.click_sample_lnk();
        String sName=mySubmission.get_SampleName_PopUp();
        mySubmission.click_cross();
        CustomAssert.assertEquals(mySubmission.get_sampleName(),sName,"Sample name did  not matched on pop up");
    }  
    
    
//    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
//            description = "Verify User is able to click on 'Delete' icon to choose an option to Delete Report for the samples when the report is generated")
//    public void TC_005() {
//        ActionHelper.clearCookies();
//        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
//        HomePage homePage= HomePage.getInstance();
//        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"User not able to delete the file");
//    }
//    
//    
//    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
//            description = "Verify User is able to 'Delete Sample' where only sample is added but Report Analysis is not completed")
//    public void TC_006() {
//        ActionHelper.clearCookies();
//        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
//        HomePage homePage= HomePage.getInstance();
//        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"User not able to delete the file where only sample is added but Report Analysis is not completed ");
//    }
//    
//    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
//            description = "Verify User is not able to see 'Delete Report' icon for samples where report is not generated")
//    public void TC_007() {
//        ActionHelper.clearCookies();
//        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
//        HomePage homePage= HomePage.getInstance();
//        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"User able to  see delete report icon   for samples where report is not generated");
//    }
//    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
//            description = "Verify User is not able to see 'Delete Report' icon for samples where report is not generated")
//    public void TC_008() {
//        ActionHelper.clearCookies();
//        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
//        HomePage homePage= HomePage.getInstance();
//        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"User able to  see delete report icon   for samples where report is not generated");
//    }
//    
//    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
//            description = "Verify When the user deletes a report, the status of the sample should show 'Report Deleted' under the status column.")
//    public void TC_009() {
//        ActionHelper.clearCookies();
//        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
//        HomePage homePage= HomePage.getInstance();
//        CustomAssert.assertTrue(homePage.sign_In_IsPresent(),"the status of the sample should not show 'Report Deleted' under the status column.");
//    }
    
    
    
}

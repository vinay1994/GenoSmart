package testsuite.common;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pageobjects.UploadFilePage;

public class TestSuite_UploadFilePage extends BaseTestClass {



    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To Validate  file upload functionality")
    public void TC_001_Validate_Upload_File_Functionality() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        UploadFilePage uploadFilePage=UploadFilePage.getInstance();
        uploadFilePage.click_Upload_file_Btn();
       // uploadFilePage.upload_xmlFile();
      //  uploadFilePage.upload_FastaFile();
      //  CustomAssert.assertTrue("");

    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY},
            description = "To validate upload file button is clickable and navigate to sign in button")
    public void TC_002_Validate_Upload_File_Btn() {
        ActionHelper.clearCookies();
        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
        UploadFilePage uploadFilePage=UploadFilePage.getInstance();
        uploadFilePage.click_Upload_file_Btn();
        CustomAssert.assertTrue(uploadFilePage.check_sign_In_Btn(),"either upload button is not clickable or Sign in button is not present");

    }
}
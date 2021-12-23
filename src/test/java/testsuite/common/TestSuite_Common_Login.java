package testsuite.common;

import org.testng.annotations.Test;

import actions.ActionHelper;
import assertions.CustomAssert;
import base.BaseTestClass;
import constants.Constants;
import pageobjects.HomePage;
import pageobjects.SelectProfilePage;

public class TestSuite_Common_Login extends BaseTestClass {
	
	
	  @Test(groups = "Login",
	            description = "Verify User should be able to see additional options as 'My Submissions' in Hamburger menu after Signing In with gmail  options")
	    public static void Login() {
	        ActionHelper.clearCookies();
	        ActionHelper.openURL(Constants.Urls.URL_HOMEPAGE);
	        HomePage homePage= HomePage.getInstance();
	        SelectProfilePage selectProfilePage=SelectProfilePage.getInstance();
	        selectProfilePage.click_Sign_In_Btn();
	        selectProfilePage.click_google_Lnk();
	        selectProfilePage.login_email();
	        CustomAssert.assertTrue(homePage.validate_MySubscription_Btn(),"Gmail login option is not working");
	    }

}

package pageobjects;

import actions.ActionHelper;
import constants.Constants;

import org.openqa.selenium.By;
import utils.Locator;

public class SelectProfilePage {


 public static SelectProfilePage  _instance=null;

     private final Locator sign_Btn=Locator.builder().withWeb(By.xpath("//button[text()='Sign In']"));
    private final Locator google_Lnk=Locator.builder().withWeb(By.xpath("//span[text()='Sign in with Google']"));
    private final Locator submit_btn=Locator.builder().withWeb(By.xpath(""));
    private final Locator email_Txt=Locator.builder().withWeb(By.xpath("//input[@id='identifierId']"));
    private final Locator next_btn=Locator.builder().withWeb(By.xpath("//span[text()='Next']"));
    private final Locator password_Txt=Locator.builder().withWeb(By.xpath("//input[@name='password']"));
    
    

public SelectProfilePage(){

}
    public static synchronized SelectProfilePage getInstance() {
        if (_instance == null)
            _instance = new SelectProfilePage();
        return _instance;
    }



    public void click_google_Lnk(){
        ActionHelper.click(google_Lnk);

    }
    
    public boolean validate_google_lnk() {
    	return ActionHelper.IsEnableOrDisplay(google_Lnk);
    }
    public void click_Sign_In_Btn(){
        ActionHelper.click(sign_Btn);

    }
    
    public void login_email() {
    	ActionHelper.fill(email_Txt, ActionHelper.getCommonString(Constants.email));
    	ActionHelper.click(next_btn);
    	ActionHelper.fill(password_Txt, ActionHelper.getCommonString(Constants.email_Password));
    	ActionHelper.click(next_btn);
    	
    }
}

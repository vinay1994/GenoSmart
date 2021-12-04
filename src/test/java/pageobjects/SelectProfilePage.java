package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;
import utils.Locator;

public class SelectProfilePage {


 public static SelectProfilePage  _instance=null;

private final Locator sign_Btn=Locator.builder().withWeb(By.linkText("Sign In"));
    private final Locator google_Lnk=Locator.builder().withWeb(By.linkText("Sign in with Google"));
    private final Locator submit_btn=Locator.builder().withWeb(By.xpath(""));


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
    public void click_Sign_In_Btn(){
        ActionHelper.click(sign_Btn);

    }
}

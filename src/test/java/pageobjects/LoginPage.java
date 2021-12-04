package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;
import utils.Locator;
/*
public class LoginPage {

    private static LoginPage _instance = null;
    private final Locator loginByUserId_Btn = Locator.builder().withWeb(By.xpath("//button[text()='Use your login ID/Password']"));
    private final Locator userName_Txt = Locator.builder().withWeb(By.id("Fname"));
    private final Locator password_Txt = Locator.builder().withWeb(By.id("password-lg1"));
    private final Locator login_Btn = Locator.builder().withWeb(By.xpath("(//*[text()='Login'])[2]"));
    private final Locator selectProfile_Lbl = Locator.builder().withWeb(By.xpath("//h3[contains(text(),'Select Profile -')]"));
    private final Locator admissionFee_Btn = Locator.builder().withWeb(By.xpath("(//div[@class='roleStudentSl-profile'])[1]"));
    private final Locator proceed_Btn = Locator.builder().withWeb(By.id("proceedButton"));


    private final Locator mobile_Txt = Locator.builder().withWeb(By.xpath("//input[@id='mobileno']"));
    private final Locator go_Btn = Locator.builder().withWeb(By.xpath("//button[@class='goBtnLoginScreen afterArrowNone goBtnActiveScreen ng-scope']"));
    private final Locator enterOtp_Txt = Locator.builder().withWeb(By.xpath("//input[@id='enterOTP']"));
    private final Locator verify_Btn = Locator.builder().withWeb(By.xpath("//button[@ng-click='otpVerify(otpFrm)']"));
    private final Locator newUser_Rbtn = Locator.builder().withWeb(By.xpath("//p[text()='I am a new user']/../preceding-sibling::div/div [@class='radiobutton']"));
    private final Locator confirm_Btn = Locator.builder().withWeb(By.xpath("//button[text()='Confirm']"));
    private final Locator firstName_Txt = Locator.builder().withWeb(By.id("learnersName"));
    private final Locator select_Class_Drw = Locator.builder().withWeb(By.xpath("(//select[@id='radiusSelect'])[3]"));
    private final Locator select_Board_Drw = Locator.builder().withWeb(By.xpath("(//select[@id='radiusSelect'])[4]"));
    private final Locator continue_btn = Locator.builder().withWeb(By.xpath("(//button[@ng-click='classSelectedByUser(ClassFrm)'])[2]"));
    private final Locator home_lnk = Locator.builder().withWeb(By.xpath("//a[text()='Home']"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.xpath("//button[text()='Skip']"));
    private final Locator login_with_phone = Locator.builder().withWeb(By.xpath("//button[text()='Use Your Phone Number']"));
    private final Locator looks_like_good = Locator.builder().withWeb(By.xpath("//span[@class='float-left letGoTextComment ng-scope']"));
    private final Locator mobile_edit_Btn = Locator.builder().withWeb(By.xpath("//i[@ng-click]"));
    private final Locator cross_btn = Locator.builder().withWeb(By.xpath("(//button[@ng-click])[3]"));
    private final Locator forgetLoginId = Locator.builder().withWeb(By.xpath("//a[@ng-click='forgotLoginId()']"));
    private final Locator enter_register_mob = Locator.builder().withWeb(By.xpath("//input[@id='mobile']"));
    private final Locator next_Btn = Locator.builder().withWeb(By.id("btn-next"));
    private final Locator Otp_forgetLogin_txt = Locator.builder().withWeb(By.xpath("//input[@id='enterOTP']"));
    private final Locator verify_Btn_forgot_Login = Locator.builder().withWeb(By.xpath("//button[text()='Verify']"));
    private final Locator select_loginId = Locator.builder().withWeb(By.xpath("(//label[contains(@for,'admissionFee')])[1]"));
    private final Locator submit_Btn = Locator.builder().withWeb(By.xpath("//button[text()='Submit']"));
    private final Locator back_Login_lnk = Locator.builder().withWeb(By.xpath("//a[text()='Back to Login']"));
    private final Locator forgot_Password_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Password?']"));
    private final Locator enterForgot_Login_txt = Locator.builder().withWeb(By.xpath("//input[@id='userid']"));
    private final Locator next_Btn_forgotPass = Locator.builder().withWeb(By.xpath("//button[text()='Next']"));
    private final Locator otp_forgotPass = Locator.builder().withWeb(By.id("mobileVerifyCode"));
    private final Locator enterNewPassword = Locator.builder().withWeb(By.xpath("//input[@name='npassword']"));
    private final Locator cpassword = Locator.builder().withWeb(By.xpath("//input[@name='cpassword']"));
    private final Locator done_btn = Locator.builder().withWeb(By.xpath("//button[text()='Done']"));
    private Locator learnTab_Lnk= Locator.builder().withWeb(By.xpath("//span[text()='Learn']"));


    private LoginPage() {

    }

    public static synchronized LoginPage getInstance() {
        if (_instance == null)
            _instance = new LoginPage();
        return _instance;
    }


    public void fillNew_Password() {
        ActionHelper.fill(enterNewPassword, "123456");
        ActionHelper.fill(cpassword, "123456");
        ActionHelper.click(done_btn);
    }

    public void fill_Otp_Pass(String mob_no) {
        String Otp = ActionHelper.JdbcConnection("SELECT * FROM ums_api.user_verification_code where mobile_no=" + mob_no + " order by 1 desc limit 1;", "verification_code");
        ActionHelper.fill(otp_forgotPass, Otp);
        ActionHelper.click(verify_Btn_forgot_Login);
    }

    public void fill_loginId() {
        ActionHelper.fill(enterForgot_Login_txt, "vinay4.student");
        ActionHelper.click(next_Btn_forgotPass);
    }

    public boolean isBackButtonDisplay() {
        return ActionHelper.isPresent(back_Login_lnk);
    }

    public void click_On_submit_Btn() {
        ActionHelper.scrollTo_Element(submit_Btn);
        ActionHelper.click(submit_Btn);
    }

    public void setSelect_LoginProfile() {
        ActionHelper.click(select_loginId);

    }

    public void click_OnForgotLogin_Btn() {
        ActionHelper.click(forgetLoginId);
    }

    public void click_OnForgoPassword_Btn() {
        ActionHelper.click(forgot_Password_Btn);
    }

    public void fillOTP_for_ForgetLogin(String mob_no) {
        String Otp = ActionHelper.JdbcConnection("SELECT * FROM ums_api.user_verification_code where mobile_no=" + mob_no + " order by 1 desc limit 1;", "verification_code");
        ActionHelper.fill(Otp_forgetLogin_txt, Otp);

        ActionHelper.click(verify_Btn_forgot_Login);

    }

    public void click_onNext_forgetLogin() {
        ActionHelper.click(next_Btn);
    }


    public void fill_Register_Mob(String mob) {
        ActionHelper.fill(enter_register_mob, mob);
    }


    public void fill_MobileNumber(String mobile_No) {
        ActionHelper.click(loginByUserId_Btn);
        ActionHelper.click(login_with_phone);
        ActionHelper.fill(mobile_Txt, mobile_No);
    }

    public boolean verify_ALl_WebElements_PresentOn_Enter_OTP_PopUp() {
        if (ActionHelper.isPresent(verify_Btn))
            return true;
        else if (ActionHelper.isPresent(mobile_edit_Btn))
            return true;
        else if (ActionHelper.isPresent(cross_btn))
            return true;
        else
            return true;
    }

    public void click_login_with_phone() {
        ActionHelper.click(login_with_phone);
    }

    public boolean isDisplay_Go_Btn() {
        return ActionHelper.isPresentWithWait(go_Btn);
    }

    public void click_Go_Btn() {
        ActionHelper.click(go_Btn);
    }

    public String get_Looks_Like_Good_ValidationMessage() {
        return ActionHelper.getText(looks_like_good);
    }

    public void fill_OtP(String mob_no) {
        String Otp = ActionHelper.JdbcConnection("SELECT * FROM ums_api.user_verification_code where mobile_no=" + mob_no + " order by 1 desc limit 1;", "verification_code");
        ActionHelper.fill(enterOtp_Txt, Otp);
    }

    public void click_Verify_Btn() {
        ActionHelper.waitUntilElementVisible(verify_Btn);
        ActionHelper.click(verify_Btn);

    }

    public void newUser_Rbt() {
        ActionHelper.scrollTo_Element(newUser_Rbtn);
        ActionHelper.click(newUser_Rbtn);
    }

    public void click_confirm_Btn() {
        ActionHelper.click(confirm_Btn);
    }

    public void fill_firstname() {
        ActionHelper.fill(firstName_Txt, "Vinay_Demo");
    }

    public void select_class_Drw() {
        ActionHelper.selectIndexFromDropDown(select_Class_Drw, 12);
    }

    public void setSelect_Board_Drw() {
        ActionHelper.selectIndexFromDropDown(select_Board_Drw, 3);
    }

    public void click_Continue_Btn() {
        ActionHelper.click(continue_btn);
    }

    public String getHomeText() {
        return ActionHelper.getText(home_lnk);
    }


    public void click_LoginByUserId_Btn() {
        ActionHelper.click(loginByUserId_Btn);
    }

    public void fill_UserName_Txt(String userName) {
        ActionHelper.fill(userName_Txt, userName);
    }

    public void fill_Password_Txt(String password) {
        ActionHelper.fill(password_Txt, password);
    }

    public void click_Login_Btn() {
        ActionHelper.click(login_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isPresent_SelectProfile_Lbl() {
        ActionHelper.gotoSleep(2000);
        return ActionHelper.isPresent(selectProfile_Lbl);

    }

    public boolean isPresent_Skip_Btn() {
        ActionHelper.gotoSleep(1000);
        return ActionHelper.isPresent(skip_Btn);
    }

    public void click_SelectProfile_Btn() {
        ActionHelper.click(admissionFee_Btn);
    }

    public void click_Proceed_Btn() {
        ActionHelper.gotoSleep(1000);
        if (ActionHelper.isPresent(proceed_Btn))
            System.out.println("Click on skip button");
        ActionHelper.click(proceed_Btn);
    }

    public boolean isPresent_LoginByUserId_Btn() {
        ActionHelper.gotoSleep(1000);
        return ActionHelper.isPresentWithWait(loginByUserId_Btn);
    }

    public void performLogin(String userName, String password) {
        click_LoginByUserId_Btn();
        fill_UserName_Txt(userName);
        fill_Password_Txt(password);
        click_Login_Btn();
        if (isPresent_SelectProfile_Lbl()) {
            click_SelectProfile_Btn();
            click_Proceed_Btn();
        }
        if (isPresent_Skip_Btn()) {
            ActionHelper.click(skip_Btn);
        }

    }
}

*/


package pageobjects;

import actions.ActionHelper;
import constants.Constants;
import org.openqa.selenium.By;
import utils.Locator;

public class UploadFilePage {

   private static UploadFilePage _instance=null;
    public  final Locator upload_File_Btn=Locator.builder().withWeb(By.xpath("//span[text()='Upload Files']"));
    private  final  Locator browser_xml_Btn=Locator.builder().withWeb(By.xpath("(//button[text()='Browse'])[1]"));
    private  final  Locator browser_fasta_Btn=Locator.builder().withWeb(By.xpath("(//button[text()='Browse'])[2]"));
    private  final Locator sign_In_Btn=Locator.builder().withWeb(By.xpath("//span[text()='Sign in with Google']"));
    private final Locator uplaod_lnk=Locator.builder().withWeb(By.xpath("//span[text()='Upload']"));
    private final Locator success_Sms=Locator.builder().withWeb(By.xpath("//strong[text()='File uploaded Successfully!']"));
    private UploadFilePage() {

    }

    public static synchronized UploadFilePage getInstance() {
        if (_instance == null)
            _instance = new UploadFilePage();
        return _instance;
    }


    public  void click_Upload_file_Btn(){
        ActionHelper.click(upload_File_Btn);
    }
    
    public  void click_Upload_Lnk(){
    	ActionHelper.scrollTo_Element(uplaod_lnk);
        ActionHelper.click(uplaod_lnk);
    }
    public void upload_xmlFile(){
       ActionHelper.click(browser_xml_Btn);
     //  ActionHelper.uploadFile(browser_xml_Btn, "E:\\GenoSmart\\Automation\\genoSmart\\src\\main\\resources\\testdata\\files\\SampleTest.xml");
     ActionHelper.uploadFile_RobotClass("E:\\GenoSmart\\Automation\\genoSmart\\src\\main\\resources\\testdata\\files\\SampleTest");
    }
    public void upload_FastaFile(){
        ActionHelper.click(browser_fasta_Btn);
     //   ActionHelper.uploadFile(browser_xml_Btn, "E:\\GenoSmart\\Automation\\genoSmart\\src\\main\\resources\\testdata\\files\\SampleTest.fasta");
        ActionHelper.uploadFile_RobotClass("E:\\GenoSmart\\Automation\\genoSmart\\src\\main\\resources\\testdata\\files\\SampleTest.fasta");
       // System.out.println(Constants.FILEPATH_FASTA_FILE);
    }


     public Boolean check_sign_In_Btn(){
        String sign_In=null;
        sign_In=ActionHelper.getText(sign_In_Btn);
        if(!(sign_In==null))
            return true;
        return false;
}
     
     public Boolean check_success_Sms(){
         String sms=null;
         sms=ActionHelper.getText(success_Sms);
         if(sms!=null)
             return true;
         return false;
 }
     
     
     
     
     
     
     
}

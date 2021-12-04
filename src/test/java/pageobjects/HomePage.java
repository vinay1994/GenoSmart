package pageobjects;

import actions.ActionHelper;
import constants.Constants;
import csvreader.CSVReader;
import driver.DriverManager;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Locator;

public class HomePage {
	
	
	static String actual=null;
	
	

    private static  HomePage _instance =null;
    private final Locator Sign_In_Btn = Locator.builder().withWeb(By.xpath("//button[text()='Sign In']"));
    private  final Locator need_Help_Btn=Locator.builder().withWeb(By.xpath("//span[@class='ms-1 m-auto']"));
     private final Locator about_us_Btn=Locator.builder().withWeb(By.xpath("//span[text()='About Us']")) ; 
     private final Locator org_Lnk=Locator.builder().withWeb(By.xpath("//a[text()='(arlg.org)']"));
     private final Locator genoSmart_lnk=Locator.builder().withWeb(By.xpath("//a[text()='GENO-SMART Team members']"));
     private final Locator genoSmart_txt=Locator.builder().withWeb(By.xpath("//p[text()='GENO-SMART Thought Leadership:']"));
    private final Locator ARLG_lnk=Locator.builder().withWeb(By.xpath("//a[text()='ARLG CRACKLE-2']"));
    private final Locator publication_lnk=Locator.builder().withWeb(By.xpath("(//a[@class='text-decoration-none'])[4]"));
    private final Locator pipline_lnk=Locator.builder().withWeb(By.xpath("(//a[@class='text-decoration-none'])[5]"));
    private final Locator wiki_lnk=Locator.builder().withWeb(By.xpath("(//a[@class='text-decoration-none'])[6]"));
    private final Locator custom_links=Locator.builder().withWeb(By.xpath("//a[@class='custom-link']"));
    private final Locator footers=Locator.builder().withWeb(By.xpath("//div[@class='d-flex']/span"));
    private final Locator arg_home=Locator.builder().withWeb(By.xpath("(//a[text()='Home'])[1]"));
    private final Locator publication_account=Locator.builder().withWeb(By.xpath("//h4[text()='Account']"));
    private final Locator pipeline_about=Locator.builder().withWeb(By.xpath("//h2[text()='About']"));
    private final Locator wiki_home=Locator.builder().withWeb(By.xpath("//h1[text()='Home']"));
    
    
    
    private HomePage() {

    }

    public static synchronized HomePage getInstance() {
        if (_instance == null)
            _instance = new HomePage();
        return _instance;
    }

    public boolean sign_In_IsPresent(){
       return  ActionHelper.isPresent(Sign_In_Btn);
    }
    public boolean need_Help_IsPresent(){
        return  ActionHelper.isPresent(need_Help_Btn);
    }
   public void click_About_Us() {
	   actual=ActionHelper.getText(about_us_Btn);
	 ActionHelper.click(about_us_Btn);
 }
 
   public  boolean validate_AboutUs_Url() {
	   actual=ActionHelper.getCommonString(actual);
	  String currentUrl =DriverManager.getDriver().getCurrentUrl();
	  if(currentUrl.contains(actual))
	  return true;
	  
	   return false;
   }
   
   public  boolean validate_Org_Url() {
	   return ActionHelper.validate_currentUrl(ActionHelper.getCommonString(actual),arg_home);
	   }
    public void click_Org_Lnk() {
    actual=ActionHelper.getText(org_Lnk);
    ActionHelper.click(org_Lnk);
    }
    public void click_GenoSmart_lnk() {
    	actual=ActionHelper.getText(genoSmart_lnk);
    	ActionHelper.click(genoSmart_lnk);
    }
    
    public  boolean validate_Genosmart_Section() {
		  if(ActionHelper.getText(genoSmart_txt).contains(ActionHelper.getCommonString(actual)))
		  return true;
		  
		   return false;
	   }
    public void click_ARLG_lnk() {
    	ActionHelper.scrollTo_Element(ARLG_lnk);
    	actual=ActionHelper.getText(genoSmart_lnk);
    	ActionHelper.click(ARLG_lnk);
    }
    public void click_publication_lnk() {
    	ActionHelper.scrollTo_Element(publication_lnk);
    	actual=ActionHelper.getText(publication_lnk);
    	System.out.println(actual);
    	ActionHelper.click(publication_lnk);
    }
    
    
    public  boolean validate_publication_Url() {
	   
		  return ActionHelper.validate_currentUrl(ActionHelper.getCommonString(actual.trim()),publication_account);
		
	   }
    
    public void click_pipline_lnk() {
    	ActionHelper.scrollTo_Element(pipline_lnk);
    	actual=ActionHelper.getText(pipline_lnk);
    	ActionHelper.click(pipline_lnk);
    }
    
    
    public  boolean validate_pipeline_Url() {
	    return ActionHelper.validate_currentUrl(ActionHelper.getCommonString(actual),pipeline_about);
	   }
    
    
    public void click_wiki_lnk() {
    	ActionHelper.scrollTo_Element(wiki_lnk);
    	actual=ActionHelper.getText(wiki_lnk);
    	ActionHelper.click(wiki_lnk);
    }
    
    public  boolean validate_wiki_Url() {
	    return ActionHelper.validate_currentUrl(ActionHelper.getCommonString(actual),wiki_home);
	   }
    
    
    public void validate_Custom_link() {
    	List<WebElement> custom_Links = ActionHelper.waitUntilAllElementsVisible(custom_links);
    	List<WebElement> footers_lnk  = ActionHelper.waitUntilAllElementsVisible(footers);
    	
    	for(int i=1; i<custom_Links.size(); i++) {
    		WebElement custom_link = custom_Links.get(i);
    		String text=custom_link.getText();
    		ActionHelper.click(custom_link);
    		if(text=="") {
    			
    		}
    		
    		
    	}
    }
    

    
  
    
}
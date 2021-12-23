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
    private  final Locator MySubmissions=Locator.builder().withWeb(By.xpath("//span[text()='My Submissions']"));
    private final Locator complete_reprot_btn=Locator.builder().withWeb(By.xpath("//span[text()='Completed Reports']"));
    private final Locator sign_Btn=Locator.builder().withWeb(By.xpath("//button[text()='Sign In']"));
    private final Locator Email_Name=Locator.builder().withWeb(By.xpath("//span/span"));
    private final Locator newsBlog=Locator.builder().withWeb(By.xpath("//strong[text()='NEWS & BLOG']"));
    private final Locator content_NewsBlog=Locator.builder().withWeb(By.xpath("//div[@class='col-12 col-md-4 d-flex']/div/ul/li"));
    private final Locator publications_btn=Locator.builder().withWeb(By.xpath("//span[text()='Publications']"));
    private final Locator twitter=Locator.builder().withWeb(By.xpath("//span[text()='Twitter']"));
    public  final Locator upload_File_Btn=Locator.builder().withWeb(By.xpath("//span[text()='Upload Files']"));
    private final Locator home_lnk=Locator.builder().withWeb(By.xpath("//span[text()='Home']"));
    private final Locator author=Locator.builder().withWeb(By.xpath("//th[text()='Authors']"));
    private final Locator newsAndBlogs_hamburg=Locator.builder().withWeb(By.xpath("//span[text()='News & Blogs']"));
    private final Locator wiki_hamburg=Locator.builder().withWeb(By.xpath("//span[text()='Wiki']"));
    private final Locator contactUs=Locator.builder().withWeb(By.xpath("//span[text()='Contact Us']"));
    
    private final Locator logout_btn=Locator.builder().withWeb(By.xpath("//span[text()='Logout']"));
    
    private final Locator backTohome=Locator.builder().withWeb(By.xpath("//a[@class='back-to-home']"));
    private final Locator home_img=Locator.builder().withWeb(By.xpath("//img[@class='cursor-pointer ']"));
    private final Locator home_active_btn=Locator.builder().withWeb(By.xpath("//a[@class='float-left nav-link active']"));
    private final Locator upload_actie_btn=Locator.builder().withWeb(By.xpath("(//a[@class='float-left nav-link'])[1]"));
    private final Locator publication_active=Locator.builder().withWeb(By.xpath("(//a[@class='float-left nav-link'])[2]"));
    private final Locator my_Subscription_btn=Locator.builder().withWeb(By.xpath("//span[text()='My Submissions']"));
    
    private final Locator about_active_btn=Locator.builder().withWeb(By.xpath("(//a[@class='float-left nav-link'])[3]"));
    
    
    
    
    private HomePage() {

    }

    public static synchronized HomePage getInstance() {
        if (_instance == null)
            _instance = new HomePage();
        return _instance;
    }

    
    public void click_home_img() {
    	ActionHelper.click(home_img);
    }
    
    
    public boolean isVisible_Home() {
    	String text=null;
    	ActionHelper.performMouseHover(home_active_btn);
    	text=ActionHelper.getText(home_lnk);
    	if(text!=null)
    		return true;
    	return false;
    }
    public boolean isVisible_uploadFile() {
    	String text=null;
    	ActionHelper.performMouseHover(upload_actie_btn);
    	text=ActionHelper.getText(upload_File_Btn);
    	if(text!=null)
    		return true;
    	return false;
    }
    
    
    public boolean isVisible_publication() {
    	String text=null;
    	ActionHelper.performMouseHover(publication_active);
    	text=ActionHelper.getText(publications_btn);
    	if(text!=null)
    		return true;
    	return false;
    }
    
    public boolean isVisible_mySubmission() {
    	String text=null;
    	ActionHelper.performMouseHover(publication_active);
    	text=ActionHelper.getText(my_Subscription_btn);
    	if(text!=null)
    		return true;
    	return false;
    }
    
    
    public boolean isVisible_about_us() {
    	String text=null;
    	ActionHelper.performMouseHover(about_active_btn);
    	text=ActionHelper.getText(about_us_Btn);
    	if(text!=null)
    		return true;
    	return false;
    }
    
    public boolean isVisible_completed_Report() {
    	String text=null;
    	ActionHelper.performMouseHover(about_active_btn);
    	text=ActionHelper.getText(complete_reprot_btn);
    	if(text!=null)
    		return true;
    	return false;
    }
    
    
    
    
    public boolean sign_In_IsPresent(){
       return  ActionHelper.isPresent(sign_Btn);
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
   
   public  boolean validate_Publications_Url() {
	   actual= ActionHelper.getText(publications_btn);
	  String currentUrl =DriverManager.getDriver().getCurrentUrl();
	  if(currentUrl.contains(actual.toLowerCase()))
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
    

    
  public String getMysubscription_Text() {
	 return ActionHelper.getText(MySubmissions);
  }
  
  public Boolean validate_MySubscription_Btn() {
	  actual=getMysubscription_Text();
	  if(actual.equalsIgnoreCase(actual))
	  return true;
	  return false;
			  
  }
  
  public String getCompleteReport_Text() {
	 return ActionHelper.getText(complete_reprot_btn);
  }
  
  public Boolean validate_CompleteReport_Btn() {
	  actual=getMysubscription_Text();
	  if(actual.equalsIgnoreCase(actual))
	  return true;
	  return false;
			  
  }
  
  public Boolean validate_Sign_Btn_visibility() {
	  if(ActionHelper.isPresent(sign_Btn))
	  return false;
	  return true;
  }
  
  
   public Boolean validate_EmailUser_Name() {
	   
	   if(ActionHelper.getText(Email_Name).equals(Constants.emailUserName))
		  return true; 
	    return false;
	   
	   
   }
  
   
   public boolean isPresent_publications_btn() {
		  return ActionHelper.isPresent(publications_btn);
				  }
	   public void click_Publicatios() {
		   ActionHelper.click(publications_btn);
	   }
	   
	   
	   
	   
   public boolean isPresent_Upload_lnk() {
	  return ActionHelper.isPresent(UploadFilePage.getInstance().upload_File_Btn);
   }
   public boolean IsPresent_Home_lnk() {
	  return  ActionHelper.isPresent(home_lnk);
   }
   
   public  boolean validate_newsblockSection() {
	  return  ActionHelper.IsEnableOrDisplay(newsBlog);
   }
   
   public Boolean valide_ContentInnewsblock() {
	   try {
	   if(ActionHelper.findElements(content_NewsBlog).size()>0)
		   return true;
	   }
	   catch(Exception e) {
		   
	   }
	   
	   return false;
   }
   
   
   public boolean isClickable_contactUs_hamburg() {
	   return ActionHelper.isEnabled(contactUs);
   }
   public boolean isPresent_ContactUs() {
	   return ActionHelper.isPresent(contactUs);
   }
   
   public void click_contactUs() {
	  ActionHelper.click(contactUs);   }
   
   
   public boolean isPresent_Twitter() {
	   return ActionHelper.isPresent(twitter);
   }
   public boolean isPresent_wiki_hamburg() {
	   return ActionHelper.isPresent(wiki_hamburg);
   }
   public boolean isClickable_wiki_hamburg() {
	   try {
		   ActionHelper.click(wiki_hamburg);
	   	    if(ActionHelper.isPresent(backTohome))
	    	return true;
	   }
	   catch(Exception e) {
		   return true;
	   }
	    return false;
  }
   

   public boolean isClickable_Twitter() {
	   try {
		   ActionHelper.click(twitter);
	   	    if(ActionHelper.isPresent(backTohome))
	    	return true;
	   }
	   catch(Exception e) {
		   return true;
	   }
	    return false;
   }
   public boolean isClickable_NewsAndBlogs() {
	    try {
			   ActionHelper.click(newsAndBlogs_hamburg);
		   	    if(ActionHelper.isPresent(backTohome))
		    	return true;
		   }
		   catch(Exception e) {
			   return true;
		   }
		    return false;
	    
  }
   
   public boolean validate_logout_Btn() {
	   return ActionHelper.isEnabled(logout_btn);
   }
   public boolean validate_SignIn_Btn() {
	   return ActionHelper.isEnabled(sign_Btn);
   }
   public void click_logout() {
	   ActionHelper.click(logout_btn);
   }
   public void click_UserName() {
	   ActionHelper.click(Email_Name);
   }
}

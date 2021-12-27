package pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import actions.ActionHelper;
import utils.Locator;

public class MySubmissionsPage {
	
	
	private static MySubmissionsPage _instance =null;
	
	
	private MySubmissionsPage() {
		
	}
	 public static synchronized MySubmissionsPage getInstance() {
	        if (_instance == null)
	            _instance = new MySubmissionsPage();
	        return _instance;
	    }
	
	 
	 private final Locator sample_lnk=Locator.builder().withWeb(By.xpath("//span[@class='cursor-pointer success-link text-decoration-underline']"));
	private final Locator sample_details_txt=Locator.builder().withWeb(By.xpath("//strong[text()='Sample Details']"));
	private final Locator popup_Contents=Locator.builder().withWeb(By.xpath("//table[@class='text-modal-detail Upload_sampleDetailsTable__2pX9N']/tr"));
	private final Locator croxx_Btn=Locator.builder().withWeb(By.xpath("//span//img[@data-nimg='intrinsic']"));
	private final Locator popUpContents_Key=Locator.builder().withWeb(By.xpath("//td[text()=':']/preceding-sibling::td"));
	private final Locator SampleName=Locator.builder().withWeb(By.xpath("(//td[text()=':']/following-sibling::td)[1]"));
	private final Locator submissios_date=Locator.builder().withWeb(By.xpath("(//td[text()=':']/following-sibling::td)[4]"));
	private final Locator subm_Date=Locator.builder().withWeb(By.xpath("(//span[contains(@class,'d-flex align-items-s')]/parent::td/following-sibling::td)[1]"));
	
	
	
	
	
	
	
	public void click_MySubmissions() {
		 ActionHelper.click(HomePage.MySubmissions);
	 }
	public void click_cross() {
		 ActionHelper.click(croxx_Btn);
	 }
	public void click_sample_lnk() {
		 ActionHelper.click(sample_lnk);
	 }
	public String get_sampleName() {
		return ActionHelper.getText(sample_lnk);
		 
	 }
	public String get_SampleName_PopUp() {
		return ActionHelper.getText(SampleName);
		 
	 }
	public String get_SumbDate() {
		return ActionHelper.getText(subm_Date);
		 
	 }
	public String get_SubmissionDate() {
		return ActionHelper.getText(submissios_date);
		 
	 }
	
	
	
	public boolean isPresent_DetailsHeader() {
		return ActionHelper.isPresent(sample_details_txt);
	}
	
	
	public boolean verify_popUp_Content() {
		List<WebElement> listOfContent = ActionHelper.findElements(popUpContents_Key);
		for(int i=0; i<listOfContent.size(); i++) {
			if(!(listOfContent.get(i).getText().equals(ActionHelper.getCommonString(Integer.toString(i))))) {
				System.out.println(listOfContent.get(i).getText());
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
	
	
	
}

// ---------------------------------------------------------------------------------------------------------------
// Test Description: Validates LinkedIn's Profile Page: Links, Title, Textboxes ...
// Created By: Jefry Denny
// Created On: January 12, 2016
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageProfile {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageProfile(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -------------- Properties -------------------------

	//Locator Text Link: Who's Viewed Your Profile
	@FindBy(css="a[href*='/wvmx/profile?trk=prof-sb-wvmp-more']")
	public WebElement txtViewedProfile;	
	
	//Locator Text Link: Profile Name 
	@FindBy(id="strength")
	public WebElement txtProfileStrength;	
	
	//Locator Text Link: Profile Name 
	@FindBy(id="name")
	public WebElement txtProfileName;	
	
	//Locator Text Link: Add Background Photo 
	@FindBy(id="backgroundImageFile")
	public WebElement lnkAddBackground;	
	
	//Locator Button: Change Photo 
	@FindBy(id="control_gen_4")
	public WebElement btnChangePhoto;
	
	//Locator Button: Change Photo 
	@FindBy(xpath="id('background-summary')/x:div[1]/x:h3")
	public WebElement lblProfileSummary;	
	

	//Locator Link: Discover More
//	@FindBy(css="a[href*='/pulse/discover?trk=prof-edit-following-discover-link']")
	@FindBy(xpath="html/body/div[8]/div/div[2]/div[1]/div[7]/div/a")
	public WebElement lnkProfileDiscoverMore;
	
	// -------------- Methods -------------------------

	//Method: 
	public String TextViewedProfile(){
		return txtViewedProfile.getText();
	}
	
	
	//Method: 
	public boolean IsDisplayedProfileStrength(){
		return txtProfileStrength.isDisplayed();
	}
	
	//Method: Validate the Text Displayed
	public String TextProfileStrength(){
		return txtProfileStrength.getText();
	}
	
	//Method: 
	public boolean IsDisplayedProfileName(){
		return txtProfileName.isDisplayed();
	}
	
	//Method:  
	public void clickLnkAddBackgroundPhoto() throws AssertionError {
		try {
			lnkAddBackground.click();
		} catch (AssertionError e) {
			
			System.out.println("Ooppss ... ");
		}
	}
	
	//Method:  
		public boolean isDisplayedAddBackgroundPhoto() throws AssertionError {
			try {
				lnkAddBackground.isDisplayed();
			} catch (AssertionError e){
				System.out.println("Ooppss ... ");
			}
			
			return lnkAddBackground.isDisplayed();
		}
	
	//Method: Link Click: Share an Update 
	public boolean isEnabledAddBackgroundPhoto(){
		return lnkAddBackground.isEnabled();
	}

	//Method: Link Click: Share an Update 
	public void clickBtnChangePhoto(){
		btnChangePhoto.click();
	}
	
	//Method: Link Click: Share an Update 
	public boolean isDisplayedSummary(){
		return lblProfileSummary.isDisplayed();
	}
	
	//Method: Link isEnabled: Discover More 
	public boolean isEnabledDiscoverMore(){
		return lnkProfileDiscoverMore.isEnabled();
	}
	
	//Method: Click Link: Discover More
	public void clickLnkDiscoverMore(){
		lnkProfileDiscoverMore.click();
	}
}

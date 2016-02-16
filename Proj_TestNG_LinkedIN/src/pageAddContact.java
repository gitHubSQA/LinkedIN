// ---------------------------------------------------------------------------------------------------------------
// Test Description: Validates LinkedIn's Add Contact Page: Links, Title, Textboxes ...
// Created By: Jefry Denny
// Created On: February 12, 2016
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageAddContact {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageAddContact(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -------------- Properties -------------------------

	//Locator Text Link: Who's Viewed Your Profile
	@FindBy(css="a[href*='nav_responsive_sub_nav_wvmp']")
	public WebElement lnkViewedProfile;	


	// -------------- Methods -------------------------
	
	//Method:  
		public void clickSubWhoViewedProfile() {
			
			
		}
	
}

// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Base Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: January 14, 2016 
// ---------------------------------------------------------------------------------------------------------------


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageBaseLinkedIn {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageBaseLinkedIn(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	// -------------- Properties -------------------------
	
	//Locator Logo: LinkedIn Logo 
	@FindBy(css="a[href*='nav_logo']")
	public WebElement lnkMainLogo;
	
	//Locator Menu: Home 
	@FindBy(css="a[href*='nav_responsive_tab_home']")
	public WebElement lnkMenuHome;
	
	//Locator Menu: Profile 
	@FindBy(css="a[href*='nav_responsive_tab_profile']")
	public WebElement lnkMenuProfile;
	
	//Locator Menu: Connections 
	@FindBy(css="a[href*='nav_responsive_tab_network']")
	public WebElement lnkMenuConnections;	
	
	//Locator Menu: Jobs
	@FindBy(css="a[href*='nav_responsive_sub_nav_jobs']")
	public WebElement lnkMenuJobs;		
		
	//Locator Menu: Interests 
	@FindBy(id="nav-link-interests")
	public WebElement lnkMenuInterests;	

	//Locator Interest Sub Menu: Companies  
	@FindBy(css="a[href*='nav_responsive_sub_nav_companies']")
	public WebElement lnkMenuInterestsCompanies;	
	
	
    //Locator Menu: Account-Settings Main Menu  
	@FindBy(css="a[href*='nav_responsive_tab_profile_pic']")
	public WebElement lnkMenuSettings;	

	//Locator Menu: Account-Settings Sign Out Menu  
	@FindBy(css="a[href*='nav_account_sub_nav_signout']")
	public WebElement lnkMenuSettingsSignOut;	

	
	// -------------- Methods -------------------------
	
	
	//Method: Click Main Logo 
		public void clickLinkMainLogo(){
			while (!lnkMainLogo.isDisplayed()){	
				lnkMainLogo.click();
			}
				lnkMainLogo.click();
		}
	
	//Method: Click Menu: Home 
	public void clickLinkMenuHome(){
		while (!lnkMenuHome.isDisplayed()){	
			lnkMenuHome.click();
		}
		
		lnkMenuHome.click();
	}
	
	//Method: Click Menu: Profile 
	public void clickLinkProfile(){
		lnkMenuProfile.click();
	}
	
	//Method: Click Menu: Connections 
	public void clickLinkConnections(){
		lnkMenuConnections.click();
	}
	
	//Method: Click Menu: Jobs 
	public void clickLinkJobs(){
		lnkMenuJobs.click();
	}
	
	//Method: Click Menu: Interests 
	public void clickLinkInterests(){
		while(lnkMenuInterests.isDisplayed()){
			lnkMenuInterests.click();
		}
	}
	
	//Method: Click Interests Menu: Companies 
	public void clickLinkInterestsCompanies(){
		lnkMenuInterestsCompanies.click();
	}
	
	//Method: Click Account-Settings Menu 
	public void clickLinkMenuSettings(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
	}
	
	//Method: Click Account-Settings Menu 
	public void clickLinkMenuSettingsSignOut(){
		while(lnkMenuSettingsSignOut.isEnabled()){
			lnkMenuSettingsSignOut.click();
		}
	}
	
	//Method: Click Account-Settings Menu 
	public void selectLinkMenuSettingsSignOut(){
		lnkMenuSettingsSignOut.isSelected();
	}
	
}

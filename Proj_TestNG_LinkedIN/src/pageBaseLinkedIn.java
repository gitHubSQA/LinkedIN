// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Base Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: February 11, 2016 
// Last Update:    Added function to hover over Main Menu: My Network and click Sub-Menu: Connections
// ---------------------------------------------------------------------------------------------------------------


import java.util.concurrent.TimeUnit;

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
	
	boolean iFlag = false;
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- LOCATORS -----------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//Locator Logo: LinkedIn Logo 
	@FindBy(id="in-logo")
	public WebElement lnkMainLogo;
	
	//Locator Menu: Home 
	@FindBy(css="a[href*='nav_responsive_tab_home']")
	public WebElement lnkMenuHome;
	
	// ********** MAIN MENU: Profile *****************
	
	//Locator MAIN Menu: Profile 
	@FindBy(css="a[href*='nav_responsive_tab_profile']")
	public WebElement lnkMenuProfile;
	
	//Locator SUB-Menu: Edit Profile 
	@FindBy(css="a[href*='nav_responsive_sub_nav_edit_profile']")
	public WebElement lnkSubMenuEditProfile;
	
	//Locator SUB-Menu: Who's Viewed Your Profile
	@FindBy(css="a[href*='nav_responsive_sub_nav_wvmp']")
	public WebElement lnkViewedProfile;	
	
	// ********** MAIN MENU: My Network *****************

	//Locator MAIN Menu: My Network 
	@FindBy(id="nav-link-network")
	public WebElement lnkMenuNetwork;	
	
	//Locator SUB-Menu: Connections 
	@FindBy(css="a[href*='nav_responsive_sub_nav_network']")
	public WebElement lnkSubMenuConnections;	
	
	//Locator Sub Menu: Add Contacts 
	@FindBy(css="a[href*='nav_responsive_sub_nav_add_connections']")
	public WebElement lnkSubMenuAddContact;	
	
	
	
	// ********** MAIN MENU: Jobs *****************

	//Locator Menu: Jobs
	@FindBy(css="a[href*='nav_responsive_sub_nav_jobs']")
	public WebElement lnkMenuJobs;		
		

	// ********** MAIN MENU: Interests *****************
	
	//Locator Menu: Interests 
	@FindBy(id="nav-link-interests")
	public WebElement lnkMenuInterests;	

	//Locator Interest Sub Menu: Companies  
	@FindBy(css="a[href*='nav_responsive_sub_nav_companies']")
	public WebElement lnkMenuInterestsCompanies;	
	
	
	
	// ********** MAIN MENU: Account - Settings *****************	
	
    //Locator Menu: Account-Settings Main Menu  
	@FindBy(css="a[href*='nav_responsive_tab_profile_pic']")
	public WebElement lnkMenuSettings;	

	//Locator Menu: Account-Settings Sign Out Menu  
	@FindBy(css="a[href*='nav_account_sub_nav_signout']")
	public WebElement lnkMenuSettingsSignOut;	

	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- METHODS ------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//Method: Click Main Logo 
		public void clickLinkMainLogo(WebDriver driver){
			while (! lnkMainLogo.isEnabled()){	
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
				lnkMainLogo.click();

		}
	
	//Method: Click MAIN Menu: HOME 
	public void clickLinkMenuHome(WebDriver driver){
		while (! lnkMenuHome.isDisplayed()){	
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		
		lnkMenuHome.click();
	}
	
	
	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: PROFILE
	//------------------------------------------------------------------------------------------------------------
	
	//Method: Click MAIN Menu: PROFILE 
	public void clickLinkProfile(){
		lnkMenuProfile.click();
	}
	

	//Method: Click Sub Menu: WHO'S VIEWED YOUR PROFILE
	public void clickSubWhoViewedProfile(WebDriver driver) {
		//Conditional Loop: Waits for 
//		while(! lnkMenuProfile.isEnabled()){
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuProfile).click().build().perform();
		lnkViewedProfile.click();
		
		// Wait for page to completely load ... how?
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
		


	
// **********	
	
	
	//Method: Click Network Menu: Sub Menu: Connections 
	public void clickLinkConnections(WebDriver driver){
		Actions builder = new Actions(driver);
		//NOTE: This works only if the MAIN Menu is not click-able.
		builder.moveToElement(lnkMenuNetwork).click().build().perform();
		lnkSubMenuConnections.click();
		
		// Wait for page to completely load ... how?
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Network Menu: Sub Menu: Add Contacts 
	public void clickSubAddContact(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuNetwork).click().build().perform();
		lnkSubMenuAddContact.click();
		
		// Wait for selected page to completely load ... how?
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	//Method: Click Menu: Jobs 
	public void clickLinkJobs(){
		lnkMenuJobs.click();
	}
	
	//Method: Click Menu: Interests 
	public void clickLinkInterests(WebDriver driver){
//		while(! lnkMenuInterests.isDisplayed()){
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuInterests).click().build().perform();	
		lnkMenuInterests.click();				
	}
	
	//Method: Click Interests Menu: Companies 
	public void clickLinkInterestsCompanies(WebDriver driver){
			lnkMenuInterestsCompanies.click();
	}
	
	//Method: Click Account-Settings Menu 
	public void clickLinkMenuSettings(WebDriver driver){
		while(! lnkMenuSettings.isEnabled()){
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
	}
	
	//Method: Click Account-Settings Menu -> Sign Out
	public void clickLinkMenuSettingsSignOut(WebDriver driver){
//		while(! lnkMenuSettings.isDisplayed()){
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
		lnkMenuSettingsSignOut.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// INSERT A BOOL FLAG Here 
		
	}
	
	
}

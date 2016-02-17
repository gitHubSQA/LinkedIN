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
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- PROPERTIES ---------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
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

	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- MY NETWORK ---------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	//Locator MAIN Menu: My Network 
	@FindBy(id="nav-link-network")
	public WebElement lnkMenuNetwork;	
	
	//Locator SUB-Menu: Connections 
	@FindBy(css="a[href*='nav_responsive_sub_nav_network']")
	public WebElement lnkSubMenuConnections;	
	
	//Locator Sub Menu: Add Contacts 
	@FindBy(css="a[href*='nav_responsive_sub_nav_add_connections']")
	public WebElement lnkSubMenuAddContact;	
	
	//Locator Sub Menu: People You May Know 
	@FindBy(css="a[href*='nav_responsive_sub_nav_pymk']")
	public WebElement lnkSubMenuPeopleYouKnow;	
	
	//Locator Sub Menu: Find Alumni 
	@FindBy(css="a[href*='nav_responsive_sub_nav_find_alumni']")
	public WebElement lnkSubMenuFindAlumni;	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- JOBS ---------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	//Locator Menu: Jobs
	@FindBy(css="a[href*='nav_responsive_sub_nav_jobs']")
	public WebElement lnkMenuJobs;		
		


	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- INTERESTS ----------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//Locator Menu: Interests 
	@FindBy(id="nav-link-interests")
	public WebElement lnkMenuInterests;	

	//Locator Interest Sub Menu: Companies  
	@FindBy(css="a[href*='nav_responsive_sub_nav_companies']")
	public WebElement lnkMenuInterestsCompanies;	
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- ACCOUNTS - SETTINGS ------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
    //Locator Menu: Account-Settings Main Menu  
	@FindBy(css="a[href*='nav_responsive_tab_profile_pic']")
	public WebElement lnkMenuSettings;	

	//Locator Menu: Account-Settings Sign Out Menu  
	@FindBy(css="a[href*='nav_account_sub_nav_signout']")
	public WebElement lnkMenuSettingsSignOut;	

	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- METHODS ------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	// Method: Logo 
	// Step 1: Condition: Logo is enabled on the screen	
	// Step 2: Click on the main logo
	// Step 3: Wait for 5 Seconds (temporary sync solution)
		public void clickLinkMainLogo(WebDriver driver){
			while (! lnkMainLogo.isEnabled()){	
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
				lnkMainLogo.click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	// Method: MAIN Menu: HOME 
	// Step 1: Condition: Home link is displayed on the screen	
	// Step 2: Click Main Menu: Home
	// Step 3: Wait for 5 Seconds (temporary sync solution)
	public void clickLinkMenuHome(WebDriver driver){
		while (! lnkMenuHome.isDisplayed()){	
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}		
		lnkMenuHome.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: PROFILE  ******* Note: Needs to be fixed
	//------------------------------------------------------------------------------------------------------------
	
	//Method: Click MAIN Menu: PROFILE 
	public void clickLinkProfile(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuProfile).click().build().perform();
		lnkMenuProfile.click();
	}

	//Method: Click Sub Menu: WHO'S VIEWED YOUR PROFILE
	public void clickSubWhoViewedProfile(WebDriver driver) {
		lnkViewedProfile.click();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
		
		

	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: MY NETWORKS
	//------------------------------------------------------------------------------------------------------------
	
	
	//NOTE: This works only if the MAIN Menu is not click-able.
	
	// Method: Click Main Menu: My Networks 
	// Step 1: New instance of Class Action
	// Step 2: Move to specified element, then click
	// Step 3: Click Link
	public void clickMainMyNetworks(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuNetwork).click().build().perform();
		lnkMenuNetwork.click();	
	}
	
	// Method: Click Network Menu: Sub Menu: Connections
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	public void clickSubConnections(WebDriver driver){
		lnkSubMenuConnections.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	// Method: Click Network Menu: Sub Menu: Add Contacts 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	public void clickSubAddContact(WebDriver driver){
		lnkSubMenuAddContact.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	// Method: Click Network Menu: Sub Menu: People You May Know
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution )
	public void clickSubPeopleYouKnow(WebDriver driver){
		lnkSubMenuPeopleYouKnow.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}	
	
	// Method: Click Network Menu: Sub Menu: Find Alumni
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	public void clickSubFindAlumni(WebDriver driver){
		lnkSubMenuFindAlumni.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}		

	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: JOBS
	//------------------------------------------------------------------------------------------------------------

	// Method: Click Main Menu: Jobs
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	public void clickLinkJobs(WebDriver driver){
		lnkMenuJobs.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Menu: Interests 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	public void clickLinkInterests(WebDriver driver){		
		lnkMenuInterests.click();				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Interests Menu: Companies 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	public void clickLinkInterestsCompanies(WebDriver driver){
			lnkMenuInterestsCompanies.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: ACCOUNT-SETTINGS
	//------------------------------------------------------------------------------------------------------------	
	
	// Method: Account-Settings Menu 
	// Step 1: Click Account-Settings
	public void clickLinkMenuSettings(WebDriver driver){
		while(! lnkMenuSettings.isEnabled()){
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
	}

	
	// Method: Click Account-Settings Menu -> Sign Out
	// Step 1: Click Sign Out
	// Step 2: Wait for 5 Seconds (temporary sync solution)	
	public void clickLinkMenuSettingsSignOut(WebDriver driver){
		lnkMenuSettingsSignOut.click();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// INSERT A BOOL FLAG Here 
		
	}
	
	
}

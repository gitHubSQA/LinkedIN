// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Base Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: February 11, 2016 
// Last Update:    Added function to hover over Main Menu: My Network and click Sub-Menu: Connections
// ---------------------------------------------------------------------------------------------------------------

import java.util.List;
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
	private WebElement lnkMainLogo;
	
	//Locator Menu: Home 
	@FindBy(css="a[href*='nav_responsive_tab_home']")
	protected WebElement lnkMenuHome;
	
	// ********** MAIN MENU: Profile *****************
	
	//Locator MAIN Menu: Profile 
	@FindBy(css="a[href*='nav_responsive_tab_profile']")
	private WebElement lnkMenuProfile;
	
	//Locator SUB-Menu: Edit Profile 
	@FindBy(css="a[href*='nav_responsive_sub_nav_edit_profile']")
	private WebElement lnkSubMenuEditProfile;
	
	//Locator SUB-Menu: Who's Viewed Your Profile
	@FindBy(css="a[href*='nav_responsive_sub_nav_wvmp']")
	private WebElement lnkViewedProfile;	

	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- MY NETWORK ---------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	//Locator MAIN Menu: My Network 
	@FindBy(id="nav-link-network")
	private WebElement lnkMenuNetwork;	
	
	//Locator SUB-Menu: Connections 
	@FindBy(css="a[href*='nav_responsive_sub_nav_network']")
	private WebElement lnkSubMenuConnections;	
	
	//Locator Sub Menu: Add Contacts 
	@FindBy(css="a[href*='nav_responsive_sub_nav_add_connections']")
	private WebElement lnkSubMenuAddContact;	
	
	//Locator Sub Menu: People You May Know 
	@FindBy(css="a[href*='nav_responsive_sub_nav_pymk']")
	private WebElement lnkSubMenuPeopleYouKnow;	
	
	//Locator Sub Menu: Find Alumni 
	@FindBy(css="a[href*='nav_responsive_sub_nav_find_alumni']")
	private WebElement lnkSubMenuFindAlumni;	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- JOBS ---------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	//Locator Menu: Jobs
	@FindBy(css="a[href*='nav_responsive_sub_nav_jobs']")
	private WebElement lnkMenuJobs;		
		


	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- INTERESTS ----------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//Locator Menu: Interests 
	@FindBy(id="nav-link-interests")
	private WebElement lnkMenuInterests;	

	//Locator Interest Sub Menu: Companies  
	@FindBy(css="a[href*='nav_responsive_sub_nav_companies']")
	private WebElement lnkMenuInterestsCompanies;
	
	//Locator Interest Sub Menu: Groups  
	@FindBy(css="a[href*='nav_responsive_sub_nav_groups']")
	private WebElement lnkMenuInterestsGroups;
	
	//Locator Interest Sub Menu: Pulse  
	@FindBy(css="a[href*='nav_responsive_sub_nav_pulse']")
	private WebElement lnkMenuInterestsPulse;
	
	//Locator Interest Sub Menu: Education  
	@FindBy(css="a[href*='nav_responsive_sub_nav_edu']")
	private WebElement lnkMenuInterestsEducation;
	
	//Locator Interest Sub Menu: SlideShare  
	@FindBy(css="a[href*='nav_responsive_sub_nav_slideshare']")
	private WebElement lnkMenuInterestsSlideShare;
	
	//Locator Interest Sub Menu: Online Learning
	@FindBy(css="a[href*='nav_responsive_sub_nav_lynda']")
	private WebElement lnkMenuInterestsOnlineLearning;
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- ACCOUNTS - SETTINGS ------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
    //Locator Menu: Account-Settings Main Menu  
	@FindBy(css="a[href*='nav_responsive_tab_profile_pic']")
	private WebElement lnkMenuSettings;	

	//Locator Menu: Account-Settings Sign Out Menu  
	@FindBy(css="a[href*='nav_account_sub_nav_signout']")
	private WebElement lnkMenuSettingsSignOut;	

	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- METHODS ------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	// Method: Logo 
	// Step 1: Condition: Logo is enabled on the screen	
	// Step 2: Click on the main logo
	// Step 3: Wait for 5 Seconds (temporary sync solution)
	protected void clickLinkMainLogo(WebDriver driver){
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
	protected void clickLinkMenuHome(WebDriver driver){
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
	protected void clickLinkProfile(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuProfile).click().build().perform();
		lnkMenuProfile.click();
	}

	//Method: Click Sub Menu: WHO'S VIEWED YOUR PROFILE
	protected void clickSubWhoViewedProfile(WebDriver driver) {
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
	protected void clickMainMyNetworks(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuNetwork).click().build().perform();
		lnkMenuNetwork.click();	
	}
	
	// Method: Click Network Menu: Sub Menu: Connections
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubConnections(WebDriver driver){
		lnkSubMenuConnections.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	// Method: Click Network Menu: Sub Menu: Add Contacts 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubAddContact(WebDriver driver){
		lnkSubMenuAddContact.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	// Method: Click Network Menu: Sub Menu: People You May Know
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution )
	protected void clickSubPeopleYouKnow(WebDriver driver){
		lnkSubMenuPeopleYouKnow.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}	
	
	// Method: Click Network Menu: Sub Menu: Find Alumni
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubFindAlumni(WebDriver driver){
		lnkSubMenuFindAlumni.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}		

	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: JOBS
	//------------------------------------------------------------------------------------------------------------

	// Method: Click Main Menu: Jobs
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickLinkJobs(WebDriver driver){
		lnkMenuJobs.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: INTERESTS
	//------------------------------------------------------------------------------------------------------------
	
	//Method: Click Menu: Interests 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickMainInterests(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuInterests).click().build().perform();	
		lnkMenuInterests.click();				
	}
	
	//Method: Click Interests Menu: Companies 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubCompanies(WebDriver driver){
		lnkMenuInterestsCompanies.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Interests Menu: Groups 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubGroups(WebDriver driver){
		lnkMenuInterestsGroups.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Interests Menu: Pulse 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubPulse(WebDriver driver){
		lnkMenuInterestsPulse.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Interests Menu: Education 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	protected void clickSubEducation(WebDriver driver){
		lnkMenuInterestsEducation.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Method: Click Interests Menu: SlideShare 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	// Step 3: Switch to New Window and extract the Page Title 
	// Step 4: Close the New Window
	// Step 5: Switch back to the Main Window
	// Step 6: Return the New Window's Title 
	protected String clickSubSlideShare(WebDriver driver){
		lnkMenuInterestsSlideShare.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String winMainHandle = driver.getWindowHandle();
		String winNewHandleTitle = "";
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            winNewHandleTitle = driver.getTitle();
        }
        
        driver.close();
     
        driver.switchTo().window(winMainHandle);
        
        return winNewHandleTitle;
	}
	
	//Method: Click Interests Menu: Online Learning 
	// Step 1: Click Link
	// Step 2: Wait for 5 Seconds (temporary sync solution)
	// Step 3: Switch to New Window and extract the Page Title 
	// Step 4: Close the New Window
	// Step 5: Switch back to the Main Window
	// Step 6: Return the New Window's Title 
	protected String clickSubOnlineLearning(WebDriver driver){
		lnkMenuInterestsOnlineLearning.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String winMainHandle = driver.getWindowHandle();
		String winNewHandleTitle = "";
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            winNewHandleTitle = driver.getTitle();
        }
        
        driver.close();
     
        driver.switchTo().window(winMainHandle);
        
        return winNewHandleTitle;
	}
	
	//------------------------------------------------------------------------------------------------------------
	// MAIN MENU: ACCOUNT-SETTINGS
	//------------------------------------------------------------------------------------------------------------	
	
	// Method: Account-Settings Menu 
	// Step 1: Click Account-Settings
	protected void clickLinkMenuSettings(WebDriver driver){
		while(! lnkMenuSettings.isEnabled()){
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
	}

	
	// Method: Click Account-Settings Menu -> Sign Out
	// Step 1: Click Sign Out
	// Step 2: Wait for 5 Seconds (temporary sync solution)	
	protected void clickLinkMenuSettingsSignOut(WebDriver driver){
		lnkMenuSettingsSignOut.click();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// INSERT A BOOL FLAG Here 
		
	}
	
	
}

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
	
	//Locator Logo: LinkedIn Logo 
	//@FindBy(css="a[href*='nav_logo']")
	@FindBy(id="in-logo")
	public WebElement lnkMainLogo;
	
	//Locator Menu: Home 
	@FindBy(css="a[href*='nav_responsive_tab_home']")
	public WebElement lnkMenuHome;
	
	//Locator Menu: Profile 
	@FindBy(css="a[href*='nav_responsive_tab_profile']")
	public WebElement lnkMenuProfile;
	
	//Locator Menu: My Network 
	//@FindBy(css="a[href*='nav_responsive_tab_network']")
	@FindBy(id="nav-link-network")
	public WebElement lnkMenuNetwork;	
	
	//Locator Sub Menu: Connections 
	//@FindBy(css="a[href*='nav_responsive_tab_network']")
	@FindBy(css="a[href*='nav_responsive_sub_nav_network']")
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
		public void clickLinkMainLogo(WebDriver driver){
			while (!lnkMainLogo.isDisplayed()){	
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
				lnkMainLogo.click();

		}
	
	//Method: Click Menu: Home 
	public void clickLinkMenuHome(WebDriver driver){
		while (!lnkMenuHome.isDisplayed()){	
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		
		lnkMenuHome.click();
	}
	
	//Method: Click Menu: Profile 
	public void clickLinkProfile(){
		lnkMenuProfile.click();
	}
	
	//Method: Click Network Menu: Sub Menu: Connections 
	public void clickLinkConnections(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuNetwork).click().build().perform();
		lnkMenuConnections.click();
		
		// Wait for page to completely load ... how?
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	//Method: Click Menu: Jobs 
	public void clickLinkJobs(){
		lnkMenuJobs.click();
	}
	
	//Method: Click Menu: Interests 
	public void clickLinkInterests(WebDriver driver){
		while(! lnkMenuInterests.isDisplayed()){
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuInterests).click().build().perform();	
		lnkMenuInterests.click();
		
		iFlag = true;
				
	}
	
	//Method: Click Interests Menu: Companies 
	public void clickLinkInterestsCompanies(WebDriver driver){
			lnkMenuInterestsCompanies.click();
	}
	
	//Method: Click Account-Settings Menu 
	public void clickLinkMenuSettings(WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
	}
	
	//Method: Click Account-Settings Menu -> Sign Out
	public void clickLinkMenuSettingsSignOut(WebDriver driver){
		while(! lnkMenuSettings.isDisplayed()){
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(lnkMenuSettings).click().build().perform();	
		lnkMenuSettingsSignOut.click();
	}
	

	public void lnkMenuConnections() {
		// TODO Auto-generated method stub
		
	}
	
}

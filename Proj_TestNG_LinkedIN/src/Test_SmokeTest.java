// ---------------------------------------------------------------------------------------------------------------
// Test Description: Clicks and Validates the Title Page each Major Link Menu
// Created By: Jefry Denny
// Created On: December 9, 2015
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import bsh.This;

public class Test_SmokeTest{

	// Declaration of Variables
	// Creation of Instances
	
	int iCounter = 1;
	
	//Create an instance of the WebDriver for Firefox
	WebDriver driver = new FirefoxDriver();
			
	//Create an instance of the LoginPage.
	pageLinkedSignIn pagelogin = new pageLinkedSignIn(driver);
	
	//Create an instance of the pageMenuLinkedIn.
	pageBaseLinkedIn pagemenu = new pageBaseLinkedIn(driver);
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- TESTS --------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	@BeforeMethod
	public void openBrowser(){
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
	}
	
	// TEST      : Validate 
	// STEP 1    : Enter Username
	// STEP 2    : Enter Password
	// STEP 3    : Click Button: Sign in 
	// VALIDATION: Title Page
	@Test(priority=1)
	public void POS_Test_SignIn() {		
		pagelogin.setTxtUserName();
		pagelogin.setTxtPassWord();
		pagelogin.clickSignIn();
		Assert.assertEquals(driver.getTitle(), "Welcome! | LinkedIn");	
	}
	
	// TEST      : Validate 
	// STEP 1    : Select Main Menu: Jobs
	// VALIDATION: Title Page	
	@Test (priority=2)
	public void POS_Test_SelectJobs(){
		pagemenu.clickLinkJobs(driver);
		Assert.assertEquals(driver.getTitle(), "Jobs Home | LinkedIn"); 
	}
	
	// TEST      : Validate 
	// STEP 1    : Select Main Menu: Profile
	// VALIDATION: Title Page	
	@Test (priority=3)
	public void POS_Test_SelectProfile(){
		pagemenu.clickLinkProfile(driver);	
		Assert.assertEquals(driver.getTitle(), "Edit Profile | LinkedIn");
	}

	// TEST      : Validate 
	// STEP 1    : Select Main Menu: My Network
	// STEP 2    : Select Sub-Menu: Connections
	// VALIDATION: Title Page	
	@Test (priority=4)
	public void POS_Test_SelectConnections(){
		pagemenu.clickMainMyNetworks(driver);
		pagemenu.clickSubConnections(driver);	
		Assert.assertEquals(driver.getTitle(), "Contacts | LinkedIn");
	}
	
	// TEST      : Validate 
	// STEP 1    : Select Main Menu: Home
	// VALIDATION: Title Page
	@Test (priority=5)
	public void POS_Test_SelectHome(){
		pagemenu.clickLinkMenuHome(driver);	
		Assert.assertEquals(driver.getTitle(), "Welcome! | LinkedIn");
	}
	
	// TEST      : Validate 
	// STEP 1    : Select Main Menu: Interests
	// STEP 2    : Select Sub-Menu: Companies
	// VALIDATION: Title Page	
	@Test (priority=6)
	public void POS_Test_SelectInterests(){
		pagemenu.clickLinkInterests(driver);	
		pagemenu.clickLinkInterestsCompanies(driver);
		Assert.assertEquals(driver.getTitle(), "Companies | LinkedIn");;
	}

	// TEST      : Validate 
	// STEP 1    : Select Main Menu: Account-Settings
	// STEP 2    : Select Sub-Menu: Sign Out
	// VALIDATION: Title Page	
	@Test (priority=7)
	public void POS_Test_SignOut(){		
		pagemenu.clickLinkMenuSettings(driver);
		pagemenu.clickLinkMenuSettingsSignOut(driver);
		Assert.assertEquals(driver.getTitle(), "Signed Out | LinkedIn");
	}
	
	@AfterMethod
	public void displayCounter(){
		System.out.println(iCounter + "- Test Completed");
		iCounter++;
	}
	
	@AfterSuite
	public void minimizeBrowser(){
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
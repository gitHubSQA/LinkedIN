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
	
	
	// ------------- Tests ----------------------------------------------------------

	@BeforeMethod
	public void openBrowser(){
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void POS_Test_SignIn() {		
		pagelogin.setTxtUserName();
		pagelogin.setTxtPassWord();
		pagelogin.clickSignIn();
		Assert.assertEquals(driver.getTitle(), "Welcome! | LinkedIn");
		
	}
	
	@Test (priority=2)
	public void POS_Test_SelectJobs(){
		pagemenu.clickLinkJobs();
//		WebElement testme = driver.findElement(By.xpath("id('main-site-nav')/x:ul/x:li[4]/x:a"));
//		Assert.assertEquals(true, testme.isDisplayed());
		Assert.assertEquals(driver.getTitle(), "Jobs Home | LinkedIn"); //("Assertion: Title: Jobs", driver.getTitle(), "Jobs Home | LinkedIn");

	}
	
	@Test (priority=3)
	public void POS_Test_SelectProfile(){
		pagemenu.clickLinkProfile();	
		Assert.assertEquals(driver.getTitle(), "Edit Profile | LinkedIn");

	}
	
	@Test (priority=4)
	public void POS_Test_SelectConnections(){
		pagemenu.clickLinkConnections();	
		Assert.assertEquals(driver.getTitle(), "Contacts | LinkedIn");

	}
	
	@Test (priority=5)
	public void POS_Test_SelectHome(){
		pagemenu.clickLinkMenuHome();	
		Assert.assertEquals(driver.getTitle(), "Welcome! | LinkedIn");

	}
	
	@Test (priority=6)
	public void POS_Test_SelectInterests(){
		//STEP 1: Select Interests
		pagemenu.clickLinkInterests();	
		//STEP 2: Select Companies from the sub-menu
		pagemenu.clickLinkInterestsCompanies();
		//VALIDATION: Title Page
		Assert.assertEquals(driver.getTitle(), "Companies | LinkedIn");;

	}
	
	@Test (priority=7)
	public void POS_Test_SignOut(){
		
		pagemenu.clickLinkMenuSettings(driver);
		pagemenu.clickLinkMenuSettingsSignOut();
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
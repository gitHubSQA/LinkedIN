// ---------------------------------------------------------------------------------------------------------------
// Test Description: Sign In and Sign Out successfully
// Created By: Jefry Denny
// Created On: December 9, 2015
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------

import java.util.concurrent.TimeUnit;
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

public class Test_SignIn_Pass{

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
	
	
	@Test (priority=2, enabled = false)
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
	
	@AfterSuite(enabled = false)
	public void closeBrowser(){
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
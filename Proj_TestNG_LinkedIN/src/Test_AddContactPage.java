//---------------------------------------------------------------------------------------------------------------
//Test Description: Validates LinkedIn's Who's Viewed Your Profile Page: Links, Title, Textboxes ...
//Created By: Jefry Denny
//Created On: February 12, 2016
//Last Update By: 
//Last Update On: 
//---------------------------------------------------------------------------------------------------------------
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.*;

import org.apache.commons.io.FileUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.File;

import org.eclipse.jetty.util.log.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.testng.ITestResult;


public class Test_AddContactPage {
	
	// Declaration of Variables		
	int iCounter = 1;
	
	// ********* Creation of Instances
	//Create an instance of the WebDriver for Firefox
	WebDriver driver = new FirefoxDriver();
	
	//Create an instance of the Sign In Page.
	pageLinkedSignIn pageLogin = new pageLinkedSignIn(driver);
		
	//Create an instance of the pageMenuLinkedIn.
	pageBaseLinkedIn pageMenu = new pageBaseLinkedIn(driver);
		
	//Create an instance of the pageWhoViewedProfilePage.
	pageWhoViewedProfile pagewhoviewedprofile = new pageWhoViewedProfile(driver);
	

	// ********* End Creation of Instances
	
	// ********* Annotations

	@BeforeClass
	public void openBrowser(){
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();

		//Sign In
		pageLogin.setTxtUserName();
		pageLogin.setTxtPassWord();
		pageLogin.clickSignIn();
		Assert.assertEquals(driver.getTitle(), "Welcome! | LinkedIn");
	}
	
	// TEST 1: 
		@Test(priority=2, enabled=true)
		public void POS_TEST_SelectAddContactPage() {
			//STEP 1: Select My Network Sub-Menu: Add Contact
			pageMenu.clickSubAddContact(driver);
			//VALIDATION: Title
			Assert.assertEquals(driver.getTitle(), "Import Contacts and Invite | LinkedIn");
			
		}
	
	
	@AfterMethod
	public void displayCounter(ITestResult testResult) throws IOException{
		//This is some sort of a delay - it helps the script to pass due to sync issue.
		//I need to find a better handler **************

		if(testResult.getStatus() == ITestResult.FAILURE){
			System.out.println("Test_" + Integer.toString(iCounter) + " -- FAILED: " + testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\FAIL_"  + testResult.getName() + "_testScreenshot.jpg"));
		}
		
		System.out.println(Integer.toString(iCounter) + "- Test Completed");
		iCounter++;
		
		//BASE STATE: Go Back
		pageMenu.clickLinkMainLogo(driver);
	}
	
	@AfterClass
	public void closeBrowser(){
		//Return to Base State
		pageMenu.clickLinkMainLogo(driver);
		
		//Sign Out
		pageMenu.clickLinkMenuSettingsSignOut(driver);
		Assert.assertEquals(driver.getTitle(), "Signed Out | LinkedIn");
		
		//Clean and Close Browser
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
}


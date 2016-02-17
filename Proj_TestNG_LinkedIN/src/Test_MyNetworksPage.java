//---------------------------------------------------------------------------------------------------------------
//Test Description: Clicks and Validates My Networks each Sub Menu
//Created By: Jefry Denny
//Created On: February 17, 2016
//Last Update By: 
//Last Update On: 
//---------------------------------------------------------------------------------------------------------------

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import bsh.This;

public class Test_MyNetworksPage{

	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- VARIABLES ----------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	int iCounter = 1;

	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- INSTANCES ----------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------	
	
	//Create an instance of the WebDriver for Firefox
	WebDriver driver = new FirefoxDriver();
			
	//Create an instance of the LoginPage.
	pageLinkedSignIn pagelogin = new pageLinkedSignIn(driver);
	
	//Create an instance of the pageMenuLinkedIn.
	pageBaseLinkedIn pagemenu = new pageBaseLinkedIn(driver);
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- BEFORE TESTS -------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	// METHOD 1   : OPEN BROWSER
	// METHOD 2   : SIGN IN 	
	// METHOD 3   : VALIDATE TITLE 
	@BeforeClass
	public void openBrowser(){
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
	
		pagelogin.setTxtUserName();
		pagelogin.setTxtPassWord();
		pagelogin.clickSignIn();

		Assert.assertEquals(driver.getTitle(), "Welcome! | LinkedIn");	
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- START TESTS --------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	// TEST      : SELECTS MY NETWORK'S SUB MENU: CONNECTIONS 
	// STEP 1    : SELECT MAIN MENU: MY NETWORK
	// STEP 2    : SELECT SUB-MENU: CONNECTIONS
	// VALIDATION: TITLE PAGE	
	@Test (priority=1, enabled=true)
	public void POS_Test_SelectConnections(){
		pagemenu.clickMainMyNetworks(driver);
		pagemenu.clickSubConnections(driver);	
		Assert.assertEquals(driver.getTitle(), "Contacts | LinkedIn");
	}
	
	// TEST      : SELECTS MY NETWORK'S SUB MENU: ADD CONTACTS  
	// STEP 1    : SELECT MAIN MENU: MY NETWORK
	// STEP 2    : SELECT SUB-MENU: ADD CONTACTS
	// VALIDATION: TITLE PAGE
	@Test (priority=2, enabled=true)
	public void POS_Test_SelectAddContacts(){
		pagemenu.clickMainMyNetworks(driver);
		pagemenu.clickSubAddContact(driver);	
		Assert.assertEquals(driver.getTitle(), "Import Contacts and Invite | LinkedIn");
	}
	
	// TEST      : SELECTS MY NETWORK'S SUB MENU: PEOPLE YOU MAY KNOW 
	// STEP 1    : SELECT MAIN MENU: MY NETWORK
	// STEP 2    : SELECT SUB-MENU: PEOPLE YOU MAY KNOW
	// VALIDATION: TITLE PAGE	
	@Test (priority=3, enabled=true)
	public void POS_Test_SelectPeopleYouKnow(){
		pagemenu.clickMainMyNetworks(driver);
		pagemenu.clickSubPeopleYouKnow(driver);
		Assert.assertEquals(driver.getTitle(), "People You May Know | LinkedIn");
	}

	// TEST      : SELECTS MY NETWORK'S SUB MENU: FIND ALUMNI 
	// STEP 1    : SELECT MAIN MENU: MY NETWORK
	// STEP 2    : SELECT SUB-MENU: FIND ALUMNI
	// VALIDATION: TITLE PAGE	
	@Test (priority=4, enabled=true)
	public void POS_Test_SelectFindAlumni(){
		pagemenu.clickMainMyNetworks(driver);
		pagemenu.clickSubFindAlumni(driver);
		Assert.assertEquals(driver.getTitle(), "Vanier College | LinkedIn");
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- END TESTS ----------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	// METHOD 1    : AFTER-METHOD: CONDITION: PASS OR FAIL (TAKES A SCREENSHOT)
	// METHOD 2    : PRINTS ON SCREEN AND INCREMENT COUNTER
	// METHOD 3    : GO BACK TO BASE STATE
	@AfterMethod
	public void displayCounter(ITestResult testResult) throws IOException{

		if(testResult.getStatus() == ITestResult.FAILURE){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\FAIL_"  + testResult.getName() + "_testScreenshot.jpg"));
			System.out.println(Integer.toString(iCounter) + "- Test Completed - FAILED");
		}
		
		System.out.println(Integer.toString(iCounter) + "- Test Completed - PASSED");
		iCounter++;
		
		pagemenu.clickLinkMainLogo(driver);
	}
	
	// METHOD 1    : SIGN OUT AND VALIDATE TITLE
	// METHOD 2    : DELETE ALL COOKIES AND CLOSE BROWSER
	@AfterClass
	public void closeBrowser(){
		
		pagemenu.clickLinkMenuSettings(driver);
		pagemenu.clickLinkMenuSettingsSignOut(driver);
		Assert.assertEquals(driver.getTitle(), "Signed Out | LinkedIn");

		driver.manage().deleteAllCookies();
		driver.close();
	}
}
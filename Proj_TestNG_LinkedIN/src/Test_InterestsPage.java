//---------------------------------------------------------------------------------------------------------------
//Test Description: Clicks and Validates Interests each Sub Menu
//Created By: Jefry Denny
//Created On: February 18, 2016
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

public class Test_InterestsPage{

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

	// TEST      : SELECTS INTERESTS' SUB MENU: COMPANIES 
	// STEP 1    : SELECT MAIN MENU: INTERESTS
	// STEP 2    : SELECT SUB-MENU: COMPANIES
	// VALIDATION: TITLE PAGE	
	@Test (priority=1, enabled=true)
	public void POS_Test_SelectCompanies(){
		pagemenu.clickMainInterests(driver);
		pagemenu.clickSubCompanies(driver);	
		Assert.assertEquals(driver.getTitle(), "Companies | LinkedIn");
	}
	
	// TEST      : SELECTS INTERESTS' SUB MENU: GROUPS  
	// STEP 1    : SELECT MAIN MENU: INTERESTS
	// STEP 2    : SELECT SUB-MENU: GROUPS
	// VALIDATION: TITLE PAGE
	@Test (priority=2, enabled=true)
	public void POS_Test_SelectGroups(){
		pagemenu.clickMainInterests(driver);
		pagemenu.clickSubGroups(driver);	
		Assert.assertEquals(driver.getTitle(), "Highlights from your groups");
	}
	
	// TEST      : SELECTS INTERESTS' SUB MENU: PULSE
	// STEP 1    : SELECT MAIN MENU: INTERESTS
	// STEP 2    : SELECT SUB-MENU: PULSE
	// VALIDATION: TITLE PAGE	
	@Test (priority=3, enabled=true)
	public void POS_Test_SelectPulse(){
		pagemenu.clickMainInterests(driver);
		pagemenu.clickSubPulse(driver);
		Assert.assertEquals(driver.getTitle(), "Is Uber redefining the work week? | Olivia Barrow | LinkedIn");
	}

	// TEST      : SELECTS INTERESTS' SUB MENU: EDUCATION
	// STEP 1    : SELECT MAIN MENU: INTERESTS
	// STEP 2    : SELECT SUB-MENU: EDUCATION
	// VALIDATION: TITLE PAGE	
	@Test (priority=4, enabled=true)
	public void POS_Test_SelectEducation(){
		pagemenu.clickMainInterests(driver);
		pagemenu.clickSubEducation(driver);
		Assert.assertEquals(driver.getTitle(), "Higher Education Home | LinkedIn");
	}
	
	// TEST      : SELECTS INTERESTS' SUB MENU: SLIDESHARE
	// STEP 1    : SELECT MAIN MENU: INTERESTS
	// STEP 2    : SELECT SUB-MENU: SLIDESHARE
	// VALIDATION: TITLE PAGE	
	@Test (priority=5, enabled=true)
	public void POS_Test_SelectSlideShare(){
		pagemenu.clickMainInterests(driver);
		String strSlideShareTitle = pagemenu.clickSubSlideShare(driver);
		Assert.assertEquals(strSlideShareTitle, "Share and Discover Knowledge on LinkedIn SlideShare");
	}
	
	// TEST      : SELECTS INTERESTS' SUB MENU: ONLINE LEARNING
	// STEP 1    : SELECT MAIN MENU: INTERESTS
	// STEP 2    : SELECT SUB-MENU: ONLINE LEARNING
	// VALIDATION: TITLE PAGE	
	@Test (priority=6, enabled=true)
	public void POS_Test_SelectOnlineLearning(){
		pagemenu.clickMainInterests(driver);
		String strOnlineLearningTitle = pagemenu.clickSubOnlineLearning(driver);
		Assert.assertEquals(strOnlineLearningTitle, "Online Video Tutorials & Training at Lynda.com");
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
		} else {
			System.out.println(Integer.toString(iCounter) + "- Test Completed - PASSED");
		}
		
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
// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Sign Out Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: January 14, 2016 
// ---------------------------------------------------------------------------------------------------------------


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageSignOut {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageSignOut(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	// ------------------------------------ PROPERTIES ------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------
	
	//Locator Label: You have signed out 
	@FindBy(id="page-title")
	public WebElement lblSignOut;
	
	//Locator Menu: Sign In
	@FindBy(css="a[href*='hb_signin']")
	public WebElement lnkMenuSignIn;
	
	//Locator Menu: Join Today
	@FindBy(css="a[href*='hb_join']")
	public WebElement lnkMenuJoinToday;

	//Locator Menu: What is LinkedIn?
	@FindBy(css="a[href*='hb_what']")
	public WebElement lnkMenuWhatIs;
	
	// ------------------------------------ METHODS ---------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	//Method: Get Text and return a string
	public String clickLinkMainLogo(){
		return lblSignOut.getText();
	}
	
	//Method: checks if Sign In WebElement is enabled and return a boolean
	public boolean isEnabledLinkSignIn(){
		return lnkMenuSignIn.isEnabled();
	}
	
	//Method: checks if Join Today WebElement is enabled and return a boolean
	public boolean isEnabledLinkJoinToday(){
		return lnkMenuJoinToday.isEnabled();
	}
	
	//Method: checks if What is LinkedIn WebElement is enabled and return a boolean
	public boolean isEnabledLinkWhatIs(){
		return lnkMenuWhatIs.isEnabled();
	}

}

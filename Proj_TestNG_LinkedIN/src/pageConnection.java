// ---------------------------------------------------------------------------------------------------------------
// Test Description: Validates LinkedIn's Connection Page: Links, Title, Textboxes ...
// Created By: Jefry Denny
// Created On: February 11, 2016
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageConnection {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageConnection(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -------------- Properties -------------------------

	//Locator Text Link: Connections
	@FindBy(xpath="id('wrapper')/x:div[1]/x:div[1]/x:div[2]/x:div/x:a/x:h1")
	public WebElement txtConnections;	


	// -------------- Methods -------------------------
	
	//Method:  
		public boolean isDisplayedLinkConnections() throws AssertionError {
			try {
				txtConnections.isDisplayed();
			} catch (AssertionError e){
				System.out.println("Ooppss ... ");
			}
			
			return txtConnections.isDisplayed();
		}
	
}

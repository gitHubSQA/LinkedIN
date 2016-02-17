// ---------------------------------------------------------------------------------------------------------------
// Test Description: Validates LinkedIn's Find Alumni Page: Links, Title, Textboxes ...
// Created By: Jefry Denny
// Created On: February 17, 2016
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageFindAlumni{
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageFindAlumni(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- PROPERTIES ---------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------

	//Locator Text Link: Pending invitations
	@FindBy(id="invitations-cards")
	public WebElement cntPendingInvitation;	


	// -----------------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------- METHODS ------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//Method:  
		public boolean isDisplayedPendingInvite() throws AssertionError {
			try {
				cntPendingInvitation.isDisplayed();
			} catch (AssertionError e){
				System.out.println("Ooppss ... ");
			}
			
			return cntPendingInvitation.isDisplayed();
		}
	
}

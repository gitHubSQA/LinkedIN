// ---------------------------------------------------------------------------------------------------------------
// Test Description: Validates LinkedIn's People You May Know Page: Links, Title, Textboxes ...
// Created By: Jefry Denny
// Created On: February 16, 2016
// Last Update By: 
// Last Update On: 
// ---------------------------------------------------------------------------------------------------------------

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pagePeopleYouKnow{
	
	//Constructor to initialize all the WebElements in THIS page.
	public pagePeopleYouKnow(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -------------- Properties -------------------------

	//Locator Text Link: Pending invitations
	@FindBy(id="invitations-cards")
	public WebElement cntPendingInvitation;	


	// -------------- Methods -------------------------
	
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

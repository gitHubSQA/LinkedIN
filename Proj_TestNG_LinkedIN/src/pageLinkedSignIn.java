// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Sign In Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: January 14, 2016 
// ---------------------------------------------------------------------------------------------------------------


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageLinkedSignIn {
	
	//Constructor to initialize all the WebElements in THIS page.
		public pageLinkedSignIn(WebDriver driver){
			PageFactory.initElements(driver, this);	
		}
		
		// -------------- Properties -------------------------
		
		//Locator Textbox: Username 
		@FindBy(id="login-email")
		public WebElement txtUserName;	
		
		//Locator Textbox: Password
		@FindBy(id="login-password")
		public WebElement txtPassWord;	
		
		//Locator Button: Sign In
		@FindBy(name="submit")
		public WebElement btnSignIn;	
		
		
		// -------------- Methods -------------------------

		//Method: Set Text: Username 
		public void setTxtUserName(){
			txtUserName.clear();
			txtUserName.sendKeys("jjdenny@gmail.com");
		}
		
		//Method: Set Text: Username 
		public void setTxtPassWord(){
			txtPassWord.clear();
			txtPassWord.sendKeys("php21days");
		}
		
		//Method: Click Button: Sign In 
		public void clickSignIn(){
			btnSignIn.click();
		}
		
}

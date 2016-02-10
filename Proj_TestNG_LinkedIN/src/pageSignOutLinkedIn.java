import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageSignOutLinkedIn {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageSignOutLinkedIn(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	//Locator Menu: What is LinkedIn 
	@FindBy(linkText="What is LinkedIn")
	public WebElement lnkMenuWhatIsLinkedIn;	
		
	//Locator Menu: What is Join Today 
	@FindBy(linkText="Join Today")
	public WebElement lnkMenuJoinToday;	

	//Locator Menu: What is Sign In 
	@FindBy(linkText="Sign In")
	public WebElement lnkMenuSignIn;		
	
	
	// -------------- Methods -------------------------
	
	//Method: Click Menu: Home 
	public void clickLinkMenuWhatIsLinkedIn(){
		lnkMenuWhatIsLinkedIn.click();
	}
	
	//Method: Click Menu: Home 
	public void clickLinkMenuJoinToday(){
		lnkMenuJoinToday.click();
	}

	//Method: Click Menu: Home 
	public void clickLinkMenuSignIn(){
		lnkMenuSignIn.click();
	}	
}

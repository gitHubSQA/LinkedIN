// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Home Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: January 14, 2016 
// ---------------------------------------------------------------------------------------------------------------


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageHomeLinkedIn {
	
	//Constructor to initialize all the WebElements in THIS page.
	public pageHomeLinkedIn(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -------------- Properties -------------------------
	
	//Locator Textbox: Username 
	@FindBy(id="login-email")
	public WebElement txtUserName;	
	
	//Locator Textbox: Identity 
	@FindBy(css="a[href*='https://www.linkedin.com/profile/view?id=AAMAAAX6AOIBo5Cc1u_7ai-smLWqsUd_ZD_H65o&trk=hp-identity-name']")
//	@FindBy(linkText="Jefry Denny")
	public WebElement txtIdentity;	
	
	//Locator Menu Button: Share an update 
	@FindBy(xpath="html/body/div[3]/div/div[2]/div[5]/div/div[2]/div/menu/li[1]/button")
	public WebElement btnShareUpdate;	

	
	//Locator Menu Button: Upload a Photo
	@FindBy(xpath="html/body/div[3]/div/div[2]/div[5]/div/div[2]/div/menu/li[2]/label")
	public WebElement btnUploadPhoto;	
	
	//Locator Menu Button: Publish a post 
	@FindBy(css="a[href*='hp-share-poncho-pencil']")
//	@FindBy(linkText="Jefry Denny")
	public WebElement btnPublishPost;	

	//Locator Textarea: Share an Update Text Area 
	@FindBy(id="postmodule-text")
	public WebElement txtAreaShareUpdate;	
	

// -------------- Methods -------------------------

	//Method: Button Click: Share an Update 
	public void clickBtnShareUpdate(){
		btnShareUpdate.click();
	}
	
	//Method: Button Click: Upload a Photo 
	public void clickBtnUploadPhoto(){
		btnUploadPhoto.click();
	}
	
	//Method: Button Click: Publish a Post 
	public void clickBtnPublishPost(){
		btnPublishPost.click();
	}

}
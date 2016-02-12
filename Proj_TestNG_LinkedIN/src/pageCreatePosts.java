// ---------------------------------------------------------------------------------------------------------------
// Test Description: LinkedIn's Create Post Page
// Created By: Jefry Denny
// Created On: January 14, 2016
// Last Update By: Jefry Denny
// Last Update On: January 14, 2016 
// ---------------------------------------------------------------------------------------------------------------


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageCreatePosts {

	//Constructor to initialize all the WebElements in THIS page.
	public pageCreatePosts(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	
	
	// -------------- Properties -------------------------
	
	//Locator Label: Your Posts 
	@FindBy(xpath="html/body/div[3]/div/div[2]/div[5]/div/div[2]/div/menu/li[2]/label")
	public WebElement lblYourPosts;
	
	//Locator Button: Save 
	@FindBy(xpath="html/body/div[4]/div/div[3]/div/div[1]/div/div/button[1]")
	public WebElement btnSavePost;	
	
	//Locator Button: Publish 
	@FindBy(xpath="html/body/div[4]/div/div[3]/div/div[1]/div/div/button[4]")
	public WebElement btnPublishPost;	
	
	//Locator Textarea: Write Your Headline 			- **** To validate
	@FindBy(name="title")
	public WebElement txtAreaWriteHeadline;	
	
	//Locator Tag: Pill 								- **** To validate
	@FindBy(id="s2id_autogen1")
	public WebElement picPillTag;	
	
	
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {

	// Varibales Declaration
	
	@FindBy (xpath = "//input[@id='email']") 
	private WebElement useName ;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ;
	
	@FindBy (xpath = "//button[@name='login']")
	private WebElement loginButton ;
	
	@FindBy (xpath = "//a[text()='Messenger']")
	private WebElement mesenger ;
	
		public LoginOrSignUpPage(WebDriver driver123)  
	{
		PageFactory.initElements(driver123, this);
	}
	
	public void sendUserName(String user) {
			useName.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys("1234567");
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void openMessenger() {
		mesenger.click();
	}
	
	// OR
	public void loginToApplication() {
		useName.sendKeys("Velocity@gmail.com");
		password.sendKeys("1234567");
		loginButton.click();
	}
	
	// POM Class
	
	/// Drop Drown 
	// mouse action 
	// Explicit Wait
	
	
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessengerPage {
	
		private WebDriver driver ;
		private WebDriverWait wait  ;
	
		@FindBy (xpath = "//a[text()='Rooms']") 
		private WebElement room ;
		
		@FindBy (xpath = "//a[text()='Features']") 
		private WebElement features ;	
		
		public MessengerPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver ;
			// common waiting time for all above WebElement 
		}
		
		public void openRooms() {
			// diffrent waiting time for all above WebElement
			wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOf(room));
			room.click();
		}
		
		public void openFeatures() {
			wait = new WebDriverWait(driver, 30); 
			wait.until(ExpectedConditions.visibilityOf(features));
			features.click();
		}
}

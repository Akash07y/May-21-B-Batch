package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class VerifyReturnToMessengerButton {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		// Click on meseger link
		// Object of POM Class
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.openMessenger();
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		
		RoomsPage roomsPage= new RoomsPage(driver);
		roomsPage.goBackToMessenger();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if( url.equals("https://www.messenger.com/")  &&   title.equals("Messenger"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
}

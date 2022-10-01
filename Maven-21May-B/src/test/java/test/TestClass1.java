package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class TestClass1 {

	private WebDriver driver ;
	private SoftAssert soft ;
	
	private RoomsPage roomsPage ;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private MessengerPage messengerPage  ;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {

		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
//		if(browserName.equals("Firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		if(browserName.equals("Opera"))
		{
			System.setProperty("webdriver.opera.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\geckodriver-v0.31.0-win64\\operadriver.exe");
			driver = new OperaDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMObjects() {
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		roomsPage= new RoomsPage(driver);
		messengerPage = new MessengerPage(driver);
	}
	
	@BeforeMethod
	public void goToRoomsPage() {
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage.openMessenger();
		messengerPage.openRooms();
		soft = new SoftAssert();
	}
		
	@Test
	public void verifyContactTOHelpCenterButton() {
		roomsPage.contactToHelpCenter();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();		
		soft.assertEquals(url, "https://www.messenger.com/h", "Url of Contact to HelpCenter not working");
		soft.assertEquals(title, "Messenger Help Cen", "Title is wrong");
		soft.assertAll();
	}
	
	@Test
	public void verifyGo() {		
		roomsPage.goBackToMessenger();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();	
		soft.assertEquals(url, "https://www.messenger.com/", "Url of Contact to Mesenger not working");
		soft.assertEquals(title, "Messenger", "Mesenger Title is wrong");
		soft.assertAll();
	}

	@AfterMethod
	public void afterMethod() {		
		System.out.println("After Method");
		System.out.println("logout");
	}
	
	@AfterClass
	public void removeObjects() {
		loginOrSignUpPage = null;
		roomsPage= null;
		messengerPage = null;
	}
	@AfterTest
	public void closBrowser() {
		System.out.println("After Class");
		driver.close();
		driver = null ;
		System.gc(); // garbeg collector 
	}
	


}

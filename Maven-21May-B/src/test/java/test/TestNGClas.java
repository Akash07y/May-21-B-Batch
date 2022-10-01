package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetup.Base;
import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;
import utils.Utility;

public class TestNGClas extends Base{
	
	private WebDriver driver ;
	private SoftAssert soft ;
	private RoomsPage roomsPage ;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private MessengerPage messengerPage  ;
	private int testID ;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser() {

		String browserName = Utility.getExcelData(browser,2,3);
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		if(browserName.equals("Opera"))
		{
			driver = openOperaBrowser();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMObjects() {
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
	
		String data = Utility.getExcelData(shetanem,row,cell);
		loginOrSignUpPage.sendUserName(data);
		
		data = Utility.getExcelData(shetanem,row,cell);
		loginOrSignUpPage.sendPassword(data);
		
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
		testID = 1121 ;
		roomsPage.contactToHelpCenter();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();		
		soft.assertEquals(url, "https://www.messenger.com/h", "Url of Contact to HelpCenter not working");
		soft.assertEquals(title, "Messenger Help Cen", "Title is wrong");
		soft.assertAll();
	}
	
	@Test
	public void verifyGo() {	
		testID = 2221;
		roomsPage.goBackToMessenger();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();	
		soft.assertEquals(url, "https://www.messenger.com/", "Url of Contact to Mesenger not working");
		soft.assertEquals(title, "Messenger", "Mesenger Title is wrong");
		soft.assertAll();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {	
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(testID);
		}
		System.out.println("After Method");
		System.out.println("logout");
	}
	
//	TestNG Listner 
//	
//	IReporter
//	ITestResult
//	ITestListner
//	ITestReporter
	
	
	
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

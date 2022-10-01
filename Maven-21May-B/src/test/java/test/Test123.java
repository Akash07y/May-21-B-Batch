package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class Test123 {

//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("Before Suite - Test123");
//	}
//	
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("Before Test - Test123");
//	}
//	
//	@BeforeClass
//	public void launchBrowser() {
//		System.out.println("Before Class - Test123");
//	}
//	
	@BeforeMethod
	public void goToRoomsPage() {
		System.out.println("Before Method - Test123");
	}
		
	@Test
	public void test1() {
		System.out.println("test 1 - Test123");
	}

	@AfterMethod
	public void afterMethod() {		
		System.out.println("After Method - Test123");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class - Test123");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - Test123");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - Test123");
	}
}

package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test456 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite - Test456");	
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test - Test456");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Before Class - Test456");
	}
	
	@BeforeMethod
	public void goToRoomsPage() {
		System.out.println("Before Method - Test456");
	}
		
	@Test
	public void testB() {
		System.out.println("test B - Test456");
	}
	
	@Test
	public void testA() {		
		System.out.println("test A - Test456");
	}

	@AfterMethod
	public void afterMethod() {		
		System.out.println("After Method - Test456");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class - Test456");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - Test456");
	}
	
	@AfterSuite
	public void afteruite() {
		System.out.println("After Suite - Test456");
		
	}
	
}

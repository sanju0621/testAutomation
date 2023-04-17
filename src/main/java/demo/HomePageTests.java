package demo;

import java.util.NoSuchElementException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTests {
	
	@BeforeGroups(dependsOnGroups = {"login"})
	public void groupConfig() {
		System.out.println(" before group  ... ");
	}
	
	@AfterGroups
	public void groupTear() {
		System.out.println("after group .. . ");
	}
	
	@BeforeSuite
	public void suiteConfig() {
		System.out.println("suite config .. ");
	}
	
	@AfterSuite
	public void suiteConfigteardown() {
		System.out.println("suite config teardown .. ");
	}
	
	
	@BeforeTest
	public void testsetup() {
		System.out.println("Test Setup .. ");
	}
	
	@AfterTest
	public void testTearDown() {
		System.out.println("Test teardown .. ");
	}
	
	@BeforeClass
	public void configuration() {
		System.out.println("Config ... . . .");
	}
	
	@AfterClass
	public void Closeconfiguration() {
		System.out.println("Closing config ... . . .");
	}

	@BeforeMethod
	public void loginHome() {
		System.out.println("Login ... ");
	}

	@Test(groups = {"login"})
	public void homeTC1() {
		System.out.println("Test 1...");
	}

	@Test(groups = {"home"})
	public void homeTC2() {
		System.out.println("Test 2...");
		throw new NoSuchElementException();
	}

	@Test(groups = {"login"})
	public void homeTC3() {
		System.out.println("Test 3...");
	}

	@Test(groups = {"home"})
	public void homeTC4() {
		System.out.println("Test 4...");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("close ...");
	}

}

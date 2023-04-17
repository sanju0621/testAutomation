package tests;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import listeners.SfdcListeners;
import pages.LoginPage;
import pages.UserMenuPage;

@Listeners(SfdcListeners.class)
public class LoginTest extends BaseTest {

	
	@Test //(invocationCount = 0, groups = {"smoke","regression"}, timeOut = 60000, successPercentage = 60)
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver =  getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		Assert.assertTrue(launchApp("https://login.salesforce.com/"), "Actual URL should match the expected URL");
		test.log(Status.INFO, "App is launched");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.log(Status.INFO, "User name is entered.");
//		Assert.assertEquals(lp.getUsername(driver), PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		Assert.assertTrue(lp.selectRememberMeCheckbox(), "Remember me checkbox should be selected");
		test.log(Status.INFO, "Remember me checked box is selected.");
		lp.clickLoginButton(driver);
		test.log(Status.INFO, "Login button is clicked.");
		Assert.assertTrue(lp.isHomePageDisplayed(), "Home page should be displayed");
		Assert.assertTrue(ump.logOut(driver), "Failed to logout");
		Assert.assertTrue(lp.isLoginPageDisplayed(driver), "Login page should be displayed");
		Assert.assertEquals(lp.getSavedUserName(driver), PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.pass("TC01 - loginTest passed");
	}
	@Test
	public void loginErrorMsgTest()throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		launchApp("https://login.salesforce.com/");
		test.log(Status.INFO, "App is launched");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.log(Status.INFO, "User name is entered.");
			
		lp.enterPassword(driver, "");
		lp.clickLoginButton(driver);
		test.log(Status.INFO, "Login button is clicked.");
		Assert.assertTrue(lp.checkLoginErrorMsg());
		test.pass("TC02 - loginErrorMsgTest passed");
	}
	@Test
	public void checkRememberMe() throws IOException, InterruptedException {
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver);
		launchApp("https://login.salesforce.com/");
		test.log(Status.INFO, "App is launched");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		lp.selectRememberMeCheckbox();
		test.log(Status.INFO, "Remember me checkbox is selected");
		lp.clickLoginButton(driver);
		test.log(Status.INFO, "Login button is clicked.");
		UserMenuPage ump = new UserMenuPage(driver);
		ump.logOut(driver);
		test.log(Status.INFO, "Logout button is clicked.");
		Assert.assertEquals(lp.getSavedUserName(driver), PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.pass("TC03 - checkRememberMe passed");
	}
	
	@Test
	public void forgotPassword() throws IOException, InterruptedException {
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver);
		launchApp("https://login.salesforce.com/");
		test.log(Status.INFO, "App is launched");
		lp.clickForgotButton(driver);
		test.log(Status.INFO, "clicked Forgot button");
		lp.enterForgotUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.log(Status.INFO, "Entered forgot user name");
		lp.clickForgotPwdContinue(driver);
		test.log(Status.INFO, "clicked Forgot password button continue");
		Assert.assertTrue(lp.checkPwdResetContent());
		
		test.pass("TC04 - forgotPassword passed");
	}
	
/*
	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"}, successPercentage = 10 )
	public void loginTest1() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
	}
	
	@Test(dependsOnMethods = "loginTest1", alwaysRun = true)
	public void loginTest2() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
		throw new NoSuchElementException();
	}
	
	@Test(dataProvider = "userCreds")
	public void loginTest3(String user, String pass) {
//		WebDriver driver =  BaseTest.getDriver();
//		driver.get("https://google.com");
		System.out.println("username: "+user);
		System.out.println("Pass: "+pass);
	}
	*/
	@DataProvider( parallel = true)
	public Object[][] userCreds(){
//		Write a logic here to read all the username and passwords from excel
		
		return new Object[][] {{"mithun.r@tekarch.com","1234Sam"},{"Chandra@gmail.com","12345Chandra"},{"deekshith", "1234deekshith"}};
		
	}
	
	

}

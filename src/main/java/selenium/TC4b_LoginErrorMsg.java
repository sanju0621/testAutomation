package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;


public class TC4b_LoginErrorMsg extends BaseTest {

	
	void runTest() {
		WebDriver driver = getWebDriver("chrome", "https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("sanjusf@abc.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("123");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		delay(1, "");
		WebElement error = driver.findElement(By.id("error"));
		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if (expectedError.equals(error.getText())) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		delay(2, "Test Completed");
		driver.close();
	}
	public static void main(String args[]) {

		TC4b_LoginErrorMsg tc1 = new TC4b_LoginErrorMsg();
		tc1.runTest();
		
//
		
	}
	
	
	
}

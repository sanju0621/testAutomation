package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC3_CheckRemembberMe extends BaseTest {
	

	void runTest() {
		WebDriver driver = getWebDriver("chrome", "https://login.salesforce.com"); 
		driver.manage().window().maximize();
		// WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement user = driver.findElement(By.id("username"));
		String expectedUserName = "sanjusf@tekarch.com";
		user.sendKeys(expectedUserName);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("abcd1234");
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='rememberUn']"));
		rememberMe.click();
		delay(1, "Clicked RememberMe");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		delay(2, "Login successfull");
		try {
			WebElement menu = driver.findElement(By.id("userNavLabel"));
			menu.click();
			
			delay(1, "Menu Opened");
			WebElement logout = driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]"));
			logout.click();
			System.out.println("logout clicked");
			
			delay(1, "logout worked");
			
			WebElement username = driver.findElement(By.id("idcard-identity"));
			String userName = username.getText();
			if (userName.equals(expectedUserName)) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
			delay(2, "username found");
		} catch (Exception e) {
			delay(8, "exception");
			System.out.println("Got Exception" + e);
		} finally {
			driver.close();
		}

	}
	
	public static void main(String[] args) {
		TC3_CheckRemembberMe test = new TC3_CheckRemembberMe();
		test.runTest();
		
	}

}

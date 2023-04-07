package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword extends BaseTest {

	void runTest() {
		WebDriver driver = getWebDriver("firefox", "https://login.salesforce.com");
		
		
		WebElement user = driver.findElement(By.id("username"));
		String expectedUserName = "sanjusf@abc.com";
		user.sendKeys(expectedUserName);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("SrgSANJU21");
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='rememberUn']"));
		rememberMe.click();
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		delay(2, "Login successfull");
		driver.close();
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		ForgotPassword fp = new ForgotPassword();
		fp.runTest();

	}

}

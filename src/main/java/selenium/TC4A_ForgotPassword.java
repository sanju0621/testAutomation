package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC4A_ForgotPassword extends BaseTest {

	void runTest() {
		WebDriver driver = getWebDriver("chrome", "https://login.salesforce.com");
		
		WebElement forgotPwd = driver.findElement(By.id("forgot_password_link"));
		forgotPwd.click();
		WebElement userName  = driver.findElement(By.xpath("//input[@id='un']"));
		userName.sendKeys("sanjusf@abc.com");
		WebElement clickContinue  = driver.findElement(By.id("continue"));
		clickContinue.click();
		
		WebElement content  = driver.findElement(By.xpath("//div[@id='content']"));
		
		System.out.println(content.getText());
		
		driver.quit();
	}
	
	
	
	////div[@id='content']
	
	public static void main(String[] args) {
		
		TC4A_ForgotPassword fp = new TC4A_ForgotPassword();
		fp.runTest();

	}

}

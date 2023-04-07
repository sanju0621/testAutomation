package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSalesForce {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sanju/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new SafariDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("sanjusf@abc.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("SrgSANJU21");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}

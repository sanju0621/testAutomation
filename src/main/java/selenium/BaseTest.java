package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {

	WebDriver getWebDriver(String browserName, String url) {
		WebDriver driver = null;
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/sanju/Downloads/chromedriver_mac_arm64/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
			
		default:
			driver = new FirefoxDriver();

		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}

	void delay(int seconds, String msg) {
		try {
			Thread.sleep(seconds * 1000);
			System.out.println(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

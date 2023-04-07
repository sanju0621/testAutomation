package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UrlOpen {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "/Users/sanju/Downloads/chromedriver_mac_arm64/chromedriver");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		

	}

}

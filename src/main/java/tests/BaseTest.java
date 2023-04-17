package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import file.utils.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	protected static ExtentReports extent = new ExtentReports();
	protected static ExtentHtmlReporter report = null;
	protected static ExtentTest test = null;

	@BeforeSuite
	public void setup() {
		String sFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String filePath = System.getProperty("user.dir") + "/src/main/resources/reports/" + sFileNamePrefix
				+ "_SFDC.html";
		report = new ExtentHtmlReporter(filePath);
		extent.attachReporter(report);
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

	@BeforeMethod
	public void setDriver(Method name) {
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		threadLocalDriver.set(driver);
		test = extent.createTest(name.getName());
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	@AfterMethod
	public void removeDriver() {
		BaseTest.getDriver().quit();
		;
		threadLocalDriver.remove();
	}

	/**
	 * This method configures the browser dynamically with headless mode.
	 * 
	 * @param browserName should be either of the string 'chrome', 'firefox',
	 *                    'edge', 'safari'
	 * @param headless    set to true to run in headless mode
	 * @return driver object, on wrong param returns null
	 */
	public static WebDriver getBrowserType(String browserName, boolean headless) {

		WebDriver driver = null;
		String browserType = browserName.toLowerCase();

		switch (browserType) {
		case "chrome":
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "/Users/sanju/Downloads/chromedriver_mac_arm64/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			if (headless) {

				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver(options);
			}
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Provide input either as Chrome or Safari");
			break;
		}
		return driver;
	}

	/**
	 * @param driver
	 * @param sURL
	 * @return
	 * @throws IOException
	 */
	public static boolean launchApp(String sURL) throws IOException {
		boolean isAppLaunched = false;
		WebDriver driver = getDriver();
		driver.get(sURL);
		String actualURL = driver.getCurrentUrl();
		if (actualURL.equals(sURL)) {
			isAppLaunched = true;
		} else {
			CommonUtils.captureScreenShot(driver);
		}
		return isAppLaunched;
	}
}

package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import listeners.SfdcListeners;
import pages.AmazonPage;

@Listeners(SfdcListeners.class)
public class AmazonTest extends BaseTest{
	
		@Test//(invocationCount = 0, groups = {"Regression"}, timeOut = 60000)
		public void amazonTest() throws IOException, InterruptedException {
			WebDriver driver = getDriver();
			AmazonPage ap = new AmazonPage(driver);
			launchApp("https://amazon.com");
			test.log(Status.INFO, "App is launhed");
			ap.enterSearchText("kindle");
			test.log(Status.INFO, "Search text is entered: kindle");
			ap.clickGoButton();
			test.log(Status.INFO, "Go button clicked");
			ap.clickChoiceButton(driver);
			test.log(Status.INFO, "Choice button clicked");
			ap.clickAddCartButton(driver);
			test.log(Status.INFO, "Add cart button clicked");
			try {
				ap.clickNoThanks(driver);
				test.log(Status.INFO, "No Thanks clicked");
			} catch(Exception e) {
				System.out.println("Ignoring this exception...");
			}
			ap.clickGoCartButton(driver);
			test.log(Status.INFO, "Go cart button clicked");
			Assert.assertTrue(ap.checkSubTotal(driver));
			Assert.assertTrue(ap.checkItem(driver));
			test.pass("Amazon Test Passed");
		}

		
}

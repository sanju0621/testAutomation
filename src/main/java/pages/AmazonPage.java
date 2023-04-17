package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.utils.CommonUtils;

public class AmazonPage extends BasePage {
	public AmazonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	//@FindBy(id = "@FindBy(id = \"twotabsearchtextbox\")")
	@FindBy(id = "nav-search-submit-button")
	WebElement go;

	//@FindBy(xpath = "//div[@class='a-section a-spacing-none s-badge-spacing']//span[@class='a-badge-text'][normalize-space()='Choice']")
	@FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']//img[@alt='Kindle (2022 release) – The lightest and most compact Kindle, now with a 6” 300 ppi high-resolution display, and 2x the st...']")
	WebElement choice;

	@FindBy(id = "add-to-cart-button")
	WebElement addCart;

	@FindBy(xpath = "//span[@class='a-button a-button-base abb-intl-decline']//input[@type='submit']")
	WebElement noThanks;

	@FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=sw_gtc']")
	WebElement goToCart;

	@FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
	WebElement total;
//////span[@class='a-truncate-cut'][contains(text(),'Kindle (2022 release) – The lightest and most comp')]
	@FindBy(xpath = "//span[@class='a-truncate-cut'][contains(text(),'Kindle (2022 release) – The lightest and most comp')]")
	WebElement item;

	public void enterSearchText(String searchText) {

		if (searchBox.isDisplayed()) {
			searchBox.sendKeys(searchText);
		} else {
			System.out.println("Search box element is not visible");

		}

	}

	public void clickGoButton() {
		if (go.isDisplayed()) {
			go.click();
		} else {
			System.out.println("go button is not visible");
		}

	}

	public void clickChoiceButton(WebDriver driver) {
		CommonUtils.waitForElement(driver, choice);
		if (choice.isDisplayed()) {
			choice.click();
		} else {
			System.out.println("Choice button is not visible");
		}

	}

	public void clickAddCartButton(WebDriver driver) {
		CommonUtils.waitForElement(driver, addCart);
		if (addCart.isDisplayed()) {
			addCart.click();
		} else {
			System.out.println("AddCart button is not visible");
		}
	}

	public void clickNoThanks(WebDriver driver) {
		CommonUtils.waitForElement(driver, noThanks);
		if (noThanks.isDisplayed()) {
			noThanks.click();
		} else {
			System.out.println("No thanks button is not visible");
		}
	}

	public void clickGoCartButton(WebDriver driver) {
		CommonUtils.waitForElement(driver, goToCart);
		if (goToCart.isDisplayed()) {
			goToCart.click();
		} else {
			System.out.println("Go to cart button is not visible");
		}
	}

	public boolean checkSubTotal(WebDriver driver) {
		CommonUtils.waitForElement(driver, total);
		if (total.isDisplayed()) {
			if (total.getText().equals("Subtotal (1 item):")) {
				return true;
			} else {
				return false;
			}
		}
		System.out.println("Sub total is not visible");
		return false;

	}

	public boolean checkItem(WebDriver driver) {
		CommonUtils.waitForElement(driver, item);
		if (item.isDisplayed()) {
			System.out.println("Item: " + item.getText());
			if (item.getText().equals("Kindle (2022 release) – The lightest and most compact Kindle, now with a 6” 300 ppi high-resolution display…")) {
				return true;
			} else {
				return false;
			}
		}
		System.out.println("Item is not visible");
		return false;

	}
}
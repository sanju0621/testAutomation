package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.utils.CommonUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement login;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(css = "#error")
	public WebElement loginErrorMsg;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(partialLinkText = "Forgot Your")
	public WebElement forgotPassword;
	
	@FindBy(id = "forgot_password_link")
	public WebElement forgotPasswordLink;
	
	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(id = "forgotPassForm")
	public WebElement passwordResetScreen;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id = "content")
	public WebElement passwordResetContent;
	
	
	@FindBy(id = "userNavLabel")
	public WebElement homeUserMenu;

	public void enterUsername(WebDriver driver, String userName) {

		if (username.isDisplayed()) {
			username.sendKeys(userName);
		} else {
			System.out.println("User name element is not visible");
		}
	}
	public void enterForgotUsername(WebDriver driver, String userName) {

		if (forgotUsername.isDisplayed()) {
			forgotUsername.sendKeys(userName);
		} else {
			System.out.println("User name element is not visible");
		}
	}
	
	public String getUsername(WebDriver driver) {
		return username.getText();
	}
	
	public String getSavedUserName(WebDriver driver) {
		CommonUtils.waitForElement(driver, savedUsername);
		return savedUsername.getText();
	}

	public void enterPassword(WebDriver driver, String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
		} else {
			System.out.println("password element is not visible");
		}
	}
	
	public void clickLoginButton(WebDriver driver) {
		if (login.isDisplayed()) {
			login.click();
		} else {
			System.out.println("login button is not visible");
		}
	}
	
	
	
	public boolean selectRememberMeCheckbox() {
		boolean bIsCheckBoxSelected = false; 
		if(rememberMe.isSelected()) {
			bIsCheckBoxSelected = true;
		} else {
			rememberMe.click();
			bIsCheckBoxSelected = true;
		}
		return bIsCheckBoxSelected;
	}

	public void clickForgotButton(WebDriver driver) {
		if (forgotPasswordLink.isDisplayed()) {
			forgotPasswordLink.click();
		} else {
			System.out.println("login button is not visible");
		}
	}
	
	public void clickForgotPwdContinue(WebDriver driver) {
		if ( continueButton.isDisplayed()) {
			 continueButton.click();
		} else {
			System.out.println(" Continue button is not visible");
		}
	}
	
	public boolean checkPwdResetContent() {
		if (passwordResetContent.isDisplayed()) {
			System.out.println(passwordResetContent.getText());
			if (passwordResetContent.getText().contains("sent you an email")) {
				return true;
			} else {
				return false;
			}
		}
		System.out.println("Reset conent is not visible");
		return false;
		
	}
	
	public boolean checkLoginErrorMsg() {
		if (loginErrorMsg.isDisplayed()) {
			if (loginErrorMsg.getText().equals("Please enter your password.")) {
				return true;
			} else {
				return false;
			}
		}
		System.out.println("Login error message is not visible");
		return false;
		
	}
	public boolean isHomePageDisplayed() {
		if (homeUserMenu.getText().equals("Sangeeta Gupta")) {
			return true;
		} else {
			return false;
		}
		//return homeUserMenu.isDisplayed();
	}
	
	public boolean isLoginPageDisplayed(WebDriver driver) {
		return CommonUtils.waitForElement(driver, login);
	}

}

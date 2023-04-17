package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.WaitConstants;
import file.utils.CommonUtils;
import file.utils.PropertiesFileutils;

public class UserMenuPage extends BasePage {

	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(id = "userNav-menuItems/a[1]")
	public WebElement MyProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editprofilebutton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement Userprofilepagenamedisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	public boolean isProfilePageVisible() {
		return profilePage.isDisplayed();
	}

	/**
	 * This function is responsible to select user menu item in user menu drop down
	 * by passing an option name
	 * 
	 * @param sOption example: {"My profile", "Settings", "Logout"}
	 * @return true if option is selected else false
	 */
	public boolean selectOptionFromUserMenuOptions(WebDriver driver, String sOption) {
		boolean isOptionClicked = false;
		if (userMenu.isDisplayed()) {
			userMenu.click();
		}
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + sOption + "']"));
		if (userMenuOption.isDisplayed()) {
			userMenuOption.click();
			isOptionClicked = true;
		} else {
			System.out.println("Option " + sOption + " not found");
		}
		return isOptionClicked;
	}

	public boolean logOut(WebDriver driver) {
		return this.selectOptionFromUserMenuOptions(driver, "Logout");
	}

	public void clickOnUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("The usermenu element is not found");
		}
	}

	public boolean verifyUserMenuItems() throws IOException {
		boolean isOptionsverified = true;
		String[] expectedUserMenuItems = PropertiesFileutils.readUserMenuTestData("usermenu.items").split(",");
		for (int i = 0; i < expectedUserMenuItems.length; i++) {
			String actualUserMenuItem = userMenuOptions.get(i).getText();
			if (actualUserMenuItem.equals(expectedUserMenuItems[i])) {
				System.out.println("The option " + expectedUserMenuItems[i] + " Passed");
			} else {
				isOptionsverified = false;
				System.out.println(
						"Actual option: " + actualUserMenuItem + " Expected option: " + expectedUserMenuItems[i]);
			}
		}
		return isOptionsverified;
	}

	public boolean selectMyprofile(WebDriver driver) {
		return this.selectOptionFromUserMenuOptions(driver, "My Profile");
	}

	public void clickEditProfile(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, editprofilebutton)) {
			editprofilebutton.click();
		}
	}

	public boolean verifyProfilePopUpWindow(WebDriver driver) {
		boolean isPopUpTabVerified = false;
		if (CommonUtils.waitForElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if (Abouttab.isDisplayed() && contactTab.isDisplayed()) {
				isPopUpTabVerified = true;
			}
			driver.switchTo().parentFrame();
		}
		return isPopUpTabVerified;
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String sLastName) throws InterruptedException {
		boolean isLastNameVerified = false;
		driver.switchTo().frame(iframeAboutTab);
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			Abouttablastname.clear();
			Abouttablastname.sendKeys(sLastName);
			saveAllButton.click();
			Thread.sleep(WaitConstants.WAIT_FOR_LAST_NAME_TO_UPDATE);
			driver.switchTo().parentFrame();
			if (Userprofilepagenamedisplay.isDisplayed()) {
				String sExpectedLastName = Userprofilepagenamedisplay.getText();
				if (sExpectedLastName.contains(sLastName)) {
					isLastNameVerified = true;
				}
			}
		} else {
			System.out.println("AAbout tab is not displayed");
		}
		return isLastNameVerified;
	}

	public boolean verifyCreatePost(WebDriver driver, String sPostMessage) throws InterruptedException {
		boolean isCreatePostVerified = false;
		if (CommonUtils.waitForElement(driver, postLink)) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(sPostMessage);
			driver.switchTo().parentFrame();
			if (shareButton.isDisplayed()) {
				shareButton.click();
				driver.navigate().refresh();
				Thread.sleep(WaitConstants.WAIT_FOR_NEW_POST_TO_UPDATE);
				isCreatePostVerified = true;
//				if (firstPostText.isDisplayed()) {
//					if (firstPostText.getText().equals(sPostMessage)) {
//						isCreatePostVerified = true;
//					}
//				}
			}
		} else {
			System.out.println("Element is not visible");
		}
		return isCreatePostVerified;

	}


	public boolean verifyFileUpload(WebDriver driver, String sFilePathToUpload) throws InterruptedException {
		boolean isFileUploadSuccess = false;
		if (CommonUtils.waitForElement(driver, filelink)) {
			filelink.click();

			if (CommonUtils.waitForElement(driver, Uploadfile)) {
				Uploadfile.click();
				if (CommonUtils.waitForElement(driver, Fileopen)) {
					Fileopen.sendKeys(sFilePathToUpload);
					shareButton.click();
					Thread.sleep(WaitConstants.WAIT_FOR_UPLOAD_TO_START);
					if (CommonUtils.waitForElementToDisappear(driver, cancelUpload)) {
						if (verifyFilePostElement.isDisplayed()) {
							isFileUploadSuccess = true;
						}
					}

				}
			}
		}
		return isFileUploadSuccess;
	}
	
	public void clickOnUpdatePhoto(WebDriver driver) {
		CommonUtils.moveToElement(driver, moderatorButton);
		if(updateButton.isDisplayed()) {
			updateButton.click();
		}
	}
	
	public boolean uploadPhoto(WebDriver driver, String sFilePath) throws InterruptedException {
		boolean isPhotoUploadSuccess = false;
		clickOnUpdatePhoto(driver);
		driver.switchTo().frame(photoUploadIframe);
		if(CommonUtils.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(sFilePath);
			photoSaveButton.click();
			Thread.sleep(4000);
		}
		if(CommonUtils.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			Thread.sleep(4000);
			isPhotoUploadSuccess = true;
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadSuccess;
	}
}

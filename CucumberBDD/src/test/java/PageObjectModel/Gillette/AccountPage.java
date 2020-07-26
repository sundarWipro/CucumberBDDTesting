package PageObjectModel.Gillette;

import org.apache.commons.exec.ExecuteException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumberTest.CucumberBDD.Utilities;

import static cucumberTest.CucumberBDD.Utilities.jsonObject;
import static cucumberTest.CucumberBDD.Utilities.TestData;

public class AccountPage {
	
	WebDriver driver = null;
	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@id='customerName'] | //input[contains(@id,'[firstname]')] | //input[@id='customer_firstname']")
	private static WebElement FirstName;
	
	@FindBy(xpath = "//input[@id='customerEmail'] | //input[contains(@id,'[emails]')] | //input[@id='email']")
	private static WebElement EnterEmail;
	
	@FindBy(xpath = "//input[@id='confirmCustomerEmail']")
	private static WebElement ConfirmEnterEmail;
	
	@FindBy(xpath = "//input[contains(@id,'[lastname]')] | //input[@id='customer_lastname']")
	private static WebElement LastName;
	
	@FindBy(xpath = "//input[@id='customerPassword'] | //input[contains(@id,'[password][password]')] | //input[@id='passwd']")
	private static WebElement EnterPassword;
	
	@FindBy(xpath = "//input[@id='confirmPassword'] | //input[contains(@id,'[password][confirm]')]")
	private static WebElement ConfirmEnterPassword;
	
	@FindBy(xpath = "//input[contains(@id,'[postalarea]')]")
	private static WebElement EnterPostalCode;
	
	@FindBy(xpath = "//label[@path='OptInReceiveNewsLetterRadio'] | //input[contains(@id,'phdesktopbody') and @type='checkbox'] | //div[@id='uniform-newsletter']")
	private static WebElement ClickNoThanksYes;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private static WebElement ClickVerifyCaptcha;
	
	@FindBy(xpath = "//select[contains(@id,'[birthdate][month]')]")
	private static WebElement SelectMonth;
	
	@FindBy(xpath = "//select[contains(@id,'[birthdate][year]')]")
	private static WebElement SelectYear;
	
	@FindBy(xpath = "//input[@id='phdesktopbody_0_submit'] | //button[@type='submit' and contains(text(),'Registrieren')]")
	private static WebElement CreateProfile;
	
	@FindBy(xpath = "//h1[text()='Your Registration Is Complete'] | //button[contains(text(),'Ausloggen')]")
	private static WebElement VerifyRegistrationSuccess;
	
	@FindBy(xpath = "//span[text()='KONTO']")
	private static WebElement MoveToKontoGermany;
	
	@FindBy(xpath = "//input[@data-key='signInEmailAddress'] | //input[@id='username'] | //input[@id='email']")
	private static WebElement EnterSignInEmail;
	
	@FindBy(xpath = "//input[@data-key='currentPassword'] | //input[@id='password'] | //input[@id='passwd']")
	private static WebElement EnterSignInPassword;
	
	@FindBy(xpath = "//input[@value='Sign In' and @type='submit'] | //button[@id='login-submit'] | //button[@id='SubmitLogin']")
	private static WebElement ClickSignIn;
	
	@FindBy(xpath = "//button[contains(text(),'Ausloggen')]")
	private static WebElement ClickLogOut;
	
	@FindBy(xpath = "//a[contains(text(),'Anmelden')]")
	private static WebElement ClickLogInGerMany;
	
	@FindBy(xpath = "//div[@id='viewLoginForm']//a[@class='white']")
	private static WebElement ClickLogInFrance;
	
	@FindBy(xpath = "//h1[@id='phdesktopbody_0_TitleText' and text()='Your Profile'] | //h1[text()='Mein Konto'] | //h3[text()='Informations personnelles']")
	private static WebElement LoginSuccess;
	
	@FindBy(xpath = "//a[@id='phdesktopheader_0_phdesktopheadertop_2_LogOffLink'] | //button[@value='Abmelden' and contains(@class,'myAccount_logOutButton')] | //div[@id='account-menu']//a[@id='logout_link']")
	private static WebElement ClickLogOutButton;
	
	@FindBy(xpath = "//a[@id='phdesktopheader_0_phdesktopheadertop_2_anchrContinue']")
	private static WebElement ConfirmLogOut;
	
	@FindBy(xpath = "//a[@id='phdesktopbody_0_forgotpassword'] | //a[@class='lost_password grey'] | //div[@class='forgottenPasswordModal']//div[@class='modal_trigger']")
	private static WebElement ClickForgotPassword;
	
	@FindBy(xpath = "//h1[@class='title' and text()='Mot de passe oublié ?'] | //h1[@id='phdesktopbody_0_Header' and text()='Reset my password'] | //h2[@class='forgottenPasswordModal_dialog_form_title' and contains(text(),'Passwort vergessen?')]")
	private static WebElement VerifyForgotPasswordPage;
	
	@FindBy(xpath = "//input[@id='phdesktopbody_0_username'] | //input[@id='forgotten-password-email-field'] | //input[@id='email']")
	private static WebElement EnterResetEmailId;
	
	@FindBy(xpath = "//input[@class='forgottenPasswordModal_dialog_form_submit'] | //input[@value='Create Your New Password'] | //button[@class='password button']")
	private static WebElement CreateNewPassword;
	
	@FindBy(xpath = "//div[@id='password_page']//p[@class='warning'] | //div[@id='phdesktopbody_0_afterSubmit']//h2 | //p[@class='forgottenPasswordModal_dialog_text forgottenPasswordModal_dialog_successSection_text']")
	private static WebElement ResetPasswordMailSent;
	
	@FindBy(xpath = "//input[@id='email_create']")
	private static WebElement FranceCreateEmail;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	private static WebElement CreateAccountFrance;
	
	@FindBy(xpath = "//a[@class='event_profile_login']")
	private static WebElement ClickRegisterButton;
	
	public void enterAccountDetails(String siteRegion, String strEmail) {
		
		if(!siteRegion.equalsIgnoreCase("France")) {
			Select select = null;
			FirstName.sendKeys((String)jsonObject.get("FirstName"));
			EnterEmail.sendKeys(strEmail);
			if(siteRegion.equalsIgnoreCase("India")) {
				LastName.sendKeys((String)jsonObject.get("LastName"));
				EnterPostalCode.sendKeys((String)jsonObject.get("PostalCodeInd"));
				//Select Birth Date
				select = new Select(SelectMonth);
				select.selectByValue((String)jsonObject.get("BirthMonthGillette"));
				select = new Select(SelectYear);
				select.selectByValue((String)jsonObject.get("BirthYearGillette"));
			}
			else if(siteRegion.equalsIgnoreCase("Germany")) {
				ConfirmEnterEmail.sendKeys(strEmail);
			}
			EnterPassword.sendKeys((String)jsonObject.get("PasswordGillette"));
			if(siteRegion.equalsIgnoreCase("India") || siteRegion.equalsIgnoreCase("Germany"))
				ConfirmEnterPassword.sendKeys((String)jsonObject.get("PasswordGillette"));
			ClickNoThanksYes.click();
			CreateProfile.isDisplayed();
			CreateProfile.click();
			if(siteRegion.equalsIgnoreCase("Germany")) {
				Actions action = new Actions(driver);
				action.moveToElement(MoveToKontoGermany).build().perform();
			}
			Utilities.sleepMedium();
			try {
				VerifyRegistrationSuccess.isDisplayed();
			}catch(Exception e) {
				Assert.fail("Account is Not Created Successfully");
			}	
		}
	}
	
	public void loginToAccount(String siteRegion, String strEmail) {
		
		if(siteRegion.equalsIgnoreCase("Germany")) {
			Actions action = new Actions(driver);
			action.moveToElement(MoveToKontoGermany).build().perform();
			Utilities.sleepMedium();
			ClickLogOut.click();
			MoveToKontoGermany.isDisplayed();
			action.moveToElement(MoveToKontoGermany).build().perform();
			Utilities.sleepMedium();
			ClickLogInGerMany.click();
		}
		if(siteRegion.equalsIgnoreCase("France"))
			ClickLogInFrance.click();
		Utilities.sleepMedium();
		EnterSignInEmail.sendKeys(strEmail);
		EnterSignInPassword.sendKeys((String)jsonObject.get("PasswordGillette"));
		ClickSignIn.click();
		try {
			LoginSuccess.isDisplayed();
		}catch(Exception e) {
			Assert.fail("Login to Account is Not Successful");
		}
	}
	
	public void logOutAccount(String siteRegion) {
		Utilities.sleepMedium();
		ClickLogOutButton.isDisplayed();
		ClickLogOutButton.click();
		if(siteRegion.equalsIgnoreCase("India")) {
			Utilities.sleepMedium();
			ConfirmLogOut.isDisplayed();
			ConfirmLogOut.click();
		}
	}

	public void verifyForgotPassword(String siteRegion, String strEmail) {
		if(siteRegion.equalsIgnoreCase("France")) {
			ClickRegisterButton.isDisplayed();
			ClickRegisterButton.click();
			ClickLogInFrance.click();
		}
		if(siteRegion.equalsIgnoreCase("Germany")) {
			Actions action = new Actions(driver);
			action.moveToElement(MoveToKontoGermany).build().perform();
			Utilities.sleepMedium();
			ClickLogInGerMany.click();
		}
		ClickForgotPassword.isDisplayed();
		ClickForgotPassword.click();
		Utilities.sleepMedium();
		VerifyForgotPasswordPage.isDisplayed();
		EnterResetEmailId.sendKeys(strEmail);
		CreateNewPassword.click();
		Utilities.sleepMedium();
		String passwordTxt = ResetPasswordMailSent.getText();
		if(siteRegion.equalsIgnoreCase("India")) {
			if(!passwordTxt.trim().equalsIgnoreCase(TestData.get("PasswordResetInd")))
				Assert.fail("Password Reset Mail Sent Confirmation Message is Not Displayed");
		}
		else if(siteRegion.equalsIgnoreCase("Germany")) {
			System.out.println(passwordTxt);
			System.out.println(TestData.get("PasswordResetGermany"));
			if(!passwordTxt.trim().equalsIgnoreCase(TestData.get("PasswordResetGermany")))
				Assert.fail("Password Reset Mail Sent Confirmation Message is Not Displayed");
		}
		else if(siteRegion.equalsIgnoreCase("France")) {
			if(!passwordTxt.trim().equalsIgnoreCase(TestData.get("PasswordResetFrance")))
				Assert.fail("Password Reset Mail Sent Confirmation Message is Not Displayed");
		}
	}

}

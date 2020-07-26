package PageObjectModel.Gillette;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver = null;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[@title='REGISTER'] | //a[contains(text(),'Registrieren')] | //a[@data-action-detail='Mon compte']")
	private static WebElement ClickRegisterButton;
	
	@FindBy(xpath = "//input[@id='phdesktopbody_0_submit'] | //button[@type='submit' and contains(text(),'Registrieren')] | //button[@id='SubmitCreate']")
	private static WebElement CreateProfile;
	
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private static WebElement GermanyAcceptCookie;
	
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private static WebElement FranceAcceptCookie;
	
	@FindBy(xpath = "//span[text()='KONTO']")
	private static WebElement MoveToKontoGermany;
	
	public void ClickRegisterButton(String siteRegion) {
		
		if(siteRegion.equalsIgnoreCase("Germany")) {
			if(GermanyAcceptCookie.isDisplayed())
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", GermanyAcceptCookie);
			Actions action = new Actions(driver);
			action.moveToElement(MoveToKontoGermany).build().perform();
		}
		if(siteRegion.equalsIgnoreCase("France")) {
			if(FranceAcceptCookie.isDisplayed())
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", FranceAcceptCookie);
		}
		ClickRegisterButton.isDisplayed();
		ClickRegisterButton.click();
		if(!CreateProfile.isDisplayed())
			Assert.fail("Create Profile Page is Not Opened");
	}
	
}

package PageObjectModel.Goibibo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageObjectModel.Gillette.HomePage;
import cucumberTest.CucumberBDD.Utilities;
import static PageObjectModel.Goibibo.HomePageSelectJourneyDetails.journeyDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import static cucumberTest.CucumberBDD.Utilities.TestData;
import static cucumberTest.CucumberBDD.Utilities.jsonObject;

public class FlightSelectionPage {

	WebDriver driver = null;
	public FlightSelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//i[@class='ico13 icon-arrow2-up hpyBlueLt ']")
	private static WebElement PriceLowFlight;
	
	@FindBy(xpath = "(//input[@data-cy='bookBtn'])[1]")
	private static WebElement ClickBookButton;
	
	@FindBy(xpath = "//span[@class='fl mobdn ico18 padL10']")
	private static WebElement GetFromDestCityDate;
	
	@FindBy(xpath = "//label[@for='secure-trip' and text()='Yes, secure my trip']")
	private static WebElement ClickSecureTrip;
	
	@FindBy(xpath = "//select[@data-fieldname='Title']")
	private static WebElement SelectTitle;
	
	@FindBy(xpath = "//input[@id='AdultfirstName1']")
	private static WebElement EnterFirstName;
	
	@FindBy(xpath = "//input[@id='AdultlastName1']")
	private static WebElement EnterLastName;
	
	@FindBy(xpath = "//input[@id='email']")
	private static WebElement EnterEmailId;
	
	@FindBy(xpath = "//input[@id='mobile']")
	private static WebElement EnterMobileNumber;
	
	@FindBy(xpath = "//button[@class='button orange col-md-3 fr large dF justifyCenter min37']")
	private static WebElement ClickProceedButton;
	
	@FindBy(xpath = "//div[@class='flexCol alignItemsStart']/div[contains(text(),'#SkipTheQueue')]")
	private static WebElement VerifyPopUp;
	
	@FindBy(xpath = "//button[@class='button blue large fb padLR30' and text()='OK']")
	private static WebElement ClickPopupOk;
	
	@FindBy(xpath = "//span[text()='Proceed To Payment']")
	private static WebElement ClickProceedPayment;
	
	@FindBy(xpath = "//span[text()='Payment Details']")
	private static WebElement PaymentDetails;
	
	public void selectFlight() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(7L);
		//Verify FlightSelectPage is Opened
		try {
			PriceLowFlight.isDisplayed();
		  } catch (NoSuchElementException e) {
			  PriceLowFlight.click();
		}
		ClickBookButton.isDisplayed();
		ClickBookButton.click();
	}

	public void reviewBookingDetails() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(7L);
		ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(Tabs.get(1));
		String strCityDate = GetFromDestCityDate.getText().trim().toLowerCase();
		System.out.println("Sundaramoorthy");
		System.out.println(strCityDate);
		if(!strCityDate.contains(TestData.get("FromCity").toLowerCase()))
			Assert.fail("From City is Not Displayed");
		if(!strCityDate.contains(TestData.get("DestinationCity").toLowerCase()))
			Assert.fail("Destination City is Not Displayed");
		if(!strCityDate.contains(String.valueOf(journeyDate)))
			Assert.fail("journeyDate is Not Displayed");
			
		ClickSecureTrip.isDisplayed();
		ClickSecureTrip.click();
		Select select = new Select(SelectTitle);
		select.selectByValue("1");
		//Enter Passenger Details
		EnterFirstName.sendKeys(TestData.get("PassengerFirstName"));
		EnterLastName.sendKeys(TestData.get("PassengerLastName"));
		EnterEmailId.sendKeys(new Utilities().getEmailId());
		EnterMobileNumber.sendKeys(TestData.get("MobileNumber"));
		ClickProceedButton.click();
		TimeUnit.SECONDS.sleep(4L);
		try {
			VerifyPopUp.isDisplayed();
			ClickPopupOk.click();
		  } catch (NoSuchElementException e) {}
	}

	public void clickProceedPayment() throws InterruptedException {
		
		ClickProceedPayment.isDisplayed();
		ClickProceedPayment.click();
		try {
			PaymentDetails.isDisplayed();
		  } catch (NoSuchElementException e) {
			  Assert.fail("Payment Details Page is Not Opened");
		}
	}
}

package PageObjectModel.Goibibo;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumberTest.CucumberBDD.Utilities;

import static cucumberTest.CucumberBDD.Utilities.TestData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomePageSelectJourneyDetails {

	public static int journeyDate;
	WebDriver driver = null;
	public HomePageSelectJourneyDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h1[text()='Domestic and International Flights']")
	private static WebElement GoibiboHomePageLogo;
	
	@FindBy(xpath = "//span[@id='oneway']")
	private static WebElement SelectOneWay;
	
	@FindBy(xpath = "//input[@id='gosuggest_inputSrc']")
	private static WebElement EnterFromCity;
	
	@FindBy(xpath = "//input[@id='gosuggest_inputDest']")
	private static WebElement EnterDestinationCity;
	
	@FindBy(xpath = "//div[@class='DayPicker DayPicker--en']")
	private static WebElement SelectDateSuggestion;
	
	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	private static WebElement SelectNextMonth;
	
	@FindBy(xpath = "//button[@id='gi_search_btn']")
	private static WebElement ClickSearchButton;
	
	public void selectJourneyDetails() {
		
		//Verify HomePage is Opened
		if(!GoibiboHomePageLogo.isDisplayed())
			Assert.fail("Goibibo Home Page is Not Opened");
		String selectOneWay = SelectOneWay.getAttribute("class");
		if(!selectOneWay.trim().equals("curPointFlt switchAct"))
			SelectOneWay.click();
		EnterFromCity.sendKeys(TestData.get("FromCity"));
		Utilities.sleepMedium();
		EnterFromCity.sendKeys(Keys.ARROW_DOWN);
		EnterFromCity.sendKeys(Keys.ENTER);
		EnterDestinationCity.sendKeys(TestData.get("DestinationCity"));
		Utilities.sleepMedium();
		EnterDestinationCity.sendKeys(Keys.ARROW_DOWN);
		EnterDestinationCity.sendKeys(Keys.ENTER);
		if(!SelectDateSuggestion.isDisplayed())
			Assert.fail("Select Date Suggestion is Not Opened");
		//Select Date
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		int getDate = Integer.parseInt(dateFormat.format(cal.getTime()).toString());
		journeyDate = getDate + 3;
		if(journeyDate>30) {
			SelectNextMonth.click();
			journeyDate = 1;
		}
		driver.findElement(By.xpath("//div[@class='calDate' and contains(text(),'"+journeyDate+"')]")).click();
		ClickSearchButton.click();
	}



}

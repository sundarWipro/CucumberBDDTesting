package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import cucumberTest.CucumberBDD.Utilities;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjectModel.Gillette.HomePage;
import PageObjectModel.Goibibo.FlightSelectionPage;
import PageObjectModel.Goibibo.HomePageSelectJourneyDetails;

@RunWith(Cucumber.class)
public class GoibiboTicketBooking extends Utilities {

	WebDriver driver = null;
	
    @Given("^Initialize the Webdriver for Goibibo$")
    public void initialize_the_webdriver_for_goibibo(){
    	driver = setBrowserDriver();
    	//Implicit Wait
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^launch the Application URL \"([^\"]*)\"$")
    public void launch_the_application_url_something(String siteUrl){
    	launchApplication(driver, siteUrl);
    }

    @Then("^Select Journey Details$")
    public void select_journey_details(){
    	new HomePageSelectJourneyDetails(driver).selectJourneyDetails();
    }

    @Then("^Select Flight Details$")
    public void select_flight_details() throws InterruptedException{
    	new FlightSelectionPage(driver).selectFlight();
    }

    @And("^Review Flight and Add Passenger Details$")
    public void review_flight_and_add_passenger_details() throws InterruptedException {
    	new FlightSelectionPage(driver).reviewBookingDetails();
    	new FlightSelectionPage(driver).clickProceedPayment();
    }
    
    @And("^Close all the browser window$")
    public void close_all_the_browser_window(){
    	closeBrowser(driver);
    }

}
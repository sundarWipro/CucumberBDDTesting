package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import cucumberTest.CucumberBDD.Utilities;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import PageObjectModel.Gillette.AccountPage;
import PageObjectModel.Gillette.HomePage;

@RunWith(Cucumber.class)
public class GilletteUserValidations extends Utilities{
	
	WebDriver driver = null;
	String siteRegion = null, strEmailId = null;

    @Given("^Initialize the Webdriver$")
    public void initialize_the_webdriver(){
    	driver = setBrowserDriver();
    	//Implicit Wait
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^launch the Application URL (.+) and (.+)$")
    public void launch_the_application_url_and(String siteUrl, String siteRegion) {
    	launchApplication(driver, siteUrl);
    	this.siteRegion = siteRegion;
    }

    @Then("^Click Register Button in HomePage$")
    public void click_register_button_in_homepage(){
    	new HomePage(driver).ClickRegisterButton(siteRegion);
    }

    @Then("^Enter the Registration details$")
    public void enter_the_registration_details(){
    	strEmailId = getEmailId();
    	//France Site Have Captcha Verification in Account Create Section it's Not Possible to Automate So Skipping the Account Creation functionality
    	new AccountPage(driver).enterAccountDetails(siteRegion, strEmailId);
    }

    @And("^Login To Account$")
    public void login_to_account(){
    	if(siteRegion.equalsIgnoreCase("France"))
    		strEmailId = TestData.get("FranceEmailId");
    	new AccountPage(driver).loginToAccount(siteRegion, strEmailId);
    }
    
    @And("^LogOut of the Account$")
    public void logout_of_the_account() {
    	new AccountPage(driver).logOutAccount(siteRegion);
    }
    
    @Then("^Verify Password Reset Function$")
    public void verify_password_reset_function(){
    	new AccountPage(driver).verifyForgotPassword(siteRegion, strEmailId);
    }

    @And("^Quite The Webdriver$")
    public void quite_the_webdriver() {
    	closeBrowser(driver);
    }
    
}
package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import cucumberTest.CucumberBDD.Utilities;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class ReadTestData {

    @Given("^Read The TestData$")
    public void read_the_testdata() {
    	Utilities.loadTestData();
    }
    
}

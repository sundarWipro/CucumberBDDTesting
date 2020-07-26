Feature: Goibibo Application Flight Ticket Booking

Scenario: Load Test Data Before Starting The Test Execution
Given Read The TestData

Scenario: Goibibo Application Ticket Booking
Given Initialize the Webdriver for Goibibo
When launch the Application URL "https://www.goibibo.com/"
Then Select Journey Details
Then Select Flight Details
And Review Flight and Add Passenger Details
And Close all the browser window
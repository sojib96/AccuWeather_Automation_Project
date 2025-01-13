package stepdefinitions;

import io.cucumber.java.en.When;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BrowserSteps {

    @When("the user goes back to the main page")
    public void goBack() {
        getBrowser().goBack();
    }
}

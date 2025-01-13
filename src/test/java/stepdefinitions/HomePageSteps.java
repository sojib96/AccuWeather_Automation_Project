package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;

public class HomePageSteps {
    private final MainPage mainPage = new MainPage();

    @When("the user accepts the data usage consent")
    public void acceptDataUsageConsent() {
        mainPage.acceptConsentDataUsage();
    }

    @When("the user inputs {string} in the search field")
    public void inputStringToTheSearchField(String string) {
        mainPage.inputInTheSearchField(string);
        mainPage.waitForSearchResulListToDisplay();
    }

    @Then("the user should see that the search results list is displayed")
    public void verifySearchResultIsDisplayed() {
        Assert.assertTrue(mainPage.waitForSearchResulListToDisplay(), "Search Result is not displayed");
    }

    @When("the user clicks on the first search result")
    public void clickFirstSearchResult() {
        mainPage.clickOnTheFirstSearchResult();
        mainPage.state().waitForNotDisplayed();
    }

    @Then("the user should see that the main page is displayed")
    public void verifyMainPageIsDisplayed() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Home Page is not displayed");
    }

   @When("the user chooses the first city from Recent locations")
    public void chooseFirstRecentLocation() {
        mainPage.clickOnTheFirstCityInRecentLocation();
   }

   @When("the user clicks on the search field")
    public void clickOnTheSearchField() {
        mainPage.clickOnTheSearchField();
   }

   @Then("the Use your current location label is displayed")
    public void verifyCurrentLocationLabel() {
        Assert.assertTrue(mainPage.waitForUseYourCurrentLocationToDisplay(), "Use Your Current Location is not displayed");
   }
}

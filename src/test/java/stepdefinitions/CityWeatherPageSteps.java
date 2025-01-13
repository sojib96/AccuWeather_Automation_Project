package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CityWeatherPage;

public class CityWeatherPageSteps {
    private final CityWeatherPage cityWeatherPage = new CityWeatherPage();

    @Then("the user should see that the city weather page header contains {string}")
    public void verifyHeaderName(String string) {
        Assert.assertTrue(cityWeatherPage.getCityWeatherHeaderName().contains(string), "City name does not match");
    }
}

package hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.*;
import io.qameta.allure.Step;
import utils.SettingsTestData;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class Hooks {

    @Before
    @Step("Maximizes the browser window and navigating to the accuweather main page")
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(SettingsTestData.getEnvData().getHost());
    }

    @After
    @Step("Quiting the browser and closing session")
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}

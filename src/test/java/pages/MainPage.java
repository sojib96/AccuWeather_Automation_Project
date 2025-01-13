package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.BrowserUtils;

import java.util.List;

public class MainPage extends Form {
    private final By resultListLocator = By.className("search-bar-result__name");
    private final By recentLocationLocator = By.xpath("//div[@class='featured-locations']//a");
    private final IButton dataConsentBtn = getElementFactory().getButton(By.className("policy-accept"), "Consent data usage");
    private final ITextBox searchInputTextBox = getElementFactory().getTextBox(By.className("search-input"), "Search input Box");
    private final ILabel searchResultsContainer = getElementFactory().getLabel(By.className("results-container"), "Search result container");
    private final ILabel getIframeElement = getElementFactory().getLabel(By.xpath("//iframe[@id='google_ads_iframe_/6581/web/gb/interstitial/news_info/country_home_0']"), "Adds iframe");
    private final IButton removeAdds = getElementFactory().getButton(By.id("dismiss-button"), "Dismiss button");
    private final ILabel useYourCurrentLocationLabel = getElementFactory().getLabel(By.className("current-location-text"), "Use your current location label");

    public MainPage() {
        super(By.className("featured-locations__header"), "Accuweather main page");
    }

    @Step("Clicks on the data consent usage")
    public void acceptConsentDataUsage() {
        dataConsentBtn.click();
    }

    @Step("Provides input to the search box")
    public void inputInTheSearchField(String inputString) {
        searchInputTextBox.clearAndType(inputString);
    }

    @Step("Waits for search result list to display")
    public boolean waitForSearchResulListToDisplay() {
        return searchResultsContainer.state().waitForDisplayed();
    }

    @Step("Clicks on the first search result")
    public void clickOnTheFirstSearchResult() {
        getListOfSearchResults().get(0).click();
    }

    @Step("Clicks on the first location from recent location section")
    public void clickOnTheFirstCityInRecentLocation() {
        getRecentLocation().get(0).click();
        removeGoogleAdds();
    }

    @Step("Clicks on the search box")
    public void clickOnTheSearchField() {
        searchInputTextBox.click();
    }

    @Step("Waits for the use your current location to display")
    public boolean waitForUseYourCurrentLocationToDisplay() {
        return useYourCurrentLocationLabel.state().waitForDisplayed();
    }

    @Step("Gets the list of search results")
    private List<ILabel> getListOfSearchResults() {
        return getElementFactory().findElements(resultListLocator, "Search result", ElementType.LABEL);
    }

    @Step("Gets the list of recent location")
    private List<ILink> getRecentLocation() {
        return getElementFactory().findElements(recentLocationLocator, "Use your current location label",ElementType.LINK);
    }

    @Step("Remove google ads if they appear")
    private void removeGoogleAdds() {
        if (getIframeElement.state().isExist()) {
            BrowserUtils.switchToFrame(getIframeElement.getElement());
            removeAdds.click();
            BrowserUtils.returnDefaultContent();
        }
    }
}

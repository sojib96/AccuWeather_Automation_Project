package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CityWeatherPage extends Form {
    private final ILabel cityNameHeader = getElementFactory().getLabel(By.className("header-loc"), "City Name Header");

    public CityWeatherPage() {
        super(By.className("card-header"), "City Weather Page");
    }

    @Step("Gets the text of the header from city weather page")
    public String getCityWeatherHeaderName() {
        return cityNameHeader.getText();
    }
}

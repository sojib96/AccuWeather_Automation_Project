package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class BrowserUtils {

    public void switchToFrame(WebElement element) {
        getBrowser().getDriver().switchTo().frame(element);
    }

    public void returnDefaultContent() {
        getBrowser().getDriver().switchTo().defaultContent();
    }
}

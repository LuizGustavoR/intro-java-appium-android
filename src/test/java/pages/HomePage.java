package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Text\"]")
    private WebElement listItemText;

    public HomePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public void clickListItemText() {
        listItemText.click();
    }

}

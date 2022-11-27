package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListTextPage {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"LogTextBox\"]")
    private WebElement listItemTextLog;

    public ListTextPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public void clickListItemLogTextBox() {
        listItemTextLog.click();
    }

}

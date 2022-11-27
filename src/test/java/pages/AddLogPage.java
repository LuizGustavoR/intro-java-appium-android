package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddLogPage {

    @FindBy(id = "io.appium.android.apis:id/add")
    private WebElement btnAdd;
    @FindBy(id = "io.appium.android.apis:id/text")
    private WebElement textViewLog;

    public AddLogPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public void clickAddLogButton() {
        btnAdd.click();
    }

    public String getTextViewMessage() {
        return textViewLog.getText().trim();
    }

}

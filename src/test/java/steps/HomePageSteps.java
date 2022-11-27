package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddLogPage;
import pages.HomePage;
import pages.ListTextPage;
import setup.SetupMyAppiumDriver;

import java.io.IOException;

public class HomePageSteps {

    private AppiumDriver appiumDriver;
    private HomePage homePage;
    private ListTextPage listTextPage;
    private AddLogPage addLogPage;

    @Before
    public void setup() throws IOException {
        appiumDriver = new SetupMyAppiumDriver().getAppiumDriver();
        homePage = new HomePage(appiumDriver);
        listTextPage = new ListTextPage(appiumDriver);
        addLogPage = new AddLogPage(appiumDriver);
    }

    @Given("I open the Log-TextBox screen")
    public void iOpenTheLogTextBoxScreen() {
        // Text -> LogTextBox
        homePage.clickListItemText();
        listTextPage.clickListItemLogTextBox();
    }

    @When("I click the Add button")
    public void iClickTheAddButton() {
        addLogPage.clickAddLogButton();
    }

    @Then("the Log view display {string}")
    public void theLogViewDisplay(String log) {
        Assert.assertEquals(log, addLogPage.getTextViewMessage());
    }

    @After
    public void tearDown(){
        appiumDriver.quit();
    }

}

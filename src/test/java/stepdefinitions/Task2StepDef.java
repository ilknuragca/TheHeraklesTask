package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MainPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Task2StepDef {

    //creating MainPage obj.
    MainPage mainPage= new MainPage();


    @Given("user goes to {string}")
    public void userGoesTo(String url) {

        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }

    @When("user clicks on the tv text")
    public void user_clicks_on_the_tv_text() {
        //Clicks CheckBox
        mainPage.selectTV.click();
        Driver.wait(1);
    }

    @Then("user verifies the tv checkbox is selected")
    public void userVerifiesTheTvCheckboxIsSelected() {
        Assert.assertEquals("TV",mainPage.tagText.getText());
        Assert.assertTrue(mainPage.selectTV.isSelected());
    }

    @Then("user verifies the tv checkbox is deselected")
    public void userVerifiesTheTvCheckboxIsDeselected() {
        Assert.assertFalse(mainPage.tagText.isDisplayed());
        Assert.assertFalse(mainPage.selectTV.isSelected());
    }

    @When("user clicks on the console text")
    public void userClicksOnTheConsoleText() {
        //Clicks CheckBox
        mainPage.selectConsole.click();
        Driver.wait(1);
    }

    @Then("user verifies the console checkbox is selected")
    public void userVerifiesTheConsoleCheckboxIsSelected() {
        Assert.assertEquals("Console",mainPage.tagText.getText());
        Assert.assertTrue(mainPage.selectConsole.isSelected());
    }

    @Then("user verifies the console checkbox is deselected")
    public void userVerifiesTheConsoleCheckboxIsDeselected() {
        Assert.assertFalse(mainPage.selectConsole.isSelected());
        Assert.assertFalse(mainPage.tagText.isDisplayed());
    }

    @When("user clicks on the smartPhone text")
    public void userClicksOnTheSmartPhoneText() {
        //Clicks CheckBox
        mainPage.selectSmartPhone.click();
        Driver.wait(1);
    }

    @Then("user verifies the smartPhone checkbox is selected")
    public void userVerifiesTheSmartPhoneCheckboxIsSelected() {
        Assert.assertEquals("Smart Phone",mainPage.tagText.getText());
        Assert.assertTrue(mainPage.selectSmartPhone.isSelected());
    }

    @Then("user verifies the smartPhone checkbox is deselected")
    public void userVerifiesTheSmartPhoneCheckboxIsDeselected() {
        Assert.assertFalse(mainPage.selectSmartPhone.isSelected());
        Assert.assertFalse(mainPage.tagText.isDisplayed());
    }



}

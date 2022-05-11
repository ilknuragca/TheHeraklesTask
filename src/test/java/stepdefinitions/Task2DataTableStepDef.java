package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utilities.Driver;
import java.io.IOException;
import java.util.List;

public class Task2DataTableStepDef {

    MainPage mainPage = new MainPage();
    WebElement element;
    List<String> checkboxDataList;

    @When("user clicks on checkbox and verifies_checkbox is selected")
    public void userClicksOnCheckboxAndVerifies_checkboxIsSelected(DataTable checkboxTable) throws IOException {


        for(int i=1;i<checkboxTable.height();i++){  //checkboxTable.height=4

           checkboxDataList=checkboxTable.row(i);//returns row (i) data as List

            element = mainPage.findElementWithLocate(checkboxDataList.get(0)); //column 0= checkbox_location
            element.click();
            Driver.wait(1);

            Assert.assertEquals(mainPage.tagText.getText(),checkboxDataList.get(1)); //column 1=verifies_checkbox
            Driver.wait(1);

            element.click();
            Assert.assertFalse(element.isSelected());
            Driver.wait(1);

    }}



}
package stepdefinitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Task2ExcelStepDef {

    ExcelUtil excelUtil;

    //dataMap will be used to store the Excel data
    List<Map<String,String>> dataMap;

    //MainPage object to access the MainPage elements
    MainPage mainPage= new MainPage();

    WebElement element;



    @When("user clicks with excel as {string} and verifies checkbox is selected")
    public void userClicksWithExcelAsAndVerifiesCheckboxIsSelected(String sheetName) throws IOException {

        //path of excelsheet
        String path="src/test/resources/testdata/task2.xlsx";

        excelUtil= new ExcelUtil(path, sheetName); //sheetName= testData1

        dataMap=excelUtil.getDataList();

        //Using a loop to get the list of credentials
        for(Map<String,String> eachData: dataMap){


          element= mainPage.findElementWithLocate(eachData.get("location")); //location column
            Driver.waitAndClick(element);
            ReusableMethods.getScreenshot("SelectedWithExcelFile");

            Driver.wait(1);
            Assert.assertEquals(eachData.get("checkbox"),mainPage.tagText.getText()); //checkbox column

            Driver.waitAndClick(element);
            ReusableMethods.getScreenshot("DeselectedWithExcelFile");
            Assert.assertFalse(element.isSelected());
        }


    }


}


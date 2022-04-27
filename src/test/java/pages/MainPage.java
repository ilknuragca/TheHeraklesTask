package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {

    public MainPage(){
        //creating the constructor to initialize the page element
        PageFactory.initElements(Driver.getDriver(),this);
    }

  //Find the WebElement

    @FindBy(id="cbTV")        //you want to use xpath => xpath = "//*[@id='cbTV']"
    public WebElement selectTV;

    @FindBy(id="cbConsole")
    public WebElement selectConsole;

    @FindBy(id="cbSmartPhone")
    public WebElement selectSmartPhone;

    @FindBy(tagName = "h5")
    public WebElement tagText;
}

package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageElementsOtherCalc extends BaseElements {

    public PageElementsOtherCalc(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "OtherCalciFrame")
    public WebElement frame;

    @FindBy(id = "saveButtonSettings")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='w-box-content']/table")
    public WebElement resultsInTables;


    /********************************************** PACE CALCULATOR ELEMENTS ***********************************************/

    @FindBy(xpath = "//a[text()='Pace Calculator']")
    public WebElement paceCalcTab;

    public By paceCalcTabLocator = By.xpath("//a[text()='Pace Calculator']");

    @FindBy(xpath = "//h5[contains(.,'Enter a distance and time to calculate pace:')]")
    public WebElement paceCalcTitleText;

    @FindBy(id = "RunDist")
    public WebElement distanceInputField;

    @FindBy(id = "RaceDist")
    public WebElement distanceDropDown;

    @FindBy(css = "#RaceDist option")
    public WebElement distanceDropDownView;

    @FindBy(css = "#RaceDist option")
    public List<WebElement> distanceDropDownOption;

    @FindBy(id = "TimeHH")
    public WebElement hhInputField;

    @FindBy(id = "TimeMM")
    public WebElement mmInputField;

    @FindBy(id = "TimeSS")
    public WebElement ssInputField;


    /********************************************** CALORIC NEEDS ELEMENTS ***********************************************/

    @FindBy(xpath = "//a[text()='Caloric Needs']")
    public WebElement caloricNeedsTab;

    public By caloricNeedsTabLocator = By.xpath("//a[text()='Caloric Needs']");

    @FindBy(xpath = "//h5[contains(.,'Enter your information below:')]")
    public WebElement caloricNeedsTitleText;

    @FindBy(id = "Weight")
    public WebElement weightInputField;

    @FindBy(id = "HeightInchCent")
    public WebElement heightInputField;

    @FindBy(id = "Age")
    public WebElement ageInputField;

    @FindBy(id = "RunDist")
    public WebElement runDistanceInputField;

    @FindBy(id = "optionsRadios5")
    public WebElement maleRadioButton;

}

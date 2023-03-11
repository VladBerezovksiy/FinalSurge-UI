package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageElementsWorkoutCalc extends BaseElements {

    public PageElementsWorkoutCalc(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "IntensityCalciFrame")
    public WebElement frame;

    @FindBy(id = "saveButtonSettings")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='w-box-content']/table")
    public WebElement resultsInTables;


    /********************************************** PALLADINO ELEMENTS ***********************************************/

    @FindBy(xpath = "//h5[contains(.,'Calculate Interval Power Targets')]")
    public WebElement palladinoTitleText;

    @FindBy(xpath = "//a[text()='Palladino']")
    public WebElement palladinoBtn;

    @FindBy(id = "CP")
    public WebElement criticalPowerInputField;

    @FindBy(id = "RWC")
    public WebElement reserveWorkInputField;

    @FindBy(id = "AVPWS")
    public WebElement shortTestInputField;

    @FindBy(id = "TimeMML")
    public WebElement longMmInputFiled;

    @FindBy(id = "TimeSSL")
    public WebElement longSsInputFiled;

    @FindBy(id = "AVPWL")
    public WebElement longTestInputFiled;

    @FindBy(id = "TimeHHR")
    public WebElement hhInputField;

    @FindBy(id = "TimeMMR")
    public WebElement mmInputField;

    @FindBy(id = "TimeSSR")
    public WebElement ssInputField;

    @FindBy(id = "RAP")
    public WebElement raceAvgPowerInputField;

    @FindBy(id = "TimeMMRR")
    public WebElement rcMmInputField;

    @FindBy(id = "TimeSSRR")
    public WebElement rcSsInputField;

    @FindBy(id = "RAPR")
    public WebElement raceAvgPowerWInputField;

    @FindBy(id = "saveButtonSettings2")
    public WebElement submitBtn1;

    @FindBy(id = "saveButtonSettings3")
    public WebElement submitBtn2;

    @FindBy(id = "saveButtonSettings4")
    public WebElement submitBtn3;


    /********************************************** TINMAN ELEMENTS ***********************************************/

    @FindBy(xpath = "//h5[contains(.,'Enter your most recent Race Time')]")
    public WebElement tinmanTitleText;

    @FindBy(xpath = "//a[text()='Tinman']")
    public WebElement tinmanBtn;

    @FindBy(xpath = "//select[@name='distance']")
    public WebElement rDistanceDropdown;

    @FindBy(xpath = "//select[@name='distance']/option")
    public WebElement rDistanceDropdownView;

    @FindBy(xpath = "//select[@name='distance']/option")
    public List<WebElement> rDistanceDropdownOption;

    @FindBy(id = "Male")
    public WebElement maleRadioBtn;


    /********************************************** MCMILLAN ELEMENTS ***********************************************/

    @FindBy(xpath = "//h5[contains(.,'Enter a recent race time (or estimated time)')]")
    public WebElement mcMillanTitleText;

    @FindBy(xpath = "//a[text()='McMillan']")
    public WebElement mcMillanBtn;

    @FindBy(id = "GTimeHH")
    public WebElement gEventHhInputFiled;

    @FindBy(id = "GTimeMM")
    public WebElement gEventMmInputFiled;

    @FindBy(id = "GTimeSS")
    public WebElement gEventSsInputFiled;

    @FindBy(id = "distance")
    public WebElement raceDistanceDropdown;

    @FindBy(css = "#distance option")
    public WebElement raceDistanceDropdownView;

    @FindBy(css = "#distance option")
    public List<WebElement> raceDistanceDropdownOption;

    @FindBy(xpath = "//select[@name='goaldistance']")
    public WebElement goalDistanceDropdown;

    @FindBy(xpath = "//select[@name='goaldistance']/option")
    public WebElement goalDistanceDropdownView;

    @FindBy(xpath = "//select[@name='goaldistance']/option")
    public List<WebElement> goalDistanceDropdownOption;


    /********************************************** HANSONS ELEMENTS ***********************************************/

    @FindBy(xpath = "//h5[contains(.,'Enter a recent race time or goal time below')]")
    public WebElement hansonsTitleText;

    @FindBy(xpath = "//a[text()='Hansons']")
    public WebElement hansonsBtn;

    @FindBy(id = "RaceDist")
    public WebElement distanceDropdown;

    @FindBy(css = "#RaceDist option")
    public WebElement distanceDropdownView;

    @FindBy(css = "#RaceDist option")
    public List<WebElement> distanceDropdownOption;

    @FindBy(id = "Temp")
    public WebElement tempInputField;

    @FindBy(id = "Humid")
    public WebElement humidityInputField;

    @FindBy(id = "Wind")
    public WebElement windSpeedInputField;


    /********************************************** INTENSITY ELEMENTS ***********************************************/

    @FindBy(xpath = "//h4[contains(.,'Running Workout Intensity Calculator')]")
    public WebElement intensityTitleText;

    @FindBy(xpath = "//button[text()='Intensity']")
    public WebElement intensityBtn;

    @FindBy(id = "MARATHON")
    public WebElement eventRadioBtn;

    @FindBy(id = "TimeHH")
    public WebElement eventHhInputFiled;

    @FindBy(id = "TimeMM")
    public WebElement eventMmInputFiled;

    @FindBy(id = "TimeSS")
    public WebElement eventSsInputFiled;

}

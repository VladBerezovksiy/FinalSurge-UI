package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageElementsDailyVitals extends BaseElements {

    public PageElementsDailyVitals(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "del-vitals")
    public WebElement trashIcon;

    @FindBy(xpath = "//div[@class='modal-footer']/a[contains(.,'OK')]")
    public WebElement okBtn;

    @FindBy(id = "PastDays")
    public WebElement selectDateDropdown;

    @FindBy(css = "#PastDays option")
    public WebElement selectDateDropdownView;

    @FindBy(css = "#PastDays option")
    public List<WebElement> selectDateDropdownOption;

    @FindBy(css = ".table-striped td a")
    public List<WebElement> dateLinks;

    @FindBy(css = ".table-striped th")
    public List<WebElement> columns;

    @FindBy(id = "Steps")
    public WebElement stepsInputField;

    @FindBy(id = "Calories")
    public WebElement caloriesInputField;

    @FindBy(id = "Weight")
    public WebElement weightInputField;

    @FindBy(id = "BodyFat")
    public WebElement bodyFatsInputField;

    @FindBy(id = "WaterPercent")
    public WebElement waterPercentInputField;

    @FindBy(id = "MuscleMass")
    public WebElement muscleMassInputField;

    @FindBy(id = "RestHR")
    public WebElement restingHRInputField;

    @FindBy(id = "HRVar")
    public WebElement HRVariabilityInputField;

    @FindBy(id = "SleepHours")
    public WebElement sleepHoursInputField;

    @FindBy(id = "AwakeTime")
    public WebElement awakeTimeInputField;

    @FindBy(id = "SleepAmount")
    public WebElement sleepAmountDropdown;

    @FindBy(css = "#SleepAmount option")
    public WebElement sleepAmountDropdownView;

    @FindBy(css = "#SleepAmount option")
    public List<WebElement> sleepAmountDropdownOption;

    @FindBy(id = "SleepQuality")
    public WebElement sleepQualityDropdown;

    @FindBy(css = "#SleepQuality option")
    public WebElement sleepQualityDropdownView;

    @FindBy(css = "#SleepQuality option")
    public List<WebElement> sleepQualityDropdownOption;

    @FindBy(id = "Stress")
    public WebElement stressAmountDropdown;

    @FindBy(css = "#Stress option")
    public WebElement stressAmountDropdownView;

    @FindBy(css = "#Stress option")
    public List<WebElement> stressAmountDropdownOption;

    @FindBy(id = "Systolic")
    public WebElement bloodPressureInputField;

    @FindBy(id = "Diastolic")
    public WebElement bloodPressure2InputField;

    @FindBy(id = "HealthNotes")
    public WebElement healsNotesInputField;

    @FindBy(id = "saveButton")
    public WebElement submitAddVitals;

}

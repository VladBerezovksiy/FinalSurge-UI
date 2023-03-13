package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageElementsWorkout extends BaseElements {

    public PageElementsWorkout(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".w-box-header h4")
    public WebElement optionsTable;


    /************************************ NEW ACTIVITY TYPE ELEMENTS ***********************************************/

    @FindBy(id = "ATypeName")
    public WebElement activityTypeInputField;

    @FindBy(css = "div.hideable .w-box-header h4")
    public List<WebElement> activityType;


    /************************************ NEW ACTIVITY ZONE ELEMENTS ***********************************************/

    @FindBy(id = "ZoneType")
    public WebElement zoneTypeDropdown;

    @FindBy(css = "#ZoneType option")
    public WebElement zoneTypeDropdownView;

    @FindBy(css = "#ZoneType option")
    public List<WebElement> zoneTypeDropdownOption;

    @FindBy(id = "Zone1High")
    public WebElement zone1InputField;

    @FindBy(id = "Zone2High")
    public WebElement zone2InputField;

    @FindBy(id = "Zone3High")
    public WebElement zone3InputField;

    @FindBy(id = "Zone4High")
    public WebElement zone4InputField;

    @FindBy(id = "Zone5High")
    public WebElement zone5InputField;

    @FindBy(id = "Zone6High")
    public WebElement zone6InputField;


    /************************************ WORKOUT LIBRARY ELEMENTS ***********************************************/

    @FindBy(id = "FolderID")
    public WebElement libraryDropdown;

    @FindBy(id = "LibCode")
    public WebElement libraryCodeInputField;

    @FindBy(css = ".icon-plus")
    public WebElement plusIcon;

    @FindBy(css = ".table-condensed")
    public WebElement tableNewActivityZone;

    @FindBy(css = ".table-condensed tr td:nth-child(2)")
    public List<WebElement> libraryTable;


    /************************************ PRINT WORKOUTS ELEMENTS ***********************************************/

    public By errorMessage = By.cssSelector(".alert-error");

    @FindBy(xpath = "//table//a")
    public WebElement printLink;

    @FindBy(id = "EditProfile")
    public List<WebElement> printResult;

    @FindBy(id = "PrintWorkoutsiFrame")
    public WebElement printFrame;

    @FindBy(id = "PrintStartDate")
    public WebElement printStartDateInput;

    @FindBy(id = "PrintEndDate")
    public WebElement printEndDateInput;

    @FindBy(id = "saveButtonPrint")
    public WebElement submitPrintBtn;


    /************************************ REPORTS & STATISTICS ELEMENTS ***********************************************/

    @FindBy(id = "WorkoutDateEnd")
    public WebElement endDateInputField;

    @FindBy(id = "groupBy1")
    public WebElement listViewRadioBtn;

    @FindBy(css = ".table-striped tr td:nth-child(2)")
    public List<WebElement> reportTable;


    /***************************************** VIEW CALENDAR ELEMENTS *************************************************/

    @FindBy(css = ".detailslink")
    public List<WebElement> dataInCalendar;

    @FindBy(id = "QuickAddToggle")
    public WebElement quickAddButton;

    @FindBy(id = "WorkoutLibAdd")
    public WebElement addWorkoutLibraryButton;

    @FindBy(id = "FullAddBtn")
    public WebElement fullAddButton;

    @FindBy(id = "GarminAddBtn")
    public WebElement addGarminButton;

    @FindBy(id = "ActivityType")
    public WebElement activityTypeDropDown;

    @FindBy(css = "#ActivityType option")
    public WebElement activityTypeDropDownView;

    @FindBy(css = "#ActivityType option")
    public List<WebElement> activityTypeDropDownOptions;

    @FindBy(id = "HowFeel")
    public WebElement howIFeelDropDown;

    @FindBy(css = "#HowFeel option")
    public WebElement howIFeelDropDownView;

    @FindBy(css = "#HowFeel option")
    public List<WebElement> howIFeelDropDownOptions;


    /***************************************** ADD WORKOUT ELEMENTS *************************************************/

    @FindBy(css = "#col1 .w-box-content")
    public WebElement workoutForm;

    @FindBy(id = "WorkoutDate")
    public WebElement dateInputField;

    @FindBy(id = "WorkoutTime")
    public WebElement timeOfDayInputField;

    @FindBy(id = "Name")
    public WebElement workoutNameInputField;

    @FindBy(id = "Desc")
    public WebElement workoutDescriptionInputField;

    @FindBy(id = "PlannedWorkout")
    public WebElement distanceCheckbox;

    @FindBy(xpath = "//*[@id='tBasic']/parent::li")
    public WebElement basicWorkoutTab;

    @FindBy(id = "Distance")
    public WebElement distanceInputField;

    @FindBy(id = "DistType")
    public WebElement distanceDropDown;

    @FindBy(css = "#DistType option")
    public WebElement distanceDropDownView;

    @FindBy(css = "#DistType option")
    public List<WebElement> distanceDropDownOptions;

    @FindBy(id = "Duration")
    public WebElement durationInputField;

    @FindBy(id = "Pace")
    public WebElement paceInputField;

    @FindBy(id = "PaceType")
    public WebElement paceDropDown;

    @FindBy(css = "#PaceType option")
    public WebElement paceDropDownView;

    @FindBy(css = "#PaceType option")
    public List<WebElement> paceDropDownOptions;

    @FindBy(id = "IsRace")
    public WebElement raceCheckbox;

    @FindBy(id = "OverallPlace")
    public WebElement placeInputField;

    @FindBy(id = "AgeGroupPlace")
    public WebElement ageGroupPlaceInputField;

    @FindBy(id = "hf_great")
    public WebElement howIFeltRadioButton;

    @FindBy(id = "PerEffort")
    public WebElement perceivedEffortDropdown;

    @FindBy(css = "#PerEffort option")
    public WebElement perceivedEffortDropdownView;

    @FindBy(css = "#PerEffort option")
    public List<WebElement> perceivedEffortDropdownOption;

    @FindBy(id = "saveButton")
    public WebElement addWorkoutSubmitBtn;

    public By addWorkoutSubmitBtnLocator = By.id("saveButton");


    /********************************** ACTIVITY TYPE NAVIGATION BAR *************************************************/
    /********************************** RUN NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement runTab;

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]/div[@id]//li[2]/a")
    public WebElement fartlekSubTab;

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]/div[@id]//li[3]/a")
    public WebElement hillsSubTab;


    /********************************** BIKE NAVIGATION BAR *************************************************/


    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement bikeTab;


    /********************************** SWIM NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement swimTab;


    /********************************** CROSS NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement crossTab;


    /********************************** WALK NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement walkTab;


    /********************************** REST NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement restTab;


    /********************************** STRENGTH NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement strengthTab;


    /********************************** RECOVERY NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement recoveryTab;


    /********************************** OTHER NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement otherTab;


    /********************************** TRANSITION NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement transitionTab;


    /********************************** ADD NEW TYPE NAVIGATION BAR *************************************************/

    @FindBy(xpath = "//div[@id='blog_accordion_left']//div[@class='accordion-group'][1]")
    public WebElement addNewTypeTab;


}

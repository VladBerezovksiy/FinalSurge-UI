package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElementsWorkout extends BaseElements {

    public PageElementsWorkout(WebDriver driver) {
        super(driver);
    }


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

    @FindBy(id = "tBasic")
    public WebElement basicWorkoutTab;

    @FindBy(id = "Distance")
    public WebElement distanceInputField;

    @FindBy(id = "DistType")
    public WebElement distanceDropDown;

    @FindBy(id = "Duration")
    public WebElement durationInputField;

    @FindBy(id = "Pace")
    public WebElement paceInputField;

    @FindBy(id = "Pace")
    public WebElement paceDropDown;

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

    @FindBy(id = "saveButton")
    public WebElement addWorkoutSubmitBtn;


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

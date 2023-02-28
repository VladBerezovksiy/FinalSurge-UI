package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsWorkout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

public class WorkoutTestLogic extends MainLogic {

    private PageElementsWorkout elements;

    public WorkoutTestLogic(WebDriver driver, WebDriverWait wait, PageElementsWorkout elements) {
        super(driver, wait, elements);
        this.elements = elements;
    }

    @Override
    public void getRootPage() {
        browseLoginPage();
    }

    @Override
    public void backToRootPage() {
        browseLoginPage();
    }


    public void addWorkout() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.addWorkoutBtn);
        clickWhenReady(elements.runTab);
        clickWhenReady(elements.hillsSubTab);
        waitForVisible(elements.workoutForm);
        waitForVisible(elements.dateInputField).clear();
        waitForVisible(elements.dateInputField).sendKeys("");
        waitForVisible(elements.timeOfDayInputField).clear();
        waitForVisible(elements.timeOfDayInputField).sendKeys("");
        waitForVisible(elements.workoutNameInputField).clear();
        waitForVisible(elements.workoutNameInputField).sendKeys("");
        waitForVisible(elements.workoutDescriptionInputField).clear();
        waitForVisible(elements.workoutDescriptionInputField).sendKeys("");
        clickWhenReady(elements.distanceCheckbox);
        // TODO поставить метод на Basic Workout
        waitForVisible(elements.distanceInputField).clear();
        waitForVisible(elements.distanceInputField).sendKeys("");
//        selectDropdownOption();
        waitForVisible(elements.durationInputField).clear();
        waitForVisible(elements.durationInputField).sendKeys("");
        waitForVisible(elements.paceInputField).clear();
        waitForVisible(elements.paceInputField).sendKeys("");
//        selectDropdownOption();
        clickWhenReady(elements.raceCheckbox);
        waitForVisible(elements.placeInputField).clear();
        waitForVisible(elements.placeInputField).sendKeys("");
        waitForVisible(elements.ageGroupPlaceInputField).clear();
        waitForVisible(elements.ageGroupPlaceInputField).sendKeys("");
        clickWhenReady(elements.howIFeltRadioButton);
//        selectDropdownOption();
        clickWhenReady(elements.addWorkoutSubmitBtn);
        waitForInvisible(elements.addWorkoutSubmitBtn);
    }

}

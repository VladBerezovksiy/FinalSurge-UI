package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsWorkout;
import logic.models.WorkoutModel;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

import java.util.Locale;

@Log4j2
public class WorkoutTestLogic extends MainLogic {

    private PageElementsWorkout elements;

    private final WorkoutModel workoutModel = new WorkoutModel();

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


    @Step("Check Add Workout")
    public void addWorkout() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.addWorkoutBtn);
        clickWhenReady(elements.runTab);
        clickWhenReady(elements.hillsSubTab);
        waitForVisible(elements.workoutForm);
        waitForVisible(elements.dateInputField).clear();
        waitForVisible(elements.dateInputField)
                .sendKeys(workoutModel.getDate());
        waitForVisible(elements.timeOfDayInputField).clear();
        waitForVisible(elements.timeOfDayInputField)
                .sendKeys(workoutModel.getTime());
        waitForVisible(elements.workoutNameInputField).clear();
        waitForVisible(elements.workoutNameInputField)
                .sendKeys(workoutModel.getName());
        waitForVisible(elements.workoutDescriptionInputField).clear();
        waitForVisible(elements.workoutDescriptionInputField)
                .sendKeys(workoutModel.getDescription());
        clickWhenReady(elements.distanceCheckbox);
        if (elements.basicWorkoutTab.getCssValue("border-top").contains("rgb(54, 140, 169)")) {
            waitForVisible(elements.distanceInputField).clear();
            waitForVisible(elements.distanceInputField)
                    .sendKeys(String.valueOf(workoutModel.getDistance()));
            selectDropdownOption(elements.distanceDropDown, elements.distanceDropDownView,
                    elements.distanceDropDownOptions, 1);
            waitForVisible(elements.durationInputField).clear();
            waitForVisible(elements.durationInputField)
                    .sendKeys(String.valueOf(workoutModel.getDuration()));
            selectDropdownOption(elements.paceDropDown, elements.paceDropDownView,
                    elements.paceDropDownOptions, 1);
            waitForVisible(elements.paceInputField).clear();
            waitForVisible(elements.paceInputField)
                    .sendKeys(workoutModel.getPace());
            clickWhenReady(elements.raceCheckbox);
            waitForVisible(elements.placeInputField).clear();
            waitForVisible(elements.placeInputField)
                    .sendKeys(String.valueOf(workoutModel.getOverallPlace()));
            waitForVisible(elements.ageGroupPlaceInputField).clear();
            waitForVisible(elements.ageGroupPlaceInputField)
                    .sendKeys(String.valueOf(workoutModel.getAgePlace()));
        } else {
            clickWhenReady(elements.basicWorkoutTab);
        }
        clickWhenReady(elements.howIFeltRadioButton);
        selectDropdownOption(elements.perceivedEffortDropdown, elements.perceivedEffortDropdownView,
                elements.perceivedEffortDropdownOption, 2);
        clickWhenReady(elements.addWorkoutSubmitBtn);
        makePause(3000);
        Assert.assertFalse(isElementPresent(elements.addWorkoutSubmitBtnLocator),
                "Didn't was add workout!!!");
    }

    @Step("Check Import Garmin")
    public void importGarmin() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.garminBtn);
        waitForJSToBeLoaded();
        Assert.assertTrue(elements.optionsTable.isDisplayed(),
                "Garmin import page wasn't open!!!");
    }

    @Step("Check View Calendar")
    public void viewCalendar() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.viewCalendarBtn);
        waitForVisible(elements.quickAddButton).isEnabled();
        waitForVisible(elements.addWorkoutLibraryButton).isEnabled();
        waitForVisible(elements.fullAddButton).isEnabled();
        waitForVisible(elements.addGarminButton).isEnabled();
        clickWhenReady(elements.quickAddButton);
        waitForVisible(elements.dateInputField).clear();
        waitForVisible(elements.dateInputField)
                .sendKeys(workoutModel.getDate());
        waitForVisible(elements.timeOfDayInputField).clear();
        waitForVisible(elements.timeOfDayInputField)
                .sendKeys(workoutModel.getTime());
        selectDropdownOption(elements.activityTypeDropDown, elements.activityTypeDropDownView,
                elements.activityTypeDropDownOptions, 3);
        waitForVisible(elements.workoutNameInputField).clear();
        waitForVisible(elements.workoutNameInputField)
                .sendKeys(workoutModel.getName());
        waitForVisible(elements.workoutDescriptionInputField).clear();
        waitForVisible(elements.workoutDescriptionInputField)
                .sendKeys(workoutModel.getDescription());
        clickWhenReady(elements.distanceCheckbox);
        waitForVisible(elements.distanceInputField).clear();
        waitForVisible(elements.distanceInputField)
                .sendKeys(String.valueOf(workoutModel.getDistance()));
        selectDropdownOption(elements.distanceDropDown, elements.distanceDropDownView,
                elements.distanceDropDownOptions, 1);
        waitForVisible(elements.durationInputField).clear();
        waitForVisible(elements.durationInputField)
                .sendKeys(String.valueOf(workoutModel.getDuration()));
        waitForVisible(elements.paceInputField).clear();
        waitForVisible(elements.paceInputField)
                .sendKeys(String.valueOf(workoutModel.getPace()));
        selectDropdownOption(elements.paceDropDown, elements.paceDropDownView,
                elements.paceDropDownOptions, 1);
        clickWhenReady(elements.raceCheckbox);
        waitForVisible(elements.placeInputField).clear();
        waitForVisible(elements.placeInputField)
                .sendKeys(String.valueOf(workoutModel.getOverallPlace()));
        waitForVisible(elements.ageGroupPlaceInputField).clear();
        waitForVisible(elements.ageGroupPlaceInputField)
                .sendKeys(String.valueOf(workoutModel.getAgePlace()));
        selectDropdownOption(elements.howIFeelDropDown, elements.howIFeelDropDownView,
                elements.howIFeelDropDownOptions, 2);
        selectDropdownOption(elements.perceivedEffortDropdown, elements.perceivedEffortDropdownView,
                elements.perceivedEffortDropdownOption, 2);
        clickWhenReady(elements.addWorkoutSubmitBtn);
        makePause(3000);
        Assert.assertFalse(elements.dataInCalendar.isEmpty(),
                "Didn't was add quick workout in Calendar!!!");
    }

    @Step("Check View Report")
    public void viewReport() {
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.reportsStatisticsBtn);
        waitForVisible(elements.dateInputField).clear();
        waitForVisible(elements.dateInputField)
                .sendKeys(workoutModel.getDate());
        waitForVisible(elements.endDateInputField).clear();
        waitForVisible(elements.endDateInputField)
                .sendKeys(workoutModel.getDate());
        selectDropdownOption(elements.activityTypeDropDown, elements.activityTypeDropDownView,
                elements.activityTypeDropDownOptions, 3);
        clickWhenReady(elements.listViewRadioBtn);
        clickWhenReady(elements.addWorkoutSubmitBtn);

        for (int i = 0; i < elements.reportTable.size(); i++) {
            if (elements.reportTable.get(i).getText().toLowerCase(Locale.ROOT).contains("run - hills")) {
                log.info("Added report: [{}]", elements.reportTable.get(i).getText());
                break;
            } else if ((i + 1) == elements.reportTable.size() && !elements.reportTable.get(i).getText().toLowerCase(Locale.ROOT).contains("run - hills")) {
                Assert.fail("Report Filter doesn't work!!!");
            }
        }
    }

    @Step("Check Print Workout")
    public void printWorkout() {
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.printWorkoutBtn);
        switchToFrame(elements.printFrame);
        waitForVisible(elements.printStartDateInput).clear();
        waitForVisible(elements.printStartDateInput)
                .sendKeys(workoutModel.getDate());
        waitForVisible(elements.printEndDateInput).clear();
        waitForVisible(elements.printEndDateInput)
                .sendKeys(workoutModel.getDate());
        clickWhenReady(elements.submitPrintBtn);
        driver.switchTo().defaultContent();
        switchToDefauldWindow();
        driver.close();
        switchToDefauldWindow();
        Assert.assertFalse(isElementPresent(elements.errorMessage),
                "The date range you have selected does not contain any workouts. " +
                        "Please close this browser window and adjust your date range");
        Assert.assertFalse(elements.printResult.isEmpty(),
                "Don't print activities");
        clickWhenReady(elements.printLink);
        makePause(3000);
    }

    @Step("Check Add Workout Library")
    public void addWorkoutLibrary() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.workoutLibraryBtn);
        clickWhenReady(elements.libraryDropdown);
        clickWhenReady(elements.libraryDropdown);
        selectDropdownOption(elements.activityTypeDropDown, elements.activityTypeDropDownView,
                elements.activityTypeDropDownOptions, 3);
        waitForVisible(elements.workoutNameInputField).clear();
        waitForVisible(elements.workoutNameInputField)
                .sendKeys(workoutModel.getNewLibrary());
        waitForVisible(elements.workoutDescriptionInputField).clear();
        waitForVisible(elements.workoutDescriptionInputField)
                .sendKeys(workoutModel.getDescription());
        waitForVisible(elements.libraryCodeInputField).clear();
        waitForVisible(elements.libraryCodeInputField)
                .sendKeys(String.valueOf(workoutModel.getCode()));
        clickWhenReady(elements.addWorkoutSubmitBtn);
        clickWhenReady(elements.plusIcon);
        makePause(3000);

        for (int i = 0; i < elements.libraryTable.size(); i++) {
            if (elements.libraryTable.get(i).getText().contains(workoutModel.getNewLibrary())) {
                log.info("Added library: [{}]", elements.libraryTable.get(i).getText());
                break;
            } else if ((i + 1) == elements.libraryTable.size() && !elements.libraryTable.get(i).getText().contains(workoutModel.getName())) {
                Assert.fail("Doesn't added NEW WORKOUT TO LIBRARY!!!");
            }
        }
    }

    @Step("Check Add New Activity Zone")
    public void addNewActivityZone() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.hrZonesBtn);
        selectDropdownOption(elements.zoneTypeDropdown, elements.zoneTypeDropdownView,
                elements.zoneTypeDropdownOption, 2);
        clickWhenReady(elements.addWorkoutSubmitBtn);
        makePause(3000);
        selectDropdownOption(elements.activityTypeDropDown, elements.activityTypeDropDownView,
                elements.activityTypeDropDownOptions, 3);
        clickWhenReady(elements.addWorkoutSubmitBtn);
        makePause(3000);
        waitForVisible(elements.zone1InputField).clear();
        waitForVisible(elements.zone1InputField).sendKeys("2");
        waitForVisible(elements.zone2InputField).clear();
        waitForVisible(elements.zone2InputField).sendKeys("4");
        waitForVisible(elements.zone3InputField).clear();
        waitForVisible(elements.zone3InputField).sendKeys("6");
        waitForVisible(elements.zone4InputField).clear();
        waitForVisible(elements.zone4InputField).sendKeys("8");
        waitForVisible(elements.zone5InputField).clear();
        waitForVisible(elements.zone5InputField).sendKeys("10");
        waitForVisible(elements.zone6InputField).clear();
        waitForVisible(elements.zone6InputField).sendKeys("12");
        clickWhenReady(elements.addWorkoutSubmitBtn);
        makePause(3000);
        clickWhenReady(elements.plusIcon);
        Assert.assertTrue(elements.tableNewActivityZone.isDisplayed(),
                "Doesn't added NEW ACTIVITY ZONE!!!");
    }

    @Step("Check Add New Activity Type")
    public void addNewActivityType() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.customizeActivityBtn);
        waitForVisible(elements.activityTypeInputField).clear();
        waitForVisible(elements.activityTypeInputField)
                .sendKeys(workoutModel.getName());
        clickWhenReady(elements.addWorkoutSubmitBtn);

        for (int i = 0; i < elements.activityType.size(); i++) {
            if (elements.activityType.get(i).getText().contains(workoutModel.getName())) {
                log.info("Added activity type: [{}]", elements.activityType.get(i).getText());
                break;
            } else if ((i + 1) == elements.activityType.size() && !elements.activityType.get(i).getText().contains(workoutModel.getName())) {
                Assert.fail("Doesn't added NEW ACTIVITY TYPE!!!");
            }
        }
    }

    @Step("Check Import Data")
    public void importData() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.importDataBtn);
        waitForJSToBeLoaded();
        Assert.assertTrue(elements.optionsTable.isDisplayed(),
                "Import data page wasn't open!!!");
    }

}

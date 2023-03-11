package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsWorkout;
import logic.models.WorkoutModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

import java.util.Locale;

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
            // TODO: дописать логику на "Advanced Workout (Intervals)"
        }
        clickWhenReady(elements.howIFeltRadioButton);
        selectDropdownOption(elements.perceivedEffortDropdown, elements.perceivedEffortDropdownView,
                elements.perceivedEffortDropdownOption, 2);
        clickWhenReady(elements.addWorkoutSubmitBtn);
        makePause(3000);
        // TODO: дописать ассерты на "WORKOUT DETAILS"
        Assert.assertFalse(isElementPresent(elements.addWorkoutSubmitBtnLocator),
                "Didn't was add workout!!!");
    }

    public void importGarmin() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.garminBtn);
        // TODO:
    }

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
        // TODO: добавить ассерт со сравнением на то что данные на календари равны
        Assert.assertFalse(elements.dataInCalendar.isEmpty(),
                "Didn't was add quick workout in Calendar!!!");
        // TODO: добавить логику на "Workout Library"
    }

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
                System.out.println(elements.reportTable.get(i).getText());
                // TODO: добавить ассерт со сравнением на то что данные на календари равны
                Assert.assertTrue(elements.reportTable.get(i).isDisplayed(), "ERROR");
                break;
            }
        }
    }

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
//        String buff = driver.ge;
//        System.out.println(buff);
        // TODO почему то фейлится разобраться!!
        clickWithSikuli(Variables.PRINT_BUTTON);
        makePause(3000);
        uploadFile(Variables.PROJECT_UPLOAD_TEST_PATH);
        makePause(5000);
    }

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
                // TODO: добавить ассерт со сравнением на то что данные на календари равны
                break;
            }
        }
    }

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
        // TODO: добавить ассерт со сравнением на то что данные на календари равны
    }

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
                // TODO: добавить ассерт со сравнением на то что данные на календари равны
                break;
            }
        }
    }

    public void importData() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.workoutsBtn);
        clickWhenReady(elements.importDataBtn);
        // TODO:
    }

}

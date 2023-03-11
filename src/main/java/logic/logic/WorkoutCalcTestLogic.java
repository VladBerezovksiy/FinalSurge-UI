package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsWorkoutCalc;
import logic.models.WorkoutCalcModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

public class WorkoutCalcTestLogic extends MainLogic {

    private PageElementsWorkoutCalc elements;

    private final WorkoutCalcModel workoutCalcModel = new WorkoutCalcModel();

    public WorkoutCalcTestLogic(WebDriver driver, WebDriverWait wait, PageElementsWorkoutCalc elements) {
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


    public void addIntensity() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.workoutCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        clickWhenReady(elements.intensityBtn);
        waitForVisible(elements.intensityTitleText);
        clickWhenReady(elements.eventRadioBtn);
        waitForVisible(elements.eventHhInputFiled).clear();
        waitForVisible(elements.eventHhInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentHh()));
        waitForVisible(elements.eventMmInputFiled).clear();
        waitForVisible(elements.eventMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentMm()));
        waitForVisible(elements.eventSsInputFiled).clear();
        waitForVisible(elements.eventSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentSs()));
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

    public void addHansons() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.workoutCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        clickWhenReady(elements.hansonsBtn);
        waitForVisible(elements.hansonsTitleText);
        selectDropdownOption(elements.distanceDropdown, elements.distanceDropdownView,
                elements.distanceDropdownOption, 1);
        waitForVisible(elements.eventHhInputFiled).clear();
        waitForVisible(elements.eventHhInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentHh()));
        waitForVisible(elements.eventMmInputFiled).clear();
        waitForVisible(elements.eventMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentMm()));
        waitForVisible(elements.eventSsInputFiled).clear();
        waitForVisible(elements.eventSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentSs()));
        waitForVisible(elements.tempInputField).clear();
        waitForVisible(elements.tempInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getTemperature()));
        waitForVisible(elements.humidityInputField).clear();
        waitForVisible(elements.humidityInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getHumidity()));
        waitForVisible(elements.windSpeedInputField).clear();
        waitForVisible(elements.windSpeedInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getWindSpeed()));
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

    public void addMcMillan() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.workoutCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        clickWhenReady(elements.mcMillanBtn);
        waitForVisible(elements.mcMillanTitleText);
        selectDropdownOption(elements.raceDistanceDropdown, elements.raceDistanceDropdownView,
                elements.raceDistanceDropdownOption, 27);
        waitForVisible(elements.eventHhInputFiled).clear();
        waitForVisible(elements.eventHhInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentHh()));
        waitForVisible(elements.eventMmInputFiled).clear();
        waitForVisible(elements.eventMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentMm()));
        waitForVisible(elements.eventSsInputFiled).clear();
        waitForVisible(elements.eventSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentSs()));
        selectDropdownOption(elements.goalDistanceDropdown, elements.goalDistanceDropdownView,
                elements.goalDistanceDropdownOption, 29);
        waitForVisible(elements.gEventHhInputFiled).clear();
        waitForVisible(elements.gEventHhInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalHh()));
        waitForVisible(elements.gEventMmInputFiled).clear();
        waitForVisible(elements.gEventMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalMm()));
        waitForVisible(elements.gEventSsInputFiled).clear();
        waitForVisible(elements.gEventSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalSs()));
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

    public void addTinman() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.workoutCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        clickWhenReady(elements.tinmanBtn);
        waitForVisible(elements.tinmanTitleText);
        selectDropdownOption(elements.rDistanceDropdown, elements.rDistanceDropdownView,
                elements.rDistanceDropdownOption, 27);
        waitForVisible(elements.eventHhInputFiled).clear();
        waitForVisible(elements.eventHhInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentHh()));
        waitForVisible(elements.eventMmInputFiled).clear();
        waitForVisible(elements.eventMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentMm()));
        waitForVisible(elements.eventSsInputFiled).clear();
        waitForVisible(elements.eventSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentSs()));
        clickWhenReady(elements.maleRadioBtn);
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

    public void addPalladino() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.workoutCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        clickWhenReady(elements.palladinoBtn);
        waitForVisible(elements.palladinoTitleText);
        waitForVisible(elements.criticalPowerInputField).clear();
        waitForVisible(elements.criticalPowerInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getCriticalPower()));
        waitForVisible(elements.reserveWorkInputField).clear();
        waitForVisible(elements.reserveWorkInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getReserveWorkCapacity()));
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");

        waitForVisible(elements.eventMmInputFiled).clear();
        waitForVisible(elements.eventMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentHh()));
        waitForVisible(elements.eventSsInputFiled).clear();
        waitForVisible(elements.eventSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentMm()));
        waitForVisible(elements.shortTestInputField).clear();
        waitForVisible(elements.shortTestInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getShortTest()));

        waitForVisible(elements.longMmInputFiled).clear();
        waitForVisible(elements.longMmInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalHh()));
        waitForVisible(elements.longSsInputFiled).clear();
        waitForVisible(elements.longSsInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalMm()));
        waitForVisible(elements.longTestInputFiled).clear();
        waitForVisible(elements.longTestInputFiled)
                .sendKeys(String.valueOf(workoutCalcModel.getLongTest()));
        clickWhenReady(elements.submitBtn1);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");

        waitForVisible(elements.hhInputField).clear();
        waitForVisible(elements.hhInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalHh()));
        waitForVisible(elements.mmInputField).clear();
        waitForVisible(elements.mmInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalMm()));
        waitForVisible(elements.ssInputField).clear();
        waitForVisible(elements.ssInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getGoalHh()));
        waitForVisible(elements.raceAvgPowerInputField).clear();
        waitForVisible(elements.raceAvgPowerInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getRaceAvgPowerW()));
        clickWhenReady(elements.submitBtn2);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");

        waitForVisible(elements.rcMmInputField).clear();
        waitForVisible(elements.rcMmInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentMm()));
        waitForVisible(elements.rcSsInputField).clear();
        waitForVisible(elements.rcSsInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getRecentSs()));
        waitForVisible(elements.raceAvgPowerWInputField).clear();
        waitForVisible(elements.raceAvgPowerWInputField)
                .sendKeys(String.valueOf(workoutCalcModel.getRaceAvgPowerW()));
        clickWhenReady(elements.submitBtn3);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

}

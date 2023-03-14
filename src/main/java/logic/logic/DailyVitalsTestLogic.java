package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsDailyVitals;
import logic.models.DailyVitalsModal;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

import java.util.List;

@Log4j2
public class DailyVitalsTestLogic extends MainLogic {

    private PageElementsDailyVitals elements;

    private final DailyVitalsModal dailyVitalsModal = new DailyVitalsModal();

    public DailyVitalsTestLogic(WebDriver driver, WebDriverWait wait, PageElementsDailyVitals elements) {
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


    @Step("Clear values of Daily Vitals")
    public void clearHistory() {
        for (int i = 0; i < elements.dateLinks.size(); i++) {
            for (int j = 1; j <= elements.columns.size(); j++) {
                List<WebElement> el = driver.findElements(By.cssSelector(".table-striped tr:nth-child(" + (i + 1) + ") td:nth-child(" + (j + 1) + ")"));
                for (WebElement elem : el) {
                    if (elem.getText().isEmpty()) {
                        log.info("Open: [{}]", elem.getText());
                        break;
                    }
                    clickWhenReady(elements.dateLinks.get(i));
                    makePause(4000);
                    clickWhenReady(elements.trashIcon);
                    clickWhenReady(elements.okBtn);
                    makePause(3000);
                }
            }
        }
    }

    @Step("Add Daily Vitals")
    public void addDailyAndVitals() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.dailyVitalsBtn);
        clickWhenReady(elements.viewAddVitalsBtn);
        selectDropdownOption(elements.selectDateDropdown, elements.selectDateDropdownView,
                elements.selectDateDropdownOption, 1);
        for (int i = 0; i < elements.dateLinks.size(); i++) {
            if (elements.dateLinks.get(i).getText().contains(dailyVitalsModal.getDate())) {
                log.info("Click on: [{}]", elements.dateLinks.get(i).getText());
                clickWhenReady(elements.dateLinks.get(i));
                break;
            }
        }
        makePause(3000);
        waitForVisible(elements.stepsInputField).clear();
        waitForVisible(elements.stepsInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getSteps()));
        waitForVisible(elements.caloriesInputField).clear();
        waitForVisible(elements.caloriesInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getCalories()));
        waitForVisible(elements.weightInputField).clear();
        waitForVisible(elements.weightInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getWeight()));
        waitForVisible(elements.bodyFatsInputField).clear();
        waitForVisible(elements.bodyFatsInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getBodyFat()));
        waitForVisible(elements.waterPercentInputField).clear();
        waitForVisible(elements.waterPercentInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getWater()));
        waitForVisible(elements.muscleMassInputField).clear();
        waitForVisible(elements.muscleMassInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getMuscleMass()));
        waitForVisible(elements.restingHRInputField).clear();
        waitForVisible(elements.restingHRInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getRestingHR()));
        waitForVisible(elements.HRVariabilityInputField).clear();
        waitForVisible(elements.HRVariabilityInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getVariabilityHR()));
        waitForVisible(elements.sleepHoursInputField).clear();
        waitForVisible(elements.sleepHoursInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getSleepHours()));
        waitForVisible(elements.awakeTimeInputField).clear();
        waitForVisible(elements.awakeTimeInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getTotalTimeAwake()));
        waitForVisible(elements.healsNotesInputField).clear();
        waitForVisible(elements.healsNotesInputField)
                .sendKeys(dailyVitalsModal.getNotes());
        selectDropdownOption(elements.sleepAmountDropdown, elements.sleepAmountDropdownView,
                elements.sleepAmountDropdownOption, 2);
        selectDropdownOption(elements.sleepQualityDropdown, elements.sleepQualityDropdownView,
                elements.sleepQualityDropdownOption, 2);
        selectDropdownOption(elements.stressAmountDropdown, elements.stressAmountDropdownView,
                elements.stressAmountDropdownOption, 2);
        waitForVisible(elements.bloodPressureInputField).clear();
        waitForVisible(elements.bloodPressureInputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getBloodPressure()));
        waitForVisible(elements.bloodPressure2InputField).clear();
        waitForVisible(elements.bloodPressure2InputField)
                .sendKeys(String.valueOf(dailyVitalsModal.getBloodPressure1()));
        clickWhenReady(elements.submitAddVitals);
        makePause(3000);

        for (int i = 0; i < elements.dateLinks.size(); i++) {
            if (elements.dateLinks.get(i).getText().contains(dailyVitalsModal.getDate())) {
                List<WebElement> column =
                        driver.findElements(By.cssSelector(".table-striped tr:nth-child(" + (i + 1) + ") td"));
                for (WebElement webElement : column) {
                    log.info("Added: [{}]", webElement.getText().trim());
                    Assert.assertFalse(webElement.getText().trim().isEmpty(),
                            "Don't add DAILY VITALS!!!");
                }
                break;
            }
        }
    }

}

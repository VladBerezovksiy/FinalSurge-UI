package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsOtherCalc;
import logic.models.OtherCalcModel;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

@Log4j2
public class OtherCalcTestLogic extends MainLogic {

    private PageElementsOtherCalc elements;

    private final OtherCalcModel otherCalcModel = new OtherCalcModel();

    public OtherCalcTestLogic(WebDriver driver, WebDriverWait wait, PageElementsOtherCalc elements) {
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


    @Step("Add date in Pace calculator")
    public void addPaceCalc() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.otherCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        makePause(3000);
        if (isElementPresent(elements.paceCalcTabLocator)) {
            clickWhenReady(elements.paceCalcTab);
        }
        waitForVisible(elements.paceCalcTitleText);
        selectDropdownOption(elements.distanceDropDown, elements.distanceDropDownView,
                elements.distanceDropDownOption, 1);
        waitForVisible(elements.distanceInputField).clear();
        waitForVisible(elements.distanceInputField)
                .sendKeys(String.valueOf(otherCalcModel.getDistance()));
        waitForVisible(elements.hhInputField).clear();
        waitForVisible(elements.hhInputField)
                .sendKeys(String.valueOf(otherCalcModel.getHh()));
        waitForVisible(elements.mmInputField).clear();
        waitForVisible(elements.mmInputField)
                .sendKeys(String.valueOf(otherCalcModel.getMm()));
        waitForVisible(elements.ssInputField).clear();
        waitForVisible(elements.ssInputField)
                .sendKeys(String.valueOf(otherCalcModel.getSs()));
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

    @Step("Add date in Caloric calculator")
    public void addCaloricNeeds() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.otherCalculatorIcon);
        waitForJSToBeLoaded();
        switchToFrame(elements.frame);
        makePause(3000);
        if (isElementPresent(elements.caloricNeedsTabLocator)) {
            clickWhenReady(elements.caloricNeedsTab);
        }
        waitForVisible(elements.caloricNeedsTitleText);
        waitForVisible(elements.weightInputField).clear();
        waitForVisible(elements.weightInputField)
                .sendKeys(String.valueOf(otherCalcModel.getWeight()));
        waitForVisible(elements.heightInputField).clear();
        waitForVisible(elements.heightInputField)
                .sendKeys(String.valueOf(otherCalcModel.getHeight()));
        waitForVisible(elements.ageInputField).clear();
        waitForVisible(elements.ageInputField)
                .sendKeys(String.valueOf(otherCalcModel.getAge()));
        clickWhenReady(elements.maleRadioButton);
        waitForVisible(elements.runDistanceInputField).clear();
        waitForVisible(elements.runDistanceInputField)
                .sendKeys(String.valueOf(otherCalcModel.getDistance()));
        clickWhenReady(elements.submitBtn);
        makePause(4000);
        Assert.assertTrue(elements.resultsInTables.isDisplayed(),
                "Incorrect data has been entered!");
    }

}

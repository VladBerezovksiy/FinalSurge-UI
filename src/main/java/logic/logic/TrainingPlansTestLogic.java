package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsTrainingPlans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

public class TrainingPlansTestLogic extends MainLogic {

    private PageElementsTrainingPlans elements;

    public TrainingPlansTestLogic(WebDriver driver, WebDriverWait wait, PageElementsTrainingPlans elements) {
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


    @Step()
    public void viewMyPlan() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.trainingPlansBtn);
        clickWhenReady(elements.viewMyPlansBtn);
        String page1 = driver.getCurrentUrl();
        clickWhenReady(elements.findTrainingPlanBtn);
        makePause(3000);
        String page2 = driver.getCurrentUrl();
        Assert.assertNotEquals(page1, page2, "Didn't go to new page!!!");
    }

    @Step()
    public void findAPlan() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        String page1 = driver.getCurrentUrl();
        hoverOverElement(elements.trainingPlansBtn);
        clickWhenReady(elements.findMyPlansBtn);
        makePause(5000);
        String page2 = driver.getCurrentUrl();
        Assert.assertNotEquals(page1, page2, "Didn't go to new page!!!");
    }

}

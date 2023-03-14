package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsTrainingPlans;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

@Log4j2
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


    @Step("Check View My Plan")
    public void viewMyPlan() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.trainingPlansBtn);
        clickWhenReady(elements.viewMyPlansBtn);
        String page1 = driver.getCurrentUrl();
        log.info("Expected URL: [{}]", page1);
        clickWhenReady(elements.findTrainingPlanBtn);
        makePause(3000);
        String page2 = driver.getCurrentUrl();
        log.info("Actial URL: [{}]", page2);
        Assert.assertNotEquals(page1, page2, "Didn't go to new page!!!");
    }

    @Step("Check a Find Plan")
    public void findAPlan() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        String page1 = driver.getCurrentUrl();
        log.info("Expected URL: [{}]", page1);
        hoverOverElement(elements.trainingPlansBtn);
        clickWhenReady(elements.findMyPlansBtn);
        makePause(5000);
        String page2 = driver.getCurrentUrl();
        log.info("Actial URL: [{}]", page2);
        Assert.assertNotEquals(page1, page2, "Didn't go to new page!!!");
    }

}

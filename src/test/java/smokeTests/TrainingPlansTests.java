package smokeTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.elements.PageElementsTrainingPlans;
import logic.logic.TrainingPlansTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.*;

@Listeners(WebEventListener.class)
public class TrainingPlansTests extends BaseTest {

    private TrainingPlansTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER, iTestContext);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsTrainingPlans elements = new PageElementsTrainingPlans(driver);
        logic = new TrainingPlansTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_01_viewMyPlan() {
        logic.viewMyPlan();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_02_findPlan() {
        logic.findAPlan();
    }

}

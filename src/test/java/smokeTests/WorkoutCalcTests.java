package smokeTests;

import logic.elements.PageElementsWorkoutCalc;
import logic.logic.WorkoutCalcTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverInstances;
import utils.Retry;
import utils.Settings;
import utils.WebDriverWaitHelper;

public class WorkoutCalcTests extends BaseTest {

    private WorkoutCalcTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER);
        setContextAttribute(iTestContext, "driver", driver);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsWorkoutCalc elements = new PageElementsWorkoutCalc(driver);
        logic = new WorkoutCalcTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    private void test_01_workoutCalcIntensity() {
        logic.addIntensity();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_02_workoutCalcHansons() {
        logic.addHansons();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_03_workoutCalcMcMillan() {
        logic.addMcMillan();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_04_workoutCalcTinman() {
        logic.addTinman();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_05_workoutCalcPalladino() {
        logic.addPalladino();
    }

}

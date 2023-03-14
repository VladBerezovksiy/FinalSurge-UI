package smokeTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.elements.PageElementsWorkoutCalc;
import logic.logic.WorkoutCalcTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.*;

@Listeners(WebEventListener.class)
public class WorkoutCalcTests extends BaseTest {

    private WorkoutCalcTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER, iTestContext);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsWorkoutCalc elements = new PageElementsWorkoutCalc(driver);
        logic = new WorkoutCalcTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_01_workoutCalcIntensity() {
        logic.addIntensity();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_02_workoutCalcHansons() {
        logic.addHansons();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_03_workoutCalcMcMillan() {
        logic.addMcMillan();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_04_workoutCalcTinman() {
        logic.addTinman();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_05_workoutCalcPalladino() {
        logic.addPalladino();
    }

}

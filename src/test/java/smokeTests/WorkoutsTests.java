package smokeTests;

import logic.elements.PageElementsWorkout;
import logic.logic.WorkoutTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverInstances;
import utils.Retry;
import utils.Settings;
import utils.WebDriverWaitHelper;

public class WorkoutsTests extends BaseTest {

    private WorkoutTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER);
        setContextAttribute(iTestContext, "driver", driver);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsWorkout elements = new PageElementsWorkout(driver);
        logic = new WorkoutTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterClass
    private void tearDown() {
        // TODO: добавить очистку (View Calendar, Workout Library, Pace Zones, Activity Types)
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    private void test_01_addWorkout() {
        logic.addWorkout();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_02_importGarmin() {
        logic.importGarmin();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_03_viewCalendar() {
        logic.viewCalendar();
    }

    @Test(dependsOnMethods = "test_01_addWorkout", retryAnalyzer = Retry.class)
    private void test_04_viewReports() {
        logic.viewReport();
    }

    @Test(dependsOnMethods = "test_01_addWorkout", retryAnalyzer = Retry.class)
    private void test_05_printWorkout() {
        logic.printWorkout();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_06_addNewWorkoutLibrary() {
        logic.addWorkoutLibrary();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_07_addNewActivityZone() {
        logic.addNewActivityZone();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_08_customizeActivityType() {
        logic.addNewActivityType();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_09_importData() {
        logic.importData();
    }

}

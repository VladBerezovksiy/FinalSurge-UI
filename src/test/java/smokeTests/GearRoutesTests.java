package smokeTests;

import logic.elements.PageElementsGearRoutes;
import logic.logic.GearRoutesTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverInstances;
import utils.Retry;
import utils.Settings;
import utils.WebDriverWaitHelper;

public class GearRoutesTests extends BaseTest {

    private GearRoutesTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER);
        setContextAttribute(iTestContext, "driver", driver);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsGearRoutes elements = new PageElementsGearRoutes(driver);
        logic = new GearRoutesTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterClass
    private void tearDown() {
        logic.clearHistory();
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    private void test_01_addWorkout() {
        logic.addShoes();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_02_addBikes() {
        logic.addBikes();
    }

    @Test(retryAnalyzer = Retry.class)
    private void test_03_addRoutes() {
        logic.addRoutes();
    }

}

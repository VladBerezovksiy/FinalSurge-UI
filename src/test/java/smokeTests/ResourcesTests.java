package smokeTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.elements.PageElementsResources;
import logic.logic.ResourcesTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.*;

@Listeners(WebEventListener.class)
public class ResourcesTests extends BaseTest {

    private ResourcesTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER, iTestContext);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsResources elements = new PageElementsResources(driver);
        logic = new ResourcesTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_01_viewFiles() {
        logic.viewFiles();
    }

}

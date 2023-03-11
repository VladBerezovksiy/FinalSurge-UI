package smokeTests;

import logic.elements.PageElementsPreferences;
import logic.logic.PreferencesTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverInstances;
import utils.Settings;
import utils.WebDriverWaitHelper;

public class PreferencesTests extends BaseTest {

    protected PreferencesTestLogic logic;

    @BeforeClass
    protected void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER);
        setContextAttribute(iTestContext, "driver", driver);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsPreferences elements = new PageElementsPreferences(driver);
        logic = new PreferencesTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

}

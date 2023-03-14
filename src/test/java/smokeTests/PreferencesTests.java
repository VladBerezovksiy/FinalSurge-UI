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
        driver = DriverInstances.getInstance(Settings.DRIVER, iTestContext);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsPreferences elements = new PageElementsPreferences(driver);
        logic = new PreferencesTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

}

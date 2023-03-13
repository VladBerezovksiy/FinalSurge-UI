package smokeTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.elements.PageElementsLogin;
import logic.logic.LoginTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverInstances;
import utils.Retry;
import utils.Settings;
import utils.WebDriverWaitHelper;

public class LoginTests extends BaseTest {

    private LoginTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER);
        setContextAttribute(iTestContext, "driver", driver);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsLogin elements = new PageElementsLogin(driver);
        logic = new LoginTestLogic(driver, wait, elements);
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
    @Severity(value = SeverityLevel.NORMAL)
    private void test_01_checkLoginPage() {
        logic.checkLoginPage();
    }

    @Test(retryAnalyzer = Retry.class, enabled = false)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_02_checkForgotPasswordRestorationFunctionality() {
        logic.checkForgotPasswordRestorationFunctionality();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.CRITICAL)
    private void test_03_verificationOnTheMainPage() {
        logic.verificationOnTheMainPage();
    }

}

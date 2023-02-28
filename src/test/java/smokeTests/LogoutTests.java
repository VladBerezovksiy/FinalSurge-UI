package smokeTests;

import logic.BaseElements;
import logic.MainLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.*;

public class LogoutTests extends BaseTest {

    private MainLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER);
        setContextAttribute(iTestContext, "driver", driver);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        BaseElements elements = new BaseElements(driver);
        logic = new MainLogic(driver, wait, elements) {
            @Override
            public void getRootPage() {

            }

            @Override
            public void backToRootPage() {

            }
        };
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    private void test_01_logoutLogin() {
        logic.login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logic.logOut();
    }

}

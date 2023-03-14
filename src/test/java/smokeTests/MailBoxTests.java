package smokeTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.elements.PageElementsMailBox;
import logic.logic.MailBoxTestLogic;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.*;

@Listeners(WebEventListener.class)
public class MailBoxTests extends BaseTest {

    private MailBoxTestLogic logic;

    @BeforeClass
    private void beforeClass(ITestContext iTestContext) {
        driver = DriverInstances.getInstance(Settings.DRIVER, iTestContext);
        WebDriverWait wait = WebDriverWaitHelper.generateWaits(driver, 5, 30, 3);
        PageElementsMailBox elements = new PageElementsMailBox(driver);
        logic = new MailBoxTestLogic(driver, wait, elements);
        logic.getRootPage();
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }


    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.MINOR)
    private void test_01_mailBoxInbox() {
        logic.verifyInbox();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.MINOR)
    private void test_02_mailBoxSent() {
        logic.verifySent();
    }

}

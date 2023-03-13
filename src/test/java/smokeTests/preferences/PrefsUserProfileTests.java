package smokeTests.preferences;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import smokeTests.PreferencesTests;
import utils.Retry;

public class PrefsUserProfileTests extends PreferencesTests {

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.NORMAL)
    private void test_01_changeUserData() {
        logic.changeUserData();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.CRITICAL)
    private void test_02_changeEmail() {
        logic.changeEmail();
    }

    @Test(retryAnalyzer = Retry.class, enabled = false)
    @Severity(value = SeverityLevel.CRITICAL)
    private void test_03_deleteAccount() {
        logic.deleteAccount();
    }

}

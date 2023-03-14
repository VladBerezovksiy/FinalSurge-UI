package smokeTests.preferences;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import smokeTests.PreferencesTests;
import utils.Retry;
import utils.WebEventListener;

@Listeners(WebEventListener.class)
public class PrefsUserSettingsTests extends PreferencesTests {

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.MINOR)
    private void test_01_changePrimarySport() {
        logic.changePrimarySport();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.MINOR)
    private void test_02_changeLanguage() {
        logic.changeLanguage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.MINOR)
    private void test_03_changeTimeZone() {
        logic.changeTimeZone();
    }

}

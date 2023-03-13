package smokeTests.preferences;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import smokeTests.PreferencesTests;
import utils.Retry;

public class PrefsCalendarSyncTests extends PreferencesTests {

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.MINOR)
    private void test_01_changeCalendarSync() {
        logic.changeCalendarSync();
    }

}

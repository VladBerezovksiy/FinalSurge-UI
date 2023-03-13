package smokeTests.preferences;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import smokeTests.PreferencesTests;
import utils.Retry;

public class PrefsSocialMediaTests extends PreferencesTests {

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.TRIVIAL)
    private void test_01_addSocialMedia() {
        logic.addSocialMedia();
    }

}

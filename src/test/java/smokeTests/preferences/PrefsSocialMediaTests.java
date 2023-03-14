package smokeTests.preferences;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import smokeTests.PreferencesTests;
import utils.Retry;
import utils.WebEventListener;

@Listeners(WebEventListener.class)
public class PrefsSocialMediaTests extends PreferencesTests {

    @Test(retryAnalyzer = Retry.class)
    @Severity(value = SeverityLevel.TRIVIAL)
    private void test_01_addSocialMedia() {
        logic.addSocialMedia();
    }

}

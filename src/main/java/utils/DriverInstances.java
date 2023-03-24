package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import logic.credentials.WindowSizeConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;

import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

@Log4j2
@Listeners(WebEventListener.class)
public class DriverInstances {

    private static final Map<String, WebDriver> webDriverInstances = new HashMap();

    private DriverInstances() {
    }

    /**
     * @param driverType - a type of driver to be initialized:
     *                   GC - Google Chrome
     *                   FF - Firefox
     *                   EG - Edge
     */

    public static WebDriver getInstance(String driverType, ITestContext iTestContext) {
        WebDriver webDriver = webDriverInstances.get(driverType);
        log.info("Browser: [{}]", driverType.toUpperCase());

        switch (driverType.toUpperCase()) {
            case Variables.GOOGLE_CHROME:
                String downloadFilepath = Variables.PROJECT_DOWNLOAD_PATH;
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.prompt_for_download", false);
                chromePrefs.put("download.default_directory", downloadFilepath);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
//                options.addArguments("--headless");
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(cap);
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(options);
                break;
            case Variables.FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("browser.download.dir", Variables.PROJECT_DOWNLOAD_PATH);
                firefoxOptions.addPreference("browser.download.folderList", 2);
                firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
                firefoxOptions.addPreference("browser.helperApps.neverAsk.openFile",
                        Variables.MIME_TYPES);
                firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
                        Variables.MIME_TYPES);
                firefoxOptions.addPreference("browser.helperApps.alwaysAsk.force", false);
                firefoxOptions.addPreference("browser.download.manager.alertOnEXEOpen", false);
                firefoxOptions.addPreference("browser.download.manager.focusWhenStarting", false);
                firefoxOptions.addPreference("browser.download.manager.useWindow", false);
                firefoxOptions.addPreference("browser.download.manager.showAlertOnComplete", false);
                firefoxOptions.addPreference("browser.download.manager.closeWhenDone", false);
//                firefoxOptions.addArguments("--headless");
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case Variables.EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default: {
                System.out.println(DriverInstances.class + " Empty or invalid browser type: " + driverType);
                System.exit(1);
            }
        }
        webDriverInstances.put(driverType, webDriver);
        System.out.println("New WebDriver instance has been initialized: " + driverType);
        Dimension dimension = new Dimension(
                WindowSizeConstants.WIGHT_WINDOW,
                WindowSizeConstants.HEIGHT_WINDOW
        );
        setContextAttribute(iTestContext, "webDriver", webDriver);
        log.info("Size of window browser [{}]x[{}]",
                WindowSizeConstants.WIGHT_WINDOW, WindowSizeConstants.HEIGHT_WINDOW);
        webDriver.manage().window().setSize(dimension);
        webDriver.manage().timeouts().setScriptTimeout(60, SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        return new EventFiringWebDriver(webDriver);
    }

    private static void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

}

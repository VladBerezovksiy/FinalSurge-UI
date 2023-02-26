package smokeTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.Variables;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class BaseTest {

    protected WebDriver driver;

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(Variables.PROJECT_SCREENSHOT_PATH + generateFileName());
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Generates file name for screenshots, which are taken, when test fail
     *
     * @return generated file name
     */
    public String generateFileName() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.getDayOfMonth() + "." + dateTime.getMonthValue() + "." + dateTime.getYear() +
                "_" + dateTime.getHour() + "." + dateTime.getMinute() + "." + dateTime.getSecond() +
                ".png";
    }


}

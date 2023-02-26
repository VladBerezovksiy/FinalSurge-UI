package utils;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebEventListener implements ITestListener {

    public void onTestFailure(ITestResult iTestResult) {
        AllureUtils.attachScreenshot(getScreenshot(iTestResult));
    }

    private byte[] getScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                return null;
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return null;
        }
    }

}
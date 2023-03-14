package utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebDriverWaitHelper {

    public static WebDriverWait generateWaits (WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.pollingEvery(5, TimeUnit.SECONDS);
        return wait;
    }

    /**
     * @param iWait - implicit wait
     * @param eWait - explicit wait
     * @param pollingTime - the interval taken between checking expected conditions. Default - FIVE_HUNDRED_MILLIS.
     */
    public static WebDriverWait generateWaits (WebDriver driver, int iWait, int eWait, int pollingTime){
        driver.manage().timeouts().implicitlyWait(iWait, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, eWait);
        wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(Exception.class);
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementClickInterceptedException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait;
    }

}

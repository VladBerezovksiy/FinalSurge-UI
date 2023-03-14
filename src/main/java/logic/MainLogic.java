package logic;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static utils.Variables.FINALSURGE_URL;

@Log4j2
public abstract class MainLogic {

    public WebDriver driver;
    public WebDriverWait wait;
    public BaseElements elements;

    public MainLogic(WebDriver driver, WebDriverWait wait, BaseElements elements) {
        this.driver = driver;
        this.wait = wait;
        this.elements = elements;
    }

    /**
     * @implSpec used to get the root of a test page,
     * i.e. the main page of the section being tested, hereafter "zero-point".
     * Should be implemented for each logic pages.
     * Example for Calendar: Login into the app → Switch to Calendar section.
     */
    public abstract void getRootPage();

    /**
     * @implSpec implementation of getting back to
     * the zero-point right after a TC execution / failure etc.
     */
    public abstract void backToRootPage();


    /**************************************** WAITS *****************************************************/

    /**
     * Waits until all JavaScript code is executed in a page
     */
    public void waitForJSToBeLoaded() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Waits until all JQuery code is executed in a page
     */
    public void waitForJQueryToBeLoaded() {
        wait.until(webDriver -> (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
    }

    /**
     * Waits until web-element is visible on a page
     *
     * @param element the web-element, which should be visible
     * @return the passed element will be returned
     */
    public WebElement waitForVisible(WebElement element) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Waits until all web-elements in list are visible
     *
     * @param elements the list of web-elements
     * @return the same list of elements will be returned
     */
    public List<WebElement> waitForVisible(List<WebElement> elements) {
        waitForJSToBeLoaded();
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return elements;
    }

    /**
     * Waits until web-element contains specific text inside tag
     *
     * @param element the web-element
     * @param text    a text, which should be present inside web-element
     * @return the same element will be returned
     */
    public WebElement waitForElementContainsText(WebElement element, String text) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.textToBePresentInElement(element, text.trim()));
        return element;
    }


    /**************************************** ACTIONS ****************************************/

    /**
     * Clicks a web-element after it becomes visible
     *
     * @param element a web-element
     * @return the passed element will be returned
     */
    public WebElement clickWhenReady(WebElement element) {
        makePause(Variables.SHORT_SLEEP);
        waitForVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;

    }

    public WebElement jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return element;
    }

    public boolean isElementPresent(By element) {
        boolean bool = false;
        if (driver.findElements(element).size() != 0) {
            bool = true;
        }
        return bool;
    }


    /**
     * Moves a mouse to specific web-element
     *
     * @param element a web-element
     */
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    /**************************************** CHECKS ****************************************/

    /**
     * Check if the web-element exists in DOM on a page
     *
     * @param element the locator of web-element
     * @return true will be returned if web-element exists,
     * and false if doesn't exist
     */
    public Boolean checkForExistence(By element) {
        makePause(Variables.SHORT_SLEEP);
        return !driver.findElements(element).isEmpty();
    }


    /**************************************** RELOADING ****************************************/

    /**
     * Method performs login page browsing, which includes clearing all the cookies,
     * navigating to a page and window maximization
     */
    public void browseLoginPage() {
        driver.manage().deleteAllCookies();
        log.info("Open URL: [{}]", FINALSURGE_URL);
        driver.get(FINALSURGE_URL);
        driver.manage().window().maximize();
        waitForJSToBeLoaded();
        waitForVisible(elements.loginPanel);
    }

    public void browseOpenPage(String url) {
        driver.manage().deleteAllCookies();
        log.info("Open URL: [{}]", url);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        waitForJSToBeLoaded();
    }

    /**
     * Performs login with given logic.credentials
     * and ensures that all web-elements were correctly loaded
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        browseLoginPage();
        try {
            waitForVisible(elements.loginPanel);
        } catch (TimeoutException te) {
            login(login, password);
            te.printStackTrace();
        }
        log.info("Enter email: [{}], password: [{}]", login, password);
        waitForVisible(elements.emailInputField).clear();
        waitForVisible(elements.emailInputField).sendKeys(login);
        waitForVisible(elements.passwordInputField).clear();
        waitForVisible(elements.passwordInputField).sendKeys(password);
        clickWhenReady(elements.loginButton);
        waitForJSToBeLoaded();
        waitForVisible(elements.dashboardIcon).isEnabled();
        waitForVisible(elements.calendarIcon).isEnabled();
        waitForVisible(elements.workoutCalculatorIcon).isEnabled();
        waitForVisible(elements.otherCalculatorIcon).isEnabled();
        waitForVisible(elements.reportsStatisticsIcon).isEnabled();
        waitForVisible(elements.mailBoxIcon).isEnabled();
        waitForVisible(elements.printWorkoutsIcon).isEnabled();
        waitForVisible(elements.betaPlatformsIcon).isEnabled();
    }

    /**
     * Performs log out from a system
     */
    public void logOut() {
        waitForJSToBeLoaded();
        waitForJQueryToBeLoaded();
        clickWhenReady(elements.logoutLink);
        waitForJSToBeLoaded();
        waitForVisible(elements.logoutPanel);
        clickWhenReady(elements.accountLoginButton);
        waitForJSToBeLoaded();
        waitForJQueryToBeLoaded();
        driver.manage().deleteAllCookies();
        waitForVisible(elements.emailInputField);
        waitForVisible(elements.passwordInputField);
    }

    /**************************************** OPERATIONS WITH ELEMENTS ****************************************/

    /**
     * Selects an option by given index in dropdown list
     *
     * @param dropdownButton  a web-element of dropdown input button
     * @param dropdownView    a web-element of dropdown options list view
     * @param dropdownOptions a list of web-elements of dropdown options
     * @param index           an index of the option to select
     */
    public void selectDropdownOption(WebElement dropdownButton, WebElement dropdownView,
                                     List<WebElement> dropdownOptions, int index) {
        clickWhenReady(dropdownButton);
        waitForVisible(dropdownView);
        String selectedText = dropdownOptions.get(index).getText();
        log.info("Select value in DropDown: [{}]", selectedText);
        dropdownOptions.get(index).click();
        try {
            waitForElementContainsText(dropdownButton, selectedText);
        } catch (TimeoutException ex) {
            //majority of dropdowns change their value to selected option
            //but few of them don't
        }

    }

    /**
     * Performs switching to frame with waiting for its visibility
     *
     * @param element a web-element of the frame
     */
    public void switchToFrame(WebElement element) {
        waitForVisible(element);
        driver.switchTo().frame(element);
    }

    public void switchToNewWindow() {
        Set<String> set = driver.getWindowHandles();
        String[] array = set.toArray(new String[0]);
        driver.switchTo().window(array[1]);
    }

    public void switchToDefauldWindow() {
        Set<String> set = driver.getWindowHandles();
        String[] array = set.toArray(new String[0]);
        driver.switchTo().window(array[0]);
    }


    /**************************************** OTHERS ****************************************/

    /**
     * Makes a pause for a specified time
     *
     * @param millis a time for a pause in milliseconds
     */
    public void makePause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a unique title with short current date and time
     *
     * @param base a text which will be a part of the title
     * @return a generated title will be returned
     */
    public String makeTitleShort(String base) {
        return base + LocalDateTime.now().getDayOfMonth() +
                " " + LocalDateTime.now().getHour() + " " + LocalDateTime.now().getMinute() +
                " " + LocalDateTime.now().getSecond();
    }


    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px dashed #ffe207'", element);
    }

}

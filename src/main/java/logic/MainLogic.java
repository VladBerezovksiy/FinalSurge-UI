package logic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import utils.Settings;
import utils.Variables;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import static utils.Variables.FINALSURGE_URL;

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
     * Waits until web-element is invisible on a page
     *
     * @param element the web-element, which should be invisible
     * @return the passed element will be returned
     */
    public WebElement waitForInvisible(WebElement element) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public void waitForInvisibilityOfAllertSuccess() {
//        waitForInvisibilityOfElementLocated(elements.alertSuccessLocator);
    }

    /**
     * Waits for web-element's attribute to contain specific value
     *
     * @param element   the web-element, which has attribute
     * @param attribute an attribute name
     * @param value     a text, which expected to be present in attribute
     * @return the passed element will be returned
     */
    public WebElement waitForAttributeContains(WebElement element, String attribute, String value) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
        return element;
    }

    /**
     * Waits for web-element's attribute not to contain value
     *
     * @param element   the web-element, which has attribute
     * @param attribute an attribute name
     * @param value     a text, which expected not to be present in attribute
     * @return the passed element will be returned
     */
    public WebElement waitForAttributeNotContains(WebElement element, String attribute, String value) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, attribute, value)));
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

    /**
     * Waits until web-element doesn't contain specific text inside tag
     *
     * @param element the web-element
     * @param text    a text, which shouldn't be present inside web-element
     * @return the same element will be returned
     */
    public WebElement waitForElementNotContainsText(WebElement element, String text) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text.trim())));
        return element;
    }

    /**
     * Waits until web-element contains specific text in value attribute
     *
     * @param element the web-element
     * @param text    a text, which should be present in value attribute of element
     * @return the same element will be returned
     */
    public WebElement waitForElementContainsTextInValue(WebElement element, String text) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text.trim()));
        return element;
    }

    /**
     * Waits until web-element doesn't contain specific text in value attribute
     *
     * @param element the web-element
     * @param text    a text, which should be present in value attribute of element
     * @return the passed element will be returned
     */
    public WebElement waitForElementNotContainsTextInValue(WebElement element, String text) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(element, text.trim())));
        return element;
    }

    /**
     * Waits until size of list becomes smaller
     *
     * @param listLocator  a locator of the list of web-elements
     * @param amountBefore the initial size of list
     */
    public void waitForListToHaveLessElementsThan(By listLocator, int amountBefore) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(listLocator, amountBefore));
    }

    /**
     * Waits until size of list becomes bigger
     *
     * @param listLocator  a locator of the list of web-elements
     * @param amountBefore the initial size of list
     */
    public void waitForListToHaveMoreElementsThan(By listLocator, int amountBefore) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listLocator, amountBefore));
    }

    /**
     * Waits until size of list is equal to exact amount
     *
     * @param listLocator a locator of the list of web-elements
     * @param amount      the expected amount of list
     */
    public void waitForListToHaveElementsAmount(By listLocator, int amount) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.numberOfElementsToBe(listLocator, amount));
    }

    /**
     * Waits until size of list is equal to exact amount
     *
     * @param elements list of web-elements
     * @param amount   the expected amount of list
     */
    public void waitForListToHaveElementsAmount(List<WebElement> elements, int amount) {
        waitForJSToBeLoaded();
        int count = 0;
        int maxTries = 25;
        while (elements.size() < amount) {
            if ((elements.size() == amount) || (count >= maxTries)) {
                break;
            } else
                waitForVisible(elements);
            makePause(100);
            count++;
        }
    }

    /**
     * Waits until web-element is invisible
     *
     * @param elementLocator a locator of web-element
     */
    private void waitForInvisibilityOfElementLocated(By elementLocator) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
    }

    /**
     * Waits until modal window is invisible
     */
    public void waitForInvisibilityOfModal() {
//        waitForInvisibilityOfElementLocated(elements.modalLocator);
    }

    /**
     * Waits until web-element will be reloaded on a page,
     * which means appearing and disappearing of element
     *
     * @param element the web-element
     */
    public void waitForElementToReload(WebElement element) {
        waitForVisible(element);
        waitForInvisible(element);
    }

    /**
     * Waits until web-element is invisible if it is present in a DOM
     *
     * @param elementLocator the locator of web-element
     */
    public void waitForInvisibleIfPresent(By elementLocator) {
        if (checkForExistence(elementLocator)) {
            waitForInvisible(driver.findElement(elementLocator));
        }
    }

    /**************************************** FINDINGS ****************************************/

    /**
     * Finds web-element, which contains given text
     *
     * @param text
     * @return a found web-element will be returned
     */
    public WebElement findElementByText(String text) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
    }


    public WebElement findCheckBoxByText(String text) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]/parent::span/parent::div//span[@click]"));
    }


    /**
     * Searches for web-element by text inside of given web-element
     *
     * @param element a parent web-element
     * @param text
     * @return a found web-element will be returned
     */
    public WebElement findElementByText(WebElement element, String text) {
        return element.findElement(By.xpath(".//*[contains(text(), '" + text + "')]"));
    }

    /**
     * Searches for the list of web-elements which contain the same text
     *
     * @param text
     * @return a found list of web-elements will be returned
     */
    public List<WebElement> findElementsByText(String text) {
        return driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));
    }

    /**
     * Searches for web-element which has an exactly the same text as given one
     *
     * @param text
     * @return a found web-element will be returned
     */
    public WebElement findElementByExactText(String text) {
        return driver.findElement(By.xpath("//*[.='" + text + "']"));
    }

    /**
     * Searches for text inside frame and in case of failing switches back default content
     *
     * @param frameContent a web-element of frame
     * @param text         a text, to search in frame
     */
    public void findTextInFrame(WebElement frameContent, String text) {
        try {
            waitForElementContainsText(frameContent, text);
        } catch (TimeoutException te) {
            driver.switchTo().defaultContent();
            te.printStackTrace();
        }
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
        } else {
            bool = false;
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

    /**
     * Checks if web-element contains specific attribute
     *
     * @param element   the web-element
     * @param attribute the name of attribute
     * @return true will be returned if web-element has an attribute,
     * and false if web-element hasn't an attribute
     */
    public boolean isAttributePresent(WebElement element, String attribute) {
        return element.getAttribute(attribute) != null ? true : false;
    }

    /**
     * Checks if attribute of web-element contains a specific value
     *
     * @param element   a web-element
     * @param attribute the name of attribute
     * @param value     the value, which attribute contains
     * @return true will be returned if attribute contains value,
     * and false if attribute doesn't contain value
     */
    public boolean hasAttributeValue(WebElement element, String attribute, String value) {
        String attrValue = element.getAttribute(attribute);
        return attrValue.contains(value);
    }

    /**
     * Checks if the web-element is ready to be clicked
     *
     * @param el a web-element
     * @return true will be returned if the element can be clicked
     * and false if not
     */
    public boolean isClickable(WebElement el) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if modal with input error appeared and closes it after
     */
    public void checkModalErrorGeneral() {
//        waitForVisible(elements.modal);
//        clickWhenReady(elements.modalCloseButton);
        waitForInvisibilityOfModal();
    }

    public void confirmModalGeneral() {
//        waitForVisible(elements.modal);
//        clickWhenReady(elements.deleteModal);
        waitForInvisibilityOfModal();
    }

    /**************************************** WORKING WITH FILES ****************************************/

    /**
     * Uploads a first file in a folder located by path
     *
     * @param path a path to the folder
     */
    public void fileUpload(String path) {
        File file = new File(path);
        File[] folderEntries = file.listFiles();
        uploadFile(folderEntries[0].getAbsolutePath());
    }


    public String sikuliPatternSelectorOS() {
        String versionOS = Settings.OS.toLowerCase(Locale.ROOT);
        String sikuliPattern = null;
        if (versionOS.equals(Variables.WINDOWS_10_NAME)) {
            sikuliPattern = Variables.PROJECT_SIKULI_PATTERNS_WIN10;
        } else if (versionOS.equals(Variables.WINDOWS_7_NAME)) {
            sikuliPattern = Variables.PROJECT_SIKULI_PATTERNS_WIN7;
        }
        return sikuliPattern;
    }


    /**
     * Uploads a file to a File Manager window
     *
     * @param path a path to file
     */
    public void uploadFile(String path) {
        Screen s = new Screen();
        Pattern uploadInput = new Pattern(sikuliPatternSelectorOS() + Variables.UPLOAD_INPUT);
        Pattern uploadButton = new Pattern(sikuliPatternSelectorOS() + Variables.UPLOAD_BUTTON);
        try {
            s.wait(uploadInput, 5);
            System.out.println(path);
            s.type(uploadInput, path);
            s.click(uploadButton);
        } catch (FindFailed ex) {
            throw new NoSuchElementException(ex.getMessage());
        }
    }

    /**
     * Click Cancel button on Upload window
     */
    public void clickCancelUpload() {
        Screen s = new Screen();
        Pattern uploadCancelButton = new Pattern(sikuliPatternSelectorOS() + Variables.UPLOAD_CANCEL);
        try {
            s.wait(uploadCancelButton, 5);
            s.click(uploadCancelButton);
        } catch (FindFailed ex) {
            throw new NoSuchElementException(ex.getMessage());
        }
    }


    /**
     * Checks if the file was downloaded to the folder
     *
     * @param downloadButton a web-element of the download button
     */
    public void performDownload(WebElement downloadButton, String fileExtension) {
        String[] files = new File(Variables.PROJECT_DOWNLOAD_PATH).list();
        int amountOfFilesBefore = 0;
        /*for(String file : files) {
            if(file.endsWith(fileExtension)) {
                amountOfFilesBefore++;
            }

        }*/
//        int amountOfFilesBefore = new File(Variables.PROJECT_DOWNLOAD_PATH).list().length;
        clickWhenReady(downloadButton);
        try {
            clickWithSikuli(Variables.KEEP_FILE);
        } catch (NoSuchElementException ex) {
            //clicking on 'keep' button is necessary only for certain types of files
        }
        // makePause(Variables.VERY_LONG_SLEEP2);
        //makePause(45000);//time for file to download
        int counter = 0;
        int amountOfFilesAfter = 0;
        while (counter < 45) {
            files = new File(Variables.PROJECT_DOWNLOAD_PATH).list();
            for (String file : files) {
                if (file.endsWith(fileExtension)) {
                    amountOfFilesAfter++;
                    counter = 45;
                    break;
                }
            }
            makePause(1000);
            counter++;

        }
        Assert.assertTrue(amountOfFilesBefore + 1 == amountOfFilesAfter);
        counter = 0;
        File dir = new File(Variables.PROJECT_DOWNLOAD_PATH);
        File[] arrFiles = dir.listFiles();
        for (File file : arrFiles) {
            file.delete();
        }
    }

    /**
     * Extract extension of a file
     *
     * @param fileName name of file, which extension is needed to get
     * @return
     */
    public String getFileExtension(String fileName) {
        String[] parts = fileName.split("\\.");
        System.out.println("Extension=" + parts[parts.length - 1]);
        return parts[parts.length - 1];
    }

    /**
     * Deletes all files in project's download folder
     */
    public void emptyDownloadFolder() {
        File folder = new File(Variables.PROJECT_DOWNLOAD_PATH);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }
    }

    /**************************************** RELOADING ****************************************/

    /**
     * Method performs login page browsing, which includes clearing all the cookies,
     * navigating to a page and window maximization
     */
    public void browseLoginPage() {
        driver.manage().deleteAllCookies();
        driver.get(FINALSURGE_URL);
        driver.manage().window().maximize();
        waitForJSToBeLoaded();
        waitForVisible(elements.loginPanel);
    }

    public void browseOpenPage(String url) {
        driver.manage().deleteAllCookies();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        waitForJSToBeLoaded();
    }

    /**
     * Performs login with given credentials
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
     * Sets checkbox selected if it was unset before
     *
     * @param checkbox a web-element of checkbox
     */
    public void setCheckbox(WebElement checkbox) {
        if (!checkbox.getAttribute(Variables.CSS_CLASS_ATR).contains(Variables.CSS_CHECKED_CLASS)) {
            clickWhenReady(checkbox);
        }
    }

    /**
     * Deselects checkbox if it was set before
     *
     * @param checkbox
     */
    public void unsetCheckbox(WebElement checkbox) {
        if (checkbox.getAttribute(Variables.CSS_CLASS_ATR).contains(Variables.CSS_CHECKED_CLASS)) {
            clickWhenReady(checkbox);
        }
    }

    public void unsetCheckboxMF(WebElement checkbox) {
        if (checkbox.getAttribute(Variables.CSS_CLASS_ATR).contains(Variables.CSS_CHECKED_CLASS)) {
            clickWhenReady(checkbox);
        }
    }

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
        System.out.println(selectedText);
        dropdownOptions.get(index).click();
        try {
            waitForElementContainsText(dropdownButton, selectedText);
        } catch (TimeoutException ex) {
            //majority of dropdowns change their value to selected option
            //but few of them don't
        }

    }

    /**
     * Selects another dropdown option
     *
     * @param dropdownButton a web-element of dropdown input button
     * @param dropdown       a web-element of dropdown options list view
     * @param selectedOption a current selected option
     * @param options        a list of web-elements of dropdown options
     */
    public void changeDropdownValueGeneral(WebElement dropdownButton, WebElement dropdown, WebElement selectedOption, List<WebElement> options) {
        String selectedOptionText = waitForVisible(selectedOption).getText();
        clickWhenReady(dropdownButton);
        waitForVisible(dropdown);
        if (options.size() == 1) {
            clickWhenReady(options.get(0));
        } else {
            for (WebElement option : options) {
                if (option.getText().compareTo(selectedOptionText) != 0) {
                    clickWhenReady(option);
                    break;
                }
            }
        }
    }

    /**
     * Closes a File Manager window
     *
     * @param patternPath
     */
    public void clickWithSikuli(String patternPath) {
        Screen s = new Screen();
        Pattern button = new Pattern(sikuliPatternSelectorOS() + patternPath);
        try {
            s.wait(button, 10);
            s.click(button);
        } catch (FindFailed ex) {
            throw new NoSuchElementException(ex.getMessage());
        }
    }

    /**
     * Closes all notifications if they are present on a page
     */
    public void closeAllNotifications() {
//        while (!elements.notifications.isEmpty()) {
//            clickWhenReady(elements.notificationCloseButton);
//        }
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

    /**
     * Sets searching options in a search field with given filters
     *
     * @param optionToSearch  a filter option to select
     * @param optionToTurnOff a filter option to deselect
     * @param textToSearch    a text to input into search field
     */
    public void searchGeneral(WebElement optionToSearch, WebElement optionToTurnOff, String textToSearch) {
//        waitForVisible(elements.searchInput).clear();
//        clickWhenReady(elements.searchButton);
//        waitForVisible(elements.searchDropdown);
//        if (!hasClass(optionToTurnOff.findElement(elements.searchOptionCheckIconLocator), Variables.CSS_HIDE_CLASS)) {
//            clickWhenReady(optionToTurnOff);
//        }
//        if (hasClass(optionToSearch.findElement(elements.searchOptionCheckIconLocator), Variables.CSS_HIDE_CLASS)) {
//            clickWhenReady(optionToSearch);
//        }
//        clickWhenReady(elements.searchButton);
//        waitForVisible(elements.searchInput).clear();
//        waitForVisible(elements.searchInput).sendKeys(textToSearch);
//        waitForVisible(elements.searchInput).sendKeys(Keys.ENTER);
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
     * Generates a unique title with full current date and time
     *
     * @param base a text which will be a part of the title
     * @return a generated title will be returned
     */
    public String makeTitle(String base) {
        return base + LocalDateTime.now();
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

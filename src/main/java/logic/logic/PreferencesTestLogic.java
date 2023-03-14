package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsPreferences;
import logic.models.PreferencesModel;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

@Log4j2
public class PreferencesTestLogic extends MainLogic {

    private PageElementsPreferences elements;

    private final PreferencesModel preferencesModel = new PreferencesModel();

    public PreferencesTestLogic(WebDriver driver, WebDriverWait wait, PageElementsPreferences elements) {
        super(driver, wait, elements);
        this.elements = elements;
    }

    @Override
    public void getRootPage() {
        browseLoginPage();
    }

    @Override
    public void backToRootPage() {
        browseLoginPage();
    }


    private void followToSettingsPage() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.settingsLink);
        waitForJSToBeLoaded();
    }


    /************************************* USER SETTINGS LOGIC *******************************************/

    @Step("Change Primary Sport in User Settings")
    public void changePrimarySport() {
        followToSettingsPage();
        clickWhenReady(elements.userSettingsButton);
        selectDropdownOption(elements.primarySportDropDown, elements.primarySportDropDownView,
                elements.primarySportDropDownOptions, 2);
        clickWhenReady(elements.saveChangesButton);
        makePause(3000);
        log.info("Primary Sport: [{}]", elements.primarySportText.getText().trim());
        Assert.assertTrue(elements.primarySportText.getText().trim().contains("Triathlon"),
                "The primary sport hasn't changed!");
    }

    @Step("Change Language in User Settings")
    public void changeLanguage() {
        followToSettingsPage();
        clickWhenReady(elements.userSettingsButton);
        clickWhenReady(elements.spainLanguageRadioButton);
        clickWhenReady(elements.saveChangesButton);
        makePause(3000);
        log.info("Language: [{}]", elements.languageText.getText().trim());
        Assert.assertTrue(elements.languageText.getText().trim().contains("español"),
                "The language hasn't changed!");

        clickWhenReady(elements.userSettingsButton);
        clickWhenReady(elements.englishLanguageRadioButton);
        clickWhenReady(elements.saveChangesButton);
        makePause(3000);
        log.info("Language: [{}]", elements.languageText.getText().trim());
        Assert.assertTrue(elements.languageText.getText().trim().contains("English"),
                "The language hasn't changed!");
    }

    @Step("Change Time Zone in User Settings")
    public void changeTimeZone() {
        followToSettingsPage();
        clickWhenReady(elements.userSettingsButton);
        selectDropdownOption(elements.timeZoneDropDown, elements.timeZoneDropDownView,
                elements.timeZoneDropDownOptions, 2);
        clickWhenReady(elements.saveChangesButton);
        makePause(3000);
        log.info("Time Zone: [{}]", elements.timeZoneText.getText().trim());
        Assert.assertTrue(elements.timeZoneText.getText().trim().contains("UTC-11"),
                "The time zone hasn't changed!");
    }


    /************************************* CALENDAR SYNC LOGIC *******************************************/

    @Step("Change Calendar Sync status in Calendar Sync Settings")
    public void changeCalendarSync() {
        followToSettingsPage();
        clickWhenReady(elements.editSyncButton);
        clickWhenReady(elements.turnOnRadioButton);
        clickWhenReady(elements.saveChangesButton1);
        makePause(3000);
        log.info("Calendar status: [{}]", elements.calendarSyncStatusText.getText().trim());
        Assert.assertTrue(elements.calendarSyncStatusText.getText().trim().contains("On"),
                "The time zone hasn't changed!");

        clickWhenReady(elements.editSyncButton);
        clickWhenReady(elements.turnOffRadioButton);
        clickWhenReady(elements.saveChangesButton1);
        makePause(3000);
        log.info("Calendar status: [{}]", elements.calendarSyncStatusText.getText().trim());
        Assert.assertTrue(elements.calendarSyncStatusText.getText().trim().contains("Off"),
                "The time zone hasn't changed!");
    }


    /************************************* SOCIAL MEDIA LOGIC *******************************************/

    @Step("Add Social Media in Social Media Settings")
    public void addSocialMedia() {
        followToSettingsPage();
        clickWhenReady(elements.editSocialMediaButton);
        String urlExpected = driver.getCurrentUrl();
        log.info("URL: [{}]", urlExpected);
        clickWhenReady(elements.twitterButton);
        makePause(3000);
        String urlActual = driver.getCurrentUrl();
        log.info("URL: [{}]", urlActual);
        Assert.assertNotEquals(urlExpected, urlActual,
                "The Twitter page hasn't open!!!");
    }


    /************************************* SECURITY SETTINGS LOGIC *******************************************/

    @Step("Change Password in Security Settings")
    public void changePassword() {
        followToSettingsPage();
        clickWhenReady(elements.editSecuritySettings);
        waitForVisible(elements.currentPassInputField).clear();
        waitForVisible(elements.currentPassInputField)
                .sendKeys(Variables.MAIN_PASSWORD);
        waitForVisible(elements.newPassInputField).clear();
        waitForVisible(elements.newPassInputField)
                .sendKeys(preferencesModel.getNewPass());
        waitForVisible(elements.reNewPassInputField).clear();
        waitForVisible(elements.reNewPassInputField)
                .sendKeys(preferencesModel.getNewPass());
        clickWhenReady(elements.submitChangePassBtn);
        makePause(3000);
        logOut();
        login(Variables.MAIN_ACCOUNT, preferencesModel.getNewPass());
    }

    @Step("Change Security Question in Security Settings")
    public void changeSecurityQuestion() {
        followToSettingsPage();
        clickWhenReady(elements.editSecuritySettings);
        waitForVisible(elements.securityQuestionInputField).clear();
        waitForVisible(elements.securityQuestionInputField)
                .sendKeys(preferencesModel.getQuestion());
        waitForVisible(elements.securityAnswerInputField).clear();
        waitForVisible(elements.securityAnswerInputField)
                .sendKeys(String.valueOf(preferencesModel.getAnswer()));
        waitForVisible(elements.enterCurrentPassInputField).clear();
        waitForVisible(elements.enterCurrentPassInputField)
                .sendKeys(Variables.MAIN_PASSWORD);
        clickWhenReady(elements.updateSecurityQuestionBtn);
        makePause(3000);
    }


    /************************************* USER PROFILE SETTINGS LOGIC *******************************************/

    @Step("Change User Data in User Profile Settings")
    public void changeUserData() {
        followToSettingsPage();
        clickWhenReady(elements.editProfileButton);
        waitForVisible(elements.firstNameInputField).clear();
        waitForVisible(elements.firstNameInputField)
                .sendKeys(preferencesModel.getFirstName());
        waitForVisible(elements.lastNameInputField).clear();
        waitForVisible(elements.lastNameInputField)
                .sendKeys(preferencesModel.getLastName());
        clickWhenReady(elements.maleRadioButton);
        waitForVisible(elements.birthdayInputField).clear();
        waitForVisible(elements.birthdayInputField)
                .sendKeys(preferencesModel.getBirthday());
        waitForVisible(elements.zipCodeInputField).click();
        selectDropdownOption(elements.countryDropDown, elements.countryDropDownView,
                elements.countryDropDownOptions, 3);
        waitForVisible(elements.cityInputField).clear();
        waitForVisible(elements.cityInputField)
                .sendKeys(preferencesModel.getCity());
        waitForVisible(elements.zipCodeInputField).clear();
        waitForVisible(elements.zipCodeInputField)
                .sendKeys(String.valueOf(preferencesModel.getZipCode()));
        clickWhenReady(elements.submitButton);
        makePause(3000);
        log.info("First and Last Name: [{}]", elements.nameText.getText().trim());
        Assert.assertTrue(elements.nameText.getText().trim().contains(preferencesModel.getFirstName()),
                "The first name isn't correct!!!");
        Assert.assertTrue(elements.nameText.getText().trim().contains(preferencesModel.getLastName()),
                "The last name isn't correct!!!");
        log.info("Email: [{}]", elements.emailText.getText().trim());
        Assert.assertTrue(elements.emailText.getText().trim().contains(Variables.MAIN_ACCOUNT),
                "The email isn't correct!!!");
        log.info("Birthday: [{}]", elements.birthdayText.getText().trim());
        Assert.assertTrue(elements.birthdayText.getText().trim().contains(preferencesModel.getBirthday()),
                "The birthday isn't correct!!!");
        log.info("City: [{}]", elements.cityText.getText().trim());
        Assert.assertTrue(elements.cityText.getText().trim().contains(preferencesModel.getCity()),
                "The city isn't correct!!!");
        log.info("Zip Code: [{}]", elements.zipCodeText.getText().trim());
        Assert.assertTrue(elements.zipCodeText.getText().trim().contains(String.valueOf(preferencesModel.getZipCode())),
                "The zip code isn't correct!!!");
    }

    // не работает на веб-сайте
    @Step("Change Email in User Profile Settings")
    public void changeEmail() {
        followToSettingsPage();
        clickWhenReady(elements.editProfileButton);
        clickWhenReady(elements.emailChangedLink);
        waitForVisible(elements.emailInputField).clear();
        waitForVisible(elements.emailInputField)
                .sendKeys(Variables.MAIN_ACCOUNT);
        waitForVisible(elements.passwordInputField).clear();
        waitForVisible(elements.passwordInputField)
                .sendKeys(Variables.MAIN_PASSWORD);
        clickWhenReady(elements.saveChangeEmailBtn);
        makePause(3000);

    }

    @Step("Delete Account in User Profile Settings")
    public void deleteAccount() {
        followToSettingsPage();
        clickWhenReady(elements.editProfileButton);
        clickWhenReady(elements.deleteMyAccountLink);
        clickWhenReady(elements.okBtn);
        makePause(3000);
        Assert.assertTrue(elements.logoutPanel.isDisplayed(),
                "The account hasn't delete!!!");
    }

}

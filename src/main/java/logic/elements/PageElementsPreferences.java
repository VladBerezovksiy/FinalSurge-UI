package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageElementsPreferences extends BaseElements {

    public PageElementsPreferences(WebDriver driver) {
        super(driver);
    }


    /************************************* USER SETTINGS ELEMENTS *******************************************/

    @FindBy(xpath = "//div[1]/div[3]/div/div[2]/div[1]/div[1]/div/a")
    public WebElement userSettingsButton;

    @FindBy(xpath = "//div[1]/div[3]/div/div[2]/div[1]/div[2]/div/div/p[1]")
    public WebElement primarySportText;

    @FindBy(xpath = "//div[1]/div[3]/div/div[2]/div[1]/div[2]/div/div/p[2]")
    public WebElement languageText;

    @FindBy(xpath = "//div[1]/div[3]/div/div[2]/div[1]/div[2]/div/div/p[3]")
    public WebElement timeZoneText;

    @FindBy(id = "PSport")
    public WebElement primarySportDropDown;

    @FindBy(css = "#PSport option")
    public WebElement primarySportDropDownView;

    @FindBy(css = "#PSport option")
    public List<WebElement> primarySportDropDownOptions;

    @FindBy(css = "#settings-form .formSep .radio:nth-child(4) input")
    public WebElement spainLanguageRadioButton;

    @FindBy(css = "#settings-form .formSep .radio:nth-child(2) input")
    public WebElement englishLanguageRadioButton;

    @FindBy(id = "TZone")
    public WebElement timeZoneDropDown;

    @FindBy(css = "#TZone option")
    public WebElement timeZoneDropDownView;

    @FindBy(css = "#TZone option")
    public List<WebElement> timeZoneDropDownOptions;

    @FindBy(id = "saveButtonSettings")
    public WebElement saveChangesButton;


    /************************************* USER PROFILE ELEMENTS *******************************************/

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[1]/div[1]/div/a")
    public WebElement editProfileButton;

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div/p[1]")
    public WebElement nameText;

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div/p[2]")
    public WebElement emailText;

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div/p[4]")
    public WebElement birthdayText;

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div/p[8]")
    public WebElement cityText;

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div/p[9]")
    public WebElement zipCodeText;

    @FindBy(id = "fname")
    public WebElement firstNameInputField;

    @FindBy(id = "lname")
    public WebElement lastNameInputField;

    @FindBy(css = ".help-block a")
    public WebElement emailChangedLink;

    @FindBy(id = "email")
    public WebElement emailInputField;

    @FindBy(id = "upassword")
    public WebElement passwordInputField;

    @FindBy(id = "saveButton")
    public WebElement saveChangeEmailBtn;

    @FindBy(id = "male")
    public WebElement maleRadioButton;

    @FindBy(id = "BDay")
    public WebElement birthdayInputField;

    @FindBy(id = "Country")
    public WebElement countryDropDown;

    @FindBy(css = "#Country option")
    public WebElement countryDropDownView;

    @FindBy(css = "#Country option")
    public List<WebElement> countryDropDownOptions;

    @FindBy(id = "City")
    public WebElement cityInputField;

    @FindBy(id = "Zip")
    public WebElement zipCodeInputField;

    @FindBy(id = "del-user")
    public WebElement deleteMyAccountLink;

    @FindBy(xpath = "//div[@class='modal-footer']/a[contains(.,'OK')]")
    public WebElement okBtn;

    @FindBy(id = "saveButtonProfile")
    public WebElement submitButton;



    /************************************* SOCIAL MEDIA ELEMENTS *******************************************/

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[3]/div[1]/div/a")
    public WebElement editSocialMediaButton;

    @FindBy(css = "#form-social a")
    public WebElement twitterButton;


    /************************************* SECURITY SETTINGS ELEMENTS *******************************************/

    @FindBy(xpath = "//div[1]/div[3]/div/div[2]/div[2]/div[1]/div/a")
    public WebElement editSecuritySettings;

    @FindBy(id = "CurrentPassword")
    public WebElement currentPassInputField;

    @FindBy(id = "password_meter")
    public WebElement newPassInputField;

    @FindBy(id = "RePassword")
    public WebElement reNewPassInputField;

    @FindBy(id = "saveButtonPass")
    public WebElement submitChangePassBtn;

    @FindBy(id = "SecQuestion")
    public WebElement securityQuestionInputField;

    @FindBy(id = "SecAnswer")
    public WebElement securityAnswerInputField;

    @FindBy(id = "VerifyPass")
    public WebElement enterCurrentPassInputField;

    @FindBy(id = "saveButtonQuestion")
    public WebElement updateSecurityQuestionBtn;


    /************************************* CALENDAR SYNC ELEMENTS *******************************************/

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[2]/div[1]/div/a")
    public WebElement editSyncButton;

    @FindBy(id = "SyncOff")
    public WebElement turnOffRadioButton;

    @FindBy(id = "SyncOn")
    public WebElement turnOnRadioButton;

    @FindBy(id = "saveButtonSync")
    public WebElement saveChangesButton1;

    @FindBy(xpath = "//div[1]/div[3]/div/div[1]/div[2]/div[2]/div/div/p[1]/span")
    public WebElement calendarSyncStatusText;

}

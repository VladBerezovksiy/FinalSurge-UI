package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseElements {

    public BaseElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    /**************************************** LOGIN PAGE ****************************************************/

    @FindBy(id = "login-position")
    public WebElement loginPanel;

    @FindBy(id = "login-wrapper")
    public WebElement logoutPanel;

    @FindBy(id = "login_name")
    public WebElement emailInputField;

    @FindBy(id = "login_password")
    public WebElement passwordInputField;

    @FindBy(id = "login_remember")
    public WebElement rememberMeCheckbox;

    @FindBy(css = "#login-validate button")
    public WebElement loginButton;

    @FindBy(css = "#login-validate .signup a")
    public WebElement signUpButton;

    @FindBy(css = "#login-wrapper .signup a")
    public WebElement accountLoginButton;

    @FindBy(id = "pass_login")
    public WebElement forgotPasswordButton;

    public By forgotPasswordBtnLocator = By.id("pass_login");


    /**************************************** USER NAVIGATION BAR ****************************************************/

    @FindBy(css = ".user-box-inner .unstyled li:nth-child(1)")
    public WebElement settingsLink;

    @FindBy(css = ".user-box-inner .unstyled li:nth-child(3)")
    public WebElement logoutLink;


    /*************************************** TOP NAVIGATION BAR *****************************************************/

    @FindBy(css = ".nav-icons li:nth-child(1) a")
    public WebElement dashboardIcon;

    @FindBy(css = ".nav-icons li:nth-child(2) a")
    public WebElement calendarIcon;

    @FindBy(css = ".nav-icons li:nth-child(3) a")
    public WebElement workoutCalculatorIcon;

    @FindBy(css = ".nav-icons li:nth-child(4) a")
    public WebElement otherCalculatorIcon;

    @FindBy(css = ".nav-icons li:nth-child(5) a")
    public WebElement reportsStatisticsIcon;

    @FindBy(css = ".nav-icons li:nth-child(6) a")
    public WebElement mailBoxIcon;

    @FindBy(css = ".nav-icons li:nth-child(7) a")
    public WebElement printWorkoutsIcon;

    @FindBy(css = ".nav-icons li:nth-child(8) a")
    public WebElement betaPlatformsIcon;


    /*************************************** HEADER LIST *****************************************************/

    /*************************************** WORKOUT LIST *****************************************************/

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/a")
    public WebElement workoutsBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[1]/a")
    public WebElement addWorkoutBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[2]/a")
    public WebElement garminBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[3]/a")
    public WebElement viewCalendarBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[4]/a")
    public WebElement reportsStatisticsBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[5]/a")
    public WebElement printWorkoutBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[6]/a")
    public WebElement workoutLibraryBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[7]/a")
    public WebElement hrZonesBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[8]/a")
    public WebElement customizeActivityBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[1]/ul/li[9]/a")
    public WebElement importDataBtn;


    /*************************************** DAILY VITALS LIST ***********************************************/

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[2]/a")
    public WebElement dailyVitalsBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[2]/ul/li[1]/a")
    public WebElement viewAddVitalsBtn;


    /*************************************** GEAR ROUTES LIST ***********************************************/

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[3]/a")
    public WebElement gearRoutesBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[3]/ul/li[1]/a")
    public WebElement shoesBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[3]/ul/li[2]/a")
    public WebElement bikesBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[3]/ul/li[3]/a")
    public WebElement routesBtn;


    /*************************************** TRAINING LIST ***********************************************/

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[4]/a")
    public WebElement trainingPlansBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[4]/ul/li[1]/a")
    public WebElement viewMyPlansBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[4]/ul/li[2]/a")
    public WebElement findMyPlansBtn;


    /*************************************** RESOURCES LIST ***********************************************/

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[5]/a")
    public WebElement resourcesBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[5]/ul/li[1]/a")
    public WebElement viewFilesResourcesBtn;


    /*************************************** MESSAGE BOARDS LIST ***********************************************/

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[6]/a")
    public WebElement messageBoardsBtn;

    @FindBy(xpath = "//ul[@id='mobile-nav']/li[6]/ul/li[1]/a")
    public WebElement viewBoardsBtn;

}

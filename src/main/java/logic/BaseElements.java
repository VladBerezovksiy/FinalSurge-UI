package logic;

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


    /**************************************** USER NAVIGATION BAR ****************************************************/

    @FindBy(css = ".user-box-inner .unstyled li:nth-child(3)")
    public WebElement logoutLink;


    /*************************************** TOP NAVIGATION BAR ************************************************/

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

}

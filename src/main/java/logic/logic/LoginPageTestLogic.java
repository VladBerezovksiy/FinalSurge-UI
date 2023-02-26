package logic.logic;

import logic.BaseElements;
import logic.MainLogic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

public class LoginPageTestLogic extends MainLogic {

    private BaseElements elements;

    public LoginPageTestLogic(WebDriver driver, WebDriverWait wait, BaseElements elements) {
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


    public void incorrectCredentialsLogin() {
        waitForVisible(elements.loginPanel);
        waitForVisible(elements.emailInputField).sendKeys(Variables.NONEXISTENT_EMAIL);
        waitForVisible(elements.passwordInputField).sendKeys(Variables.INCORRECT_PASSWORD);
        clickWhenReady(elements.loginButton);
    }

    public void checkLoginPage() {
        getRootPage();
        incorrectCredentialsLogin();
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logOut();
    }

    public void checkForgotPasswordRestorationFunctionality() {

    }

    public void verificationOnTheMainPage() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logOut();
    }

}

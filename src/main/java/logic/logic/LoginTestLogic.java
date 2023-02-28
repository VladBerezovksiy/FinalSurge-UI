package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

public class LoginTestLogic extends MainLogic {

    private PageElementsLogin elements;

    public LoginTestLogic(WebDriver driver, WebDriverWait wait, PageElementsLogin elements) {
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
        incorrectCredentialsLogin();
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logOut();
    }

    public void checkForgotPasswordRestorationFunctionality() {
        if (checkForExistence(elements.forgotPasswordBtnLocator)) {
            clickWhenReady(elements.forgotPasswordButton);
            waitForVisible(elements.emailInputInForgotPass).clear();
            waitForVisible(elements.emailInputInForgotPass).sendKeys("");
            clickWhenReady(elements.loginButton);

            // need commercial mail ...
        }
    }

    public void verificationOnTheMainPage() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logOut();
    }

}

package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsLogin;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

@Log4j2
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


    @Step("Enter invalid data in Login page")
    private void incorrectCredentialsLogin() {
        waitForVisible(elements.loginPanel);
        log.info("Enter non-existent email: [{}]", Variables.NONEXISTENT_EMAIL);
        waitForVisible(elements.emailInputField).sendKeys(Variables.NONEXISTENT_EMAIL);
        log.info("Enter invalid password: [{}]", Variables.INCORRECT_PASSWORD);
        waitForVisible(elements.passwordInputField).sendKeys(Variables.INCORRECT_PASSWORD);
        clickWhenReady(elements.loginButton);
    }

    @Step("Check Login page")
    public void checkLoginPage() {
        incorrectCredentialsLogin();
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logOut();
    }

    @Step("Check forgot password in Login page")
    public void checkForgotPasswordRestorationFunctionality() {
        if (checkForExistence(elements.forgotPasswordBtnLocator)) {
            clickWhenReady(elements.forgotPasswordButton);
            waitForVisible(elements.emailInputInForgotPass).clear();
            waitForVisible(elements.emailInputInForgotPass).sendKeys("");
            clickWhenReady(elements.loginButton);

            // need commercial mail ...
        }
    }

    @Step("Enter valid data in Login page")
    public void verificationOnTheMainPage() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        logOut();
    }

}

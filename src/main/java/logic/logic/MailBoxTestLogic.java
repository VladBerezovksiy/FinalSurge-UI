package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsMailBox;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

@Log4j2
public class MailBoxTestLogic extends MainLogic {

    private PageElementsMailBox elements;

    public MailBoxTestLogic(WebDriver driver, WebDriverWait wait, PageElementsMailBox elements) {
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


    @Step("Check Inbox page")
    public void verifyInbox() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.mailBoxIcon);
        waitForJSToBeLoaded();
        clickWhenReady(elements.inboxTab);
        makePause(3000);

        Assert.assertTrue(elements.noMessagesText.isDisplayed());
    }

    @Step("Check Sent page")
    public void verifySent() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        clickWhenReady(elements.mailBoxIcon);
        waitForJSToBeLoaded();
        clickWhenReady(elements.sentTab);
        makePause(3000);

        Assert.assertTrue(elements.noMessagesText.isDisplayed());
    }

}

package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsMessageBoards;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

@Log4j2
public class MessageBoardsTestLogic extends MainLogic {

    private PageElementsMessageBoards elements;

    public MessageBoardsTestLogic(WebDriver driver, WebDriverWait wait, PageElementsMessageBoards elements) {
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


    @Step("Check View Board")
    public void viewBoards() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.messageBoardsBtn);
        clickWhenReady(elements.viewBoardsBtn);
        makePause(3000);
        Assert.assertTrue(elements.errorTextMessage.isDisplayed(),
                "Page doesn't open!!!");
    }
}

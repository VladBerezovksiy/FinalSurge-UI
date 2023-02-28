package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsMessageBoards;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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


}

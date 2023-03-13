package logic.logic;

import io.qameta.allure.Step;
import logic.MainLogic;
import logic.elements.PageElementsResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

public class ResourcesTestLogic extends MainLogic {

    private PageElementsResources elements;

    public ResourcesTestLogic(WebDriver driver, WebDriverWait wait, PageElementsResources elements) {
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


    @Step()
    public void viewFiles() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.resourcesBtn);
        clickWhenReady(elements.viewFilesResourcesBtn);
        makePause(3000);
        Assert.assertTrue(elements.aboutInfoText.isDisplayed(), "Page doesn't open!!!");
    }

}

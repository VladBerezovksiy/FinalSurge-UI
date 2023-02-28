package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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


}

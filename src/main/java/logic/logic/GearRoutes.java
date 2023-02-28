package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsGearRoutes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GearRoutes extends MainLogic {

    private PageElementsGearRoutes elements;

    public GearRoutes(WebDriver driver, WebDriverWait wait, PageElementsGearRoutes elements) {
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

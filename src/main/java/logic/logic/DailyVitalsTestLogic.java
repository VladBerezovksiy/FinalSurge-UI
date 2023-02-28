package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsDailyVitals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DailyVitalsTestLogic extends MainLogic {

    private PageElementsDailyVitals elements;

    public DailyVitalsTestLogic(WebDriver driver, WebDriverWait wait, PageElementsDailyVitals elements) {
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

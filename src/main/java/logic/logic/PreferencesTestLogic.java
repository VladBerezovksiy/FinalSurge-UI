package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsPreferences;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreferencesTestLogic extends MainLogic {

    private PageElementsPreferences elements;

    public PreferencesTestLogic(WebDriver driver, WebDriverWait wait, PageElementsPreferences elements) {
        super(driver, wait, elements);
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

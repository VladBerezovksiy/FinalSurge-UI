package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsTrainingPlans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainingPlansTestLogic extends MainLogic {

    private PageElementsTrainingPlans elements;

    public TrainingPlansTestLogic(WebDriver driver, WebDriverWait wait, PageElementsTrainingPlans elements) {
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

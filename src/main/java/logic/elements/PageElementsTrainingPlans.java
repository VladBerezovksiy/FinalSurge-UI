package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElementsTrainingPlans extends BaseElements {

    public PageElementsTrainingPlans(WebDriver driver) {
        super(driver);
    }


    /************************************** VIEW MY PLANS ELEMENTS *********************************************/

    @FindBy(css = "a.btn-success")
    public WebElement findTrainingPlanBtn;


    /************************************** FIND A PLANS ELEMENTS *********************************************/


}

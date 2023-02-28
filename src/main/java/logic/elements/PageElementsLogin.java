package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElementsLogin extends BaseElements {

    public PageElementsLogin(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "FEmail")
    public WebElement emailInputInForgotPass;
}

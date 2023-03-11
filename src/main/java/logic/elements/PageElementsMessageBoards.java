package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElementsMessageBoards extends BaseElements {

    public PageElementsMessageBoards(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "ErrorMessageTxt")
    public WebElement errorTextMessage;

}

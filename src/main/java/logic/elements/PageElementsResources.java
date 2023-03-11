package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElementsResources extends BaseElements {

    public PageElementsResources(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".w-box-blue")
    public WebElement aboutInfoText;

}

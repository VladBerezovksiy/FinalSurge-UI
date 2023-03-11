package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElementsMailBox extends BaseElements {

    public PageElementsMailBox(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[text()=\"You have no messages in your Inbox.\"]")
    public WebElement noMessagesText;


    /******************************************* INBOX ELEMENTS *******************************************/

    @FindBy(xpath = "//a[@href=\"Mailbox\"]")
    public WebElement inboxTab;


    /******************************************* SENT ELEMENTS *******************************************/

    @FindBy(xpath = "//a[@href=\"Mailbox?sent=1\"]")
    public WebElement sentTab;

}

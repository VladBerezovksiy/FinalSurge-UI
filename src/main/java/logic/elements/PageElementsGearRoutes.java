package logic.elements;

import logic.BaseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageElementsGearRoutes extends BaseElements {

    public PageElementsGearRoutes(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@title='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//table//a[@title='Delete']")
    public WebElement trashBtn;

    @FindBy(xpath = "//div[@class='modal-footer']/a[contains(.,'OK')]")
    public WebElement okBtn;

    @FindBy(id = "saveButton")
    public WebElement submitBtn;

    @FindBy(css = ".w-box-content tr td:nth-child(2)")
    public List<WebElement> tableResults;

    @FindBy(id = "ShoeName")
    public WebElement nameInputField;

    @FindBy(id = "ShoeModel")
    public WebElement modelInputField;

    @FindBy(id = "ShoeCost")
    public WebElement costInputField;

    @FindBy(id = "StartDist")
    public WebElement distStartInputField;

    @FindBy(id = "DistAlert")
    public WebElement distAlertInputField;

    @FindBy(id = "ShoeNotes")
    public WebElement notesInputField;

    @FindBy(css = "#s2id_ShoeBrand a")
    public WebElement brandDropdown;

    @FindBy(css = ".select2-results")
    public WebElement brandDropdownView;

    @FindBy(css = ".select2-results li")
    public List<WebElement> brandDropdownOption;


    /************************************************ ROUTES ELEMENTS *************************************************/

    @FindBy(id = "RouteBox")
    public WebElement routesForm;

    @FindBy(id = "RouteName")
    public WebElement routesNameInputField;

    @FindBy(id = "Activity")
    public WebElement routesActivityDropdown;

    @FindBy(css = "#Activity option")
    public WebElement routesActivityDropdownView;

    @FindBy(css = "#Activity option")
    public List<WebElement> routesActivityDropdownOption;

    @FindBy(id = "Distance")
    public WebElement routesDistanceInputField;

    @FindBy(id = "RoutePR")
    public WebElement routesRecordInputField;

    @FindBy(id = "PRDate")
    public WebElement routesRecordDateInputField;

    @FindBy(id = "Notes")
    public WebElement routesDescInputField;


    /************************************************ BIKES ELEMENTS *************************************************/

    @FindBy(id = "BikeEditForm")
    public WebElement bikeForm;

    @FindBy(id = "TrackDist")
    public WebElement trackDistCheckbox;


    /************************************************ SHOES ELEMENTS *************************************************/

    @FindBy(id = "ShoeEditForm")
    public WebElement shoeForm;

    @FindBy(id = "ShoeSize")
    public WebElement shoeSizeDropdown;

    @FindBy(css = "#ShoeSize option")
    public WebElement shoeSizeDropdownView;

    @FindBy(css = "#ShoeSize option")
    public List<WebElement> shoeSizeDropdownOption;

}

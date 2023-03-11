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

    // TODO: совместить локаторы

    @FindBy(xpath = "//a[@title='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//table//a[@title='Delete']")
    public WebElement trashBtn;

    @FindBy(xpath = "//div[@class='modal-footer']/a[contains(.,'OK')]")
    public WebElement okBtn;


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

    @FindBy(css = ".w-box-content tr td:nth-child(1)")
    public List<WebElement> currentRoutes;


    /************************************************ BIKES ELEMENTS *************************************************/

    @FindBy(id = "BikeEditForm")
    public WebElement bikeForm;

    @FindBy(id = "TrackDist")
    public WebElement trackDistCheckbox;


    /************************************************ SHOES ELEMENTS *************************************************/

    @FindBy(id = "ShoeEditForm")
    public WebElement shoeForm;

    @FindBy(id = "ShoeName")
    public WebElement shoeNameInputField;

    @FindBy(css = "#s2id_ShoeBrand a")
    public WebElement brandDropdown;

    @FindBy(css = ".select2-results")
    public WebElement brandDropdownView;

    @FindBy(css = ".select2-results li")
    public List<WebElement> brandDropdownOption;

    @FindBy(id = "ShoeModel")
    public WebElement shoeModelInputField;

    @FindBy(id = "ShoeCost")
    public WebElement shoeCostInputField;

    @FindBy(id = "ShoeSize")
    public WebElement shoeSizeDropdown;

    @FindBy(css = "#ShoeSize option")
    public WebElement shoeSizeDropdownView;

    @FindBy(css = "#ShoeSize option")
    public List<WebElement> shoeSizeDropdownOption;

    @FindBy(id = "StartDist")
    public WebElement shoeDistStartInputField;

    @FindBy(id = "DistAlert")
    public WebElement shoeDistAlertInputField;

    @FindBy(id = "ShoeNotes")
    public WebElement shoeNotesInputField;

    @FindBy(id = "saveButton")
    public WebElement submitAddShoeBtn;

    @FindBy(css = ".w-box-content tr td:nth-child(2)")
    public List<WebElement> currentShoes;


}

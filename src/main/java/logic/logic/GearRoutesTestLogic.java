package logic.logic;

import logic.MainLogic;
import logic.elements.PageElementsGearRoutes;
import logic.models.BikesModel;
import logic.models.RoutesModel;
import logic.models.ShoesModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Variables;

public class GearRoutesTestLogic extends MainLogic {

    private PageElementsGearRoutes elements;

    private final ShoesModel shoesModel = new ShoesModel();
    private final BikesModel bikesModel = new BikesModel();
    private final RoutesModel routesModel = new RoutesModel();

    public GearRoutesTestLogic(WebDriver driver, WebDriverWait wait, PageElementsGearRoutes elements) {
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


    public void clearHistory() {
        int size = elements.currentShoes.size();
        for (int i = 0; i < size; i++) {
            waitForVisible(elements.editBtn).click();
            waitForVisible(elements.trashBtn).click();
            waitForVisible(elements.okBtn).click();
            makePause(2000);
        }
    }

    public void addShoes() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.gearRoutesBtn);
        clickWhenReady(elements.shoesBtn);
        waitForVisible(elements.shoeForm);
        waitForVisible(elements.shoeNameInputField).clear();
        waitForVisible(elements.shoeNameInputField)
                .sendKeys(shoesModel.getName());
        selectDropdownOption(elements.brandDropdown, elements.brandDropdownView,
                elements.brandDropdownOption, 3);
        waitForVisible(elements.shoeModelInputField).clear();
        waitForVisible(elements.shoeModelInputField)
                .sendKeys(shoesModel.getModal());
        waitForVisible(elements.shoeCostInputField).clear();
        waitForVisible(elements.shoeCostInputField)
                .sendKeys(String.valueOf(shoesModel.getCost()));
        selectDropdownOption(elements.shoeSizeDropdown, elements.shoeSizeDropdownView,
                elements.shoeSizeDropdownOption, 4);
        waitForVisible(elements.shoeDistStartInputField).clear();
        waitForVisible(elements.shoeDistStartInputField)
                .sendKeys(String.valueOf(shoesModel.getStartingDistance()));
        waitForVisible(elements.shoeDistAlertInputField).clear();
        waitForVisible(elements.shoeDistAlertInputField)
                .sendKeys(String.valueOf(shoesModel.getDistanceAlert()));
        waitForVisible(elements.shoeNotesInputField).clear();
        waitForVisible(elements.shoeNotesInputField)
                .sendKeys(shoesModel.getNotes());
        clickWhenReady(elements.submitAddShoeBtn);
        makePause(3000);
        Assert.assertFalse(elements.currentShoes.isEmpty(),
                "Didn't was add new Shoe!!!");
    }

    public void addBikes() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.gearRoutesBtn);
        clickWhenReady(elements.bikesBtn);
        waitForVisible(elements.bikeForm);
        waitForVisible(elements.shoeNameInputField).clear();
        waitForVisible(elements.shoeNameInputField)
                .sendKeys(bikesModel.getName());
        selectDropdownOption(elements.brandDropdown, elements.brandDropdownView,
                elements.brandDropdownOption, 3);
        waitForVisible(elements.shoeModelInputField).clear();
        waitForVisible(elements.shoeModelInputField)
                .sendKeys(bikesModel.getModal());
        waitForVisible(elements.shoeCostInputField).clear();
        waitForVisible(elements.shoeCostInputField)
                .sendKeys(String.valueOf(bikesModel.getCost()));
        waitForVisible(elements.shoeDistStartInputField).clear();
        waitForVisible(elements.shoeDistStartInputField)
                .sendKeys(String.valueOf(bikesModel.getStartingDistance()));
        clickWhenReady(elements.trackDistCheckbox);
        waitForVisible(elements.shoeDistAlertInputField).clear();
        waitForVisible(elements.shoeDistAlertInputField)
                .sendKeys(String.valueOf(bikesModel.getDistanceAlert()));
        waitForVisible(elements.shoeNotesInputField).clear();
        waitForVisible(elements.shoeNotesInputField)
                .sendKeys(bikesModel.getNotes());
        clickWhenReady(elements.submitAddShoeBtn);
        makePause(3000);
        Assert.assertFalse(elements.currentShoes.isEmpty(),
                "Didn't was add new Bike!!!");
    }

    public void addRoutes() {
        login(Variables.MAIN_ACCOUNT, Variables.MAIN_PASSWORD);
        hoverOverElement(elements.gearRoutesBtn);
        clickWhenReady(elements.routesBtn);
        waitForVisible(elements.routesForm);
        waitForVisible(elements.routesNameInputField).clear();
        waitForVisible(elements.routesNameInputField)
                .sendKeys(routesModel.getName());
        selectDropdownOption(elements.routesActivityDropdown, elements.routesActivityDropdownView,
                elements.routesActivityDropdownOption, 3);
        waitForVisible(elements.routesDistanceInputField).clear();
        waitForVisible(elements.routesDistanceInputField)
                .sendKeys(String.valueOf(routesModel.getDistance()));
        waitForVisible(elements.routesRecordInputField).clear();
        waitForVisible(elements.routesRecordInputField)
                .sendKeys(routesModel.getRouteRecord());
        waitForVisible(elements.routesRecordDateInputField).clear();
        waitForVisible(elements.routesRecordDateInputField)
                .sendKeys(routesModel.getDateRecord());
        waitForVisible(elements.routesDescInputField).clear();
        waitForVisible(elements.routesDescInputField)
                .sendKeys(routesModel.getNotes());
        clickWhenReady(elements.submitAddShoeBtn);
        makePause(3000);
        Assert.assertFalse(elements.currentShoes.isEmpty(),
                "Didn't was add new Route!!!");
    }

}

package pageObjects.assetOverview;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.general.PageObject;

import java.util.ArrayList;
import java.util.List;

import static com.sun.jmx.snmp.ThreadContext.contains;


public class AssetOverviewPO extends PageObject {
    public WebDriver driver = getDriver();

    //Elements of Assets Overview
    @FindBy(xpath ="//button[text()='Filtern nach']")
    WebElement filterIcon;

    @FindBy(xpath ="/html/body/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/button[2]")
    WebElement mapViewIcon;

    @FindBy(xpath ="/html/body/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/button[1]")
    WebElement listViewIcon;

    @FindBy(className ="t-account-card-overview")
    WebElement contentAreaTileView;

    @FindBy(className ="t-account-list-overview")
    WebElement contentAreaListView;

    @FindBy(className ="t-new-account")
    WebElement newAccountWidget;

    @FindBy(className = "t-account-balance")
    List<WebElement> allWidgetsList;

    By h5 = By.tagName("h5");
    By h4 = By.tagName("h4");
    By p = By.tagName("p");
    By span = By.tagName("span");

    public AssetOverviewPO(WebDriver commonDriver) {
        super(commonDriver);
        PageFactory.initElements(driver, this);
    }

    public Boolean hasWidgetWithItems(ArrayList list) {
        //String name = e.findElement(h5).getText();

        for(WebElement e : allWidgetsList) {
            //name
            if(e.findElement(h5).getText().equals(list.get(0))) {
                String title = e.findElement(h4).getText();
                String tlist = list.get(1).toString();
                //title
                if(title.contains(tlist)){
                    String p2 = e.findElements(p).get(1).getText();
                    //currency
                    if(e.findElement(p).equals(p2)){
                    String ba = e.findElement(span).getText().replaceAll("[^0-9.]", "").replace(".",",");;
                    //saldo
                        if(e.findElement(h4).getText().equals(list.get(3))){
                        return true;
                    }}}}
        }return false;
    }



    public void clickElement(String element) {

        getElementByString(element).click();
    }

    public boolean elementIsClickable(String element) {
        return isDisplayed(getElementByString(element), element) && getElementByString(element).isEnabled();
    }

    public WebElement getElementByString(String element){
        switch(element) {
            case "Filtern nach":
                return filterIcon;
            case "Listenansicht":
                return contentAreaListView;
            case "Kachelansicht":
                return contentAreaTileView;
            case "Neues Konto eröffnen":
                return newAccountWidget;
            case "Button Listenansicht":
                return listViewIcon;
            case "Button Kachelansicht":
                return mapViewIcon;
            case "Eva Moniter":
                return getWidgetByName(element);
            case "Markus Moniter":
                return getWidgetByName(element);
            default:
                throw new ElementNotVisibleException("Invalid value: " + element);
        }
    }

    public void clickWidgetByAccountName(String name) {
        getElementByString(name).click();
    }

    private WebElement getWidgetByName(String element) {
        for(WebElement e : allWidgetsList) {
            if(e.findElement(h5).getText().equals(element)){
            return e;
            }
        }
        return null;
    }

    public boolean isDisplayedOnAssetOverview(String element) {
        return isDisplayed(getElementByString(element), element);
    }
}

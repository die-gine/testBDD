package pageObjects.balanceSheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.general.PageObject;

public class AssetsOverviewPO extends PageObject {
    public WebDriver driver = getDriver();



    public AssetsOverviewPO(WebDriver commonDriver) {
        super(commonDriver);
    }



}

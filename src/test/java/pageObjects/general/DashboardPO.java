package pageObjects.general;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.assetOverview.AssetOverviewPO;

import java.util.concurrent.TimeUnit;

public class DashboardPO extends PageObject {

    private WebDriver driver = getDriver();

    public DashboardPO(WebDriver commonDriver) {
        super(commonDriver);
    }

    public PageObject load() {
        driver.manage().window().maximize();
        driver.get(getDashboardURL());

        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        PageFactory.initElements(driver, this);
        return new DashboardPO(driver);
    }

    public PageObject navigateToAssetsOverview(){
        waitUntilElementIsClickable(driver, assetsMainMenuIcon);
        return new AssetOverviewPO(driver);
    }
}

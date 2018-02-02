package pageObjects.general;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.balanceSheet.AssetsOverviewPO;

import java.util.concurrent.TimeUnit;

public class GeneralEntryPO extends PageObject {

    private WebDriver driver = getDriver();

    public GeneralEntryPO(WebDriver commonDriver) {
        super(commonDriver);
    }

    public PageObject load() {
        driver.get(getDashboardURL());

        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return new GeneralEntryPO(driver);
    }

    public PageObject navigateToAssetsOverview(){
        assetsMainMenuIcon.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new AssetsOverviewPO(driver);
    }
}

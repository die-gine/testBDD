package pageObjects.assetsOverview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AssetsOverviewEntryPO {
    private final String url = "http://www.google.co.uk/";
    private final WebDriver driver;

    @FindBy(css = ".g .r")
    private WebElement firstHitDescriptionText;


    @FindBy(css = "#lst-ib")
    private WebElement searchField;

    @FindBy(css = "button[name='btnG']")
    private WebElement searchButton;

    public AssetsOverviewEntryPO(WebDriver commonDriver) {
        driver = commonDriver;
        PageFactory.initElements(driver, this);
    }

    public String firstHitTitle() {
        return firstHitDescriptionText.getText();
    }

    public void load() {
        driver.get(url);
    }
    public void searchFor(String searchString) {
        searchField.clear();
        searchField.sendKeys(searchString + "\n");
        searchButton.click();
    }
}

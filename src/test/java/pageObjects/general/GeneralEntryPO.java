package pageObjects.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GeneralEntryPO {
    private final String url = "http://www.yahoo.com/";
    private final WebDriver driver;




    public GeneralEntryPO(WebDriver commonDriver) {
        driver = commonDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }




}

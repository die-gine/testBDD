package pageObjects.general;

import config.TestConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PageObject {
    private final Logger logger = LoggerFactory.getLogger(PageObject.class);
    private final String url = getDashboardURL();
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/nav/ul/li[2]/a/h6")
    public WebElement balanceIcon;

    @FindBy(xpath ="/html/body/div[1]/div/div[2]/div[3]/div[1]/div[1]/h1")
    public WebElement contentHeaderTitle;

    @FindBy(xpath="/html/body/div[1]/div/div[1]/nav/ul/li[2]/a/h6")
    public WebElement assetsMainMenuIcon;

    @FindBy(xpath="/html/body/div[1]/div/div[1]/nav/ul/li[1]/a/h6")
    public WebElement dashboardMainMenuIcon;

    public By breadcrumpElements =  By.className("breadcrumbs__crumb");

    public PageObject(WebDriver commonDriver) {
        driver = commonDriver;
        PageFactory.initElements(driver, this);

    }

    public String getDashboardURL() {
        String URL = "not set";
        {
            try {
                URL = TestConfig.valueFor("URL");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return URL;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public String getContentHeaderTitle(){
       return contentHeaderTitle.getText();
    }

    public void switchToEnglish() {
        //#todo get current language and maybe switch
    }

    public String getElementTextbyID(String arg1) {
        //#todo get current text of element by id arg1
        return "";
    }

    public String getElementTextbyXpath(String arg1) {
        WebElement result = null;
        switch (arg1) {
            case "Vermögen":
                result = assetsMainMenuIcon;
                break;
            case "Dashboard":
                result = dashboardMainMenuIcon;
                break;
            default:
                throw new IllegalArgumentException("Do nothing. Invalid value: " + arg1);
        }
        return result.getText();
    }

    public String getListOfBreadcrumpItems() {
       List<WebElement> elements = driver.findElements(breadcrumpElements);
       List<String> items = new ArrayList<String>();
        ArrayList<String> removeIds = new ArrayList<>();
        for (WebElement o:elements) {
            items.add(o.getText());
        }
        String itemCommaSeparated = String.join(", ", items);
        for (String id : removeIds){
            items.remove(id);
        }
        takeScreenshotCurrentPage("CheckListOfBreadcrumpItems");
        return itemCommaSeparated;
    }

    public void takeScreenshotCurrentPage(String filename){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String filePath = TestConfig.valueFor("ScreenshotPath");
            FileUtils.copyFile(scrFile, new File(filePath+filename+".png"));
            logger.debug(scrFile.getName()+".png - Screenshot created");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

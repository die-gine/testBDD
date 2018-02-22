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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PageObject {
    private final Logger logger = LoggerFactory.getLogger(PageObject.class);
    private final String url = getDashboardURL();
    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(tagName ="h1")
    WebElement contentHeaderTitle;

    @FindBy(tagName ="h2")
    WebElement subContentHeaderTitle;

    @FindBy(xpath="//span[@class='main-nav__item__label' and text()='Vermögen']")
    WebElement assetsMainMenuIcon;

    @FindBy(xpath = "//span[@class='main-nav__item__label' and text()='Dashboard']")
    WebElement dashboardMainMenuIcon;

    By breadcrumpElements =  By.className("breadcrumbs__crumb");

    public PageObject(WebDriver commonDriver) {
        driver = commonDriver;
        PageFactory.initElements(driver, this);
    }

    String getDashboardURL() {
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
    public String getContentSubHeaderTitle() {
        return subContentHeaderTitle.getText();
    }


    public void switchToEnglish() {
        //#todo get current language and maybe switch
    }

    public String getMainMenueIcon(String arg1) {
        WebElement result;
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
        List<String> items = new ArrayList<>();
        ArrayList<String> removeIds = new ArrayList<>();
        for (WebElement o:elements) {
            items.add(o.getText());
        }
        String itemCommaSeparated = String.join(", ", items);
        takeScreenshotCurrentPage("CheckListOfBreadcrumpItems");
        return itemCommaSeparated;
    }

    public void takeScreenshotCurrentPage(String filename){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String projectPath = new File("").getAbsolutePath();
            String filePath = TestConfig.valueFor("ScreenshotPath");
            FileUtils.copyFile(scrFile, new File(projectPath+filePath+filename+".png"));
            logger.debug(scrFile.getName()+".png - Screenshot created");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean isDisplayed(WebElement element, String view) {
        Boolean present;
        try {
            element.isDisplayed();
            present = true;
        } catch (NoSuchElementException e) {
            return false;
        }
        return present;
    }


}

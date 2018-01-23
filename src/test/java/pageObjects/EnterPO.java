package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class EnterPO extends PageObject{

    WebDriver driver;
    By enterInput = By.id("Password");

    By sprint1 = By.id("u65_div");

    public EnterPO(WebDriver driver) {
        this.driver= driver;
    }

    public KontoUebersichtPO enterKonto(String pw) {
        driver.findElement(enterInput).clear();
        driver.findElement(enterInput).sendKeys(pw);
        driver.findElement(enterInput).sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(sprint1).click();
        return new KontoUebersichtPO(driver);
    }

}

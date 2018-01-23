package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObject {
    WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver= driver;
    }

    public PageObject() {
    }
}

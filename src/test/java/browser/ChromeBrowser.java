package browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeBrowser extends ChromeDriver {
    public static WebDriver buildChromeBrowser() throws Throwable {
        String projectPath = new File("").getAbsolutePath();
        String chromePath = projectPath + TestConfig.valueFor("WebDriverChromeDriverPath");
        System.setProperty("webdriver.chrome.driver", chromePath);
        ChromeBrowser browser = new ChromeBrowser();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }

    private ChromeBrowser() {
        super();
    }
}

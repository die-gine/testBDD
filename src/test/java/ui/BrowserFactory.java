package ui;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public static WebDriver getBrowser() throws Throwable {
        String desiredBrowserName = System.getProperty("browser", "chrome");
        WebDriver desiredBrowser = null;

        switch(desiredBrowserName) {
            case "ie":
                desiredBrowser = IEBrowser.buildIEBrowser();
                break;
            case "chrome":
                desiredBrowser = ChromeBrowser.buildChromeBrowser();
                break;
            case "firefox":
                desiredBrowser = FirefoxBrowser.buildFirefoxBrowser();
                break;
            default:
                //todo
                break;
        }
        return desiredBrowser;
    }
}

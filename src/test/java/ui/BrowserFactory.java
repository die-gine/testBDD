package ui;

import org.openqa.selenium.WebDriver;

class BrowserFactory {

    static WebDriver getBrowser() throws Throwable {
        String desiredBrowserName = System.getProperty("browser", "browserstack");
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
            case "browserstack":
                desiredBrowser = BrowserStack.buildBrowserstack();
                break;
            default:
                //todo
                break;
        }
        return desiredBrowser;
    }
}

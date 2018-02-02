package browser;

import config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStack {
    public static WebDriver buildBrowserstack(String device) {
        WebDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        switch(device) {
            case "androidTablet_samsungGalaxy":
                caps.setCapability("browserName", "android");
                caps.setCapability("device", "Samsung Galaxy Tab 4");
                caps.setCapability("realMobile", "true");
                caps.setCapability("os_version", "4.4");
                caps.setCapability("browserstack.local", "true");
                break;
            case "iphoneX":
                caps.setCapability("browserName", "iPhone");
                caps.setCapability("device", "iPhone X");
                caps.setCapability("realMobile", "true");
                caps.setCapability("os_version", "11.0");
                caps.setCapability("browserstack.local", "true");
                break;
            case "androidPhone_samsungS8":
                caps.setCapability("browserName", "android");
                caps.setCapability("device", "Samsung Galaxy S8");
                caps.setCapability("realMobile", "true");
                caps.setCapability("os_version", "7.0");
                caps.setCapability("browserstack.local", "true");
                break;
            case "chrome_winDesktop":
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "62.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");
                caps.setCapability("browserstack.local", "true");
                break;
            case "firefox_winDesktop":
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "58.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");
                caps.setCapability("browserstack.local", "true");
                break;
            default:
                //todo
                break;
        }

            try {
                String USERNAME = TestConfig.valueFor("USERNAME");
                String AUTOMATE_KEY = TestConfig.valueFor("AUTOMATE_KEY");
                String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
                driver = new RemoteWebDriver(new URL(URL), caps);

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        return driver;
    }
}

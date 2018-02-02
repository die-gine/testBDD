package ui;

import config.TestConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStack {
    public static WebDriver buildBrowserstack() {
        WebDriver driver = null;
/*
        try {
            Runtime.getRuntime().exec("cmd /c startBrowserStackLocal.bat");
            //todo remove hack for waiting time
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "android");
            caps.setCapability("device", "Samsung Galaxy Tab 4");
            caps.setCapability("realMobile", "true");
            caps.setCapability("os_version", "4.4");
            caps.setCapability("browserstack.local", "true");

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

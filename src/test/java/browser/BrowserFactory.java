package browser;

import org.openqa.selenium.WebDriver;

class BrowserFactory {

    static WebDriver getBrowser() throws Throwable {
        String desiredBrowserName = System.getProperty("browser", "chrome");
        //select defined browserstack device: "androidTablet_samsungGalaxy","iphoneX", "androidPhone_samsungS8","chrome_winDesktop", "firefox_winDesktop"
        String device = System.getProperty("device", "androidPhone_samsungS8");
        WebDriver desiredBrowser = null;

        switch(desiredBrowserName) {
            case "chrome":
                desiredBrowser = ChromeBrowser.buildChromeBrowser();
                break;
            case "browserstack":
                desiredBrowser = BrowserStack.buildBrowserstack(device);
                break;
            default:
                //todo
                break;
        }
        return desiredBrowser;
    }

    static void startBrowserstackConnection(){
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
    }
}

package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@sprint1"},features = "classpath:", glue = {"steps"},
        plugin = {"pretty" ,"html:target","json:target/chrome/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:"})

public class ChromeRunCukes {

    @BeforeClass
    public static void setProperties(){
        System.setProperty("browser", "browserstack");
        //available device: "androidTablet_samsungGalaxy","iphoneX", "androidPhone_samsungS8","chrome_winDesktop", "firefox_winDesktop"
        System.setProperty("device", "chrome_winDesktop");
    }


    @AfterClass
    public static void setupAfter() {
        Reporter.loadXMLConfig(new File("src/test/resources/extend-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setTestRunnerOutput("CIC Mobile Banking Chrome Tests");


    }
}

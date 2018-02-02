package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@mobile", "@android", "@testtest"},features = "classpath:", glue = {"steps"},
        plugin = {"pretty" ,"html:target/android","json:target/android/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:"}
) //if you're on windows add `monochrome=true` for clean output
//{"pretty" ,"html:target","json:target/cucumber.json"}

public class AndroidRunCukes {
    @BeforeClass
    public static void setProperties(){
        System.setProperty("browser", "browserstack");
        //available device: "androidTablet_samsungGalaxy","iphoneX", "androidPhone_samsungS8","chrome_winDesktop", "firefox_winDesktop"
        System.setProperty("device", "androidPhone_samsungS8");
    }

    @AfterClass
    public static void setupAfter() {
        Reporter.loadXMLConfig(new File("src/test/resources/extend-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setTestRunnerOutput("CIC Mobile Banking Android Tests");


    }
}
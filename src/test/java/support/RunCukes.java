package support;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@sprint1"},features = "classpath:", glue = {"steps"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/REPORT/report.html"}
) //if you're on windows add `monochrome=true` for clean output
public class RunCukes {

    @AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");

        //{"pretty" ,"html:target","json:target/cucumber.json"}
    }
}

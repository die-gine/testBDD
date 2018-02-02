package support;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@sprint1"},features = "classpath:", glue = {"steps"},
        plugin = {"pretty" ,"html:target","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:"}
) //if you're on windows add `monochrome=true` for clean output
//{"pretty" ,"html:target","json:target/cucumber.json"}

public class RunCukes {

    @AfterClass
    public static void setupAfter() {
        Reporter.loadXMLConfig(new File("src/test/resources/extend-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setTestRunnerOutput("CIC Mobile Banking Cucumber Tests");


    }
}

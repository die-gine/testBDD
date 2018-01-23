package support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@test1"},features = "classpath:", glue = {"steps"},
        plugin = {"pretty" ,"html:target" ,
                "json:target/cucumber.json"}) //if you're on windows add `monochrome=true` for clean output
public class RunCukes {

}
